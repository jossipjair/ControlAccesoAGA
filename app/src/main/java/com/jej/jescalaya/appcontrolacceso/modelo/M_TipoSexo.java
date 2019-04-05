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
import com.jej.jescalaya.appcontrolacceso.BD.T_TipoSexo;
import com.jej.jescalaya.appcontrolacceso.entidad.E_TipoSexo;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_TipoSexo {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int TipSex_Id;
    private int Est_Id;
    private String TipSex_Codigo;
    private String TipSex_Descripcion;

    public void insertarTipoSexoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "TipoSexo", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_TipoSexo.DROP_TTIPOSEXO);
                            sqLiteDatabase.execSQL(T_TipoSexo.CREATE_TTIPOSEXO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                TipSex_Id = jsonObject.getInt("TipSex_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                TipSex_Codigo = jsonObject.getString("TipSex_Codigo");
                                TipSex_Descripcion = jsonObject.getString("TipSex_Descripcion");

                                sqLiteDatabase.execSQL(T_TipoSexo.INSERT_TTIPOSEXO(TipSex_Id, Est_Id, TipSex_Codigo, TipSex_Descripcion));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Tipo Sexo Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Tipo Sexo conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void llenarTipoSexo(Context context, Spinner spEmpresa) {
        ArrayList<E_TipoSexo> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_TipoSexo.SELECT_TIPOSEXO(), null);

            if (registros.moveToFirst()) {
                do {
                    E_TipoSexo e_tipoSexo = new E_TipoSexo(registros.getInt(0), registros.getString(1));
                    lista.add(e_tipoSexo);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_TipoSexo> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lista);
            spEmpresa.setAdapter(arrayAdapter);
        } finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
    }


}
