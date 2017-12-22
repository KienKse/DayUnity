package com.app.kien.dayunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class DayActivity extends AppCompatActivity {

    TextView segundaDay;
    TextView tercaDay;
    TextView quartaDay;
    TextView quintaDay;
    TextView sextaDay;
    TextView todos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        segundaDay = findViewById(R.id.segunda);
        tercaDay = findViewById(R.id.terca);
        quartaDay = findViewById(R.id.quarta);
        quintaDay = findViewById(R.id.quinta);
        sextaDay = findViewById(R.id.sexta);
        todos = findViewById(R.id.todos);

    }

    public String getDiaSemana(TextView tv) {
       return tv.getText().toString();
    }

    public void onClickSegunda(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(segundaDay));
        startActivity(intent);
    }
    public void onClickTerca(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(tercaDay));
        startActivity(intent);
    }
    public void onClickQuarta(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(quartaDay));
        startActivity(intent);
    }
    public void onClickQuinta(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(quintaDay));
        startActivity(intent);
    }
    public void onClickSexta(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(sextaDay));
        startActivity(intent);
    }

    public void onClickTodos(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("diaDaSemana", getDiaSemana(todos));
        startActivity(intent);
    }



}
