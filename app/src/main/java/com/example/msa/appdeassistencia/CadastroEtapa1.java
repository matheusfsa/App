package com.example.msa.appdeassistencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.io.BufferedReader;

public class CadastroEtapa1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_etapa1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int id  = rg.getCheckedRadioButtonId();
        Button avancar = (Button)findViewById(R.id.avancar_renda);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent cadastro2 = new Intent(CadastroEtapa1.this, CadastroEtapa2.class);
                startActivity(cadastro2);
            }
        });
    }

}
