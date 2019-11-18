/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Matrix;

import edd.py2_201520498.Win.Login_User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author herre
 */
public class Matrix {

    private NodeMatrix HeadNode;

    public Matrix() {
        NodeMatrix NNode = new NodeMatrix("", "");
        HeadNode = NNode;
    }

    public void AddMatrizSoloPadres(String NombrePadre) {
        CreateLateral2Padres(NombrePadre);
        CreateCabera2Hijos(NombrePadre);
    }

    public void AddMatrizSoloHijos(String Nombre) {
        CreateLateral2Padres(Nombre);
    }

    public void AddMatrix(String NombrePadre, String NombreHijos) {
        CreateCabera2Hijos(NombreHijos);
        CreateLateral2Padres(NombrePadre);

        AgrearHijos(NombrePadre, NombreHijos);
        AgregarPadre(NombrePadre, NombreHijos);
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
        NodeMatrix Temp = getHeadNode().getRightNode();
        NodeMatrix Temp2 = getHeadNode().getDownNode();

        if (Temp != null && Temp2 != null) {
            Dot += "digraph Sparse_Matrix{\n";
            Dot += "node [shape=box]\n";
            Dot += "graph[nodesep = 0.5];\n";
            Dot += "Terminal [ label = \"Matrix\", width = 1.5, style = filled, group = 0 ];\n";
            Dot += "e0[ shape = point, width = 0 ]\n";
            Dot += "e1[ shape = point, width = 0 ]\n";
            Dot += "Terminal -> Y" + String.valueOf(Temp2.getNombrePadre()) + " [dir=both];\n";
            while (Temp2.getDownNode() != null) {
                Dot += "Y" + String.valueOf(Temp2.getNombrePadre()) + "[label = \"" + String.valueOf(Temp2.getNombrePadre()) + " \" , group ="
                        + String.valueOf(0) + "];\n";
                Dot += "Y" + String.valueOf(Temp2.getNombrePadre()) + "-> Y" + String.valueOf(Temp2.getDownNode().getNombrePadre()) + "[dir=both];\n";
                NodeMatrix Aux2 = Temp2;
                while (Aux2.getRightNode() != null) {
                    if (Aux2.getNombreHijo().equalsIgnoreCase("")) {
                        Dot += "Y" + String.valueOf(Aux2.getNombrePadre()) + "-> n" + String.valueOf(Aux2.getRightNode().getNombreHijo()) + "_"
                                + String.valueOf(Aux2.getRightNode().getNombrePadre()) + "[dir=both];\n";
                        Dot += "{ rank = same; Y" + String.valueOf(Temp2.getNombrePadre()) + "; n" + String.valueOf(Aux2.getRightNode().getNombreHijo())
                                + "_" + String.valueOf(Aux2.getRightNode().getNombrePadre()) + " }\n";
                    } else {
                        Dot += "n" + String.valueOf(Aux2.getNombreHijo()) + "_" + String.valueOf(Aux2.getNombrePadre()) + "-> n"
                                + String.valueOf(Aux2.getRightNode().getNombreHijo()) + "_" + String.valueOf(Aux2.getRightNode().getNombrePadre())
                                + "[dir=both];\n";
                        Dot += "{ rank = same; n" + String.valueOf(Aux2.getNombreHijo()) + "_" + String.valueOf(Aux2.getNombrePadre()) + "; n"
                                + String.valueOf(Aux2.getRightNode().getNombreHijo()) + "_" + String.valueOf(Aux2.getRightNode().getNombrePadre()) + " }\n";
                    }
                    Aux2 = Aux2.getRightNode();
                }
                Temp2 = Temp2.getDownNode();
            }
            Dot += "Y" + String.valueOf(Temp2.getNombrePadre()) + "[label = \"" + String.valueOf(Temp2.getNombrePadre()) + " \" ,group =X" + String.valueOf(0)
                    + "];\n";
            while (Temp2.getRightNode() != null) {
                if (Temp2.getNombreHijo().equalsIgnoreCase("")) {
                    Dot += "Y" + String.valueOf(Temp2.getNombrePadre()) + "-> n" + String.valueOf(Temp2.getRightNode().getNombreHijo()) + "_"
                            + String.valueOf(Temp2.getNombrePadre()) + "[dir=both];\n";
                    Dot += "{ rank = same; Y" + String.valueOf(Temp2.getNombrePadre()) + "; n" + String.valueOf(Temp2.getRightNode().getNombreHijo()) + "_"
                            + String.valueOf(Temp2.getNombrePadre()) + " }\n";

                } else {
                    Dot += "n" + String.valueOf(Temp2.getNombreHijo()) + "_" + String.valueOf(Temp2.getNombrePadre()) + "-> n"
                            + String.valueOf(Temp2.getRightNode().getNombreHijo()) + "_" + String.valueOf(Temp2.getNombrePadre()) + "[dir=both];\n";
                    Dot += "{ rank = same; n" + String.valueOf(Temp2.getNombreHijo()) + "_" + String.valueOf(Temp2.getNombrePadre()) + "; n"
                            + String.valueOf(Temp2.getRightNode().getNombreHijo()) + "_" + String.valueOf(Temp2.getNombrePadre()) + " }\n";

                }
                Temp2 = Temp2.getRightNode();
            }
            Dot += "Terminal -> X" + String.valueOf(Temp.getNombreHijo()) + " [dir=both];\n";
            while (Temp.getRightNode() != null) {
                Dot += "X" + String.valueOf(Temp.getNombreHijo()) + "[label = \"" + String.valueOf(Temp.getNombreHijo()) + " \"  , group = X"
                        + String.valueOf(Temp.getNombreHijo()) + "];\n";
                Dot += "X" + String.valueOf(Temp.getNombreHijo()) + "-> X" + String.valueOf(Temp.getRightNode().getNombreHijo()) + "[dir=both];\n";
                Dot += "{ rank = same; Terminal; X" + String.valueOf(Temp.getNombreHijo()) + " }\n";
                NodeMatrix Aux = Temp;
                while (Aux.getDownNode() != null) {
                    Dot += "n" + String.valueOf(Aux.getNombreHijo()) + "_" + String.valueOf(Aux.getDownNode().getNombrePadre()) + "[label = \""
                            + String.valueOf(Aux.getDownNode().getNombrePadre()) + "/" + String.valueOf(Aux.getDownNode().getNombreHijo()) + " \"   width = 1.5, group =X" + String.valueOf(Aux.getNombreHijo()) + "];\n";
                    if (Aux.getNombrePadre().equalsIgnoreCase("")) {
                        Dot += "X" + String.valueOf(Aux.getNombreHijo()) + "->n" + String.valueOf(Aux.getNombreHijo()) + "_"
                                + String.valueOf(Aux.getDownNode().getNombrePadre()) + "[dir=both];\n";
                    } else {
                        Dot += "n" + String.valueOf(Aux.getNombreHijo()) + "_" + String.valueOf(Aux.getNombrePadre()) + "-> n" + String.valueOf(Aux.getNombreHijo()) + "_"
                                + String.valueOf(Aux.getDownNode().getNombrePadre()) + "[dir=both];\n";
                    }
                    Aux = Aux.getDownNode();
                }
                Temp = Temp.getRightNode();
            }
            Dot += "X" + String.valueOf(Temp.getNombreHijo()) + "[label = \"" + String.valueOf(Temp.getNombreHijo()) + " \" , group =X"
                    + String.valueOf(Temp.getNombreHijo()) + "];\n";
            Dot += "{ rank = same; Terminal; X" + String.valueOf(Temp.getNombreHijo()) + " }\n";
            while (Temp.getDownNode() != null) {
                Dot += "n" + String.valueOf(Temp.getNombreHijo()) + "_" + String.valueOf(Temp.getDownNode().getNombrePadre()) + "[label = \""
                        + String.valueOf(Temp.getDownNode().getNombrePadre()) + "/" + String.valueOf(Temp.getDownNode().getNombreHijo())
                        + " \"   width = 1.5, group =X" + String.valueOf(Temp.getNombreHijo())
                        + "];\n";
                if (Temp.getNombrePadre().equalsIgnoreCase("")) {

                    Dot += "X" + String.valueOf(Temp.getNombreHijo()) + "-> n" + String.valueOf(Temp.getNombreHijo()) + "_"
                            + String.valueOf(Temp.getDownNode().getNombrePadre()) + "[dir=both];\n";
                } else {

                    Dot += "n" + String.valueOf(Temp.getNombreHijo()) + "_" + String.valueOf(Temp.getNombrePadre()) + "-> n" + String.valueOf(Temp.getNombreHijo()) + "_"
                            + String.valueOf(Temp.getDownNode().getNombrePadre()) + "[dir=both];\n";
                }
                Temp = Temp.getDownNode();

            }
        }
        Dot += "}";
        return Dot;
    }

