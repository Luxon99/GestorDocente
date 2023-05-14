/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César Fernández García Esta clase permite la manipulación de la tabla
 * student
 */
public class StudentDTO {

    private int id_student;
    private String name;
    private String surnames;
    private boolean sex;
    private String municipality;
    private int id_group;

    @Override
    public String toString() {
        return name + " " + surnames + "de " + municipality;
    }
    
    
    
    
    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public StudentDTO(int id_student, String name, String surnames, boolean sex, String municipality, int id_group) {
        this.id_student = id_student;
        this.name = name;
        this.surnames = surnames;
        this.sex = sex;
        this.municipality = municipality;
        this.id_group = id_group;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }
    
    
    
}
