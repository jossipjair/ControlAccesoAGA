package com.jej.jescalaya.appcontrolacceso.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalBD extends SQLiteOpenHelper {


    private static final String baseDatosLocal  = "ControlAccesoSeguridad";
    private static final int versionBD = 1;


    public LocalBD(Context context) {
        super(context, baseDatosLocal, null,versionBD);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(T_Cargo.CREATE_TCARGO);
        db.execSQL(T_CentroCosto.CREATE_TCENTRO_COSTO);
        db.execSQL(T_Empresa.CREATE_TEMPRESA);
        db.execSQL(T_Estado.CREATE_TESTADO);
        db.execSQL(T_MotivoMovimiento.CREATE_TMOTIVOMOVIMIENTO);
        db.execSQL(T_MovimientoAcceso.CREATE_TMOVIMIENTOACCESO);
        db.execSQL(T_Personal.CREATE_TPERSONAL);
        db.execSQL(T_Sucursal.CREATE_TSUCURSAL);
        db.execSQL(T_TipoAcceso.CREATE_TTIPOACCESO);
        db.execSQL(T_TipoDocumentoIdentidad.CREATE_TTIPODOCUMENTOIDENTIDAD);
        db.execSQL(T_TipoSexo.CREATE_TTIPOSEXO);
        db.execSQL(T_Configuracion.CREATE_CONFIGURACION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(T_Cargo.DROP_TCARGO);
        db.execSQL(T_CentroCosto.DROP_TCENTROCOSTO);
        db.execSQL(T_Empresa.DROP_TEMPRESA);
        db.execSQL(T_Estado.DROP_TESTADO);
        db.execSQL(T_MotivoMovimiento.DROP_TMOTIVOMOVIMIENTO);
        db.execSQL(T_MovimientoAcceso.DROP_TMOVIMIENTOACCESO);
        db.execSQL(T_Personal.DROP_TPERSONAL);
        db.execSQL(T_Sucursal.DROP_TSUCURSAL);
        db.execSQL(T_TipoAcceso.DROP_TTIPOACCESO);
        db.execSQL(T_TipoDocumentoIdentidad.DROP_TTIPODOCUMENTOIDENTIDAD);
        db.execSQL(T_TipoSexo.DROP_TTIPOSEXO);
        db.execSQL(T_Configuracion.DROP_CONFIGURACION);
        onCreate(db);
    }
}
