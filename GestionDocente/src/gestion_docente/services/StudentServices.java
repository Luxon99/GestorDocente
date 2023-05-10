/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.dbutils.DbUtils;
import gestion_docente.utils.models.tableStudents;
import java.util.ArrayList;

/**
 * @author César Fernandez Garcia 08/05/2023
 */
public class StudentServices {

    private int idMasGrande;
    private ResultSet rs;

    public StudentServices() {

    }

    public boolean insertStudent(String name, String surname, boolean sexo, String municipality, int group) throws SQLException {
        try {
            idMasGrande = getIdMasGrande();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String procedimientoInsertStudent = "{call \"public\".\"insert_student\"(?,?,?,?,?,?)}";
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        CallableStatement procInsertStudent = miConexion.prepareCall(procedimientoInsertStudent);//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos

        //TODO obtener el Id del nuevo estudiante mediante un metodo que me devuelve el Id mas grande que existe en la BD
        //o buscar una variable q contenga ese numero
        idMasGrande = idMasGrande + 1;//le sumo 1 para que el proximo estudiante sea creado con el siguiente id
        procInsertStudent.setInt(1, idMasGrande);//se le pasa por parametro 1 el id
        procInsertStudent.setString(2, name);//se le pasa por parametro 2 el nombre
        procInsertStudent.setString(3, surname);// se le pasa por parametro 3 los apellidos
        procInsertStudent.setBoolean(4, sexo);//se le pasa el 4 parametro q indica el sexo
        procInsertStudent.setString(5, municipality);//se le pasa el 5 parametro q indica el municipio al cual pertenece
        procInsertStudent.setInt(6, 0);//se le pasa el grupo al cual pertenece

        return procInsertStudent.execute();
    }

    /**
     * @author Cesar Fernandez Garcia
     * @return int
     * @throws java.sql.SQLException
     *
     */
    public int getIdMasGrande() throws SQLException {
        int id = -1;
        String consulta = "SELECT max(id_student) as maximo FROM students";
        java.sql.Connection miConexion = ServicesLocator.getConnection();

        Statement procGetIdMAsGrande = miConexion.createStatement();//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos
        rs = procGetIdMAsGrande.executeQuery(consulta);
        if (rs.next()) {//si la funcion se ejecuto correctamente
            id = rs.getInt("maximo");//obtengo el retorno de la funcion
        }
        procGetIdMAsGrande.close();
        miConexion.close();
        return id;
    }

    public ArrayList<Object[]> getAllStudents() throws SQLException {
        
        
        StudentServices ss = ServicesLocator.getStudentServices();
        java.sql.Connection miConexion = ServicesLocator.getConnection();

        String consulta = "select load_students();\n"
                + "fetch all from \"all_students\";";
        Statement s = miConexion.createStatement();

        rs = s.executeQuery(consulta);
        
        String id_student;
        String nombre;
        String apellidos;
        String sexo;
        String municipio;
        int grupo;
        
        ArrayList<Object[]> datos = new ArrayList<>();
        while (rs.next()) {
            id_student = rs.getString(1);
            nombre = rs.getString(2);
            apellidos = rs.getString(3);
            if (rs.getBoolean(4)) {
                sexo = "Masculino";
            } else {
                sexo = "Femenino";
            }
            municipio = rs.getString(5);

            consulta = "select CONCAT(year,'',num_group) from groups where id_group = " + rs.getString(6)+";";
            s = miConexion.createStatement();

            rs = s.executeQuery(consulta);

            grupo = Integer.parseInt(rs.getString(1));

            datos.add(new Object[]{id_student, nombre, apellidos, sexo, municipio, grupo});
        }

        rs.close();
        s.close();
        miConexion.close();

        return datos;
    }
}
