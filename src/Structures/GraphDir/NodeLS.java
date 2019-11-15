/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.GraphDir;
import Structures.AVL.AVL;
import Structures.AVL.AVL2;
import Structures.Matrix.Matrix;

/**
 *
 * @author herre
 */
public class NodeLS {
    private String NameDir;
    private int ContadorHijo;
    private int ContadorPadre;
    private String NombrePadre;
    private NodeLS NextNode;
    private Matrix MatrixDeUsuario;
    private AVL2 AvlTree;

    public NodeLS(String Name, String NombrePadre, int ContadorPadre, int NFolders) {
        this.NameDir = Name;
        this.NextNode = null;
        this.NombrePadre = NombrePadre;
        this.ContadorHijo = NFolders;
        this.ContadorPadre = ContadorPadre;
        this.MatrixDeUsuario = new Matrix();
        this.AvlTree = new AVL2();
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

    /**
     * @return the ContadorHijo
     */
    public int getContadorHijo() {
        return ContadorHijo;
    }

    /**
     * @param ContadorHijo the ContadorHijo to set
     */
    public void setContadorHijo(int ContadorHijo) {
        this.ContadorHijo = ContadorHijo;
    }

    /**
     * @return the ContadorPadre
     */
    public int getContadorPadre() {
        return ContadorPadre;
    }

    /**
     * @param ContadorPadre the ContadorPadre to set
     */
    public void setContadorPadre(int ContadorPadre) {
        this.ContadorPadre = ContadorPadre;
    }

    /**
     * @return the NombrePadre
     */
    public String getNombrePadre() {
        return NombrePadre;
    }

    /**
     * @param NombrePadre the NombrePadre to set
     */
    public void setNombrePadre(String NombrePadre) {
        this.NombrePadre = NombrePadre;
    }

    /**
     * @return the AvlTree
     */
    public AVL2 getAvlTree() {
        return AvlTree;
    }

    /**
     * @param AvlTree the AvlTree to set
     */
    public void setAvlTree(AVL2 AvlTree) {
        this.AvlTree = AvlTree;
    }


    
    
    
    
    
    
}