    public void CreateCabera2Hijos(String NameDir) {
        if (getHeadNode().getRightNode() == null) {
            NodeMatrix Temp = new NodeMatrix("", NameDir);
            getHeadNode().setRightNode(Temp);
            Temp.setLeftNode(getHeadNode());
        } else {
            NodeMatrix Aux = getHeadNode();
            while (Aux.getRightNode() != null) {
                Aux = Aux.getRightNode();
            }
            if (Aux.getRightNode() == null) {
                NodeMatrix New_Node = new NodeMatrix("", NameDir);
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
            } else if (Aux.getRightNode() != null && !Aux.getRightNode().getNombreHijo().equalsIgnoreCase(NameDir)) {
                NodeMatrix New_Node = new NodeMatrix("", NameDir);
                NodeMatrix AuxRight = Aux.getRightNode();
                Aux.setRightNode(New_Node);
                New_Node.setLeftNode(Aux);
                New_Node.setRightNode(AuxRight);
                AuxRight.setLeftNode(New_Node);
            }
        }
    }

    public void CreateLateral2Padres(String NamePAdre) {
        if (getHeadNode().getDownNode() == null) {
            NodeMatrix Aux = new NodeMatrix(NamePAdre, "");
            getHeadNode().setDownNode(Aux);
            Aux.setUpNode(getHeadNode());
        } else {
            NodeMatrix AuxHeaders = getHeadNode();
            while (AuxHeaders.getDownNode() != null) {
                AuxHeaders = AuxHeaders.getDownNode();
            }
            if (AuxHeaders.getDownNode() == null) {
                NodeMatrix NewNode = new NodeMatrix(NamePAdre, "");
                AuxHeaders.setDownNode(NewNode);
                NewNode.setUpNode(AuxHeaders);
            } else if (AuxHeaders.getDownNode() != null && !AuxHeaders.getDownNode().getNombrePadre().equalsIgnoreCase(NamePAdre)) {
                NodeMatrix NewNode = new NodeMatrix(NamePAdre, "");
                NodeMatrix AuxUp = AuxHeaders;
                AuxHeaders.setDownNode(NewNode);
                NewNode.setUpNode(AuxHeaders);
                NewNode.setDownNode(AuxUp);
                AuxUp.setUpNode(NewNode);
            }
        }
    }

