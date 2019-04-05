package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_TipoDocumentoIdentidad {

    private int tipDocIde_Id;
    private int est_Id;
    private String tipDocId_Codigo;
    private String tipDocId_Descripcion;


    public E_TipoDocumentoIdentidad() {

    }

    public E_TipoDocumentoIdentidad(int tipDocIde_Id, String tipDocId_Descripcion) {
        this.tipDocIde_Id = tipDocIde_Id;
        this.tipDocId_Descripcion = tipDocId_Descripcion;
    }

    public E_TipoDocumentoIdentidad(int tipDocIde_Id, int est_Id, String tipDocId_Codigo, String tipDocId_Descripcion) {
        this.tipDocIde_Id = tipDocIde_Id;
        this.est_Id = est_Id;
        this.tipDocId_Codigo = tipDocId_Codigo;
        this.tipDocId_Descripcion = tipDocId_Descripcion;
    }

    public int getTipDocIde_Id() {
        return tipDocIde_Id;
    }

    public void setTipDocIde_Id(int tipDocIde_Id) {
        this.tipDocIde_Id = tipDocIde_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getTipDocId_Codigo() {
        return tipDocId_Codigo;
    }

    public void setTipDocId_Codigo(String tipDocId_Codigo) {
        this.tipDocId_Codigo = tipDocId_Codigo;
    }

    public String getTipDocId_Descripcion() {
        return tipDocId_Descripcion;
    }

    public void setTipDocId_Descripcion(String tipDocId_Descripcion) {
        this.tipDocId_Descripcion = tipDocId_Descripcion;
    }

    @Override
    public String toString(){
        return getTipDocId_Descripcion();
    }
}
