package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_Personal;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.HashMap;
import java.util.Map;

public class Sincroniza_Personal {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private String Per_Id;
    private String Est_Id;
    private String Car_Id;
    private String TipDocIde_Id;
    private String TipSex_Id;
    private String Per_ApellidoPat;
    private String Per_ApellidoMat;
    private String Per_Nombres;
    private String Per_NumeroDocIde;
    private String Per_Direccion;
    private String Per_Foto;
    private String Per_Manager;
    private String EsSincronizado;
    private String Per_FechaNac;

    public void recorreListaSincronizaPersonal(final Context context) {
        Cursor registros = null;
        try{
            LocalBD localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_Personal.SINCRONIZA_PERSONAL(), null);
            if (registros.moveToFirst()) {
                do {
                    Per_Id = registros.getString(0);
                    Est_Id = registros.getString(1);
                    Car_Id = registros.getString(2);
                    TipDocIde_Id = registros.getString(3);
                    TipSex_Id = registros.getString(4);
                    Per_ApellidoPat = registros.getString(5);
                    Per_ApellidoMat = registros.getString(6);
                    Per_Nombres = registros.getString(7);
                    Per_NumeroDocIde = registros.getString(8);
                    Per_Direccion = registros.getString(9);
                    Per_Foto = registros.getString(10);
                    Per_FechaNac = registros.getString(11);
                    Per_Manager = registros.getString(12);
                    try {
                        Thread.sleep(0);
                        sincronizaPersonalToServer(context, Per_Id, Est_Id, Car_Id, TipDocIde_Id, TipSex_Id, Per_ApellidoPat,Per_ApellidoMat,Per_Nombres,Per_NumeroDocIde, Per_Direccion, Per_Foto, Per_FechaNac, Per_Manager);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } while (registros.moveToNext());
            }
        }finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
    }

    public void sincronizaPersonalToServer(final Context context, final String per_Id, final String est_Id, final String car_Id, final String tipDocIde_Id, final String tipSex_Id, final String per_ApellidoPat, final String per_ApellidoMat, final String per_Nombres, final String per_NumeroDocIde, final String per_Direccion, final String per_Foto, final String per_FechaNac, final String per_Manager) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, VariableGeneral.ipServidor + "PersonalInsertar/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("true")) {
                    M_Personal m_personal = new M_Personal();
                    m_personal.actualizaSincronizacion(context, per_Id);
                    Toast.makeText(context, "Sincronización de Personal satisfactoria", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Per_Id", per_Id);
                params.put("Est_Id", est_Id);
                params.put("Car_Id", car_Id);
                params.put("TipDocIde_Id", tipDocIde_Id);
                params.put("TipSex_Id", tipSex_Id);
                params.put("Per_ApellidoPat", per_ApellidoPat);
                params.put("Per_ApellidoMat", per_ApellidoMat);
                params.put("Per_Nombres", per_Nombres);
                params.put("Per_NumeroDocIde", per_NumeroDocIde);
                params.put("Per_Direccion", per_Direccion);
                params.put("Per_Foto", per_Foto);
                params.put("Per_FechaNac", per_FechaNac);
                params.put("Per_Manager", per_Manager);
                return params;
            }
        };
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(stringRequest);
    }


}
