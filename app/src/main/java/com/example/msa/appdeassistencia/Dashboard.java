package com.example.msa.appdeassistencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button cadastro = (Button) findViewById(R.id.cadastre);
        Button qs = (Button) findViewById(R.id.quem_somos);
        Button cf = (Button) findViewById(R.id.como_funciona);
        Button sug = (Button) findViewById(R.id.sugestoes);
        Button not = (Button) findViewById(R.id.noticias);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(Dashboard.this, CadastroEtapa1.class);
                startActivity(cadastro);
            }
        });
        qs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qsomos = new Intent(Dashboard.this, QuemSomos.class);
                startActivity(qsomos);
            }
        });
        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cfu = new Intent(Dashboard.this, ComoFunciona.class);
                startActivity(cfu);
            }
        });
        sug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sugg = new Intent(Dashboard.this, Sugestoes.class);
                startActivity(sugg);
            }
        });
        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sugg = new Intent(Dashboard.this, ListarNoticias.class);
                startActivity(sugg);
            }
        });
    }

}
