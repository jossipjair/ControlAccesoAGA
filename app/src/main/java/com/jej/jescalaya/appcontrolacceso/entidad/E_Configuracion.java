package com.jej.jescalaya.appcontrolacceso.entidad;

public class E_Configuracion {

    private int conf_Id;
    private String conf_Empresa;
    private String conf_Sucursal;
    private String conf_IpServidor;

    public E_Configuracion(int conf_Id, String conf_Empresa, String conf_Sucursal, String conf_IpServidor) {
        this.conf_Id = conf_Id;
        this.conf_Empresa = conf_Empresa;
        this.conf_Sucursal = conf_Sucursal;
        this.conf_IpServidor = conf_IpServidor;
    }

    public E_Configuracion(String conf_Empresa, String conf_Sucursal, String conf_IpServidor) {
        this.conf_Empresa = conf_Empresa;
        this.conf_Sucursal = conf_Sucursal;
        this.conf_IpServidor = conf_IpServidor;
    }

    public E_Configuracion() {

    }

    public int getConf_Id() {
        return conf_Id;
    }

    public void setConf_Id(int conf_Id) {
        this.conf_Id = conf_Id;
    }

    public String getConf_Empresa() {
        return conf_Empresa;
    }

    public void setConf_Empresa(String conf_Empresa) {
        this.conf_Empresa = conf_Empresa;
    }

    public String getConf_Sucursal() {
        return conf_Sucursal;
    }

    public void setConf_Sucursal(String conf_Sucursal) {
        this.conf_Sucursal = conf_Sucursal;
    }

    public String getConf_IpServidor() {
        return conf_IpServidor;
    }

    public void setConf_IpServidor(String conf_IpServidor) {
        this.conf_IpServidor = conf_IpServidor;
    }
}
