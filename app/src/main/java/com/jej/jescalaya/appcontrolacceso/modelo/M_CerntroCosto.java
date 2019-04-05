package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.BD.T_CentroCosto;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_CerntroCosto {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int Con_Id;
    private int Emp_Id;
    private int Est_Id;
    private int Suc_Id;
    private String Con_Codigo;
    private String Con_Descripcion;
    private String Con_DescripcionCor;
    private String Con_CodigoLot;
    private String Con_IsLote;
    private String Con_IsFundo;
    private String Con_IsArea;
    private String Con_IsVehiculo;
    private String Con_IsMaquinaria;
    private String Con_MarcaVeh;
    private String Con_ModeloVeh;

    public void insertarCentroCostoLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "CentroCosto", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_CentroCosto.DROP_TCENTROCOSTO);
                            sqLiteDatabase.execSQL(T_CentroCosto.CREATE_TCENTRO_COSTO);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Con_Id = jsonObject.getInt("Con_Id");
                                Emp_Id = jsonObject.getInt("Emp_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                Suc_Id = jsonObject.getInt("Suc_Id");
                                Con_Codigo = jsonObject.getString("Con_Codigo");
                                Con_Descripcion = jsonObject.getString("Con_Descripcion");
                                Con_DescripcionCor = jsonObject.getString("Con_DescripcionCor");
                                Con_CodigoLot  = jsonObject.getString("Con_CodigoLot");
                                Con_IsLote  = jsonObject.getString("Con_IsLote");
                                Con_IsFundo  = jsonObject.getString("Con_IsFundo");
                                Con_IsArea  = jsonObject.getString("Con_IsArea");
                                Con_IsVehiculo  = jsonObject.getString("Con_IsVehiculo");
                                Con_IsMaquinaria  = jsonObject.getString("Con_IsMaquinaria");
                                Con_MarcaVeh  = jsonObject.getString("Con_MarcaVeh");
                                Con_ModeloVeh  = jsonObject.getString("Con_ModeloVeh");
                                sqLiteDatabase.execSQL(T_CentroCosto.INSERT_TCENTROCOSTO(Con_Id,Emp_Id,Est_Id, Suc_Id, Con_Codigo, Con_Descripcion, Con_DescripcionCor, Con_CodigoLot, Con_IsLote, Con_IsFundo, Con_IsArea, Con_IsVehiculo, Con_IsMaquinaria, Con_MarcaVeh, Con_ModeloVeh));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Centro Costo Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Centro Costo conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public ArrayAdapter<String> llenarComboCentroCostoList(Context context, ListView listView, String centroCosto) {
        ArrayAdapter<String> arrayAdapter;
        Cursor registros = null;
        try{
            ArrayList<String> lista = new ArrayList<>();
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_CentroCosto.SELECT_CENTROCOSTO(centroCosto), null);

            if (registros.moveToFirst()) {
                do {
                    lista.add(registros.getString(1));
                } while (registros.moveToNext());
            }
            arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, lista);
            listView.setAdapter(arrayAdapter);
        }finally {
            if(registros != null){
                registros.close();
                sqLiteDatabase.close();
            }
        }

        return  arrayAdapter;
    }

    public String[] buscarDatosCentroCosto(Context context, String con_Descripcion) {
        String datos[] = new String[4];
        Cursor registos = null;
        try{
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registos = sqLiteDatabase.rawQuery(T_CentroCosto.SELECT_DATOSCENTROCOSTO(con_Descripcion), null);
            if (registos.moveToFirst()) {
                do {
                    datos[0] = registos.getString(0);
                    datos[1] = registos.getString(1);
                    datos[2] = registos.getString(2);
                    datos[3] = registos.getString(3);
                } while (registos.moveToNext());
            }
        }finally {
            if(registos != null){
                registos.close();
                sqLiteDatabase.close();
            }
        }

        return datos;
    }


}