    public void AgrearHijos(String NombrePadre, String NombreHijo) {
        NodeMatrix New_Node = new NodeMatrix(NombrePadre, NombreHijo);
        NodeMatrix Aux = getHeadNode();
        while (!Aux.getNombreHijo().equalsIgnoreCase(NombreHijo)) {
            Aux = Aux.getRightNode();
        }
        if (Aux.getDownNode() == null) {
            Aux.setDownNode(New_Node);
            New_Node.setUpNode(Aux);
        } else {
            while (Aux.getDownNode() != null) {
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

    public void AgregarPadre(String NombrePadre, String NombreHijo) {
        NodeMatrix New_Node = new NodeMatrix(NombrePadre, NombreHijo);
        NodeMatrix Aux = getHeadNode();
        while (!Aux.getNombrePadre().equalsIgnoreCase(NombrePadre)) {
            Aux = Aux.getDownNode();
        }
        if (Aux.getRightNode() == null) {
            Aux.setRightNode(New_Node);
            New_Node.setLeftNode(Aux);
        } else {
            while (Aux.getRightNode() != null) {
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

    /*
    public void CreateCabecera(int Col, String NameDir) {
        if (getHeadNode().getRightNode() == null) {
            NodeMatrix Temp = new NodeMatrix(Col, 0, NameDir, "");
            getHeadNode().setRightNode(Temp);
            Temp.setLeftNode(getHeadNode());
        } else {
            NodeMatrix Aux = getHeadNode();
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
        if (getHeadNode().getDownNode() == null) {
            NodeMatrix Aux = new NodeMatrix(0, Fil, "", NameFolder);
            getHeadNode().setDownNode(Aux);
            Aux.setUpNode(getHeadNode());
        } else {
            NodeMatrix AuxHeaders = getHeadNode();
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
        NodeMatrix Aux = getHeadNode();
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
        NodeMatrix Aux = getHeadNode();
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
     */
    /**
     * @return the HeadNode
     */
    public NodeMatrix getHeadNode() {
        return HeadNode;
    }

    /**
     * @param HeadNode the HeadNode to set
     */
    public void setHeadNode(NodeMatrix HeadNode) {
        this.HeadNode = HeadNode;
    }
}
