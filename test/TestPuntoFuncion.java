/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.CtrOperaciones;
import controlador.Servicios;
import java.util.ArrayList;
import junit.framework.Assert;
import modelo.Componente;
import modelo.Estimacion;
import modelo.Proyecto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TestPuntoFuncion {

    private CtrOperaciones co;
    private Componente cm;

    @Before
    public void setUp() {
        co = new CtrOperaciones();
        co.getEstimacion().setPuntoFuncionA(1.5);
        co.getEstimacion().setLineasCod(15.2);
        co.getEstimacion().setPuntoFuncion(5);
        co.getEstimacion().setEstTiempo(2.5);
        co.getEstimacion().setEstCosto(10.5);
        co.getEstimacion().setEsthHombre(15.2);
        co.getEstimacion().setFactorEscala(18.97);
        co.getEstimacion().setMulEsfuerzo(1);
        co.getEstimacion().setNominalA(2.94);
        co.getEstimacion().setPmEstimado(10.5);
        co.getEstimacion().setPmNominal(5.2);
        co.getEstimacion().setNominalB(4.5);

    }
    /**
     * Flujo Normal
     * Test para validar el método calcularComplejidad cuando 
     * las matrices tienen valores correctos.
     */
    @Test
    public void testcalcularComplejidadValores() {
        int[] compBaja = {1, 4, 3, 7, 5};
        int[] compMedia = {4, 5, 4, 10, 7};
        int[] compAlta = {6, 7, 6, 15, 10};

        boolean resultado = co.calcularComplejidad(compBaja, compAlta, compMedia);
        Assert.assertEquals(true, resultado);

    }
    
    /**
     * Matrices con valores vacios
     * Test para validar el método calcularComplejidad cuando 
     * las matrices tienen valores vacios.
     */
    @Test
    public void testcalcularComplejidadVacias() {
        int[] compBaja = {};
        int[] compMedia = {};
        int[] compAlta = {};

        boolean resultado = co.calcularComplejidad(compBaja, compAlta, compMedia);
        Assert.assertEquals(false, resultado);

    }
    
    /**
     * Matrices con valores negativos
     * Test para validar el método calcularComplejidad cuando 
     * las matrices tienen valores negativos.
     */
    @Test
    public void testcalcularComplejidadNegativos() {
        int[] compBaja = {1, 4, 3, 7, 5};
        int[] compMedia = {4, 5, 4, 10, -7};
        int[] compAlta = {6, 7, 6, 15, 10};

        boolean resultado = co.calcularComplejidad(compBaja, compAlta, compMedia);
        Assert.assertEquals(false, resultado);

    }
    
    /**
     * Flujo normal
     * Test para validar el método calcularPF cuando 
     * el componente tiene un arraylist con valores correctos.
     */
    @Test
    public void testcalcularPfLlenos() {
        ArrayList list = new ArrayList<Componente>();
        cm = new Componente();
        cm.setTipo(2);
        cm.setValor(2);
        list.add(cm);
        cm.setTipo(5);
        cm.setValor(4);
        list.add(cm);

        co.getProyecto().setComponente(list);
        co.getProyecto().setLineaLenguaje(1);
        co.getProyecto().setValAjuste(2);

        int valor = co.calcularPf(co.getProyecto().getComponente());
        System.out.print("Componentes validos, valor: ");
        System.out.println(valor);
    }
    
    /**
     * Componente Vacio
     * Test para validar el método calcularPF cuando 
     * el componente tiene un arraylist vacio.
     */
    @Test
    public void testcalcularPfVacios() {
        ArrayList list = new ArrayList<Componente>();
        co.getProyecto().setComponente(list);
        co.getProyecto().setLineaLenguaje(1);
        co.getProyecto().setValAjuste(2);

        int valor = co.calcularPf(co.getProyecto().getComponente());
        System.out.print("Componentes Vacios, Valor: ");
        System.out.println(valor);
    }

    /**
     * Componente con valores negativos
     * Test para validar el método calcularPF cuando 
     * el componente tiene un arraylist con valores negativos.
     */
    @Test
    public void testcalcularPfNegativos() {
        ArrayList list = new ArrayList<Componente>();
        cm = new Componente();
        cm.setTipo(-2);
        cm.setValor(-8);
        list.add(cm);
        cm.setTipo(-5);
        cm.setValor(-1);
        list.add(cm);

        co.getProyecto().setComponente(list);
        co.getProyecto().setLineaLenguaje(1);
        co.getProyecto().setValAjuste(2);

        int valor = co.calcularPf(co.getProyecto().getComponente());
        System.out.print("Valores en Componentes negativos, Valor: ");
        System.out.println(valor);
    }

    /**
     * Flujo normal
     * Test para validar el método calcularLineasCodPF cuando 
     * recibe un parámetro correcto.
     */
    @Test
    public void testcalcularLineasCodPFValido() {
        double resultado = co.calcularLineasCod();
        System.out.print("Lineas de código: ");
        System.out.println(resultado);

    }

    /**
     * Flujo normal
     * Test para validar el método calcularEstTiempo cuando 
     * recibe un parámetro correcto.
     */
    @Test
    public void testcalcularEstTiempoPositivo() {
        double valor = 15.9;
        boolean respuesta = co.calcularEstTiempo(valor);
        Assert.assertEquals(true, respuesta);
    }

    /**
     * Parámetro Negativo
     * Test para validar el método calcularEstTiempo cuando 
     * recibe un valor como parámetro negativo
     */
    @Test
    public void testcalcularEstTiempoNegativo() {
        double valor = -15.9;
        boolean respuesta = co.calcularEstTiempo(valor);
        Assert.assertEquals(false, respuesta);
    }

    /**
     * Parámetro Cero
     * Test para validar el método calcularEstTiempo cuando 
     * recibe un valor como parámetro en cero
     */
    @Test
    public void testcalcularEstTiempoCero() {
        double valor = 0;
        boolean respuesta = co.calcularEstTiempo(valor);
        Assert.assertEquals(false, respuesta);
    }
    
    /**
     * Flujo normal
     * Test para validar el método calcularEstCosto cuando 
     * recibe parámetros correctos
     */
    @Test
    public void testcalcularEstCostoPositivos() {
        double salario = 400.0;
        double variacion = 20.0;
        boolean respuesta = co.calcularEstCosto(salario, variacion);
        Assert.assertEquals(true, respuesta);
    }

    /**
     * Parámetros en cero
     * Test para validar el método calcularEstCosto cuando
     * recibe parámetros enviados son cero
     */
    @Test
    public void testcalcularEstCostoCero() {
        double salario = 0.0;
        double variacion = 0.0;
        boolean respuesta = co.calcularEstCosto(salario, variacion);
        Assert.assertEquals(false, respuesta);
    }
    
    /**
     * Parámetros negativos
     * Test para validar el método calcularEstCosto cuando 
     * recibe valores negativos como parámetros.
     */
    @Test
    public void testcalcularEstCostoNegativos() {
        double salario = -400.0;
        double variacion = -20.0;
        boolean respuesta = co.calcularEstCosto(salario, variacion);
        Assert.assertEquals(false, respuesta);
    }
    
    /**
     * Flujo normal
     * Test para validar el método calcularPmEstimado cuando 
     * el flujo es normal.
     */
    @Test
    public void testcalcularPmEstimadoNormal() {
        boolean respuesta = co.calcularPmEstimado();
        Assert.assertEquals(true, respuesta);
    }
    
    /**
     * Flujo normal
     * Test para validar el método calcularEstPersona cuando 
     * el flujo es normal.
     */
    @Test
    public void testcalcularEstPersonaNormal() {
        boolean respuesta = co.calcularEstPersona();
        Assert.assertEquals(true, respuesta);
    }
    
    /**
     * Flujo normal
     * Test para validar el método calFactorEscala cuando 
     * el flujo es normal.
     */
    @Test
    public void testcalFactorEscalaNormal() {
        double respuesta = co.calFactorEscala();
        System.out.println("Factor escala: " + respuesta );
    }
    
    /**
     * Flujo normal
     * Test para validar el método calMultiEsfuerzo cuando 
     * el flujo es normal.
     */
    @Test
    public void testcalMultiEsfuerzoNormal() {
        double respuesta = co.calMultiEsfuerzo();
        System.out.println("Factor Multi esfuerzo: " + respuesta );
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
   
}
