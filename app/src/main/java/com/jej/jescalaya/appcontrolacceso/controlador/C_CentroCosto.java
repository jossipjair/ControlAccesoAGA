package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jej.jescalaya.appcontrolacceso.modelo.M_CerntroCosto;

public class C_CentroCosto {


    public void insertaCentroCostoRest(Context context){
        M_CerntroCosto m_cerntroCosto =  new M_CerntroCosto();
        m_cerntroCosto.insertarCentroCostoLocalToService(context);
    }

    public ArrayAdapter<String> llenarListaCentroCosto(Context context, ListView listView, String centroCosto){
        M_CerntroCosto modeloCentroCosto = new M_CerntroCosto();
        return modeloCentroCosto.llenarComboCentroCostoList(context, listView, centroCosto);
    }

    public String[] buscaDatosCentroCosto(Context context, String con_Descripcion){
        M_CerntroCosto modeloCentroCosto = new M_CerntroCosto();
        return modeloCentroCosto.buscarDatosCentroCosto(context, con_Descripcion);
    }

}
