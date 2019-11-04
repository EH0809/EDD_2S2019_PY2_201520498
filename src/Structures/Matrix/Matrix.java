/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Matrix;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author herre
 */
public class Matrix {

    NodeMatrix HeadNode;

    public Matrix() {
        NodeMatrix NNode = new NodeMatrix(0, 0, "", "");
        HeadNode = NNode;
    }

    public void AddMatrix(int Col, int Fil, String NameC, String NameH) {
        CreateCabecera(Col, NameC);
        CreateHeaders(Fil, NameH);
        AddMatrixC(Col, Fil, NameC, NameH);
        AddMatrixH(Col, Fil, NameC, NameH);

    }

    public void GraphMatrix() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("MatrixDot.dot");
            pw = new PrintWriter(fichero);
            String Dot = "";
            pw.println(DotMatrix(Dot));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            String cmd = "dot -Tjpg MatrixDot.dot -o MatrixDot.jpg"; 
            Runtime.getRuntime().exec(cmd);
            String cmd2 = "MatrixDot.jpg"; 
            Runtime.getRuntime().exec(cmd2);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public String DotMatrix(String Dot) {
        NodeMatrix Temp = HeadNode.getRightNode();
        NodeMatrix Temp2 = HeadNode.getDownNode();
        Dot += "digraph Sparse_Matrix{\n";
        Dot += "node [shape=box]\n";
        Dot += "graph[nodesep = 0.5];\n";
        Dot += "Terminal [ label = \"Matrix\", width = 1.5, style = filled, group = 0 ];\n";
        Dot += "e0[ shape = point, width = 0 ]\n";
        Dot += "e1[ shape = point, width = 0 ]\n";
        Dot += "Terminal -> Y" + String.valueOf(Temp2.getFil()) + " [dir=both];\n";
        while (Temp2.getDownNode() != null) {
            Dot += "Y" + String.valueOf(Temp2.getFil()) + "[label = \"" + "F" + String.valueOf(Temp2.getFil()) + " \" , group ="
                    + String.valueOf(0) + "];\n";
            Dot += "Y" + String.valueOf(Temp2.getFil()) + "-> Y" + String.valueOf(Temp2.getDownNode().getFil()) + "[dir=both];\n";
            NodeMatrix Aux2 = Temp2;
            while (Aux2.getRightNode() != null) {
                if (Aux2.getCol() == 0) {
                    Dot += "Y" + String.valueOf(Aux2.getFil()) + "-> n" + String.valueOf(Aux2.getRightNode().getCol()) + "_"
                            + String.valueOf(Aux2.getRightNode().getFil()) + "[dir=both];\n";
                    Dot += "{ rank = same; Y" + String.valueOf(Temp2.getFil()) + "; n" + String.valueOf(Aux2.getRightNode().getCol())
                            + "_" + String.valueOf(Aux2.getRightNode().getFil()) + " }\n";
                } else {
                    Dot += "n" + String.valueOf(Aux2.getCol()) + "_" + String.valueOf(Aux2.getFil()) + "-> n"
                            + String.valueOf(Aux2.getRightNode().getCol()) + "_" + String.valueOf(Aux2.getRightNode().getFil())
                            + "[dir=both];\n";
                    Dot += "{ rank = same; n" + String.valueOf(Aux2.getCol()) + "_" + String.valueOf(Aux2.getFil()) + "; n"
                            + String.valueOf(Aux2.getRightNode().getCol()) + "_" + String.valueOf(Aux2.getRightNode().getFil()) + " }\n";
                }
                Aux2 = Aux2.getRightNode();
            }
            Temp2 = Temp2.getDownNode();
        }
        Dot += "Y" + String.valueOf(Temp2.getFil()) + "[label = \"" + "F" + String.valueOf(Temp2.getFil()) + " \" ,group =" + String.valueOf(0)
                + "];\n";
        while (Temp2.getRightNode() != null) {
            if (Temp2.getCol() == 0) {
                Dot += "Y" + String.valueOf(Temp2.getFil()) + "-> n" + String.valueOf(Temp2.getRightNode().getCol()) + "_"
                        + String.valueOf(Temp2.getFil()) + "[dir=both];\n";
                Dot += "{ rank = same; Y" + String.valueOf(Temp2.getFil()) + "; n" + String.valueOf(Temp2.getRightNode().getCol()) + "_"
                        + String.valueOf(Temp2.getFil()) + " }\n";

            } else {
                Dot += "n" + String.valueOf(Temp2.getCol()) + "_" + String.valueOf(Temp2.getFil()) + "-> n"
                        + String.valueOf(Temp2.getRightNode().getCol()) + "_" + String.valueOf(Temp2.getFil()) + "[dir=both];\n";
                Dot += "{ rank = same; n" + String.valueOf(Temp2.getCol()) + "_" + String.valueOf(Temp2.getFil()) + "; n"
                        + String.valueOf(Temp2.getRightNode().getCol()) + "_" + String.valueOf(Temp2.getFil()) + " }\n";

            }
            Temp2 = Temp2.getRightNode();
        }
        Dot += "Terminal -> X" + String.valueOf(Temp.getCol()) + " [dir=both];\n";
        while (Temp.getRightNode() != null) {
            Dot += "X" + String.valueOf(Temp.getCol()) + "[label = \"" + "C" + String.valueOf(Temp.getCol()) + " \"  , group ="
                    + String.valueOf(Temp.getCol()) + "];\n";
            Dot += "X" + String.valueOf(Temp.getCol()) + "-> X" + String.valueOf(Temp.getRightNode().getCol()) + "[dir=both];\n";
            Dot += "{ rank = same; Terminal; X" + String.valueOf(Temp.getCol()) + " }\n";
            NodeMatrix Aux = Temp;
            while (Aux.getDownNode() != null) {
                Dot += "n" + String.valueOf(Aux.getCol()) + "_" + String.valueOf(Aux.getDownNode().getFil()) + "[label = \""
                        + String.valueOf(Aux.getDownNode().getNameFolderC()) + "/" + String.valueOf(Aux.getDownNode().getNameFolderH()) + "," + " \"   width = 1.5, group =" + String.valueOf(Aux.getCol()) + "];\n";
                if (Aux.getFil() == 0) {
                    Dot += "X" + String.valueOf(Aux.getCol()) + "->n" + String.valueOf(Aux.getCol()) + "_"
                            + String.valueOf(Aux.getDownNode().getFil()) + "[dir=both];\n";
                } else {
                    Dot += "n" + String.valueOf(Aux.getCol()) + "_" + String.valueOf(Aux.getFil()) + "-> n" + String.valueOf(Aux.getCol()) + "_"
                            + String.valueOf(Aux.getDownNode().getFil()) + "[dir=both];\n";
                }
                Aux = Aux.getDownNode();
            }
            Temp = Temp.getRightNode();
        }
        Dot += "X" + String.valueOf(Temp.getCol()) + "[label = \"" + "C" + String.valueOf(Temp.getCol()) + " \" , group ="
                + String.valueOf(Temp.getCol()) + "];\n";
        Dot += "{ rank = same; Terminal; X" + String.valueOf(Temp.getCol()) + " }\n";
        while (Temp.getDownNode() != null) {
            Dot += "n" + String.valueOf(Temp.getCol()) + "_" + String.valueOf(Temp.getDownNode().getFil()) + "[label = \""
                    + String.valueOf(Temp.getDownNode().getNameFolderC()) + "/" + String.valueOf(Temp.getDownNode().getNameFolderH()) + ","
                    + " \"   width = 1.5, group =" + String.valueOf(Temp.getCol())
                    + "];\n";
            if (Temp.getFil() == 0) {

                Dot += "X" + String.valueOf(Temp.getCol()) + "-> n" + String.valueOf(Temp.getCol()) + "_"
                        + String.valueOf(Temp.getDownNode().getFil()) + "[dir=both];\n";
            } else {

                Dot += "n" + String.valueOf(Temp.getCol()) + "_" + String.valueOf(Temp.getFil()) + "-> n" + String.valueOf(Temp.getCol()) + "_"
                        + String.valueOf(Temp.getDownNode().getFil()) + "[dir=both];\n";
            }
            Temp = Temp.getDownNode();

        }
        Dot += "}";

        return Dot;
    }

