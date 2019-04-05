package com.jej.jescalaya.appcontrolacceso.BD;

public class T_TipoAcceso {

    private static final String TABLA = "TipoAcceso";

    private static final String TIPACC_ID = "TipAcc_Id";
    private static final String EST_ID = "Est_Id";
    private static final String TIPACC_DESCRIPCION= "TipAcc_Descripcion";
    private static final String TIPACC_ABREVIATURA = "TipAcc_Abreviatura";

    public static final String CREATE_TTIPOACCESO = "CREATE TABLE " + TABLA + "("
            + TIPACC_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + TIPACC_DESCRIPCION + " TEXT NOT NULL,"
            + TIPACC_ABREVIATURA + " TEXT NOT NULL);";

    public static final String DROP_TTIPOACCESO = "DROP TABLE IF EXISTS "+ TABLA + ";";

    public static final String INSERT_TTIPOACCESO(int tipAcc_Id, int est_Id, String tipAcc_Descripcion, String tipAcc_Abreviatura){
        return "INSERT INTO " + TABLA + "(" + TIPACC_ID + "," + EST_ID + "," + TIPACC_DESCRIPCION + "," + TIPACC_ABREVIATURA  + ") VALUES("
                + tipAcc_Id + "," + est_Id + ",'" + tipAcc_Descripcion + "','" + tipAcc_Abreviatura + "');";
    }

    public static final String SELECT_TIPOACCESO(){
        return "SELECT TipAcc_Id, TipAcc_Descripcion FROM " + TABLA + ";";
    }

}
