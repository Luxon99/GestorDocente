/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.utils.models;

import gestion_docente.dto.StudentDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author César
 */
public class TableModelStudents extends DefaultTableModel {

    private String[] columnas = {"Nombre","Apellidos","Sexo","Municipio","Grupo"};
    private Object[][] datos;

    public TableModelStudents(ArrayList<StudentDTO> data) {
        datos = new Object[data.size()][];

        for (int i = 0; i < data.size(); i++) {
            for (int j = 1; j < 6; j++) {
                if( j == 1 ){
                    datos[i][j]=data.get(i).getName();
                }
                if( j == 2 ){
                    datos[i][j]=data.get(i).getSurnames();
                }
                if( j == 3 ){
                    datos[i][j]=data.get(i).isSex();
                }
                if( j == 4 ){
                    datos[i][j]=data.get(i).getMunicipality();
                }
                if( j == 5 ){
                    datos[i][j]=data.get(i).getId_group();
                }
                
            }

        }
    }
    /**
     @author Cesar Fernandez Garcia
     @code Este metodo lo que hace es permitir ingresar una fila a el modelo*/
//    public void addRow(String name,String surname,boolean sex,String municipality,int group){
//        
//    }
    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    
    
    
}
