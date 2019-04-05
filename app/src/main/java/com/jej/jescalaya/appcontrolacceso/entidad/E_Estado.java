package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Estado {

    private int est_Id;
    private String est_Codigo;
    private String est_Descripcion;
    private String est_Abreviatura;
    private String est_EsInterno;

    public E_Estado() {

    }

    public E_Estado(int est_Id, String est_Codigo, String est_Descripcion, String est_Abreviatura, String est_EsInterno) {
        this.est_Id = est_Id;
        this.est_Codigo = est_Codigo;
        this.est_Descripcion = est_Descripcion;
        this.est_Abreviatura = est_Abreviatura;
        this.est_EsInterno = est_EsInterno;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getEst_Codigo() {
        return est_Codigo;
    }

    public void setEst_Codigo(String est_Codigo) {
        this.est_Codigo = est_Codigo;
    }

    public String getEst_Descripcion() {
        return est_Descripcion;
    }

    public void setEst_Descripcion(String est_Descripcion) {
        this.est_Descripcion = est_Descripcion;
    }

    public String getEst_Abreviatura() {
        return est_Abreviatura;
    }

    public void setEst_Abreviatura(String est_Abreviatura) {
        this.est_Abreviatura = est_Abreviatura;
    }

    public String getEst_EsInterno() {
        return est_EsInterno;
    }

    public void setEst_EsInterno(String est_EsInterno) {
        this.est_EsInterno = est_EsInterno;
    }

    @Override
    public String toString(){
        return getEst_Descripcion();
    }

}
