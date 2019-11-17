/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Pila;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author herre
 */
public class Pila {

    private NodePila PrimeroPila;
    private String Parrafo = "";

    public Pila() {
        this.PrimeroPila = null;
    }

    public boolean Vacia() {
        return getPrimeroPila() == null;
    }

    public void InsertaraPila(String Nombre, String Descripcion) {
        NodePila Nuevo = new NodePila(Nombre, Descripcion, Time());
        if (Vacia()) {
            setPrimeroPila(Nuevo);
        } else {
            Nuevo.setSiguientePila(getPrimeroPila());
            setPrimeroPila(Nuevo);
        }
    }

    public String Imprimir() {
        NodePila Aux = getPrimeroPila();
        if (Aux != null) {

            while (Aux != null) {
                Parrafo += "Usuario: " + Aux.getUsuario() + " Descripcion:" + Aux.getDescripcion() + " Tiempo:" + Aux.getTime();
                Aux = Aux.getSiguientePila();
            }
        } else {
            System.out.println("No Hay Para imprimir la pila");
        }

        return Parrafo;
    }
    
    public String Imprimir2(){
        NodePila Aux = getPrimeroPila();
        String a = "";
        if (Aux != null){
            a = "Usuario: " + Aux.getUsuario() + " Descripcion:" + Aux.getDescripcion() + " Tiempo:" + Aux.getTime();
            return a;
        }
        return a;
    
    }

    public String Time() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String a = dateFormat.format(new Date());
        return a;
    }

    /**
     * @return the PrimeroPila
     */
    public NodePila getPrimeroPila() {
        return PrimeroPila;
    }

    /**
     * @param PrimeroPila the PrimeroPila to set
     */
    public void setPrimeroPila(NodePila PrimeroPila) {
        this.PrimeroPila = PrimeroPila;
    }

    /**
     * @return the Parrafo
     */
    public String getParrafo() {
        return Parrafo;
    }

    /**
     * @param Parrafo the Parrafo to set
     */
    public void setParrafo(String Parrafo) {
        this.Parrafo = Parrafo;
    }
}
