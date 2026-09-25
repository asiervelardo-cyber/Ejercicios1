/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dam1
 */
package Ejercicio1;

import java.sql.*;
import java.util.Scanner;

public class Conexion {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            // Crear una conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ejercicio1", "root", "root");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // Establecer un tiempo máximo de respuesta a 30 segundos
            ResultSet rs;
            
            System.out.println("1 --------------------------------------------------------------------------------");
            rs = statement.executeQuery("SELECT alumno, excusa, dias_retraso, nivel_drama FROM excusa_entrega ORDER BY nivel_drama DESC");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Nombre: " + rs.getString("alumno"));
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println("Dias de retraso: " + rs.getString("dias_retraso"));
                System.out.println("Nivel de drama: " + rs.getString("nivel_drama"));
                System.out.println(" ");
            }

            System.out.println("2 --------------------------------------------------------------------------------");
            rs = statement.executeQuery("SELECT excusa FROM excusa_entrega WHERE excusa LIKE('%perro%') AND dias_retraso BETWEEN 2 AND 6 ORDER BY dias_retraso DESC");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println(" ");
            }        
            
            System.out.println("3 --------------------------------------------------------------------------------");           
            rs = statement.executeQuery("SELECT * FROM excusa_entrega WHERE fecha_entrega IS NULL AND (credibilidad<4 OR nivel_drama >= 9)");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nombre alumno: " + rs.getString("alumno"));
                System.out.println("Curso: " + rs.getString("curso"));
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println("Dias de retraso: " + rs.getString("dias_retraso"));
                System.out.println("Credibiidad: " + rs.getString("credibilidad"));
                System.out.println("Fecha de entrega: " + rs.getString("fecha_entrega"));
                System.out.println("Aprobada: " + rs.getString("aprobada_por_profesor"));
                System.out.println("Nivel de drama: " + rs.getString("nivel_drama"));
                System.out.println(" ");
            }
            
            System.out.println("4 --------------------------------------------------------------------------------");
            rs = statement.executeQuery("SELECT * FROM excusa_entrega WHERE (nivel_drama>=8 AND credibilidad<=3) OR (dias_retraso BETWEEN 2 AND 5 AND excusa LIKE '%perro%')");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nombre alumno: " + rs.getString("alumno"));
                System.out.println("Curso: " + rs.getString("curso"));
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println("Dias de retraso: " + rs.getString("dias_retraso"));
                System.out.println("Credibiidad: " + rs.getString("credibilidad"));
                System.out.println("Fecha de entrega: " + rs.getString("fecha_entrega"));
                System.out.println("Aprobada: " + rs.getString("aprobada_por_profesor"));
                System.out.println("Nivel de drama: " + rs.getString("nivel_drama"));
                System.out.println(" ");
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

