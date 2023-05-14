/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César Fernández García
 */
public class GroupDTO {
    private int id_group;
    private int year;
    private int num_group;

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum_group() {
        return num_group;
    }

    public void setNum_group(int num_group) {
        this.num_group = num_group;
    }

    @Override
    public String toString() {
        return year +""+ num_group ;
    }

    public GroupDTO(int id_group, int year, int num_group) {
        this.id_group = id_group;
        this.year = year;
        this.num_group = num_group;
    }
    
    
}
