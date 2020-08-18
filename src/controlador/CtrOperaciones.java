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

    public Estimacion getEstimacion() {
        if (est == null) {
            est = new Estimacion();
        }
        return est;
    }

    public Proyecto getProyecto() {
        if (py == null) {
            py = new Proyecto();
        }
        return py;
    }

    /**
     * Metodo para calcular el punto de función del proyecto
     *
     * @param array
     * @return pFuncion
     */
    public int calcularPf(ArrayList array) {
        int pFuncion = 0;
        py.getComponente();
        for (Componente col : py.getComponente()) {
            if (col.getValor() > 0) {
                pFuncion += col.getValor();
            } else {
                pFuncion = -1;
                break;
            }
        }
        if (pFuncion == 0) {
            return pFuncion;
        } else {
            if (pFuncion == -1) {
                return pFuncion;
            } else {
                est.setPuntoFuncion(pFuncion);
                return pFuncion;
            }
        }
    }

    /**
     * Metodo para calcular las lineas de codigo/KSLOC
     *
     * @return ksloc
     */
    public double calcularLineasCod() {
        double ksloc;
        try {
            if (est.getPuntoFuncion() >= 0) {
                ksloc = (est.getPuntoFuncion() * lenguaje) * 0.001;
                est.setLineasCod(ksloc);
                return ksloc;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            return 0;
        }

    }

    /**
     * Metodo para calcular el tiempo estimado del proyecto
     *
     * @param sced
     */
    public boolean calcularEstTiempo(double sced) {
        boolean band = true;
        try {
            if (sced > 0.0) {
                double esT = 3.67 * Math.pow(est.getPmEstimado(), (0.28 + (0.2 * (est.getNominalB() - 0.91))));
                double esTe = esT * (sced / 100);
                est.setEstTiempo((esT + esTe));
                return band;
            } else {
                band = false;
                return band;
            }

        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            band = false;
            return band;
        }

    }

    /**
     * Metodo para calcular el costo estimado del proyecto
     *
     * @param salario
     * @param variacion
     */
    public boolean calcularEstCosto(double salario, double variacion) {
        boolean band = true;
        try {
            if (salario > 0.0 && variacion > 0.0) {
                double cost = salario * 8 * 20 * est.getEstTiempo() * (Math.round(est.getEsthHombre()));
                double costV = cost * (variacion / 100);
                est.setEstCosto((cost + costV));
                System.out.println("Costo++ " + est.getEstCosto());
                return band;
            } else {
                band = false;
                return band;
            }
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            band = false;
            return band;
        }

    }

    /**
     * Metodo para calcular el Esfuerzo Estimado
     */
    public boolean calcularPmEstimado() {
        try {
            double B = 0.91 + (0.01 * est.getFactorEscala());
            est.setNominalB(B);
            double pmN = est.getNominalA() * Math.pow(est.getLineasCod(), B);
            est.setPmNominal(pmN);
            double pmE = pmN * est.getMulEsfuerzo();
            est.setPmEstimado(pmE);
            return true;
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            return false;
        }

    }

    /**
     * Metodo para calcular la complejidad del proyecto a partir del punto
     * función
     *
     * @param arrayBaja
     * @param arrayAlta
     * @param arrayMedia
     */
    public boolean calcularComplejidad(int[] arrayBaja, int[] arrayAlta, int[] arrayMedia) {
        int aux;
        boolean band = false;
        try {
            ArrayList<Componente> list = new ArrayList();
            AgregarFrame ag = new AgregarFrame();
            for (int i = 0; i < ag.compBaja.length; i++) {
                if (arrayBaja[i] >= 0 && arrayAlta[i] >= 0 && arrayMedia[i] >= 0) {
                    aux = 0;
                    aux = (compBaja[i] * arrayBaja[i]) + (compMedia[i] * arrayMedia[i]) + (compAlta[i] * arrayAlta[i]);
                    Componente ce = new Componente();
                    ce.setTipo(i);
                    ce.setValor(aux);
                    list.add(ce);
                    band = true;
                } else {
                    i = ag.compBaja.length;
                    band = false;
                }
            }
            py.setComponente(list);
            return band;

        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            //System.out.println("Valores de complejidad vacios");
            return false;
        }
    }

    /**
     * Calcular la cantidad de personal estimado del proyecto
     */
    public boolean calcularEstPersona() {
        try {
            double prTc = est.getPmEstimado() / est.getEstTiempo();
            est.setEsthHombre(prTc);
            return true;
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            return false;
        }

    }

    /**
     * Metodo para calcular el factor escala del proyecto
     *
     * @return fEscala
     */
    public double calFactorEscala() {
        double fEscala = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                fEscala += array[i];
            }
            est.setFactorEscala(fEscala);
            return fEscala;
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            return 0.0;
        }

    }

    /**
     * Metodo para calcular el Multiplicados de esfuerzo del proyecto
     *
     * @return mEsfuerzo
     */
    public double calMultiEsfuerzo() {
        double mEsfuerzo = 1;
        try {
            for (int i = 0; i < arrayM.length; i++) {
                mEsfuerzo *= arrayM[i];
            }
            est.setMulEsfuerzo(mEsfuerzo);
            return mEsfuerzo;
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
            return 0.0;
        }

    }
}
