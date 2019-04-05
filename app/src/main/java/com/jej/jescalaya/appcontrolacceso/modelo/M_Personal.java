package com.jej.jescalaya.appcontrolacceso.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.jej.jescalaya.appcontrolacceso.BD.LocalBD;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.jej.jescalaya.appcontrolacceso.BD.T_Personal;
import com.jej.jescalaya.appcontrolacceso.vista.VariableGeneral;

public class M_Personal {

    private LocalBD localBD;
    private SQLiteDatabase sqLiteDatabase;

    private String Per_Id;
    private int Est_Id;
    private int Car_Id;
    private int TipDocIde_Id;
    private int TipSex_Id;
    private String Per_ApellidoPat;
    private String Per_ApellidoMat;
    private String Per_Nombres;
    private String Per_NumeroDocIde;
    private String Per_Direccion;
    private String Per_Foto;
    private String Per_FechaNac;
    private String Per_Manager;

    public void insertarPersonalLocalToService(final Context context) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        //RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, VariableGeneral.ipServidor + "Personal", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            sqLiteDatabase.execSQL(T_Personal.DROP_TPERSONAL);
                            sqLiteDatabase.execSQL(T_Personal.CREATE_TPERSONAL);
                            int tamañoResponse = Integer.parseInt(String.valueOf(response.length())) - 1;
                            for (int i = 0; i <= tamañoResponse; i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Per_Id = jsonObject.getString("Per_Id");
                                Est_Id = jsonObject.getInt("Est_Id");
                                Car_Id = jsonObject.getInt("Car_Id");
                                TipDocIde_Id = jsonObject.getInt("TipDocIde_Id");
                                TipSex_Id = jsonObject.getInt("TipSex_Id");
                                Per_ApellidoPat = jsonObject.getString("Per_ApellidoPat");
                                Per_ApellidoMat = jsonObject.getString("Per_ApellidoMat");
                                Per_Nombres = jsonObject.getString("Per_Nombres");
                                Per_NumeroDocIde = jsonObject.getString("Per_NumeroDocIde");
                                Per_Direccion = jsonObject.getString("Per_Direccion");
                                Per_Foto = jsonObject.getString("Per_Foto");
                                Per_FechaNac = jsonObject.getString("Per_FechaNac");
                                Per_Manager = jsonObject.getString("Per_Manager");

                                sqLiteDatabase.execSQL(T_Personal.INSERT_TPERSONAL(Per_Id,Est_Id, Car_Id, TipDocIde_Id, TipSex_Id, Per_ApellidoPat, Per_ApellidoMat, Per_Nombres, Per_NumeroDocIde, Per_Direccion, Per_Foto, Per_FechaNac, Per_Manager, 1));
                                //sqLiteDatabase.close();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }finally { //Insertado
                            sqLiteDatabase.close();
                        }//Insertado
                        Toast.makeText(context, "¡Tabla Personal Sincronizada!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Personal conexión JSON fallida", Toast.LENGTH_SHORT).show();
            }
        });

        //jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, 5));
        //queue.add(jsonArrayRequest);
        VolleyInstance.getInstanceVolley(context).addToRequestQueue(jsonArrayRequest);
    }

    public void insertPersonal(final Context context, String Per_Id,  int Est_Id, int Car_Id, int TipDocIde_Id, int TipSex_Id, String Per_ApellidoPat, String Per_ApellidoMat, String Per_Nombres, String Per_NumeroDocIde, String Per_Direccion, String Per_Foto, String Per_FechaNac, String Per_Manager) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL(T_Personal.INSERT_TPERSONAL(Per_Id, 1, Car_Id, TipDocIde_Id, TipSex_Id, Per_ApellidoPat,Per_ApellidoMat, Per_Nombres, Per_NumeroDocIde, Per_Direccion, "-",Per_FechaNac, "75526541",0));
            Toast.makeText(context, "¡Registro salvado satisfactoriamente!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }finally {
            sqLiteDatabase.close();
        }
    }

    public void actualizaSincronizacion(Context context, String per_Id) {
        localBD = new LocalBD(context);
        sqLiteDatabase = localBD.getWritableDatabase();

        try {
            sqLiteDatabase.execSQL(T_Personal.ACTUALIZA_REGISTROS_SINCRONIZADOS(per_Id));
        } catch (Exception e) {

        } finally {
            sqLiteDatabase.close();
            localBD.close();
        }
    }

    public String buscarPersonal(Context context, String per_Id) {
        String persona = "";
        Cursor registos = null;
        try{
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registos = sqLiteDatabase.rawQuery(T_Personal.BUSCA_PERSONA(per_Id), null);
            if (registos.moveToFirst()) {
                do {
                    persona = registos.getString(0) + " " + registos.getString(1)+ " " + registos.getString(2);
                } while (registos.moveToNext());
            }
        }finally {
            if(registos != null){
                registos.close();
                sqLiteDatabase.close();
            }
        }

        return persona;
    }


    /*public int ultimoId(final Context context){
        int idPersona = 1;
        Cursor registos  = null;
        try {
            localBD = new LocalBD(context);
            sqLiteDatabase = localBD.getWritableDatabase();
            registos = sqLiteDatabase.rawQuery(T_Personal.LAST_ID(), null);
            if (registos.moveToFirst()) {
                do {
                    idPersona = registos.getInt(0);
                } while (registos.moveToNext());
            }
        }finally {
            if(registos != null){
                registos.close();
            }
        }
        return idPersona;
    }
*/

}
