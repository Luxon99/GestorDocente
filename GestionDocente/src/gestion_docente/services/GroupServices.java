/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.services;

import java.util.ArrayList;

/**
 *
 * @author César
 */
public class GroupServices {
    
    
    /**
     @author Cesar Fernandez Garcia 8/05/2023 15:09
     * @param int year: Año academico del cual se quiern saber los grupos
     * @return ArrayList<Integer> listado de Grupos
     */
    public ArrayList<Integer> getGroupsOfYear(int year){
        ArrayList<Integer> listadoGrupos = new ArrayList<>();
        
        GroupServices gs = ServicesLocator.getGroupServices();
        String procedimiento = "{ ?= call \"public\".\"get_groups_of_year\"(?)}";        
        
        
        return listadoGrupos;
    }
    
}
