package com.example.bienestaraprendiz.emparejapp.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.bienestaraprendiz.emparejapp.Entidades.PuntajesVo;

import java.util.ArrayList;

public class crud extends SQLiteOpenHelper {

    public crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement, nombre text,puntaje int,nivel int)");
        for (int i=0;i<30;i++){
            int n=0;if(i<5) n=1;else if(i<10) n=2;else  if(i<15) n=3;else if(i<20) n=4;else if(i<25)n=5;else if(i<30)n=6;
            ContentValues registro=new ContentValues();
            registro.put("nombre","nadie");
            registro.put("puntaje","0");
            registro.put("nivel",String.valueOf(n));
            db.insert("tb_puntaje",null,registro);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement, nombre text,puntaje int,nivel int)");
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
        crud admin=new crud(context,"emparejados",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        int exito=db.update("tb_puntaje",registro,"id="+id,null);
        if(exito==1){
            return 1;
        }
        else Toast.makeText(context,"mal",Toast.LENGTH_SHORT).show(); return 0;
    }
    public void consultar(Context context, String consulta, ArrayList<PuntajesVo> puntajes){
        crud admin=new crud(context,"emparejados",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        Cursor cursor=db.rawQuery(consulta,null);
        while (cursor.moveToNext()){
            puntajes.add(new PuntajesVo(cursor.getString(1),Integer.valueOf(cursor.getString(2))));
        }
        cursor.close();
    }

    public  void eliminar(Context context){
        crud admin=new crud(context,"emparejados",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
    }
}
