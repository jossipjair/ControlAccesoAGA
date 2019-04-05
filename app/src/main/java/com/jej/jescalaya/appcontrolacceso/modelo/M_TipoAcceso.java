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
import com.jej.jescalaya.appcontrolacceso.BD.T_TipoAcceso;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoAcceso;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_TipoAcceso {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int TipAcc_Id;
    private int Est_Id;
    private String TipAcc_Descripcion;
    private String TipAcc_Abreviatura;

    public void insertarTipoAccesoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "TipoAcceso", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_TipoAcceso.DROP_TTIPOACCESO);
                            sqLiteDatabase.execSQL(T_TipoAcceso.CREATE_TTIPOACCESO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                TipAcc_Id = jsonObject.getInt("TipAcc_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                TipAcc_Descripcion = jsonObject.getString("TipAcc_Descripcion");
                                TipAcc_Abreviatura = jsonObject.getString("TipAcc_Abreviatura");

                                sqLiteDatabase.execSQL(T_TipoAcceso.INSERT_TTIPOACCESO(TipAcc_Id, Est_Id,TipAcc_Descripcion, TipAcc_Abreviatura));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Tipo Acceso Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Tipo Acceso conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void llenarTipoAcceso(Context context, Spinner spTipoAcceso) {
        ArrayList<E_TipoAcceso> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_TipoAcceso.SELECT_TIPOACCESO(), null);

            if (registros.moveToFirst()) {
                do {
                    E_TipoAcceso e_tipoSexo = new E_TipoAcceso(registros.getInt(0), registros.getString(1));
                    lista.add(e_tipoSexo);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_TipoAcceso> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lista);
            spTipoAcceso.setAdapter(arrayAdapter);
        } finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
    }

}
