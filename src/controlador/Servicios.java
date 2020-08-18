/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Estimacion;

/**
 *
 * @author Darwin
 */
public class Servicios extends CtrOperaciones {

    @Override
    public boolean calcularComplejidad(int[] arrayBaja, int[] arrayAlta, int[] arrayMedia) {
        return super.calcularComplejidad(arrayBaja, arrayAlta, arrayMedia);
    }

    @Override
    public double calcularLineasCod() {
        return super.calcularLineasCod();
    }

    @Override
    public boolean calcularEstTiempo(double sced) {
        return super.calcularEstTiempo(sced);
    }

    @Override
    public boolean calcularPmEstimado() {
        return super.calcularPmEstimado();
    }

    @Override
    public boolean calcularEstPersona() {
        return super.calcularEstPersona();
    }

    @Override
    public int calcularPf(ArrayList array) {
        return super.calcularPf(array);
    }

    @Override
    public double calFactorEscala() {
        return super.calFactorEscala();
    }

    @Override
    public double calMultiEsfuerzo() {
        return super.calMultiEsfuerzo();
    }

    @Override
    public boolean calcularEstCosto(double salario, double variacion) {
        return super.calcularEstCosto(salario, variacion);
    }

    public double calcularLineasCod(double est) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
