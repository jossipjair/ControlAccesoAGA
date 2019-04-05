package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_MovimientoAcceso {

    private int movAcc_Id;
    private String movAcc_FechaHorMov;
    private String movAcc_FechaHorMovLogLoc;
    private String movAcc_FechaHorMovLogSer;
    private int per_Id;
    private int est_Id;
    private int suc_Id;
    private int motMov_Id;
    private int tipAcc_Id;
    private int con_Id;
    private String movAcc_PlacaVeh;
    private String movAcc_Marca;
    private String movAcc_Modelo;

    public E_MovimientoAcceso() {

    }

    public E_MovimientoAcceso(int movAcc_Id, String movAcc_FechaHorMov, String movAcc_FechaHorMovLogLoc, String movAcc_FechaHorMovLogSer, int per_Id, int est_Id, int suc_Id, int motMov_Id, int tipAcc_Id, int con_Id, String movAcc_PlacaVeh, String movAcc_Marca, String movAcc_Modelo) {
        this.movAcc_Id = movAcc_Id;
        this.movAcc_FechaHorMov = movAcc_FechaHorMov;
        this.movAcc_FechaHorMovLogLoc = movAcc_FechaHorMovLogLoc;
        this.movAcc_FechaHorMovLogSer = movAcc_FechaHorMovLogSer;
        this.per_Id = per_Id;
        this.est_Id = est_Id;
        this.suc_Id = suc_Id;
        this.motMov_Id = motMov_Id;
        this.tipAcc_Id = tipAcc_Id;
        this.con_Id = con_Id;
        this.movAcc_PlacaVeh = movAcc_PlacaVeh;
        this.movAcc_Marca = movAcc_Marca;
        this.movAcc_Modelo = movAcc_Modelo;
    }

    public int getMovAcc_Id() {
        return movAcc_Id;
    }

    public void setMovAcc_Id(int movAcc_Id) {
        this.movAcc_Id = movAcc_Id;
    }

    public String getMovAcc_FechaHorMov() {
        return movAcc_FechaHorMov;
    }

    public void setMovAcc_FechaHorMov(String movAcc_FechaHorMov) {
        this.movAcc_FechaHorMov = movAcc_FechaHorMov;
    }

    public String getMovAcc_FechaHorMovLogLoc() {
        return movAcc_FechaHorMovLogLoc;
    }

    public void setMovAcc_FechaHorMovLogLoc(String movAcc_FechaHorMovLogLoc) {
        this.movAcc_FechaHorMovLogLoc = movAcc_FechaHorMovLogLoc;
    }

    public String getMovAcc_FechaHorMovLogSer() {
        return movAcc_FechaHorMovLogSer;
    }

    public void setMovAcc_FechaHorMovLogSer(String movAcc_FechaHorMovLogSer) {
        this.movAcc_FechaHorMovLogSer = movAcc_FechaHorMovLogSer;
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

    public int getSuc_Id() {
        return suc_Id;
    }

    public void setSuc_Id(int suc_Id) {
        this.suc_Id = suc_Id;
    }

    public int getMotMov_Id() {
        return motMov_Id;
    }

    public void setMotMov_Id(int motMov_Id) {
        this.motMov_Id = motMov_Id;
    }

    public int getTipAcc_Id() {
        return tipAcc_Id;
    }

    public void setTipAcc_Id(int tipAcc_Id) {
        this.tipAcc_Id = tipAcc_Id;
    }

    public int getCon_Id() {
        return con_Id;
    }

    public void setCon_Id(int con_Id) {
        this.con_Id = con_Id;
    }

    public String getMovAcc_PlacaVeh() {
        return movAcc_PlacaVeh;
    }

    public void setMovAcc_PlacaVeh(String movAcc_PlacaVeh) {
        this.movAcc_PlacaVeh = movAcc_PlacaVeh;
    }

    public String getMovAcc_Marca() {
        return movAcc_Marca;
    }

    public void setMovAcc_Marca(String movAcc_Marca) {
        this.movAcc_Marca = movAcc_Marca;
    }

    public String getMovAcc_Modelo() {
        return movAcc_Modelo;
    }

    public void setMovAcc_Modelo(String movAcc_Modelo) {
        this.movAcc_Modelo = movAcc_Modelo;
    }


}
