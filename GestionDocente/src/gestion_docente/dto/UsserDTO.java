/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César
 */
public class UsserDTO extends EstandarDTO{
    private String usser_name;
    private String password;

    public UsserDTO(int id,String usser_name, String password) {
        super(id);
        this.usser_name = usser_name;
        this.password = password;
    }

    

    public String getUsser_name() {
        return usser_name;
    }

    public void setUsser_name(String usser_name) {
        this.usser_name = usser_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
