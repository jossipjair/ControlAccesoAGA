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
import com.jej.jescalaya.appcontrolacceso.BD.T_MovimientoAcceso;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.HashMap;
import java.util.Map;

public class Sincroniza_MovimientoAcceso {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private String MovAcc_FechaHorMov;
    private String MovAcc_FechaHorMovLogLoc;
    private String MovAcc_FechaHorMovLogSer;
    private String Per_Id;
    private String Est_Id;
    private String Suc_Id;
    private String MotMov_Id;
    private String TipAcc_Id;
    private String Con_Id;
    private String MovAcc_PlacaVeh;
    private String MovAcc_Marca;
    private String MovAcc_Modelo;
    private String MovAcc_Id;

    public void recorreListaSincronizaPersonal(final Context context) {
        Cursor registros = null;
        try{
            LocalBD localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_MovimientoAcceso.SELECT_MOVIMIENTOACCESO(), null);
            if (registros.moveToFirst()) {
                do {
                    MovAcc_Id = registros.getString(0);
                    MovAcc_FechaHorMov = registros.getString(1);
                    MovAcc_FechaHorMovLogLoc = registros.getString(2);
                    Per_Id = registros.getString(3);
                    Est_Id = registros.getString(4);
                    Suc_Id = registros.getString(5);
                    MotMov_Id = registros.getString(6);
                    TipAcc_Id = registros.getString(7);
                    Con_Id = registros.getString(8);
                    MovAcc_PlacaVeh = registros.getString(9);
                    MovAcc_Marca = registros.getString(10);
                    MovAcc_Modelo = registros.getString(11);
                    try {
                        Thread.sleep(0);
                        sincronizaMovimientoAccesoToServer(context, MovAcc_Id, MovAcc_FechaHorMov, MovAcc_FechaHorMovLogLoc, Per_Id, Est_Id, Suc_Id, MotMov_Id,TipAcc_Id,Con_Id,MovAcc_PlacaVeh, MovAcc_Marca, MovAcc_Modelo);
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


    public void sincronizaMovimientoAccesoToServer(final Context context, final String movAcc_Id, final String movAcc_FechaHorMov, final String movAcc_FechaHorMovLogLoc, final String per_Id, final String est_Id, final String suc_Id, final String motMov_Id, final String tipAcc_Id, final String con_Id, final String movAcc_PlacaVeh, final String movAcc_Marca, final String movAcc_Modelo) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, VariableGeneral.ipServidor + "MovimientoAccesoInsertar/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("true")) {
                    M_MovimientoAcceso m_movimientoAcceso = new M_MovimientoAcceso();
                    m_movimientoAcceso.actualizaSincronizacion(context, Integer.parseInt(movAcc_Id));
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
                params.put("MovAcc_FechaHorMov", movAcc_FechaHorMov);
                params.put("MovAcc_FechaHorMovLogLoc", movAcc_FechaHorMovLogLoc);
                params.put("Per_Id", per_Id);
                params.put("Est_Id", est_Id);
                params.put("Suc_Id", suc_Id);
                params.put("MotMov_Id", motMov_Id);
                params.put("TipAcc_Id", tipAcc_Id);
                params.put("Con_Id", con_Id);
                params.put("MovAcc_PlacaVeh", movAcc_PlacaVeh);
                params.put("MovAcc_Marca", movAcc_Marca);
                params.put("MovAcc_Modelo", movAcc_Modelo);
                return params;
            }
        };
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(stringRequest);
    }

}
