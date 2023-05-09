/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import java.sql.SQLException;

import gestion_docente.utils.Connection;

/**
 *
 * @author César Fernández García En esta clase están todas las instancias de
 * los servicios de la aplicación
 */
public class ServicesLocator {

    private static StudentServices studentServices = null;
    private static GroupServices groupServices = null;
    private static AcademicYearServices academicYearServices = null;
    private static EvaluationServices evaluationServices = null;
    private static SubjectServices subjectServices = null;

    public static StudentServices getStudentServices() {
        if (studentServices == null) {
            studentServices = new StudentServices();
        }
        return studentServices;
    }

    public static GroupServices getGroupServices() {
        if (groupServices == null) {
            groupServices = new GroupServices();
        }
        return groupServices;
    }

    public static AcademicYearServices getAcademicYearServices() {
        if (academicYearServices == null) {
            academicYearServices = new AcademicYearServices();
        }
        return academicYearServices;
    }

    public static EvaluationServices getEvaluationServices() {
        if (evaluationServices == null) {
            evaluationServices = new EvaluationServices();
        }
        return evaluationServices;
    }

    public static SubjectServices getSubjectServices() {
        if (subjectServices == null) {
            subjectServices = new SubjectServices();
        }
        return subjectServices;
    }

    public static java.sql.Connection getConnection() {
        Connection connection = null;
        try {
            connection = new Connection("localhost", "sigedo", "postgres", "postgres", "5432");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection.getConnection();
    }
}
