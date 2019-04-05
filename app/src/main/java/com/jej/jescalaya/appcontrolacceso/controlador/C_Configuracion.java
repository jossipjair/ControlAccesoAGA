package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;

import com.jej.jescalaya.appcontrolacceso.entidad.E_Configuracion;
import com.jej.jescalaya.appcontrolacceso.modelo.M_Configuracion;

public class C_Configuracion {

    public void guardarConfiguracion(final Context context, String empresa, String sucursal, String ipServidor) {
            M_Configuracion configuracion = new M_Configuracion();
            configuracion.insertConfiguracion(context, empresa, sucursal, ipServidor);
    }

    public E_Configuracion configuracionSelect(Context context) {
        M_Configuracion configuracion = new M_Configuracion();
        return configuracion.mostrarConfiguracion(context);
    }

}
