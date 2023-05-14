/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César Fernández García
 */
public class GroupDTO extends EstandarDTO{
    private int year;
    private int num_group;


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

    public GroupDTO( int id,int year, int num_group) {
        super(id);
        this.year = year;
        this.num_group = num_group;
    }

    

    
}
