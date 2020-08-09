/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Componente;
import modelo.Estimacion;
import modelo.Proyecto;
import vista.AgregarFrame;

/**
 *
 * @author Darwin
 */
public class CtrOperaciones {
    public static int lenguaje = 53;
    public static Proyecto py = new Proyecto();
    public static double[] array = {3.72, 3.04, 4.24, 3.29, 4.68};
    public static double[] arrayM = {1, 1, 1, 1, 1, 1, 1};

    public static Estimacion est = new Estimacion();

    int[] compBaja = {3, 4, 3, 7, 5};
    int[] compMedia = {4, 5, 4, 10, 7};
    int[] compAlta = {6, 7, 6, 15, 10};

    /**
     * Metodo para calcular el punto de función del proyecto
     * @param array
     * @return pFuncion
     */
    public int calcularPf(ArrayList array) {
        int pFuncion = 0;
        py.getComponente();
        for (Componente col : py.getComponente()) {
            pFuncion += col.getValor();
        }
        est.setPuntoFuncion(pFuncion);
        return pFuncion;
    }

    /**
     * Metodo para calcular las lineas de codigo/KSLOC
     * @return ksloc
     */
    public double calcularLineasCod() {
        double ksloc;
        ksloc = (est.getPuntoFuncion() * lenguaje) * 0.001;
        est.setLineasCod(ksloc);
        return ksloc;
    }
    
    /**
     * Metodo para calcular el tiempo estimado del proyecto
     * @param sced 
     */
    public void calcularEstTiempo(double sced) {
        double esT = 3.67 * Math.pow(est.getPmEstimado(), (0.28 + (0.2 * (est.getNominalB() - 0.91))));
        double esTe = esT * (sced / 100);
        est.setEstTiempo((esT + esTe));
    }
    
    /**
     * Metodo para calcular el costo estimado del proyecto
     * @param salario
     * @param variacion 
     */
    public void calcularEstCosto(double salario, double variacion) {
        double cost = salario * 8 * 20 * est.getEstTiempo() * (Math.round(est.getEsthHombre()));
        double costV = cost * (variacion /100);
        est.setEstCosto((cost+costV));
        System.out.println("Costo++ " + est.getEstCosto());
    }
    /**
     * Metodo para calcular el Esfuerzo Estimado
     */
    public void calcularPmEstimado() {
        double B = 0.91 + (0.01 * est.getFactorEscala());
        est.setNominalB(B);
        double pmN = est.getNominalA() * Math.pow(est.getLineasCod(), B);
        est.setPmNominal(pmN);
        double pmE = pmN * est.getMulEsfuerzo();
        est.setPmEstimado(pmE);
    }
    
    /**
     * Metodo para calcular la complejidad del proyecto a partir del punto función
     * @param arrayBaja
     * @param arrayAlta
     * @param arrayMedia 
     */
    public void calcularComplejidad(int[] arrayBaja, int[] arrayAlta, int[] arrayMedia) {
        int aux;
        ArrayList<Componente> list = new ArrayList();
        AgregarFrame ag = new AgregarFrame();
        for (int i = 0; i < ag.compBaja.length; i++) {
            aux = 0;
            aux = (compBaja[i] * arrayBaja[i]) + (compMedia[i] * arrayMedia[i]) + (compAlta[i] * arrayAlta[i]);
            Componente ce = new Componente();
            ce.setTipo(i);
            ce.setValor(aux);
            list.add(ce);
        }
        py.setComponente(list);
    }
    
    /**
     * Calcular la cantidad de personal estimado del proyecto
     */
    public void calcularEstPersona() {
        double prTc = est.getPmEstimado() / est.getEstTiempo();
        est.setEsthHombre(prTc);
    }
    
    /**
     * Metodo para calcular el factor escala del proyecto
     * @return fEscala
     */
    public double calFactorEscala() {
        double fEscala = 0;
        for (int i = 0; i < array.length; i++) {
            fEscala += array[i];
        }
        est.setFactorEscala(fEscala);
        return fEscala;
    }
    
    /**
     * Metodo para calcular el Multiplicados de esfuerzo del proyecto
     * @return mEsfuerzo
     */
    public double calMultiEsfuerzo() {
        double mEsfuerzo = 1;
        for (int i = 0; i < arrayM.length; i++) {
            mEsfuerzo *= arrayM[i];
        }
        est.setMulEsfuerzo(mEsfuerzo);
        return mEsfuerzo;
    }
}
