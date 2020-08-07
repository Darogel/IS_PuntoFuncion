/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Darwin
 */
public class Proyecto {
    
    private ArrayList<Componente> componente;
    private int valAjuste;
    private int lineaLenguaje;

    public ArrayList<Componente> getComponente() {
        return componente;
    }

    public void setComponente(ArrayList<Componente> componente) {
        this.componente = componente;
    }

    public int getValAjuste() {
        return valAjuste;
    }

    public void setValAjuste(int valAjuste) {
        this.valAjuste = valAjuste;
    }

    public int getLineaLenguaje() {
        return lineaLenguaje;
    }

    public void setLineaLenguaje(int lineaLenguaje) {
        this.lineaLenguaje = lineaLenguaje;
    }
}
