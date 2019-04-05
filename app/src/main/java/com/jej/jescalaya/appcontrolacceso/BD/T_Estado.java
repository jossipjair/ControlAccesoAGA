package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Estado {

    private static final String TABLA = "Estado";

    private static final String EST_ID = "Est_Id";
    private static final String EST_CODIGO = "Est_Codigo";
    private static final String EST_DESCRIPCION = "Est_Descripcion";
    private static final String EST_ABREVIATURA = "Est_Abreviatura";
    private static final String EST_ESINTERNO = "Est_EsInterno";

    public static final String CREATE_TESTADO = "CREATE TABLE " + TABLA + "("
            + EST_ID + " INTEGER NOT NULL,"
            + EST_CODIGO + " TEXT NOT NULL,"
            + EST_DESCRIPCION + " TEXT NOT NULL,"
            + EST_ABREVIATURA + " TEXT NOT NULL,"
            + EST_ESINTERNO + " TEXT NOT NULL);";

    public static final String DROP_TESTADO = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TESTADO(int est_Id, String est_Codigo, String est_Descripcion, String est_Abreviatura, String est_EsInterno){
        return "INSERT INTO " + TABLA + " (" + EST_ID + "," + EST_CODIGO + "," + EST_DESCRIPCION + "," + EST_ABREVIATURA + "," + EST_ESINTERNO + ") VALUES("
                + est_Id + ",'" + est_Codigo + "','" + est_Descripcion + "','" + est_Abreviatura + "','" + est_EsInterno + "');";
    }


}
