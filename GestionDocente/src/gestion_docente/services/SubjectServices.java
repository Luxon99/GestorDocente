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
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class SubjectServices extends ServicesEstandar{
    public ArrayList<SubjectDTO> getAllSubjects() throws SQLException, ClassNotFoundException {

        ArrayList<SubjectDTO> listOfSubjects = new ArrayList<>();
        String function = "{?= call load_subjects()}";
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
    
}
