/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Darwin
 */
public class Estimacion {
    
    private double puntoFuncionA;
    private double lineasCod;
    private int puntoFuncion;
    private double estTiempo;
    private double estCosto;
    private double esthHombre;
    private double factorEscala = 18.97;
    private double mulEsfuerzo = 1;
    private double nominalA = 2.94;
    private double pmEstimado;
    private double pmNominal;
    private double nominalB; 
    
    public double getPmNominal() {
        return pmNominal;
    }

    public void setPmNominal(double pmNominal) {
        this.pmNominal = pmNominal;
    }
    

    public double getNominalB() {
        return nominalB;
    }

    public void setNominalB(double nominalB) {
        this.nominalB = nominalB;
    }

    public double getPmEstimado() {
        return pmEstimado;
    }

    public void setPmEstimado(double pmEstimado) {
        this.pmEstimado = pmEstimado;
    }

    public double getNominalA() {
        return nominalA;
    }

    public void setNominalA(double nominalA) {
        this.nominalA = nominalA;
    }

    public double getMulEsfuerzo() {
        return mulEsfuerzo;
    }

    public void setMulEsfuerzo(double mulEsfuerzo) {
        this.mulEsfuerzo = mulEsfuerzo;
    }

    public double getFactorEscala() {
        return factorEscala;
    }

    public void setFactorEscala(double factorEscala) {
        this.factorEscala = factorEscala;
    }

    public double getPuntoFuncionA() {
        return puntoFuncionA;
    }

    public void setPuntoFuncionA(double puntoFuncionA) {
        this.puntoFuncionA = puntoFuncionA;
    }

    public double getLineasCod() {
        return lineasCod;
    }

    public void setLineasCod(double lineasCod) {
        this.lineasCod = lineasCod;
    }

    public int getPuntoFuncion() {
        return puntoFuncion;
    }

    public void setPuntoFuncion(int puntoFuncion) {
        this.puntoFuncion = puntoFuncion;
    }

    public double getEstTiempo() {
        return estTiempo;
    }

    public void setEstTiempo(double estTiempo) {
        this.estTiempo = estTiempo;
    }

    public double getEstCosto() {
        return estCosto;
    }

    public void setEstCosto(double estCosto) {
        this.estCosto = estCosto;
    }

    public double getEsthHombre() {
        return esthHombre;
    }

    public void setEsthHombre(double esthHombre) {
        this.esthHombre = esthHombre;
    }
}
