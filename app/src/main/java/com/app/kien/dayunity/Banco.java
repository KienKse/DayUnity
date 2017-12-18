package com.app.kien.dayunity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by Kien on 18/12/2017.
 */

public class Banco extends SQLiteOpenHelper {

    public static final String BANCO = "dayunity.bd";
    public static final int VERSAO = 3;
    private Context context;

    public static final String TABELA = "ALIMENTOS";
    public static final String COL_ID = "id";
    public static final String COL_NOME = "NOME";
    public static final String COL_DESCRICAO = "DESCRICAO";
    public static final String COL_DIASEMANA = "DIASEMANA";
    public static final String COL_IMAGEURL = "IMAGEURL";

    private static final String BANCO_START = "create table " + TABELA + "(" + COL_ID +
            " Integer primary key autoincrement ,"
            + COL_NOME + " text not null, " + COL_DESCRICAO + " text not null, " + COL_DIASEMANA + " text not null, "
            + COL_IMAGEURL + " text not null);";

    public Banco(Context context) {
        super(context, BANCO, null,VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BANCO_START);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table " + Banco.TABELA);
        onCreate(sqLiteDatabase);
    }
}
