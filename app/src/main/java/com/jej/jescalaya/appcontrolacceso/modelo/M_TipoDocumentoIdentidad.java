package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.T_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_TipoDocumentoIdentidad {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int TipDocIde_Id;
    private int Est_Id;
    private String TipDocId_Codigo;
    private String TipDocId_Descripcion;

    public void insertarTipoDocumentoIdentidadLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "TipoDocumentoIdentidad", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_TipoDocumentoIdentidad.DROP_TTIPODOCUMENTOIDENTIDAD);
                            sqLiteDatabase.execSQL(T_TipoDocumentoIdentidad.CREATE_TTIPODOCUMENTOIDENTIDAD);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                TipDocIde_Id = jsonObject.getInt("TipDocIde_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                TipDocId_Codigo = jsonObject.getString("TipDocId_Codigo");
                                TipDocId_Descripcion = jsonObject.getString("TipDocId_Descripcion");

                                sqLiteDatabase.execSQL(T_TipoDocumentoIdentidad.INSERT_TTIPODOCUMENTOIDENTIDAD(TipDocIde_Id,Est_Id, TipDocId_Codigo, TipDocId_Descripcion));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Tipo Documento Identidad Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Tipo Documento Identidad conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }


    public void llenarTipoDocumento(Context context, Spinner spTipoDocumentoIdentidad) {
        ArrayList<E_TipoDocumentoIdentidad> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_TipoDocumentoIdentidad.SELECT_TIPODOCUMENTO(), null);

            if (registros.moveToFirst()) {
                do {
                    E_TipoDocumentoIdentidad e_tipoDocumentoIdentidad = new E_TipoDocumentoIdentidad(registros.getInt(0), registros.getString(1));
                    lista.add(e_tipoDocumentoIdentidad);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_TipoDocumentoIdentidad> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lista);
            spTipoDocumentoIdentidad.setAdapter(arrayAdapter);
        } finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
    }

}
