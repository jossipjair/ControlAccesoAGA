package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_MovimientoAcceso;

public class M_MovimientoAcceso {


    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;



    public void insertMovimientoAcceso(final Context context, String MovAcc_FechaHorMov, String MovAcc_FechaHorMovLogLoc, String MovAcc_FechaHorMovLogSer, String Per_Id, int Est_Id, int Suc_Id, int MotMov_Id, int TipAcc_Id, int Con_Id, String MovAcc_PlacaVeh, String MovAcc_Marca, String MovAcc_Modelo) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL(T_MovimientoAcceso.INSERT_TMOVIMIENTOACCESO(MovAcc_FechaHorMov,MovAcc_FechaHorMovLogLoc, MovAcc_FechaHorMovLogSer, Per_Id, Est_Id, Suc_Id, MotMov_Id, TipAcc_Id, Con_Id, MovAcc_PlacaVeh, MovAcc_Marca, MovAcc_Modelo));
            Toast.makeText(context, "¡Registro salvado satisfactoriamente!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }finally {
            sqLiteDatabase.close();
        }
    }


    public void actualizaSincronizacion(Context context, int movAcc_Id) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();

        try {
            sqLiteDatabase.execSQL(T_MovimientoAcceso.ACTUALIZA_REGISTROS_SINCRONIZADOS(movAcc_Id));
        } catch (Exception e) {

        } finally {
            sqLiteDatabase.close();
            localBD.close();
        }
    }





}