    public void Mostar() {

    }

    public void CreateCabecera(int Col, String NameDir) {
        if (HeadNode.getRightNode() == null) {
            NodeMatrix Temp = new NodeMatrix(Col, 0, NameDir, "");
            HeadNode.setRightNode(Temp);
            Temp.setLeftNode(HeadNode);
        } else {
            NodeMatrix Aux = HeadNode;
            while (Aux.getRightNode() != null && Aux.getRightNode().getCol() < Col) {
                Aux = Aux.getRightNode();
            }

            if (Aux.getRightNode() == null) {
                NodeMatrix New_Node = new NodeMatrix(Col, 0, NameDir, "");
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
            } else if (Aux.getRightNode() != null && Aux.getRightNode().getCol() != Col) {
                NodeMatrix New_Node = new NodeMatrix(Col, 0, NameDir, "");
                NodeMatrix AuxRight = Aux.getRightNode();
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
                New_Node.setRightNode(AuxRight);
                AuxRight.setLeftNode(New_Node);
            }
        }
    }

    public void CreateHeaders(int Fil, String NameFolder) {
        if (HeadNode.getDownNode() == null) {
            NodeMatrix Aux = new NodeMatrix(0, Fil, "", NameFolder);
            HeadNode.setDownNode(Aux);
            Aux.setUpNode(HeadNode);
        } else {
            NodeMatrix AuxHeaders = HeadNode;
            while (AuxHeaders.getDownNode() != null && AuxHeaders.getDownNode().getFil() < Fil) {
                AuxHeaders = AuxHeaders.getDownNode();
            }
            if (AuxHeaders.getDownNode() == null) {
                NodeMatrix NewNode = new NodeMatrix(0, Fil, "", NameFolder);
                AuxHeaders.setDownNode(NewNode);
                NewNode.setUpNode(AuxHeaders);
            } else if (AuxHeaders.getDownNode() != null && AuxHeaders.getDownNode().getFil() != Fil) {
                NodeMatrix NewNode = new NodeMatrix(0, Fil, "", NameFolder);
                NodeMatrix AuxUp = AuxHeaders;
                AuxHeaders.setDownNode(NewNode);
                NewNode.setUpNode(AuxHeaders);
                NewNode.setDownNode(AuxUp);
                AuxUp.setUpNode(NewNode);
            }

        }
    }

