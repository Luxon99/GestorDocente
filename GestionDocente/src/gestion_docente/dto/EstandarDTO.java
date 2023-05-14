/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_docente.dto;

import java.lang.reflect.Field;

/**
 *
 * @author César
 */
public class EstandarDTO {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstandarDTO(int id) {
        this.id = id;
    }

    public Object[] getValues() throws IllegalAccessException {
        Field[] fields = getClass().getDeclaredFields();//obtengo la lista de campos declarados
        Object[] values = new Object[fields.length];//hago un arreglo de objetos del mismo tamaño que la cantidad de campos
        

        //voy iterando por cada field y obtengo el valor de cada campo y lo pongo en el arreglo final de retorno
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);//hago publico el campo para poder acceder a este de manera temporal
            values[i] = fields[i].get(this);//obtengo el valor de ese campo para el objeto
        }

        return values;
    }
}
