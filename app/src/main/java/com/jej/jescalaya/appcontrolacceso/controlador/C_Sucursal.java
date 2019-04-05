package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_Empresa;
import com.jej.jescalaya.appcontrolacceso.modelo.M_Sucursal;

public class C_Sucursal {

    public void insertaSucursalRest(Context context){
        M_Sucursal m_motivoMovimiento =  new M_Sucursal();
        m_motivoMovimiento.insertarSucursallLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_Sucursal m_sucursal = new M_Sucursal();
        m_sucursal.llenarSucursal(context, spinner);
    }


}
