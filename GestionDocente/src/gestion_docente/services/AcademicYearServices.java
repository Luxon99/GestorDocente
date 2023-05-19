/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.YearDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author César
 */
public class AcademicYearServices extends ServicesEstandar{

    public ArrayList<YearDTO> getYears() throws SQLException {
        ArrayList<YearDTO> stadiums = new ArrayList<>();

        String query = "SELECT * FROM years";

        java.sql.Connection connection = ServicesLocator.getConnection();

        ResultSet result = connection.createStatement().executeQuery(query);

        while (result.next()) {
            YearDTO dto = new YearDTO(result.getInt(1), result.getInt(2), result.getString(3));
            stadiums.add(dto);
        }

        return stadiums;
    }
}
