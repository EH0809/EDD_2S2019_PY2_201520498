/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Pila;

/**
 *
 * @author herre
 */
public class NodePila {

    private String Usuario;
    private String Descripcion;
    private String Time;
    private NodePila SiguientePila;

    public NodePila(String Usuario, String Descripcion, String Time) {
        this.Usuario = Usuario;
        this.Descripcion = Descripcion;
        this.Time = Time;
        this.SiguientePila = null;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    /**
     * @return the SiguientePila
     */
    public NodePila getSiguientePila() {
        return SiguientePila;
    }

    /**
     * @param SiguientePila the SiguientePila to set
     */
    public void setSiguientePila(NodePila SiguientePila) {
        this.SiguientePila = SiguientePila;
    }

}
