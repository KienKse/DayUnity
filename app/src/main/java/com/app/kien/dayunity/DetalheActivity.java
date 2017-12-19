package com.app.kien.dayunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        TextView nomeProduto = (TextView) findViewById(R.id.nomeTextView);
        TextView descricaoProduto = (TextView) findViewById(R.id.descricaoTextView);
        TextView diaSemanaProduto = (TextView) findViewById(R.id.diaSemanaTextView);
        ImageView img = (ImageView) findViewById(R.id.imageView);

        Alimento ali = (Alimento) getIntent().getSerializableExtra("alimentos");

        nomeProduto.setText(ali.getNome());
        descricaoProduto.setText(ali.getDescricao());
        diaSemanaProduto.setText(ali.getDiaDaSemana());
        Picasso.with(this).load(ali.getImagem()).into(img);

    }
}
