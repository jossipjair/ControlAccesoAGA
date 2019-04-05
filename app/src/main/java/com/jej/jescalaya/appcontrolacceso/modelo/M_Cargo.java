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
import com.jej.jescalaya.appcontrolacceso.BD.T_Cargo;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Cargo;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;


public class M_Cargo {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private String Car_Id;
    private String Car_Descripcion;
    private String Car_Abreviatura;
    private int Est_Id;

    public void insertarCargoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "Cargo", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_Cargo.DROP_TCARGO);
                            sqLiteDatabase.execSQL(T_Cargo.CREATE_TCARGO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Car_Id = String.valueOf(jsonObject.getInt("Car_Id"));
                                Car_Descripcion = jsonObject.getString("Car_Descripcion");
                                Car_Abreviatura = jsonObject.getString("Car_Abreviatura");
                                Est_Id  = jsonObject.getInt("Est_Id");
                                sqLiteDatabase.execSQL(T_Cargo.INSERT_TCARGO(Integer.parseInt(Car_Id), Car_Descripcion, Car_Abreviatura, Est_Id));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Cargo Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Cargo conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void llenarCargo(Context context, Spinner spEmpresa) {
        ArrayList<E_Cargo> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_Cargo.MOSTRAR_TCARGO(), null);

            if (registros.moveToFirst()) {
                do {
                    E_Cargo cargo = new E_Cargo(registros.getInt(0), registros.getString(1));
                    lista.add(cargo);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_Cargo> arrayAdapter;
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
