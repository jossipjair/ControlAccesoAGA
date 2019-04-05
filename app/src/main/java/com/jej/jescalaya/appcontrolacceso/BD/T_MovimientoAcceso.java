package com.jej.jescalaya.appcontrolacceso.BD;

public class T_MovimientoAcceso {

    private static final String TABLA = "MovimientoAcceso";

    private static final String MOVACC_ID = "MovAcc_Id";
    private static final String MOVACC_FECHAHORMOV = "MovAcc_FechaHorMov";
    private static final String MOVACC_FECHAHORMOVLOGLOC = "MovAcc_FechaHorMovLogLoc";
    private static final String MOVACC_FECHAHORMOVLOGSER = "MovAcc_FechaHorMovLogSer";
    private static final String PER_ID = "Per_Id";
    private static final String EST_ID = "Est_Id";
    private static final String SUC_ID = "Suc_Id";
    private static final String MOTMOV_ID = "MotMov_Id";
    private static final String TIPACC_ID = "TipAcc_Id";
    private static final String CON_ID = "Con_Id";
    private static final String MOVACC_PLACAVEH = "MovAcc_PlacaVeh";
    private static final String MOVACC_MARCA = "MovAcc_Marca";
    private static final String MOVACC_MODELO = "MovAcc_Modelo";
    private static final String ES_SINCRONIZADO = "EsSincronizado";

    public static final String CREATE_TMOVIMIENTOACCESO = "CREATE TABLE " + TABLA + "("
            + MOVACC_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + MOVACC_FECHAHORMOV + " TEXT NOT NULL,"
            + MOVACC_FECHAHORMOVLOGLOC + " TEXT NOT NULL,"
            + MOVACC_FECHAHORMOVLOGSER + " TEXT NOT NULL,"
            + PER_ID + " TEXT NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + SUC_ID + " INTEGER NOT NULL,"
            + MOTMOV_ID + " INTEGER NOT NULL,"
            + TIPACC_ID + " INTEGER NOT NULL,"
            + CON_ID + " INTEGER NOT NULL,"
            + MOVACC_PLACAVEH + " TEXT NOT NULL,"
            + MOVACC_MARCA + " TEXT NOT NULL,"
            + MOVACC_MODELO + " TEXT NOT NULL,"
            + ES_SINCRONIZADO + " INTEGER NOT NULL);";

    public static final String DROP_TMOVIMIENTOACCESO = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TMOVIMIENTOACCESO(String MovAcc_FechaHorMov, String MovAcc_FechaHorMovLogLoc, String MovAcc_FechaHorMovLogSer, String per_Id, int est_Id, int suc_Id, int motMov_Id, int tipAcc_Id, int con_Id, String MovAcc_PlacaVe, String MovAcc_Marca, String MovAcc_Modelo){
        return "INSERT INTO " + TABLA + "(" + MOVACC_FECHAHORMOV + "," + MOVACC_FECHAHORMOVLOGLOC + "," + MOVACC_FECHAHORMOVLOGSER + "," + PER_ID + "," + EST_ID + "," + SUC_ID + "," + MOTMOV_ID + "," + TIPACC_ID + "," + CON_ID + "," + MOVACC_PLACAVEH + "," + MOVACC_MARCA + "," + MOVACC_MODELO + "," + ES_SINCRONIZADO + ") VALUES('"
                +  MovAcc_FechaHorMov + "','" + MovAcc_FechaHorMovLogLoc + "','" + MovAcc_FechaHorMovLogSer + "','" + per_Id + "'," + est_Id + "," + suc_Id + "," + motMov_Id + "," + tipAcc_Id + "," + con_Id + ",'" + MovAcc_PlacaVe + "','" + MovAcc_Marca + "','" + MovAcc_Modelo + "',"+ 0 +");";
    }

    public static String SELECT_MOVIMIENTOACCESO(){
        return "SELECT MovAcc_Id,MovAcc_FechaHorMov, MovAcc_FechaHorMovLogLoc, Per_Id, Est_Id, Suc_Id, MotMov_Id, TipAcc_Id, Con_Id, MovAcc_PlacaVeh, MovAcc_Marca, MovAcc_Modelo FROM " + TABLA  + " WHERE EsSincronizado = 0;";
    }

    public static final String ACTUALIZA_REGISTROS_SINCRONIZADOS(int movAcc_Id){
        return "UPDATE MovimientoAcceso SET EsSincronizado = 1 WHERE MovAcc_Id = " + movAcc_Id+ ";";
    }


}
