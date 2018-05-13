package com.example.msa.appdeassistencia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import classes.NoticiaObj;

public class ListarNoticias extends AppCompatActivity {
    ArrayList<NoticiaObj> lista;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_noticias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (ListView) findViewById(R.id.listview);

        lista = new ArrayList<>();
        Sincronizar s = new Sincronizar(ListarNoticias.this);
        s.execute();
        final ArrayAdapter<NoticiaObj> adapter = new ArrayAdapter<NoticiaObj>(ListarNoticias.this, android.R.layout.simple_list_item_1, lista);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Seu codigo aqui
                //Toast.makeText(ListarNoticias.this, lista.get(position).toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListarNoticias.this, Noticia.class);
                intent.putExtra("noticia",lista.get(position));
                startActivity(intent);
            }


        });
        Button voltar = (Button)findViewById(R.id.btn_voltar_list);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarNoticias.this, ListarNoticias.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

    }
    private class Sincronizar extends AsyncTask<String,String,String >{
        public static  final int CONNECTION_TIMEOUT = 10000;
        public static  final int READ_TIMEOUT = 15000;
        public static  final String URL_GET = "https://santosalmeidamatheus.000webhostapp.com/GetNoticias.php";
        public static  final String LOG_TAG = "appdeassistencia";
        ProgressDialog progressDialog;

        HttpURLConnection conn;
        URL url = null;
        Uri.Builder builder;
        Context context;
        public Sincronizar(Context context){
            this.builder = new Uri.Builder();

            this.context = context;

            builder.appendQueryParameter("app", "Assistencia");

        }
        @Override
        protected void onPreExecute() {
            Log.i("WebService", "IncluirAsyncTask()");

            progressDialog = new ProgressDialog(context);

            progressDialog.setMessage("Incluindo, por favor espere...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... strings) {
            try {

                url = new URL(URL_GET);

            } catch (MalformedURLException e) {

                Log.e("WebService", "MalformedURLException - " + e.getMessage());

            } catch (Exception e) {

                Log.e("WebService", "Exception - " + e.getMessage());

            }

            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("charset", "utf-8");

                conn.setDoInput(true);
                conn.setDoOutput(true);


                String query =  builder.build().getEncodedQuery();
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();
            }catch (IOException erro) {

                Log.e("WebService", "IOException - " + erro.getMessage());

            }
            try {

                int response_code = conn.getResponseCode();

                if (response_code == HttpURLConnection.HTTP_OK) {

                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    System.out.println("Linha " +line);
                    return (result.toString());

                } else {
                    return ("Erro de conexão");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }

        }
        @Override
        protected void onPostExecute(String result) {
            try{
                JSONArray jsonArray = new JSONArray(result);

                if(jsonArray.length()!=0){
                    final ArrayAdapter<NoticiaObj> adapter = new ArrayAdapter<NoticiaObj>(context, android.R.layout.simple_list_item_1, lista);
                    list.setAdapter(adapter);
                    lista.add(new NoticiaObj("titulo","12/05/2017","tituloadsdakdsjasdoksaodkodsodjosjadojodsoajdojoadjosajdojasodjoasjdoj"));
                    for (int i = 0; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        lista.add(new NoticiaObj(jsonObject.getString("titulo"),jsonObject.getString("data"),jsonObject.getString("texto")));
                        adapter.notifyDataSetChanged();
                        System.out.println(lista.size());
                    }
                }
            }catch (Exception e){

            }finally {

            }
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }
    }

}
