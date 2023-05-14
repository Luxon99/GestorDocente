/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.EvaluationDTO;
import gestion_docente.dto.GroupDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class EvaluationServices {
    
    
    
    public boolean insertEvaluation(int id_student,int id_subject,int evaluation) throws SQLException {
        String procedimientoInsertEvaluation = "{call insert_evaluation(?,?,?)}";
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        CallableStatement procInsertEvaluation = miConexion.prepareCall(procedimientoInsertEvaluation);//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos

        procInsertEvaluation.setInt(1, id_student);//se le pasa por parametro 1 el anio
        procInsertEvaluation.setInt(2, id_subject);// se le pasa por parametro 2 el numero del grupo
        procInsertEvaluation.setInt(3, evaluation);// se le pasa por parametro 2 el numero del grupo

        return procInsertEvaluation.execute();

    }

    public boolean deleteEvaluation(int id) throws SQLException {

        String consulta = "{call delete_evaluation(?)}";
        Connection conexion = ServicesLocator.getConnection();
        CallableStatement cs = conexion.prepareCall(consulta);

        cs.setInt(1, id);//se le pasa por parametro el id del grupo

        return cs.execute();

    }
    public ArrayList<EvaluationDTO> getAllEvaluations() throws SQLException, ClassNotFoundException {

        ArrayList<EvaluationDTO> listOfGroups = new ArrayList<>();
        String function = "{?= call load_evaluations()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        try ( CallableStatement preparedFunction = connection.prepareCall(function)) {
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            preparedFunction.execute();
            try ( ResultSet resultSet = (ResultSet) preparedFunction.getObject(1)) {
                while (resultSet.next()) {
                    listOfGroups.add(new EvaluationDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
                }
            }
        }

        return listOfGroups;
    }

}
