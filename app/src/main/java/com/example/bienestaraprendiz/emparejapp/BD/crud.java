package com.example.bienestaraprendiz.emparejapp.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class crud extends SQLiteOpenHelper {

    public crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement, nombre text,puntaje int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement, nombre text,puntaje int)");
    }
    public int crear(Context context, ContentValues registro){
        crud admin=new crud(context,"emparejados",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        long exito=db.insert("tb_puntaje",null,registro);
        if(exito!=-1){
            Toast.makeText(context,"bien",Toast.LENGTH_SHORT).show();
            return 1;
        }
        else Toast.makeText(context,"mal",Toast.LENGTH_SHORT).show(); return 0;
    }
    public int modificar(Context context,ContentValues registro,String id){
        crud admin=new crud(context,"tb_puntaje",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        int exito=db.update("tb_puntaje",registro,"id="+id,null);
        if(exito==1){
            Toast.makeText(context,"bien",Toast.LENGTH_SHORT).show();
            return 1;
        }
        else Toast.makeText(context,"mal",Toast.LENGTH_SHORT).show(); return 0;
    }
    public void consultar(Context context, String consulta, ArrayList<String> nombre,ArrayList<String> puntaje){
        crud admin=new crud(context,"tb_puntaje",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        Cursor cursor=db.rawQuery(consulta,null);
        while (cursor.moveToNext()){
            nombre.add(cursor.getString(1));
            puntaje.add(cursor.getString(2));
        }
        cursor.close();
    }
}
