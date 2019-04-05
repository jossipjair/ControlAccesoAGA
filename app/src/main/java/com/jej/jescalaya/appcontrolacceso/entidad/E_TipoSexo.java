package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_TipoSexo {

    private int tipSex_Id;
    private int est_Id;
    private String tipSex_Codigo;
    private String tipSex_Descripcion;


    public E_TipoSexo() {

    }

    public E_TipoSexo(int tipSex_Id, String tipSex_Descripcion) {
        this.tipSex_Id = tipSex_Id;
        this.tipSex_Descripcion = tipSex_Descripcion;
    }

    public E_TipoSexo(int tipSex_Id, int est_Id, String tipSex_Codigo, String tipSex_Descripcion) {
        this.tipSex_Id = tipSex_Id;
        this.est_Id = est_Id;
        this.tipSex_Codigo = tipSex_Codigo;
        this.tipSex_Descripcion = tipSex_Descripcion;
    }

    public int getTipSex_Id() {
        return tipSex_Id;
    }

    public void setTipSex_Id(int tipSex_Id) {
        this.tipSex_Id = tipSex_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getTipSex_Codigo() {
        return tipSex_Codigo;
    }

    public void setTipSex_Codigo(String tipSex_Codigo) {
        this.tipSex_Codigo = tipSex_Codigo;
    }

    public String getTipSex_Descripcion() {
        return tipSex_Descripcion;
    }

    public void setTipSex_Descripcion(String tipSex_Descripcion) {
        this.tipSex_Descripcion = tipSex_Descripcion;
    }


    @Override
    public String toString(){
        return getTipSex_Descripcion();
    }
}
