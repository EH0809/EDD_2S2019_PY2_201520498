/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Matrix;

/**
 *
 * @author herre
 */
public class NodeMatrix {

    private String NombrePadre;
    private String NombreHijo;
    private NodeMatrix RightNode;
    private NodeMatrix LeftNode;
    private NodeMatrix UpNode;
    private NodeMatrix DownNode;

    public NodeMatrix(String NombrePadre, String NombreHijo) {
        this.NombrePadre = NombrePadre;
        this.NombreHijo = NombreHijo;
        this.LeftNode = null;
        this.DownNode = null;
        this.RightNode = null;
        this.UpNode = null;
    }

 

    /**
     * @return the RightNode
     */
    public NodeMatrix getRightNode() {
        return RightNode;
    }

    /**
     * @param RightNode the RightNode to set
     */
    public void setRightNode(NodeMatrix RightNode) {
        this.RightNode = RightNode;
    }

    /**
     * @return the LeftNode
     */
    public NodeMatrix getLeftNode() {
        return LeftNode;
    }

    /**
     * @param LeftNode the LeftNode to set
     */
    public void setLeftNode(NodeMatrix LeftNode) {
        this.LeftNode = LeftNode;
    }

    /**
     * @return the UpNode
     */
    public NodeMatrix getUpNode() {
        return UpNode;
    }

    /**
     * @param UpNode the UpNode to set
     */
    public void setUpNode(NodeMatrix UpNode) {
        this.UpNode = UpNode;
    }

    /**
     * @return the DownNode
     */
    public NodeMatrix getDownNode() {
        return DownNode;
    }

    /**
     * @param DownNode the DownNode to set
     */
    public void setDownNode(NodeMatrix DownNode) {
        this.DownNode = DownNode;
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
     * @return the NombreHijo
     */
    public String getNombreHijo() {
        return NombreHijo;
    }

    /**
     * @param NombreHijo the NombreHijo to set
     */
    public void setNombreHijo(String NombreHijo) {
        this.NombreHijo = NombreHijo;
    }

}
