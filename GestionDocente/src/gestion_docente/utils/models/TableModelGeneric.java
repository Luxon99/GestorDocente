/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.utils.models;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author César
 */
public abstract class TableModelGeneric extends DefaultTableModel {
    
    public abstract void fillTable(String table);
    
}
