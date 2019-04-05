package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_Estado;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;


public class M_Estado {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int Est_Id;
    private String Est_Codigo;
    private String Est_Descripcion;
    private String Est_Abreviatura;
    private String Est_EsInterno;

    public void insertarEstadoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "Estado", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_Estado.DROP_TESTADO);
                            sqLiteDatabase.execSQL(T_Estado.CREATE_TESTADO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Est_Id = jsonObject.getInt("Est_Id");
                                Est_Codigo = jsonObject.getString("Est_Codigo");
                                Est_Descripcion = jsonObject.getString("Est_Descripcion");
                                Est_Abreviatura = jsonObject.getString("Est_Abreviatura");
                                Est_EsInterno = jsonObject.getString("Est_EsInterno");
                                sqLiteDatabase.execSQL(T_Estado.INSERT_TESTADO(Est_Id,Est_Codigo, Est_Descripcion, Est_Abreviatura, Est_EsInterno));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Estado Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Estado conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

}
