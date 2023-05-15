/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import gestion_docente.dto.EstandarDTO;
import gestion_docente.dto.StudentDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author César
 */
public class ServicesEstandar {

    public static String DELETE_EVALUATION = "delete_evaluation";
    public static String DELETE_STUDENT = "delete_student";
    public static String DELETE_SUBJECT = "delete_subject";
    public static String DELETE_GROUP = "delete_group";
    public static String DELETE_YEAR = "delete_year";

    public static String INSERT_EVALUATION = "insert_evaluation";
    public static String INSERT_STUDENT = "insert_student";
    public static String INSERT_SUBJECT = "insert_subject";
    public static String INSERT_GROUP = "insert_group";
    public static String INSERT_YEAR = "insert_year";

    public static String PARAM_STUDENT = "(?,?,?,?,?)";
    public static String PARAM_GROUP = "(?,?)";
    public static String PARAM_EVALUATION = "(?,?,?)";
    public static String PARAM_SUBJECT = "(?,?,?)";
    public static String PARAM_YEAR = "(?,?)";

    public boolean delete_object(int id, String delete_function) throws SQLException {

        String consulta = "{call " + delete_function + "(?)}";
        Connection conexion = ServicesLocator.getConnection();
        CallableStatement cs = conexion.prepareCall(consulta);

        cs.setInt(1, id);//se le pasa por parametro el id de la evaluacion

        return cs.execute();

    }

    /**
     *
     * @param insert_function
     * @param param_object
     * @param object
     * @return boolean
     * @throws java.sql.SQLException
     * @throws java.lang.IllegalAccessException
     */
    public boolean insert_object(String insert_function, String param_object, EstandarDTO object) throws SQLException, IllegalAccessException {
        String procedimiento = "{call " + insert_function + param_object + "}";
        java.sql.Connection miConexion = ServicesLocator.getConnection();
        CallableStatement proc = miConexion.prepareCall(procedimiento);//se crea el procedimiento CallableStatement el cual permite hacer llamadas a procedimietno almacenados en la Base de datos

        //si es un estudiante lo que se quiere insertar
        Object[] atributos = object.getValues();//obtengo el arreglo de campos

        //recorrer cada atributo y pasarlo como parametro del procedimiento
        for (int i = 0; i < atributos.length; i++) {
            proc.setObject(i + 1, atributos[i]);//se le pasa a cada ? su respectivo valor
        }

        return proc.execute();

    }

}
