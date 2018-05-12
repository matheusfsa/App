package com.example.msa.appdeassistencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuemSomos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView titulo = (TextView)findViewById(R.id.titulo_txt) ;
        titulo.setText(R.string.title_quem_somos);
        TextView txt = (TextView)findViewById(R.id.txt) ;
        txt.setText(R.string.txt_quem_somos);
        Button voltar = (Button)findViewById(R.id.btn_voltar2);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuemSomos.this, Dashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }

}
