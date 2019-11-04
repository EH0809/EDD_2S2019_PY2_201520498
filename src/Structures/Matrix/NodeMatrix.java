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

    /**
     * @return the NameFolderC
     */
    public String getNameFolderC() {
        return NameFolderC;
    }

    /**
     * @param NameFolderC the NameFolderC to set
     */
    public void setNameFolderC(String NameFolderC) {
        this.NameFolderC = NameFolderC;
    }

    /**
     * @return the NameFolderH
     */
    public String getNameFolderH() {
        return NameFolderH;
    }

    /**
     * @param NameFolderH the NameFolderH to set
     */
    public void setNameFolderH(String NameFolderH) {
        this.NameFolderH = NameFolderH;
    }

    /**
     * @return the Fil
     */
    public int getFil() {
        return Fil;
    }

    /**
     * @param Fil the Fil to set
     */
    public void setFil(int Fil) {
        this.Fil = Fil;
    }

    /**
     * @return the Col
     */
    public int getCol() {
        return Col;
    }

    /**
     * @param Col the Col to set
     */
    public void setCol(int Col) {
        this.Col = Col;
    }
      private int Fil;
      private int Col;
      private String NameFolderC;
      private String NameFolderH;
      private NodeMatrix RightNode;
      private NodeMatrix LeftNode;
      private NodeMatrix UpNode;
      private NodeMatrix DownNode;

    public NodeMatrix(int Col, int Fil,String NameFolderC, String NameFolderH) {
        this.Col = Col;
        this.Fil = Fil;
        this.NameFolderC = NameFolderC;
        this.NameFolderH = NameFolderH;
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
    
    
      
      
      
    
}
