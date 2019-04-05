package com.jej.jescalaya.appcontrolacceso.controlador;

import android.content.Context;

import com.jej.jescalaya.appcontrolacceso.modelo.M_MovimientoAcceso;
import com.jej.jescalaya.appcontrolacceso.modelo.M_TipoAcceso;

public class C_MovimientoAcceso {


    public void insertaMovimientoAcceso(Context context, String MovAcc_FechaHorMov, String MovAcc_FechaHorMovLogLoc, String MovAcc_FechaHorMovLogSer, String Per_Id, int Est_Id, int Suc_Id, int MotMov_Id, int TipAcc_Id, int Con_Id, String MovAcc_PlacaVeh, String MovAcc_Marca, String MovAcc_Modelo){
        M_MovimientoAcceso m_movimientoAcceso = new M_MovimientoAcceso();
        m_movimientoAcceso.insertMovimientoAcceso(context, MovAcc_FechaHorMov, MovAcc_FechaHorMovLogLoc, MovAcc_FechaHorMovLogSer,Per_Id, Est_Id, Suc_Id, MotMov_Id, TipAcc_Id, Con_Id, MovAcc_PlacaVeh, MovAcc_Marca, MovAcc_Modelo);
    }

}
