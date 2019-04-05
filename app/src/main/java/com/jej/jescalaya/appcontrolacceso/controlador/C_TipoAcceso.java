package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_TipoAcceso;

public class C_TipoAcceso {

    public void insertaTipoAccesoRest(Context context){
        M_TipoAcceso m_tipoAcceso =  new M_TipoAcceso();
        m_tipoAcceso.insertarTipoAccesoLocalToService(context);
    }


    public void llenarSpinner(Context context, Spinner spinner){
        M_TipoAcceso m_tipoAcceso =  new M_TipoAcceso();
        m_tipoAcceso.llenarTipoAcceso(context, spinner);
    }

}
