package com.jej.jescalaya.appcontrolacceso.BD;

public class T_TipoDocumentoIdentidad {

    private static final String TABLA = "TipoDocumentoIdentidad";

    private static final String TIPDOCIDE_ID = "TipDocIde_Id";
    private static final String EST_ID = "Est_Id";
    private static final String TIPDOCID_CODIGO = "TipDocId_Codigo";
    private static final String TIPDOCID_DESCRIPCION = "TipDocId_Descripcion";

    public static final String CREATE_TTIPODOCUMENTOIDENTIDAD = "CREATE TABLE " +  TABLA + "("
            + TIPDOCIDE_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + TIPDOCID_CODIGO + " TEXT NOT NULL,"
            + TIPDOCID_DESCRIPCION + " TEXT NOT NULL);";

    public static final String DROP_TTIPODOCUMENTOIDENTIDAD = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TTIPODOCUMENTOIDENTIDAD(int tipDocIde_Id, int est_Id, String tipDocId_Codigo, String tipDocId_Descripcion){
        return "INSERT INTO " + TABLA + "(" + TIPDOCIDE_ID + "," + EST_ID + "," + TIPDOCID_CODIGO + "," + TIPDOCID_DESCRIPCION +") VALUES("
                + tipDocIde_Id + "," + est_Id + ",'" + tipDocId_Codigo + "','" + tipDocId_Descripcion + "');";
    }

    public static final String SELECT_TIPODOCUMENTO(){
        return "SELECT TipDocIde_Id, TipDocId_Descripcion FROM " + TABLA + ";";
    }

}
