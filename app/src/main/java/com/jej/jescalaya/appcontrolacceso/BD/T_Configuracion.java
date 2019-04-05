package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Configuracion {

    //TABLA
    private static final String TABLA = "Configuracion";

    private static final String CONF_ID = "Conf_Id";
    private static final String CONF_EMPRESA = "Conf_Empresa";
    private static final String CONF_SUCURSAL = "Conf_Sucursal";
    private static final String CONF_IPSERVIDOR = "Conf_IpServidor";

    public static  final String CREATE_CONFIGURACION = "CREATE TABLE " + TABLA + "("
            + CONF_ID + " INTEGER NOT NULL PRIMARY KEY, "
            + CONF_EMPRESA + " TEXT NOT NULL,"
            + CONF_SUCURSAL + " TEXT NOT NULL,"
            + CONF_IPSERVIDOR + " TEXT NOT NULL);";

    //ELIMINACION DE TABLA
    public static  final String DROP_CONFIGURACION = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static String INSERT_CONFIGURACION(int conf_Id, String conf_Empresa, String conf_Sucursal, String Conf_IpServidor){
        return "INSERT INTO "
                + TABLA + "(" + CONF_ID + "," + CONF_EMPRESA + ","+ CONF_SUCURSAL + "," + CONF_IPSERVIDOR  +") VALUES("+ conf_Id +",'"  + conf_Empresa + "','"+ conf_Sucursal + "','" + Conf_IpServidor + "');";
    }

    public static String MOSTRAR_CONFIGURACION(){
        return "SELECT " + CONF_EMPRESA + "," + CONF_SUCURSAL + "," + CONF_IPSERVIDOR + " FROM " + TABLA + ";";
    }

}
