/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.utils.models;

import gestion_docente.services.StudentServices;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author César
 */
public class tableStudents extends AbstractTableModel {

    private String[] columnas = {"Id_student" + "Nombre" + "Apellidos" + "Sexo" + "Municipio" + "Grupo"};
    private ArrayList<Object[]> datos = new ArrayList<>();

    public tableStudents(ArrayList<Object[]> data) {
        //Llama a el servicio de obetener los datos de los estudiantes
        for (int i = 0; i < data.size(); i++) {
            datos.add(data.get(i));
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
