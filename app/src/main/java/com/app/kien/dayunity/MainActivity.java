package com.app.kien.dayunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.Serializable;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Alimento[] alimentos;
    private Boolean verificarBD;

    AlimentoDAO alimentoX = new AlimentoDAO(new Banco(this));

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String dia = (String) getIntent().getSerializableExtra("diaDaSemana");

        lista = (ListView) findViewById(R.id.listView1);

        final List<Alimento> ali = alimentoX.listar();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ali);

        lista.setAdapter(adapter);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(
                "https://raw.githubusercontent.com/KienKse/DayUnity/master/json/dayunity.json",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Log.d("AsyncHttpClient", "FALHA - " + throwable.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Log.d("AsyncHttpClient", "SUCESSO");

                        Gson gson = new GsonBuilder().create();
                        alimentos = gson.fromJson(responseString, Alimento[].class);
                        adapter.clear();

                        if (alimentoX.listar().isEmpty()) {
                            verificarBD = true;
                        } else {
                            verificarBD = false;
                        }

                        for(Alimento alimento : alimentos) {
                            if(alimento.getDiaDaSemana().equalsIgnoreCase(dia)) {
                                adapter.add(alimento);
                                if (verificarBD)
                                    alimentoX.insert(alimento);
                            }
                        }
                        // Seguro - Banco
                        verificarBD = false;
                    }
                });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                intent.putExtra("alimentos", (Serializable) adapterView.getItemAtPosition(i));
                startActivity(intent);
            }
        });
    }
}

