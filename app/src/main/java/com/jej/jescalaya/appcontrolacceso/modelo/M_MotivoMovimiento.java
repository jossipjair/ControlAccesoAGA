package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_MotivoMovimiento;
import com.jej.jescalaya.appcontrolacceso.entidad.E_MotivoMovimiento;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_MotivoMovimiento {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int MotMov_Id;
    private int Est_Id;
    private String MotMov_Descripcion;
    private String MotMov_Abreviatura;

    public void insertarMotivoMovimientoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "MotivoMovimiento", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_MotivoMovimiento.DROP_TMOTIVOMOVIMIENTO);
                            sqLiteDatabase.execSQL(T_MotivoMovimiento.CREATE_TMOTIVOMOVIMIENTO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                MotMov_Id = jsonObject.getInt("MotMov_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                MotMov_Descripcion = jsonObject.getString("MotMov_Descripcion");
                                MotMov_Abreviatura = jsonObject.getString("MotMov_Abreviatura");

                                sqLiteDatabase.execSQL(T_MotivoMovimiento.INSERT_TMOTIVOMOVIMIENTO(MotMov_Id, Est_Id, MotMov_Descripcion, MotMov_Abreviatura));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Motivo Movimiento Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Motivo Movimiento conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }


    public void llenarMotivoMovimiento(Context context, Spinner spMotivoMovimiento) {
        ArrayList<E_MotivoMovimiento> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_MotivoMovimiento.SELECT_MOTIVOMOVIMIENTO(), null);

            if (registros.moveToFirst()) {
                do {
                    E_MotivoMovimiento e_tipoSexo = new E_MotivoMovimiento(registros.getInt(0), registros.getString(1));
                    lista.add(e_tipoSexo);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_MotivoMovimiento> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lista);
            spMotivoMovimiento.setAdapter(arrayAdapter);
        } finally {
            if (registros != null) {
                registros.close();
                sqLiteDatabase.close();
            }
        }
    }


}
