package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Sucursal {

    private static final String TABLA = "Sucursal";

    private static final String SUC_ID = "Suc_Id";
    private static final String EMP_ID = "Emp_Id";
    private static final String EST_ID = "Est_Id";
    private static final String SUC_CODIGO = "Suc_Codigo";
    private static final String SUC_DESCRIPCION = "Suc_Descripcion";
    private static final String SUC_ISFUNDO = "Suc_IsFundo";
    private static final String SUC_ISPLANTA = "Suc_IsPlanta";
    private static final String SUC_ISOFICINA = "Suc_IsOficina";
    private static final String SUC_DESCRIPCIONCOR= "Suc_DescripcionCor";

    public static  final String CREATE_TSUCURSAL = "CREATE TABLE " + TABLA + "("
            + SUC_ID + " INTEGER NOT NULL,"
            + EMP_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + SUC_CODIGO + " TEXT NOT NULL,"
            + SUC_DESCRIPCION + " TEXT NOT NULL,"
            + SUC_ISFUNDO + " TEXT NOT NULL,"
            + SUC_ISPLANTA + " TEXT NOT NULL,"
            + SUC_ISOFICINA + " TEXT NOT NULL,"
            + SUC_DESCRIPCIONCOR + " TEXT NOT NULL);";

    public static final String DROP_TSUCURSAL = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TSUCURSAL(int suc_Id, int emp_Id, int est_Id, String suc_Codigo, String suc_Descripcion, String suc_IsFundo, String suc_IsPlanta, String suc_IsOficina, String suc_DescripcionCor){
        return "INSERT INTO " + TABLA + "(" + SUC_ID + "," + EMP_ID + "," + EST_ID + "," + SUC_CODIGO + "," + SUC_DESCRIPCION + "," + SUC_ISFUNDO + "," + SUC_ISPLANTA + "," + SUC_ISOFICINA + "," + SUC_DESCRIPCIONCOR + ") VALUES("
                + suc_Id + "," + emp_Id + "," + est_Id + ",'" + suc_Codigo + "','" + suc_Descripcion + "','" + suc_IsFundo + "','" + suc_IsPlanta + "','" + suc_IsOficina + "','" + suc_DescripcionCor + "');";

    }

    public static  final String SELECT_SUCURSAL(){
        return "SELECT " + SUC_ID + "," + SUC_DESCRIPCION + " FROM " + TABLA + ";";
    }



}
