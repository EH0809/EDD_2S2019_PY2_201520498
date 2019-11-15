/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.GraphDir;

import Structures.AVL.AVL2;

/**
 *
 * @author herre
 */
public class NodeLLS {

    /**
     * @return the Grupo
     */
    public int getGrupo() {
        return Grupo;
    }

    /**
     * @param Grupo the Grupo to set
     */
    public void setGrupo(int Grupo) {
        this.Grupo = Grupo;
    }

    
    private String Name;
    private LSimple PunteroLS;
    private NodeLLS SiguienteLSS;
    private NodeLLS AnteriorLSS;
    private int Grupo;
    private AVL2 AvlTreeLLS;

    public NodeLLS(String Name, int Grupo) {
        this.Name = Name;
        this.PunteroLS = new LSimple();
        this.SiguienteLSS = null;
        this.AnteriorLSS = null;
        this.Grupo = Grupo;
        this.AvlTreeLLS = new AVL2();
    }
    
    
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the PunteroLS
     */
    public LSimple getPunteroLS() {
        return PunteroLS;
    }

    /**
     * @param PunteroLS the PunteroLS to set
     */
    public void setPunteroLS(LSimple PunteroLS) {
        this.PunteroLS = PunteroLS;
    }

    /**
     * @return the SiguienteLSS
     */
    public NodeLLS getSiguienteLSS() {
        return SiguienteLSS;
    }

    /**
     * @param SiguienteLSS the SiguienteLSS to set
     */
    public void setSiguienteLSS(NodeLLS SiguienteLSS) {
        this.SiguienteLSS = SiguienteLSS;
    }

    /**
     * @return the AnteriorLSS
     */
    public NodeLLS getAnteriorLSS() {
        return AnteriorLSS;
    }

    /**
     * @param AnteriorLSS the AnteriorLSS to set
     */
    public void setAnteriorLSS(NodeLLS AnteriorLSS) {
        this.AnteriorLSS = AnteriorLSS;
    }

    /**
     * @return the AvlTreeLLS
     */
    public AVL2 getAvlTreeLLS() {
        return AvlTreeLLS;
    }

    /**
     * @param AvlTreeLLS the AvlTreeLLS to set
     */
    public void setAvlTreeLLS(AVL2 AvlTreeLLS) {
        this.AvlTreeLLS = AvlTreeLLS;
    }
    
}
