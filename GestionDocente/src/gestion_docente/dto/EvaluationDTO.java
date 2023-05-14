/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César
 */
public class EvaluationDTO extends EstandarDTO{
    private int id_student;
    private int id_subject;
    private int evaluation;

    public EvaluationDTO(int id,int id_student, int id_subject, int evaluation) {
        super(id);
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.evaluation = evaluation;
    }

    

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
    
    
    
}
