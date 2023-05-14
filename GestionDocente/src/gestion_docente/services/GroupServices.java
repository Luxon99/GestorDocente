/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.GroupDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author César
 */
public class GroupServices {

    /**
     * @author Cesar Fernandez Garcia 8/05/2023 15:09
     * @param int year: Año academico del cual se quiern saber los grupos
     * @return ArrayList<Integer> listado de Grupos
     */
    public ArrayList<Integer> getGroupsOfYear(int year) {
        ArrayList<Integer> listadoGrupos = new ArrayList<>();

        GroupServices gs = ServicesLocator.getGroupServices();
        String procedimiento = "{ ?= call get_groups_of_year(?)}";

        return listadoGrupos;
    }

    public boolean insertGroup(int year, int num_group) throws SQLException {
        String procedimientoInsertGroup = "{call insert_group(?,?)}";
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        CallableStatement procInsertGroup = miConexion.prepareCall(procedimientoInsertGroup);//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos

        procInsertGroup.setInt(1, year);//se le pasa por parametro 1 el anio
        procInsertGroup.setInt(2, num_group);// se le pasa por parametro 2 el numero del grupo

        return procInsertGroup.execute();

    }

    public boolean deleteGroup(int id) throws SQLException {

        String consulta = "{call delete_group(?)}";
        Connection conexion = ServicesLocator.getConnection();
        CallableStatement cs = conexion.prepareCall(consulta);

        cs.setInt(1, id);//se le pasa por parametro el id del grupo

        return cs.execute();

    }

    public String getGroup(int id_group) throws SQLException {
        String grupo = "";
        Connection conexion = ServicesLocator.getConnection();
        String consulta = "SELECT CONCAT(year,'',num_group) as grupo FROM groups WHERE groups.id_group=" + id_group;
        ResultSet rs;
        try ( Statement ss = conexion.createStatement()) {
            rs = ss.executeQuery(consulta);
            if (rs.next()) {//si la funcion se ejecuto correctamente
                grupo = rs.getString("grupo");//obtengo el retorno de la funcion
            }
        }
        rs.close();

        return grupo;
    }

    public ArrayList<GroupDTO> getAllGroups() throws SQLException, ClassNotFoundException {

        ArrayList<GroupDTO> listOfGroups = new ArrayList<>();
        String function = "{?= call load_groups()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        try ( CallableStatement preparedFunction = connection.prepareCall(function)) {
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            preparedFunction.execute();
            try ( ResultSet resultSet = (ResultSet) preparedFunction.getObject(1)) {
                while (resultSet.next()) {
                    listOfGroups.add(new GroupDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
                }
            }
        }

        return listOfGroups;
    }

}
