/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class GroupServices {
    
    
    /**
     @author Cesar Fernandez Garcia 8/05/2023 15:09
     * @param int year: Año academico del cual se quiern saber los grupos
     * @return ArrayList<Integer> listado de Grupos
     */
    public ArrayList<Integer> getGroupsOfYear(int year){
        ArrayList<Integer> listadoGrupos = new ArrayList<>();
        
        GroupServices gs = ServicesLocator.getGroupServices();
        String procedimiento = "{ ?= call get_groups_of_year(?)}";        
        
        
        return listadoGrupos;
    }
    public String getGroup(int id_group) throws SQLException{
        String grupo="";
        Connection conexion = ServicesLocator.getConnection();
        String consulta = "SELECT CONCAT(year,'',num_group) as grupo FROM groups WHERE groups.id_group="+id_group;
        ResultSet rs;
        try (Statement ss = conexion.createStatement()) {
            rs = ss.executeQuery(consulta);
            if (rs.next()) {//si la funcion se ejecuto correctamente
                grupo = rs.getString("grupo");//obtengo el retorno de la funcion
            }
        }
        rs.close();
        
        return grupo;
    }
    
}
