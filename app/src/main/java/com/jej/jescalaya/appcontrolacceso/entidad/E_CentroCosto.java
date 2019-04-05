package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_CentroCosto {

    private int con_Id;
    private int emp_Id;
    private int est_Id;
    private int suc_Id;
    private String con_Codigo;
    private String con_Descripcion;
    private String con_DescripcionCor;
    private String con_CodigoLot;

    public E_CentroCosto() {

    }

    public E_CentroCosto(int con_Id, int emp_Id, int est_Id, int suc_Id, String con_Codigo, String con_Descripcion, String con_DescripcionCor, String con_CodigoLot) {
        this.con_Id = con_Id;
        this.emp_Id = emp_Id;
        this.est_Id = est_Id;
        this.suc_Id = suc_Id;
        this.con_Codigo = con_Codigo;
        this.con_Descripcion = con_Descripcion;
        this.con_DescripcionCor = con_DescripcionCor;
        this.con_CodigoLot = con_CodigoLot;
    }

    public int getCon_Id() {
        return con_Id;
    }

    public void setCon_Id(int con_Id) {
        this.con_Id = con_Id;
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

    public int getSuc_Id() {
        return suc_Id;
    }

    public void setSuc_Id(int suc_Id) {
        this.suc_Id = suc_Id;
    }

    public String getCon_Codigo() {
        return con_Codigo;
    }

    public void setCon_Codigo(String con_Codigo) {
        this.con_Codigo = con_Codigo;
    }

    public String getCon_Descripcion() {
        return con_Descripcion;
    }

    public void setCon_Descripcion(String con_Descripcion) {
        this.con_Descripcion = con_Descripcion;
    }

    public String getCon_DescripcionCor() {
        return con_DescripcionCor;
    }

    public void setCon_DescripcionCor(String con_DescripcionCor) {
        this.con_DescripcionCor = con_DescripcionCor;
    }

    public String getCon_CodigoLot() {
        return con_CodigoLot;
    }

    public void setCon_CodigoLot(String con_CodigoLot) {
        this.con_CodigoLot = con_CodigoLot;
    }
}
