/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author César
 */
public class MunicipalitysServices extends ServicesEstandar {

    public ArrayList<MunicipalityDTO> getAllMunicipalities() throws SQLException, ClassNotFoundException {

        ArrayList<MunicipalityDTO> listOfStudents = new ArrayList<>();
        String function = "{?= call load_municipality()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        try ( CallableStatement preparedFunction = connection.prepareCall(function)) {
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            preparedFunction.execute();
            try ( ResultSet resultSet = (ResultSet) preparedFunction.getObject(1)) {
                while (resultSet.next()) {
                    listOfStudents.add(new MunicipalityDTO(resultSet.getInt(1), resultSet.getString(2)));
                }
            }
        }

        return listOfStudents;
    }

    public static void main(String[] args) {
        MunicipalitysServices m = ServicesLocator.getMunicipalityServices();
        try {
            ArrayList<MunicipalityDTO> a = m.getAllMunicipalities();

            for (MunicipalityDTO e : a) {

                System.out.println(e.getName_municipality());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MunicipalitysServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MunicipalitysServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
