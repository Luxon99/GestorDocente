/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César Fernández García
 */
public class SubjectDTO extends EstandarDTO{
    private String name_subject;
    private int hours;
    private int year;

    public SubjectDTO(int id_subject, String name_subject, int hours, int year) {
        super(id_subject);
        this.name_subject = name_subject;
        this.hours = hours;
        this.year = year;
    }

    
    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  super.getId() + " " + name_subject + " de " + hours + " horas del año " + year;
    }
    
    
}
