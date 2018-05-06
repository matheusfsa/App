package com.example.msa.appdeassistencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import classes.Pessoa;

public class CadastroEtapa2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_etapa2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText nome = (EditText)findViewById(R.id.nome_edit);
        final EditText sobrenome = (EditText)findViewById(R.id.sobrenome_edit);
        final EditText cpf = (EditText)findViewById(R.id.cpfedit);
        final EditText telefone = (EditText)findViewById(R.id.telefone_edit);
        final EditText data_nascimento = (EditText)findViewById(R.id.data_edit);
        Button avancar = (Button)findViewById(R.id.avancar_pessoa);
        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Pessoa p = new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),cpf.getText().toString(),telefone.getText().toString(), data_nascimento.getText().toString());
                Intent info2 = new Intent(CadastroEtapa2.this, CadastroEtapa3.class);
                startActivity(info2);
            }
        });

    }

}