    public void AddMatrixC(int Col, int Fil, String NameC, String NameH) {
        NodeMatrix New_Node = new NodeMatrix(Col, Fil, NameC, NameH);
        NodeMatrix Aux = HeadNode;
        while (Aux.getCol() != Col) {
            Aux = Aux.getRightNode();
        }
        if (Aux.getDownNode() == null) {
            Aux.setDownNode(New_Node);
            New_Node.setUpNode(Aux);
        } else {
            while (Aux.getDownNode() != null && Aux.getDownNode().getFil() < Fil) {
                Aux = Aux.getDownNode();
            }
            if (Aux.getDownNode() == null) {
                Aux.setDownNode(New_Node);
                New_Node.setUpNode(Aux);
            } else if (Aux.getDownNode() != null) {
                NodeMatrix Aux2 = Aux.getDownNode();
                Aux.setDownNode(New_Node);
                New_Node.setUpNode(Aux);
                New_Node.setDownNode(Aux2);
                Aux.setUpNode(New_Node);
            }

        }
    }

    public void AddMatrixH(int Col, int Fil, String NameC, String NameH) {
        NodeMatrix New_Node = new NodeMatrix(Col, Fil, NameC, NameH);
        NodeMatrix Aux = HeadNode;
        while (Aux.getFil() != Fil) {
            Aux = Aux.getDownNode();
        }
        if (Aux.getRightNode() == null) {
            Aux.setRightNode(New_Node);
            New_Node.setLeftNode(Aux);
        } else {
            while (Aux.getRightNode() != null && Aux.getRightNode().getCol() < Col) {
                Aux = Aux.getRightNode();
            }
            if (Aux.getRightNode() == null) {
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
            } else if (Aux.getRightNode() != null) {
                NodeMatrix AuxHeader = Aux.getRightNode();
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
                New_Node.setRightNode(AuxHeader);
                AuxHeader.setLeftNode(New_Node);
            }
        }

    }
}
