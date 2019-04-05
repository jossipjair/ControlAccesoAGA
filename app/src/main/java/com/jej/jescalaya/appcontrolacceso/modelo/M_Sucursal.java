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
import com.jej.jescalaya.appcontrolacceso.BD.T_Sucursal;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Sucursal;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_Sucursal {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int Suc_Id;
    private int Emp_Id;
    private int Est_Id;
    private String Suc_Codigo;
    private String Suc_Descripcion;
    private String Suc_IsFundo;
    private String Suc_IsPlanta;
    private String Suc_IsOficina;
    private String Suc_DescripcionCor;

    public void insertarSucursallLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "Sucursal", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_Sucursal.DROP_TSUCURSAL);
                            sqLiteDatabase.execSQL(T_Sucursal.CREATE_TSUCURSAL);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Suc_Id = jsonObject.getInt("Suc_Id");
                                Emp_Id = jsonObject.getInt("Emp_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                Suc_Codigo = jsonObject.getString("Suc_Codigo");
                                Suc_Descripcion = jsonObject.getString("Suc_Descripcion");
                                Suc_IsFundo = jsonObject.getString("Suc_IsFundo");
                                Suc_IsPlanta = jsonObject.getString("Suc_IsPlanta");
                                Suc_IsOficina = jsonObject.getString("Suc_IsOficina");
                                Suc_DescripcionCor = jsonObject.getString("Suc_DescripcionCor");

                                sqLiteDatabase.execSQL(T_Sucursal.INSERT_TSUCURSAL(Suc_Id, Emp_Id,Est_Id, Suc_Codigo, Suc_Descripcion, Suc_IsFundo, Suc_IsPlanta, Suc_IsOficina, Suc_DescripcionCor));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Sucursal Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Sucursal conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void llenarSucursal(Context context, Spinner spEmpresa) {
        ArrayList<E_Sucursal> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_Sucursal.SELECT_SUCURSAL(), null);

            if (registros.moveToFirst()) {
                do {
                    E_Sucursal sucursal = new E_Sucursal(registros.getInt(0), registros.getString(1));
                    lista.add(sucursal);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_Sucursal> arrayAdapter;
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
