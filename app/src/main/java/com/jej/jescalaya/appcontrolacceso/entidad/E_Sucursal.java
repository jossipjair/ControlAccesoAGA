package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Sucursal {

    private int suc_Id;
    private int emp_Id;
    private int est_Id;
    private String suc_Codigo;
    private String suc_Descripcion;
    private String suc_IsFundo;
    private String suc_IsPlanta;
    private String suc_IsOficina;
    private String suc_DescripcionCor;

    public E_Sucursal() {

    }

    public E_Sucursal(int suc_Id, String suc_Descripcion) {
        this.suc_Id = suc_Id;
        this.suc_Descripcion = suc_Descripcion;
    }

    public E_Sucursal(int suc_Id, int emp_Id, int est_Id, String suc_Codigo, String suc_Descripcion, String suc_IsFundo, String suc_IsPlanta, String suc_IsOficina, String suc_DescripcionCor) {
        this.suc_Id = suc_Id;
        this.emp_Id = emp_Id;
        this.est_Id = est_Id;
        this.suc_Codigo = suc_Codigo;
        this.suc_Descripcion = suc_Descripcion;
        this.suc_IsFundo = suc_IsFundo;
        this.suc_IsPlanta = suc_IsPlanta;
        this.suc_IsOficina = suc_IsOficina;
        this.suc_DescripcionCor = suc_DescripcionCor;
    }

    public int getSuc_Id() {
        return suc_Id;
    }

    public void setSuc_Id(int suc_Id) {
        this.suc_Id = suc_Id;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public String getSuc_Codigo() {
        return suc_Codigo;
    }

    public void setSuc_Codigo(String suc_Codigo) {
        this.suc_Codigo = suc_Codigo;
    }

    public String getSuc_Descripcion() {
        return suc_Descripcion;
    }

    public void setSuc_Descripcion(String suc_Descripcion) {
        this.suc_Descripcion = suc_Descripcion;
    }

    public String getSuc_IsFundo() {
        return suc_IsFundo;
    }

    public void setSuc_IsFundo(String suc_IsFundo) {
        this.suc_IsFundo = suc_IsFundo;
    }

    public String getSuc_IsPlanta() {
        return suc_IsPlanta;
    }

    public void setSuc_IsPlanta(String suc_IsPlanta) {
        this.suc_IsPlanta = suc_IsPlanta;
    }

    public String getSuc_IsOficina() {
        return suc_IsOficina;
    }

    public void setSuc_IsOficina(String suc_IsOficina) {
        this.suc_IsOficina = suc_IsOficina;
    }

    public String getSuc_DescripcionCor() {
        return suc_DescripcionCor;
    }

    public void setSuc_DescripcionCor(String suc_DescripcionCor) {
        this.suc_DescripcionCor = suc_DescripcionCor;
    }

    @Override
    public String toString(){
        return getSuc_Descripcion();
    }
}
