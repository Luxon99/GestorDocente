/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.StudentDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author César Fernandez Garcia 08/05/2023
 */
public class StudentServices {

    private int idMasGrande;
    private ResultSet rs;

    public StudentServices() {

    }

    public boolean insertStudent(String name, String surname, boolean sexo, String municipality, int group) throws SQLException {
        String procedimientoInsertStudent = "{call \"public\".\"insert_student\"(?,?,?,?,?)}";
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        CallableStatement procInsertStudent = miConexion.prepareCall(procedimientoInsertStudent);//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos

        procInsertStudent.setString(1, name);//se le pasa por parametro 2 el nombre
        procInsertStudent.setString(2, surname);// se le pasa por parametro 3 los apellidos
        procInsertStudent.setBoolean(3, sexo);//se le pasa el 4 parametro q indica el sexo
        procInsertStudent.setString(4, municipality);//se le pasa el 5 parametro q indica el municipio al cual pertenece
        procInsertStudent.setInt(5, group);//se le pasa el grupo al cual pertenece

        return procInsertStudent.execute();
    }

    /**
     * @author Cesar Fernandez Garcia
     * @return int
     * @throws java.sql.SQLException Esta funcion permite saber el id mas grande
     * que existe
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

    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {

        ArrayList<StudentDTO> listOfStudents = new ArrayList<>();
        String function = "{?= call load_students()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        try (CallableStatement preparedFunction = connection.prepareCall(function)) {
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            preparedFunction.execute();
            try (ResultSet resultSet = (ResultSet) preparedFunction.getObject(1)) {
                while (resultSet.next())
                {
                    listOfStudents.add(new StudentDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getBoolean(4),resultSet.getString(5),resultSet.getInt(6)));
                }
            }
        }

        return listOfStudents;
    }

}
