package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Personal {
    private int per_Id;
    private int est_Id;
    private int car_Id;
    private int tipDocIde_Id;
    private int tipSex_Id;
    private String per_ApellidoPat;
    private String per_ApellidoMat;
    private String per_Nombres;
    private String per_NumeroDocIde;
    private String per_Direccion;
    private String per_Foto;
    private String per_FechaNac;
    private int per_Manager;

    public E_Personal() {

    }

    public E_Personal(int per_Id, int est_Id, int car_Id, int tipDocIde_Id, int tipSex_Id, String per_ApellidoPat, String per_ApellidoMat, String per_Nombres, String per_NumeroDocIde, String per_Direccion, String per_Foto, String per_FechaNac, int per_Manager) {
        this.per_Id = per_Id;
        this.est_Id = est_Id;
        this.car_Id = car_Id;
        this.tipDocIde_Id = tipDocIde_Id;
        this.tipSex_Id = tipSex_Id;
        this.per_ApellidoPat = per_ApellidoPat;
        this.per_ApellidoMat = per_ApellidoMat;
        this.per_Nombres = per_Nombres;
        this.per_NumeroDocIde = per_NumeroDocIde;
        this.per_Direccion = per_Direccion;
        this.per_Foto = per_Foto;
        this.per_FechaNac = per_FechaNac;
        this.per_Manager = per_Manager;
    }

    public int getPer_Id() {
        return per_Id;
    }

    public void setPer_Id(int per_Id) {
        this.per_Id = per_Id;
    }

    public int getEst_Id() {
        return est_Id;
    }

    public void setEst_Id(int est_Id) {
        this.est_Id = est_Id;
    }

    public int getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(int car_Id) {
        this.car_Id = car_Id;
    }

    public int getTipDocIde_Id() {
        return tipDocIde_Id;
    }

    public void setTipDocIde_Id(int tipDocIde_Id) {
        this.tipDocIde_Id = tipDocIde_Id;
    }

    public int getTipSex_Id() {
        return tipSex_Id;
    }

    public void setTipSex_Id(int tipSex_Id) {
        this.tipSex_Id = tipSex_Id;
    }

    public String getPer_ApellidoPat() {
        return per_ApellidoPat;
    }

    public void setPer_ApellidoPat(String per_ApellidoPat) {
        this.per_ApellidoPat = per_ApellidoPat;
    }

    public String getPer_ApellidoMat() {
        return per_ApellidoMat;
    }

    public void setPer_ApellidoMat(String per_ApellidoMat) {
        this.per_ApellidoMat = per_ApellidoMat;
    }

    public String getPer_Nombres() {
        return per_Nombres;
    }

    public void setPer_Nombres(String per_Nombres) {
        this.per_Nombres = per_Nombres;
    }

    public String getPer_NumeroDocIde() {
        return per_NumeroDocIde;
    }

    public void setPer_NumeroDocIde(String per_NumeroDocIde) {
        this.per_NumeroDocIde = per_NumeroDocIde;
    }

    public String getPer_Direccion() {
        return per_Direccion;
    }

    public void setPer_Direccion(String per_Direccion) {
        this.per_Direccion = per_Direccion;
    }

    public String getPer_Foto() {
        return per_Foto;
    }

    public void setPer_Foto(String per_Foto) {
        this.per_Foto = per_Foto;
    }

    public String getPer_FechaNac() {
        return per_FechaNac;
    }

    public void setPer_FechaNac(String per_FechaNac) {
        this.per_FechaNac = per_FechaNac;
    }

    public int getPer_Manager() {
        return per_Manager;
    }

    public void setPer_Manager(int per_Manager) {
        this.per_Manager = per_Manager;
    }

    @Override
    public String toString(){
        return getPer_ApellidoPat() + " " + getPer_ApellidoMat() + " " + getPer_Nombres();
    }
}
