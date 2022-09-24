package android.app.hospitals9.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SQLite {
    private   sql sql;
    private SQLiteDatabase db;
    public SQLite(Context context){
        sql= new sql(context);

    }
    public void abrir(){
        Log.i("SQLite","se abre conexion con bd"+sql.getDatabaseName());
        db=sql.getWritableDatabase();
    }
    public void cerrar(){
        Log.i("SQLite","se cierra conexion con bd"+sql.getDatabaseName());
        sql.close();
    }
    public boolean addRegistroPaciente(
            int id,String area, String doc, String name, String Sexo, String date
            ,String age,String heigth, String wigth, String imagen){
        ContentValues cv = new ContentValues( );
        cv.put("ID",id);
        cv.put("AREA",area);
        cv.put("DOCTOR",doc);
        cv.put("NAME",name);
        cv.put("SEXO",Sexo);
        cv.put("FECHA_INGRESO",date);
        cv.put("EDAD",age);
        cv.put("ESTATURA",heigth);
        cv.put("PESO",wigth);
        cv.put("IMAGEN",imagen);
        return(db.insert("PACIENTES",null,cv)!=1)?true:false;
    }
    public Cursor getRegistro(){
        return db.rawQuery("SELECT * FROM PACIENTES",null);

    }
    public ArrayList<String> getPacientes(Cursor cursor){
        ArrayList<String> ListaData = new ArrayList<String>();
        String item ="";
        if(cursor.moveToFirst()){
            do{
               item += "ID: ["+cursor.getString(0)+"]\r\n";
               item += "AREA: ["+cursor.getString(1)+"]\r\n";
               item += "DOCTOR: ["+cursor.getString(2)+"]\r\n";
               item += "NOMBRE: ["+cursor.getString(3)+"]\r\n";
               item += "SEXO: ["+cursor.getString(4)+"]\r\n";
               item += "FECHA_INGRESO: ["+cursor.getString(5)+"]\r\n";
               item += "EDAD: ["+cursor.getString(6)+"]\r\n";
               item += "ESTATURA: ["+cursor.getString(7)+"]\r\n";
               item += "PESO: ["+cursor.getString(8)+"]\r\n";
               ListaData.add(item);
               item="";
            }while(cursor.moveToNext());
        }
        return  ListaData;
    }
    public ArrayList<String> getImagenes(Cursor cursor) {
        ArrayList<String> ListaData = new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                ListaData.add(cursor.getString(9));
            }while (cursor.moveToNext());
        }
        return ListaData;
    }
    public ArrayList<String> getId(Cursor cursor) {
        ArrayList<String> ListaData = new ArrayList<String>();
        String item ="";
        if(cursor.moveToFirst()){
            do{
                item += "ID: ["+cursor.getString(0)+"]\r\n";
                ListaData.add(item);
                item="";
            }while(cursor.moveToNext());
        }

        return ListaData;
    }
    public String updateRegistroPaciente(
            int id,String area, String doc, String name, String Sexo, String date
            ,String age,String heigth, String wigth, String imagen){
        ContentValues cv = new ContentValues( );
        cv.put("ID",id);
        cv.put("AREA",area);
        cv.put("DOCTOR",doc);
        cv.put("NAME",name);
        cv.put("SEXO",Sexo);
        cv.put("FECHA_INGRESO",date);
        cv.put("EDAD",age);
        cv.put("ESTATURA",heigth);
        cv.put("PESO",wigth);
        cv.put("IMAGEN",imagen);
        int valor = db.update("PACIENTES",cv, "ID="+id,null);
        if(valor!=1){
            return "Error de Actualizacion";
        }
        return "Paciente Actualizado";
    }
    public Cursor getValor(int id){
        return db.rawQuery("SELECT * FROM PACIENTES WHERE ID="+id,null);
    }
    public int Eliminar(Editable id){
        return db.delete("PACIENTES ","ID="+id,null);
    }

}
