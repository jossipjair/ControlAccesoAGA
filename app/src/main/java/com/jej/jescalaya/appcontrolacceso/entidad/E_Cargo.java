package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Cargo {

    private int car_Id;
    private String car_Descripcion;
    private String car_Abreviatura;
    private int est_Id;

    public E_Cargo() {

    }

    public E_Cargo(int car_Id, String car_Descripcion) {
        this.car_Id = car_Id;
        this.car_Descripcion = car_Descripcion;
    }

    public E_Cargo(int car_Id, String car_Descripcion, String car_Abreviatura, int est_Id) {
        this.car_Id = car_Id;
        this.car_Descripcion = car_Descripcion;
        this.car_Abreviatura = car_Abreviatura;
        this.est_Id = est_Id;
    }

    public int getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(int car_Id) {
        this.car_Id = car_Id;
    }

    public String getCar_Descripcion() {
        return car_Descripcion;
    }

    public void setCar_Descripcion(String car_Descripcion) {
        this.car_Descripcion = car_Descripcion;
    }

    public String getCar_Abreviatura() {
        return car_Abreviatura;
    }

    public void setCar_Abreviatura(String car_Abreviatura) {
        this.car_Abreviatura = car_Abreviatura;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    @Override
    public String toString(){
        return getCar_Descripcion();
    }
}
