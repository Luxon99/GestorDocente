/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César Fernández García
 */
public class YearDTO extends EstandarDTO{
    private int year;
    private String schollar_course;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchollar_course() {
        return schollar_course;
    }

    public void setSchollar_course(String schollar_course) {
        this.schollar_course = schollar_course;
    }

    public YearDTO(int id, int year, String schollar_course) {
        super(id);
        this.year = year;
        this.schollar_course = schollar_course;
    }
    
    
}
