package Ejercicios1;

import java.sql.*;

public class Conexion {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Crear una conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:myDriver:Ejercicio1", "root", "root");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // Establecer un tiempo máximo de respuesta a 30 segundos

            ResultSet rs = statement.executeQuery("SELECT alumno, excusa, dias_retraso, nivel_drama FROM excusa_entrega");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Nombre: " + rs.getString("alumno"));
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println("Dias de retraso: " + rs.getString("dias_retraso"));
                System.out.println("Nivel de drama: " + rs.getString("nivel_drama"));
            }
        } catch (SQLException e) {
            // Si el mensaje de error es "out of memory", seguramente es que no se encuentra el fichero
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage()); // Error al cerrar la conexión
            }
        }
    }
}
