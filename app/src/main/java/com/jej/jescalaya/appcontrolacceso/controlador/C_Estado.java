package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;

import com.jej.jescalaya.appcontrolacceso.modelo.M_Estado;

public class C_Estado {

    public void insertaEstadoRest(Context context){
        M_Estado m_estado =  new M_Estado();
        m_estado.insertarEstadoLocalToService(context);
    }


}
