package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Empresa {

    private static final String TABLA = "Empresa";

    private static final String EMP_ID = "Emp_Id";
    private static final String EST_ID = "Est_Id";
    private static final String EMP_CODIGO = "Emp_Codigo";
    private static final String EMP_RUC = "Emp_Ruc";
    private static final String EMP_RAZONSOC = "Emp_RazonSoc";
    private static final String EMP_DIRECCION = "Emp_Direccion";
    private static final String EMP_ABREVIADO = "Emp_Abreviado";

    public static final String CREATE_TEMPRESA = "CREATE TABLE " + TABLA + "("
            + EMP_ID + " INTEGER NOT NULL,"
            + EST_ID + " INTEGER NOT NULL,"
            + EMP_CODIGO + " TEXT NOT NULL,"
            + EMP_RUC + " TEXT NOT NULL,"
            + EMP_RAZONSOC + " TEXT NOT NULL,"
            + EMP_DIRECCION + " TEXT NOT NULL,"
            + EMP_ABREVIADO + " TEXT NOT NULL);";

    public static final String DROP_TEMPRESA = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TEMPRESA(int emp_Id, int est_Id, String emp_Codigo, String emp_Ruc, String emp_RazonSoc, String emp_Direccion, String emp_Abreviado){
        return "INSERT INTO " + TABLA + "(" + EMP_ID + "," + EST_ID + "," + EMP_CODIGO + "," + EMP_RUC + "," + EMP_RAZONSOC + "," + EMP_DIRECCION + "," + EMP_ABREVIADO + ") VALUES("
                + emp_Id + "," + est_Id + ",'" + emp_Codigo + "','" + emp_Ruc + "','" + emp_RazonSoc + "','" + emp_Direccion + "','" + emp_Abreviado + "');";
    }

    public static final String SELECT_EMPRESA(){
        return "SELECT " + EMP_ID + "," + EMP_RAZONSOC + " FROM " + TABLA + ";";
    }


}
