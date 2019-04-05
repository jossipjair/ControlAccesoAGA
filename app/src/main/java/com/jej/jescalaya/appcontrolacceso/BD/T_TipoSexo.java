package com.jej.jescalaya.appcontrolacceso.BD;

public class T_TipoSexo {

    private static final String TABLA = "TipoSexo";

    private static final String TIPSEX_ID = "TipSex_Id";
    private static final String EST_ID = "Est_Id";
    private static final String TIPSEX_CODIGO = "TipSex_Codigo";
    private static final String TIPSEX_DESCRIPCION = "TipSex_Descripcion";

    public static final String CREATE_TTIPOSEXO = "CREATE TABLE " +  TABLA + "("
            + TIPSEX_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + TIPSEX_CODIGO + " TEXT NOT NULL,"
            + TIPSEX_DESCRIPCION + " TEXT NOT NULL);";

    public static final String DROP_TTIPOSEXO = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TTIPOSEXO(int tipSex_Id, int est_Id, String tipSex_Codigo, String tipSex_Descripcion){
        return "INSERT INTO " + TABLA + "(" + TIPSEX_ID + "," + EST_ID + "," + TIPSEX_CODIGO + "," + TIPSEX_DESCRIPCION + ") VALUES("
                + tipSex_Id + "," + est_Id + ",'" + tipSex_Codigo + "','" + tipSex_Descripcion + "');";
    }

    public static final String SELECT_TIPOSEXO(){
        return "SELECT TipSex_Id, TipSex_Descripcion FROM " + TABLA + ";";
    }

}
