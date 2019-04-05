package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Personal {

    private static final String TABLA = "Personal";

    private static final String PER_ID = "Per_Id";
    private static final String EST_ID = "Est_Id";
    private static final String CAR_ID = "Car_Id";
    private static final String TIPDOCIDE_ID = "TipDocIde_Id";
    private static final String TIPSEX_ID = "TipSex_Id";
    private static final String PER_APELLIDOPAT = "Per_ApellidoPat";
    private static final String PER_APELLIDOMAT = "Per_ApellidoMat";
    private static final String PER_NOMBRES  = "Per_Nombres";
    private static final String PER_NUMERODOCIDE = "Per_NumeroDocIde";
    private static final String PER_DIRECCION = "Per_Direccion";
    private static final String PER_FOTO = "Per_Foto";
    private static final String PER_FECHANAC = "Per_FechaNac";
    private static final String PER_MANAGER = "Per_Manager";
        private static final String ES_SINCRONIZADO = "EsSincronizado";

    public static  final String CREATE_TPERSONAL = "CREATE TABLE " + TABLA + "("
            + PER_ID + " TEXT NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + CAR_ID + " INTEGER NOT NULL,"
            + TIPDOCIDE_ID + " INTEGER NOT NULL,"
            + TIPSEX_ID + " INTEGER NOT NULL,"
            + PER_APELLIDOPAT + " TEXT NOT NULL,"
            + PER_APELLIDOMAT + " TEXT NOT NULL,"
            + PER_NOMBRES + " TEXT NOT NULL,"
            + PER_NUMERODOCIDE + " TEXT NOT NULL,"
            + PER_DIRECCION +  " TEXT NOT NULL,"
            + PER_FOTO + " TEXT NOT NULL,"
            + PER_FECHANAC + " TEXT NOT NULL,"
            + PER_MANAGER + " TEXT NOT NULL,"
            + ES_SINCRONIZADO + " INTEGER NOT NULL, CONSTRAINT unk_PerId UNIQUE(Per_Id));";

    public static final String DROP_TPERSONAL = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TPERSONAL(String per_Id, int est_Id, int car_Id, int tipDocIde_Id, int tipSex_Id, String per_ApellidoPat, String per_ApellidoMat, String per_Nombres, String per_NumeroDocIde, String per_Direccion, String per_Foto, String per_FechaNac, String per_Manager, int esSincronizado){
        return  "INSERT INTO " +  TABLA + "(" + PER_ID + "," + EST_ID + "," + CAR_ID + "," + TIPDOCIDE_ID + "," + TIPSEX_ID + "," + PER_APELLIDOPAT + "," + PER_APELLIDOMAT + "," +  PER_NOMBRES  + "," + PER_NUMERODOCIDE + "," +  PER_DIRECCION + "," + PER_FOTO + "," + PER_FECHANAC + "," + PER_MANAGER + "," + ES_SINCRONIZADO + ") VALUES('"
                + per_Id + "'," + est_Id + "," + car_Id + "," + tipDocIde_Id + "," + tipSex_Id + ",'" + per_ApellidoPat + "','" + per_ApellidoMat + "','" + per_Nombres + "','" + per_NumeroDocIde + "','" + per_Direccion + "','" + per_Foto + "','" + per_FechaNac + "','" + per_Manager + "'," +  esSincronizado +");";
    }

    public static final String SINCRONIZA_PERSONAL(){
        return "SELECT Per_Id,Est_Id,Car_Id,TipDocIde_Id,TipSex_Id,Per_ApellidoPat,Per_ApellidoMat,Per_Nombres,Per_NumeroDocIde,Per_Direccion,Per_Foto,Per_FechaNac,Per_Manager FROM Personal WHERE EsSincronizado = 0";
    }

    public static final String ACTUALIZA_REGISTROS_SINCRONIZADOS(String per_Id){
        return "UPDATE Personal SET EsSincronizado = 1 WHERE Per_Id = '" + per_Id+ "';";
    }

    public static final String BUSCA_PERSONA(String per_Id){
        return "SELECT Per_Nombres, Per_ApellidoPat, Per_ApellidoMat FROM " + TABLA + " WHERE Per_Id='" + per_Id +"';";
    }

}
