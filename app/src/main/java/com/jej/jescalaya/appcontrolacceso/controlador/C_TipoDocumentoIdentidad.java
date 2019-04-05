package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.Spinner;

import com.jej.jescalaya.appcontrolacceso.modelo.M_TipoDocumentoIdentidad;

public class C_TipoDocumentoIdentidad {

    public void insertaTipoDocumentoIdentidadRest(Context context){
        M_TipoDocumentoIdentidad m_tipoDocumentoIdentidad =  new M_TipoDocumentoIdentidad();
        m_tipoDocumentoIdentidad.insertarTipoDocumentoIdentidadLocalToService(context);
    }

    public void llenarSpinner(Context context, Spinner spinner){
        M_TipoDocumentoIdentidad m_tipoDocumentoIdentidad = new M_TipoDocumentoIdentidad();
        m_tipoDocumentoIdentidad.llenarTipoDocumento(context, spinner);
    }

}
