package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Empresa {

    private int emp_Id;
    private int est_Id;
    private String emp_Codigo;
    private String emp_Ruc;
    private String emp_RazonSoc;
    private String emp_Direccion;
    private String emp_Abreviado;

    public E_Empresa() {

    }

    public E_Empresa(int emp_Id, String emp_RazonSoc) {
        this.emp_Id = emp_Id;
        this.emp_RazonSoc = emp_RazonSoc;
    }

    public E_Empresa(int emp_Id, int est_Id, String emp_Codigo, String emp_Ruc, String emp_RazonSoc, String emp_Direccion, String emp_Abreviado) {
        this.emp_Id = emp_Id;
        this.est_Id = est_Id;
        this.emp_Codigo = emp_Codigo;
        this.emp_Ruc = emp_Ruc;
        this.emp_RazonSoc = emp_RazonSoc;
        this.emp_Direccion = emp_Direccion;
        this.emp_Abreviado = emp_Abreviado;
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

    public String getEmp_Codigo() {
        return emp_Codigo;
    }

    public void setEmp_Codigo(String emp_Codigo) {
        this.emp_Codigo = emp_Codigo;
    }

    public String getEmp_Ruc() {
        return emp_Ruc;
    }

    public void setEmp_Ruc(String emp_Ruc) {
        this.emp_Ruc = emp_Ruc;
    }

    public String getEmp_RazonSoc() {
        return emp_RazonSoc;
    }

    public void setEmp_RazonSoc(String emp_RazonSoc) {
        this.emp_RazonSoc = emp_RazonSoc;
    }

    public String getEmp_Direccion() {
        return emp_Direccion;
    }

    public void setEmp_Direccion(String emp_Direccion) {
        this.emp_Direccion = emp_Direccion;
    }

    public String getEmp_Abreviado() {
        return emp_Abreviado;
    }

    public void setEmp_Abreviado(String emp_Abreviado) {
        this.emp_Abreviado = emp_Abreviado;
    }

    @Override
    public String toString(){
        return getEmp_RazonSoc();
    }
}
