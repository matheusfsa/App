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
import android.widget.Toast;

public class Precadastro extends AppCompatActivity {
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup2);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                System.out.println("------------------------|"+checkedId);
                switch (checkedId) {
                    case R.id.is1:
                        id = 1;
                        break;
                    case R.id.is2:
                        id = 2;
                        break;
                    case R.id.is3:
                        id = 3;
                        break;
                    case R.id.nenhum:
                        id = 4;
                        break;
                }
            }
        });
        id = rg.getCheckedRadioButtonId();
        Button avancar = (Button)findViewById(R.id.avancar_is);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(id != -1) {
                    if(id!=4) {
                        Intent cadastro2 = new Intent(Precadastro.this, CadastroEtapa2.class);
                        cadastro2.putExtra("renda", id);
                        startActivity(cadastro2);
                    }else{
                        Intent cadastro2 = new Intent(Precadastro.this, CadastroEtapa1.class);
                        startActivity(cadastro2);
                    }
                }else{
                    Toast.makeText(Precadastro.this,"Escolha uma opção.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
