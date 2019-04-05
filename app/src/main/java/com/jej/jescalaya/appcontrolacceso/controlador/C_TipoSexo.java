package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_TipoDocumentoIdentidad;
import com.jej.jescalaya.appcontrolacceso.modelo.M_TipoSexo;

public class C_TipoSexo {

    public void insertaTipoSexoRest(Context context){
        M_TipoSexo m_tipoSexo=  new M_TipoSexo();
        m_tipoSexo.insertarTipoSexoLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_TipoSexo m_tipoSexo=  new M_TipoSexo();
        m_tipoSexo.llenarTipoSexo(context, spinner);
    }


}
