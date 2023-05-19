/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

/**
 *
 * @author César
 */
public class MunicipalityDTO extends EstandarDTO {

    private String name_municipality;

    public String getName_municipality() {
        return name_municipality;
    }

    public void setName_municipality(String name_municipality) {
        this.name_municipality = name_municipality;
    }

    public MunicipalityDTO(int id, String name_municipality) {
        super(id);
        this.name_municipality = name_municipality;
    }

}
