/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.utils;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author César Fernández García
 * Esta clase define la conexion a la base de datos
 */
public class Connection {

    private static java.sql.Connection connection;

    public Connection(String serveraddres, String database, String user, String pasword, String port) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + serveraddres + ":"+port+"/" + database;
        connection = DriverManager.getConnection(url, user, pasword);
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
