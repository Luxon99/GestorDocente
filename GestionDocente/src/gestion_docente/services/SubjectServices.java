/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.StudentDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class SubjectServices {
    public ArrayList<StudentDTO> getAllSubjects() throws SQLException, ClassNotFoundException {

        ArrayList<StudentDTO> listOfStudents = new ArrayList<>();
        String function = "{?= call load_subjects()}";
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
