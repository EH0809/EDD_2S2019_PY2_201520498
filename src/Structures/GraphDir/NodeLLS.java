/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.GraphDir;

/**
 *
 * @author herre
 */
public class NodeLLS {

    
    private String Name;
    private LSimple PunteroLS;
    private NodeLLS SiguienteLSS;
    private NodeLLS AnteriorLSS;

    public NodeLLS(String Name) {
        this.Name = Name;
        this.PunteroLS = new LSimple();
        this.SiguienteLSS = null;
        this.AnteriorLSS = null;
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
    
}
