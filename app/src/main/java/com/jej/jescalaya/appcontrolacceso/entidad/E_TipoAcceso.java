package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_TipoAcceso {

    private int tipAcc_Id;
    private int est_Id;
    private String tipAcc_Descripcion;
    private String tipAcc_Abreviatura;

    public E_TipoAcceso() {

    }

    public E_TipoAcceso(int tipAcc_Id, String tipAcc_Descripcion) {
        this.tipAcc_Id = tipAcc_Id;
        this.tipAcc_Descripcion = tipAcc_Descripcion;
    }

    public E_TipoAcceso(int tipAcc_Id, int est_Id, String tipAcc_Descripcion, String tipAcc_Abreviatura) {
        this.tipAcc_Id = tipAcc_Id;
        this.est_Id = est_Id;
        this.tipAcc_Descripcion = tipAcc_Descripcion;
        this.tipAcc_Abreviatura = tipAcc_Abreviatura;
    }


    public int getTipAcc_Id() {
        return tipAcc_Id;
    }

    public void setTipAcc_Id(int tipAcc_Id) {
        this.tipAcc_Id = tipAcc_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getTipAcc_Descripcion() {
        return tipAcc_Descripcion;
    }

    public void setTipAcc_Descripcion(String tipAcc_Descripcion) {
        this.tipAcc_Descripcion = tipAcc_Descripcion;
    }

    public String getTipAcc_Abreviatura() {
        return tipAcc_Abreviatura;
    }

    public void setTipAcc_Abreviatura(String tipAcc_Abreviatura) {
        this.tipAcc_Abreviatura = tipAcc_Abreviatura;
    }

    @Override
    public String toString(){
        return getTipAcc_Descripcion();
    }
}
