package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;

import com.jej.jescalaya.appcontrolacceso.modelo.M_Personal;

public class C_Personal {

    public void insertaPersonalRest(Context context){
        M_Personal m_personal =  new M_Personal();
        m_personal.insertarPersonalLocalToService(context);
    }

    public void insertaPersonalLocal(Context context, String Per_Id, int Est_Id, int Car_Id, int TipDocIde_Id, int TipSex_Id, String Per_ApellidoPat, String Per_ApellidoMat, String Per_Nombres, String Per_NumeroDocIde, String Per_Direccion, String Per_Foto, String Per_FechaNac, String Per_Manager){
        M_Personal m_personal = new M_Personal();
        m_personal.insertPersonal(context, Per_Id,  Est_Id, Car_Id, TipDocIde_Id, TipSex_Id, Per_ApellidoPat, Per_ApellidoMat, Per_Nombres, Per_NumeroDocIde, Per_Direccion, Per_Foto,Per_FechaNac, "75526541");
    }

    public String buscaPersona(Context context, String per_Id){
        M_Personal m_personal = new M_Personal();
        return m_personal.buscarPersonal(context, per_Id);
    }

}
