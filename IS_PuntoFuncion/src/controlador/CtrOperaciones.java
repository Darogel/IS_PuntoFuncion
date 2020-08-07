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

/**
 *
 * @author Darwin
 */
public class CtrOperaciones {
    public static int lenguaje = 53;
    public static Proyecto py = new Proyecto();
    public static double[] array = new double[5];
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
}
