package com.app.kien.dayunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        TextView nomeProduto = (TextView) findViewById(R.id.nomeTextView);
        TextView diaSemanaProduto = (TextView) findViewById(R.id.diaSemanaTextView);
        TextView descricaoProduto = (TextView) findViewById(R.id.descricaoTextView);
        ImageView img = (ImageView) findViewById(R.id.imageView);

        String nome = "";
        String descricao = "";
        String diaSemana = "";
        String imagemUrl = "";


        Intent help = DetalheActivity.this.getIntent();

        if (help.hasExtra("nome")) {
            nome = help.getStringExtra("nome");
        }
        if (help.hasExtra("descricao")) {
            descricao = help.getStringExtra("descricao");
        }
        if (help.hasExtra("diaDaSemana")) {
            diaSemana = help.getStringExtra("diaDaSemana");
        }
        if (help.hasExtra("imagem")) {
            imagemUrl = help.getStringExtra("imagem");
        }

        nomeProduto.setText(nome);
        descricaoProduto.setText(descricao);
        diaSemanaProduto.setText(diaSemana);
        Picasso.with(this).load(imagemUrl).into(img);

        /*
        Glide.with(context)
                .load("https://inthecheesefactory.com/uploads/source/glidepicasso/gifanimation2.gif")
                .into(idDoTeuImageView);
        */
    }
}
