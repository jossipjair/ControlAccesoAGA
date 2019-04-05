package com.jej.jescalaya.appcontrolacceso.BD;

public class T_Cargo {

    //Tabla
    private static final String TABLA = "Cargo";

    //Campos
    private static final String CAR_ID = "Car_Id";
    private static final String CAR_DESCRIPCION = "Car_Descripcion";
    private static final String CAR_ABREVIATURA  = "Car_Abreviatura";
    private static final String EST_ID = "Est_Id";

    //Creacion de Tabla
    public static final String CREATE_TCARGO = "CREATE TABLE " + TABLA + "("
            + CAR_ID + " INTEGER NOT NULL,"
            + CAR_DESCRIPCION + " TEXT NOT NULL,"
            + CAR_ABREVIATURA + " TEXT NOT NULL,"
            + EST_ID + " INTEGER NOT NULL);";

    // /Elimina Tabla
    public static final String DROP_TCARGO  = "DROP TABLE IF EXISTS " + TABLA + ";";

    public static final String INSERT_TCARGO(int car_Id, String car_Descripcion, String car_Abreviatura, int est_Id){
        return "INSERT INTO " + TABLA + "(" + CAR_ID + "," + CAR_DESCRIPCION + "," + CAR_ABREVIATURA + "," + EST_ID + ") VALUES( "
                + car_Id + ",'" + car_Descripcion + "','" + car_Abreviatura + "'," + est_Id + ");";
    }

    public static final String MOSTRAR_TCARGO(){
        return "SELECT " + CAR_ID + "," + CAR_DESCRIPCION + " FROM " + TABLA + ";";
    }

}
