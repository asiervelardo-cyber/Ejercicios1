/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam1
 */
public class DaoImplementado implements Dao{

    private final Singleton conectionn;
    public DaoImplementado() throws SQLException{
        this.conectionn = Singleton.getInstancia();
    }
    
    @Override
    public boolean opcion1(Singleton conexion) {
        System.out.println("1 --------------------------------------------------------------------------------");
        try {
            Connection connection = conectionn.getConexion();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT alumno, excusa, dias_retraso, nivel_drama FROM excusa_entrega ORDER BY nivel_drama DESC");
            while (rs.next()) { try {
                // Leer el ResultSet
                System.out.println("Nombre: " + rs.getString("alumno"));
            } catch (SQLException ex) {
                Logger.getLogger(DaoImplementado.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Excusa: " + rs.getString("excusa"));
            System.out.println("Dias de retraso: " + rs.getString("dias_retraso"));
            System.out.println("Nivel de drama: " + rs.getString("nivel_drama"));
            System.out.println(" ");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean opcion2(Singleton conexion) {
        System.out.println("2 --------------------------------------------------------------------------------");   
        try{
            Connection connection = conectionn.getConexion();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT excusa FROM excusa_entrega WHERE excusa LIKE('%perro%') AND dias_retraso BETWEEN 2 AND 6 ORDER BY dias_retraso DESC");
            while (rs.next()) { // Leer el ResultSet
                System.out.println("Excusa: " + rs.getString("excusa"));
                System.out.println(" ");
            }   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean opcion3(Singleton conexion) {
        System.out.println("3 --------------------------------------------------------------------------------");
        try{
            Connection connection = conectionn.getConexion();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM excusa_entrega WHERE fecha_entrega IS NULL AND (credibilidad<4 OR nivel_drama >= 9)");
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean opcion4(Singleton conexion) {
        System.out.println("4 --------------------------------------------------------------------------------");
        try{
            Connection connection = conectionn.getConexion();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM excusa_entrega WHERE (nivel_drama>=8 AND credibilidad<=3) OR (dias_retraso BETWEEN 2 AND 5 AND excusa LIKE '%perro%')");
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
