/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.StudentDTO;
import gestion_docente.dto.SubjectDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class SubjectServices extends ServicesEstandar{
    public ArrayList<SubjectDTO> getAllSubjects() throws SQLException, ClassNotFoundException {

        ArrayList<SubjectDTO> listOfSubjects = new ArrayList<>();
        String function = "{?= call load_subject()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        try (CallableStatement preparedFunction = connection.prepareCall(function)) {
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            preparedFunction.execute();
            try (ResultSet resultSet = (ResultSet) preparedFunction.getObject(1)) {
                while (resultSet.next())
                {
                    listOfSubjects.add(new SubjectDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4)));
                }
            }
        }

        return listOfSubjects;
    }

    public String getSubjectById(int id_subject) throws SQLException {
        String nombre="Desconocido";
        String consulta = "SELECT subjects.name_subject FROM subjects WHERE subjects.id_subject="+id_subject;
        try (java.sql.Connection miConexion = ServicesLocator.getConnection()) {
            Statement procGetIdMAsGrande = miConexion.createStatement();//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos
            ResultSet rs = procGetIdMAsGrande.executeQuery(consulta);
            if (rs.next()) {//si la funcion se ejecuto correctamente
                nombre = rs.getString(1);//obtengo el retorno de la funcion
            }
            procGetIdMAsGrande.close();
        } //se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos
        return nombre;

    }
    
}
