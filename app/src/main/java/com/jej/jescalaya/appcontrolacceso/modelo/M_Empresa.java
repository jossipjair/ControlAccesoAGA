package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.jej.jescalaya.appcontrolacceso.BD.T_Empresa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import com.jej.jescalaya.appcontrolacceso.entidad.E_Empresa;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

import java.util.ArrayList;

public class M_Empresa {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private int Emp_Id;
    private int Est_Id;
    private String Emp_Codigo;
    private String Emp_Ruc;
    private String Emp_RazonSoc;
    private String Emp_Direccion;
    private String Emp_Abreviado;

    public void insertarEmpresaLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "Empresa", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_Empresa.DROP_TEMPRESA);
                            sqLiteDatabase.execSQL(T_Empresa.CREATE_TEMPRESA);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) ;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Emp_Id = jsonObject.getInt("Emp_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                Emp_Codigo = jsonObject.getString("Emp_Codigo");
                                Emp_Ruc = jsonObject.getString("Emp_Ruc");
                                Emp_RazonSoc = jsonObject.getString("Emp_RazonSoc");
                                Emp_Direccion = jsonObject.getString("Emp_Direccion");
                                Emp_Abreviado = jsonObject.getString("Emp_Abreviado");

                                sqLiteDatabase.execSQL(T_Empresa.INSERT_TEMPRESA(Emp_Id,Est_Id, Emp_Codigo, Emp_Ruc, Emp_RazonSoc, Emp_Direccion, Emp_Abreviado));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Empresa Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Empresa conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void llenarEmpresa(Context context, Spinner spEmpresa) {
        ArrayList<E_Empresa> lista = new ArrayList<>();
        Cursor registros = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registros = sqLiteDatabase.rawQuery(T_Empresa.SELECT_EMPRESA(), null);

            if (registros.moveToFirst()) {
                do {
                    E_Empresa empresa = new E_Empresa(registros.getInt(0), registros.getString(1));
                    lista.add(empresa);
                } while (registros.moveToNext());
            }

            ArrayAdapter<E_Empresa> arrayAdapter;
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
