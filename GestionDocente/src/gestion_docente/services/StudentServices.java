/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import java.sql.*;
import javax.swing.table.TableModel;
import org.apache.commons.dbutils.DbUtils;


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
    *@author Cesar Fernandez Garcia
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
    public  getAllStudents() throws SQLException{
        TableModel retorno;
        
        StudentServices ss = ServicesLocator.getStudentServices();
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        String procedimiento = "{?= call public.load_students()}";
        CallableStatement cs = miConexion.prepareCall(procedimiento);
        cs.registerOutParameter(1,java.sql.Types.REF_CURSOR);
        
        if(cs.execute()){
            System.out.println("Ejecuta la funcion");
        }
        
        return null;
    }
}
