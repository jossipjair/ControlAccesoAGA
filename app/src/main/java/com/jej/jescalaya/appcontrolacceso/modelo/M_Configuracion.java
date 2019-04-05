package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_Configuracion;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Configuracion;

public class M_Configuracion {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    public void insertConfiguracion(final Context context, String empresa, String sucursal, String ipServidor) {
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            sqLiteDatabase.execSQL(T_Configuracion.DROP_CONFIGURACION);
            sqLiteDatabase.execSQL(T_Configuracion.CREATE_CONFIGURACION);
            sqLiteDatabase.execSQL(T_Configuracion.INSERT_CONFIGURACION(1, empresa, sucursal, ipServidor));
            Toast.makeText(context, "Configuración guardada", Toast.LENGTH_SHORT).show();
        } finally {
            sqLiteDatabase.close();
        }
    }


    public E_Configuracion mostrarConfiguracion(Context context) {

        E_Configuracion conf = null;
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_Configuracion.MOSTRAR_CONFIGURACION(), null);
            if (registros.moveToFirst()) {
                do {
                    conf = new E_Configuracion(registros.getString(0), registros.getString(1), registros.getString(2));
                } while (registros.moveToNext());
            }
        } finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
        return conf;
    }


}
