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
        Singleton conexion = Singleton.getInstancia();
        Dao dao = new DaoImplementado();
        dao.opcion1(conexion);
        dao.opcion2(conexion);
        dao.opcion3(conexion);
        dao.opcion4(conexion);
    }
}

