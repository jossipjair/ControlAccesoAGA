package com.jej.jescalaya.appcontrolacceso.BD;

public class T_CentroCosto {

    private static final String TABLA = "CentroCosto";

    private static final String CON_ID = "Con_Id";
    private static final String EMP_ID = "Emp_Id";
    private static final String EST_ID = "Est_Id";
    private static final String SUC_ID = "Suc_Id";
    private static final String CON_CODIGO = "Con_Codigo";
    private static final String CON_DESCRIPCION = "Con_Descripcion";
    private static final String CON_DESCRIPCIONCOR = "Con_DescripcionCor";
    private static final String CON_CODIGOLOT = "Con_CodigoLot";
    private static final String CON_ISLOTE = "Con_IsLote";
    private static final String CON_ISFUNDO ="Con_IsFundo";
    private static final String CON_ISAREA = "Con_IsArea";
    private static final String CON_ISVEHICULO = "Con_IsVehiculo";
    private static final String CON_ISMAQUINARIA ="Con_IsMaquinaria";
    private static final String CON_MARCAVEH = "Con_MarcaVeh";
    private static final String CON_MODELOVEH = "Con_ModeloVeh";

    public static final String CREATE_TCENTRO_COSTO = "CREATE TABLE " + TABLA + "("
            + CON_ID + " INTEGER NOT NULL,"
            + EMP_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + SUC_ID + " INTEGER NOT NULL,"
            + CON_CODIGO + " TEXT NOT NULL,"
            + CON_DESCRIPCION + " TEXT NOT NULL,"
            + CON_DESCRIPCIONCOR + " TEXT NOT NULL,"
            + CON_CODIGOLOT + " TEXT NOT NULL,"
            + CON_ISLOTE + " TEXT NOT NULL,"
            + CON_ISFUNDO + " TEXT NOT NULL,"
            + CON_ISAREA + " TEXT NOT NULL,"
            + CON_ISVEHICULO + " TEXT NOT NULL,"
            + CON_ISMAQUINARIA + " TEXT NOT NULL,"
            + CON_MARCAVEH + " TEXT NOT NULL,"
            + CON_MODELOVEH + " TEXT NOT NULL);";

    public static final String DROP_TCENTROCOSTO = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TCENTROCOSTO(int con_Id, int emp_Id, int est_Id, int suc_Id, String con_Codigo, String con_Descripcion, String con_DescripcionCor, String con_CodigoLot, String con_IsLote, String con_IsFundo, String con_IsArea, String con_IsVehiculo, String con_IsMaquinaria, String con_MarcaVeh, String con_ModeloVeh) {
        return "INSERT INTO " + TABLA + "(" + CON_ID + "," + EMP_ID + "," + EST_ID + "," + SUC_ID + "," + CON_CODIGO + "," + CON_DESCRIPCION + "," + CON_DESCRIPCIONCOR + "," + CON_CODIGOLOT + "," + CON_ISLOTE + "," + CON_ISFUNDO + "," + CON_ISAREA + "," + CON_ISVEHICULO + "," + CON_ISMAQUINARIA + "," + CON_MARCAVEH + "," + CON_MODELOVEH + ") VALUES("
        + con_Id + "," + emp_Id + "," + est_Id + "," + suc_Id + ",'" + con_Codigo + "','" + con_Descripcion + "','" + con_DescripcionCor + "','" + con_CodigoLot + "','" + con_IsLote + "','" + con_IsFundo + "','" + con_IsArea + "','" + con_IsVehiculo + "','" + con_IsMaquinaria + "','" + con_MarcaVeh + "','" + con_ModeloVeh +  "');";
    }

    public static final String SELECT_CENTROCOSTO(String centroCosto){
        return "SELECT Con_Id, Con_Descripcion FROM " + TABLA + " WHERE Con_Descripcion LIKE '%" + centroCosto + "%' AND Con_IsVehiculo = 'true' OR Con_IsMaquinaria = 'true' ORDER BY Con_Descripcion;";
    }

    public static final String SELECT_DATOSCENTROCOSTO(String con_Descripcion){
        return "SELECT Con_Id, Con_CodigoLot, Con_MarcaVeh, Con_ModeloVeh FROM " + TABLA + " WHERE Con_Descripcion = '" + con_Descripcion + "';";
    }

}
