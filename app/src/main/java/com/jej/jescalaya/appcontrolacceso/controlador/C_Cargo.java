package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_Cargo;

public class C_Cargo {

    public void insertaCargoRest(Context context){
        M_Cargo m_cargo =  new M_Cargo();
        m_cargo.insertarCargoLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_Cargo m_cargo =  new M_Cargo();
        m_cargo.llenarCargo(context, spinner);
    }


}
