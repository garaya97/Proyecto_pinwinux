package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
        //Defino las credenciales de mi servidor de Base de datos
    private static String Url = "jdbc:mysql://localhost:3306/gestion_inventario_pinwinux";
    private static String usuario = "root";
    private static String contraseña = "";

    //Definimos un método para obtener la conexion
    public static Connection getConnection() throws SQLException{
        try{
            return DriverManager.getConnection(Url, usuario, contraseña);
        }catch(SQLException e){
            System.out.println("Error al obtener la conexion" + e.getMessage());
            throw e;
        }
    }

    
}
