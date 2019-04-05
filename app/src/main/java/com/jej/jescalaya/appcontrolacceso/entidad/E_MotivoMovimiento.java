package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_MotivoMovimiento {

    private int motMov_Id;
    private int est_Id;
    private String motMov_Descripcion;
    private String motMov_Abreviatura;

    public E_MotivoMovimiento() {

    }

    public E_MotivoMovimiento(int motMov_Id, String motMov_Descripcion) {
        this.motMov_Id = motMov_Id;
        this.motMov_Descripcion = motMov_Descripcion;
    }

    public E_MotivoMovimiento(int motMov_Id, int est_Id, String motMov_Descripcion, String motMov_Abreviatura) {
        this.motMov_Id = motMov_Id;
        this.est_Id = est_Id;
        this.motMov_Descripcion = motMov_Descripcion;
        this.motMov_Abreviatura = motMov_Abreviatura;
    }

    public int getMotMov_Id() {
        return motMov_Id;
    }

    public void setMotMov_Id(int motMov_Id) {
        this.motMov_Id = motMov_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getMotMov_Descripcion() {
        return motMov_Descripcion;
    }

    public void setMotMov_Descripcion(String motMov_Descripcion) {
        this.motMov_Descripcion = motMov_Descripcion;
    }

    public String getMotMov_Abreviatura() {
        return motMov_Abreviatura;
    }

    public void setMotMov_Abreviatura(String motMov_Abreviatura) {
        this.motMov_Abreviatura = motMov_Abreviatura;
    }

    @Override
    public String toString(){
        return getMotMov_Descripcion();
    }
}
