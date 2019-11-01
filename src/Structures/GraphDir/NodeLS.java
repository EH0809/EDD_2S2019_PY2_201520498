/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.GraphDir;
import Structures.AVL.AVL;

/**
 *
 * @author herre
 */
public class NodeLS {
    private String NameDir;
    private int NForders;
    private NodeLS NextNode;
    //AVL PAVL;

    public NodeLS() {
        this.NameDir = "";
        this.NextNode = null;
    }

    /**
     * @return the NameDir
     */
    public String getNameDir() {
        return NameDir;
    }

    /**
     * @param NameDir the NameDir to set
     */
    public void setNameDir(String NameDir) {
        this.NameDir = NameDir;
    }

    /**
     * @return the NForders
     */
    public int getNForders() {
        return NForders;
    }

    /**
     * @param NForders the NForders to set
     */
    public void setNForders(int NForders) {
        this.NForders = NForders;
    }

    /**
     * @return the NextNode
     */
    public NodeLS getNextNode() {
        return NextNode;
    }

    /**
     * @param NextNode the NextNode to set
     */
    public void setNextNode(NodeLS NextNode) {
        this.NextNode = NextNode;
    }
    
    
    
    
    
    
    
}
