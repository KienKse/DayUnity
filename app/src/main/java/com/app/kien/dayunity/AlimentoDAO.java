package com.app.kien.dayunity;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien on 18/12/2017.
 */

public class AlimentoDAO {

    private Banco bd;

    public AlimentoDAO(Banco bd) {
        this.bd = bd;
    }

    public void insert(Alimento food) {
        ContentValues values = new ContentValues();
        values.put(Banco.COL_NOME, food.getNome());
        values.put(Banco.COL_DIASEMANA, food.getDiaDaSemana());
        values.put(Banco.COL_DESCRICAO, food.getDescricao());
        values.put(Banco.COL_IMAGEURL, food.getImagem());
        bd.getWritableDatabase().insert("alimentos", null, values);
        bd.getWritableDatabase().close();
    }

    public List<Alimento> listar() {
        List<Alimento> lista = new ArrayList<>();

        Cursor c = bd.getReadableDatabase().query("alimentos", new String[]{"nome,descricao,diasemana,imageurl"}, null, null, null, null, null);
        Log.d("APK", c.getCount() + "");
        if (c.moveToNext()) {
            c.moveToFirst();
            do {
                Alimento ali = new Alimento(c.getString(0), c.getString(1), c.getString(2), c.getString(3));
                lista.add(ali);
            } while (c.moveToNext());
            bd.getWritableDatabase().close();
        }
        return lista;
    }

    public void excluir (Alimento ali){
        bd.getWritableDatabase().execSQL("delete from alimentos where nome='"+ ali.getNome()+"';");
        bd.getWritableDatabase().close();
    }
}
