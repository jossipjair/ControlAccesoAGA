package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_Empresa;
import com.jej.jescalaya.appcontrolacceso.modelo.M_Estado;

public class C_Empresa {

    public void insertaEmpresaRest(Context context){
        M_Empresa m_empresa =  new M_Empresa();
        m_empresa.insertarEmpresaLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_Empresa m_empresa = new M_Empresa();
        m_empresa.llenarEmpresa(context, spinner);
    }


}
