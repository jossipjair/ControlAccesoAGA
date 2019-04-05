package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_MotivoMovimiento;

public class C_MotivoMovimiento {

    public void insertaMotivoMovimientoRest(Context context){
        M_MotivoMovimiento m_motivoMovimiento =  new M_MotivoMovimiento();
        m_motivoMovimiento.insertarMotivoMovimientoLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_MotivoMovimiento m_motivoMovimiento =  new M_MotivoMovimiento();
        m_motivoMovimiento.llenarMotivoMovimiento(context, spinner);
    }

}
