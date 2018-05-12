package com.example.msa.appdeassistencia;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import classes.Pessoa;
import util.IncluirAsyncTask;

public class CadastroEtapa2 extends AppCompatActivity {

    int renda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_etapa2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        renda = getIntent().getIntExtra("renda",-1);
        System.out.println("Renda2: " + renda);
        final EditText nome = (EditText)findViewById(R.id.nome_edit);
        final EditText sobrenome = (EditText)findViewById(R.id.sobrenome_edit);
        final EditText cpf = (EditText)findViewById(R.id.cpfedit);
        final EditText telefone = (EditText)findViewById(R.id.telefone_edit);
        final EditText data_nascimento = (EditText)findViewById(R.id.data_edit);
        Button avancar = (Button)findViewById(R.id.avancar_pessoa);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa p = new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),cpf.getText().toString(),telefone.getText().toString(), data_nascimento.getText().toString(),String.valueOf(renda));
                if(p.getNome().equals("") | p.getData_nascimento().equals("") | p.getNumero().equals("") | p.getCpf().equals("") | p.getSobrenome().equals("")){
                    Toast.makeText(CadastroEtapa2.this, "Preencha todos os campos",Toast.LENGTH_LONG).show();
                }else{
                    int tam = p.getCpf().length();
                    if(tam!=11){
                        Toast.makeText(CadastroEtapa2.this, "Campo CPF incorreto!",Toast.LENGTH_LONG).show();
                    }else{
                        System.out.println(p);
                        IncluirAsyncTask is = new IncluirAsyncTask(p, CadastroEtapa2.this) ;
                        is.execute();
                        Intent info2 = new Intent(CadastroEtapa2.this, CadastroEtapa3.class);
                        info2.putExtra("pessoa",p);
                        startActivity(info2);
                    }
                }


            }
        });

    }

}
