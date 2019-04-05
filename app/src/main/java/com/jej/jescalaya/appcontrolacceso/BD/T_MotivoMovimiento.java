package com.jej.jescalaya.appcontrolacceso.BD;

public class T_MotivoMovimiento {

    private static final String TABLA = "MotivoMovimiento";

    private static final String MOTMOV_ID = "MotMov_Id";
    private static final String EST_ID = "Est_Id";
    private static final String MOTMOV_DESCRIPCION= "MotMov_Descripcion";
    private static final String MOTMOV_ABREVIATURA= "MotMov_Abreviatura";

    public static final String CREATE_TMOTIVOMOVIMIENTO = "CREATE TABLE " + TABLA + "("
            + MOTMOV_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + MOTMOV_DESCRIPCION + " TEXT NOT NULL,"
            + MOTMOV_ABREVIATURA + " TEXT NOT NULL);";

    public static final String DROP_TMOTIVOMOVIMIENTO = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TMOTIVOMOVIMIENTO (int motMov_Id, int est_Id, String motMov_Descripcion, String motMovAbreviatura){
        return "INSERT INTO " + TABLA + "(" + MOTMOV_ID + "," + EST_ID + "," + MOTMOV_DESCRIPCION + "," + MOTMOV_ABREVIATURA + ") VALUES("
                + motMov_Id + "," + est_Id + ",'" + motMov_Descripcion + "','" + motMovAbreviatura + "');";
    }

    public static final String SELECT_MOTIVOMOVIMIENTO(){
        return "SELECT MotMov_Id, MotMov_Descripcion FROM " + TABLA + ";";
    }


}
