/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.AVL;

/**
 *
 * @author herre
 */
public class AVL {

    private NodeAVL Root;

    int NodeHeight(NodeAVL Node) {
        if (Node == null) {
            return 0;
        }
        return Node.getHeight();
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public NodeAVL RotateRight(NodeAVL Node) {
        NodeAVL Aux = Node.getSonLeft();
        NodeAVL Aux2 = Aux.getSonRight();
        Aux.setSonRight(Node);
        Node.setSonLeft(Aux2);
        Node.setHeight(max(NodeHeight(Node.getSonLeft()), NodeHeight(Node.getSonRight())) + 1);
        Aux.setHeight(max(NodeHeight(Aux.getSonLeft()), NodeHeight(Aux.getSonRight())) + 1);
        return Aux;
    }

    public NodeAVL RotateLeft(NodeAVL Node) {
        NodeAVL Aux = Node.getSonRight();
        NodeAVL Aux2 = Aux.getSonLeft();
        Aux.setSonLeft(Node);
        Node.setSonRight(Aux2);
        Node.setHeight(max(NodeHeight(Node.getSonLeft()), NodeHeight(Node.getSonRight())) + 1);
        Aux.setHeight(max(NodeHeight(Aux.getSonLeft()), NodeHeight(Aux.getSonRight())) + 1);
        return Aux;
    }

    int Get_Balance(NodeAVL Node) {
        if (Node == null) {
            return 0;
        }
        int temp = NodeHeight(Node.getSonLeft()) - NodeHeight(Node.getSonRight());
        Node.setFE(abs(temp));
        return NodeHeight(Node.getSonLeft()) - NodeHeight(Node.getSonRight());
    }

    int abs(int numero) {
        return numero > 0 ? numero : -numero;
    }

    private int toAscci(String palabra) {
        int valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            valor += (int) caracter;
        }//fin for
        return valor;
    }

    public void SentInsert(String Name, String Description) {
        setRoot(InsertNode(getRoot(), Name, Description));
    }

    NodeAVL InsertNode(NodeAVL Root, String Name, String Description) {
        int Id = toAscci(Name);
        if (Root == null) {
            return (new NodeAVL(Name, Description));
        }
        if (Id < Root.getId()) {
            Root.setSonLeft(InsertNode(Root.getSonLeft(), Name, Description));
        } else if (Id > Root.getId()) {
            Root.setSonRight(InsertNode(Root.getSonRight(), Name, Description));
        } else {
            return Root;
        }
        Root.setHeight(1 + max(NodeHeight(Root.getSonLeft()), NodeHeight(Root.getSonRight())));
        int balance = Get_Balance(Root);
        if (balance > 1 && Id < Root.getSonLeft().getId()) {
            return RotateRight(Root);
        }
        if (balance < -1 && Id > Root.getSonRight().getId()) {
            return RotateLeft(Root);
        }
        if (balance > 1 && Id > Root.getSonLeft().getId()) {
            Root.setSonLeft(RotateLeft(Root.getSonLeft()));
            return RotateRight(Root);
        }
        if (balance < -1 && Id < Root.getSonRight().getId()) {
            Root.setSonRight(RotateRight(Root.getSonRight()));
            return RotateLeft(Root);
        }
        return Root;
    }

    NodeAVL minValueNode(NodeAVL Node) {
        NodeAVL current = Node;
        while (current.getSonLeft() != null) {
            current = current.getSonLeft();
        }
        return current;
    }

    public void SendDelete(String Name) {
        DeleteNode(getRoot(), Name);
    }

    NodeAVL DeleteNode(NodeAVL Root, String Name) {
        int key = toAscci(Name);
        if (Root == null) {
            return Root;
        }
        if (key < Root.getId()) {
            Root.setSonLeft(DeleteNode(Root.getSonLeft(), Name));
        } else if (key > Root.getId()) {
            Root.setSonRight(DeleteNode(Root.getSonRight(), Name));
        } else {
            if ((Root.getSonLeft() == null) || (Root.getSonRight() == null)) {
                NodeAVL temp = null;
                if (temp == Root.getSonLeft()) {
                    temp = Root.getSonRight();
                } else {
                    temp = Root.getSonLeft();
                }
                if (temp == null) {
                    temp = Root;
                    Root = null;
                } else {
                    Root = temp;
                }
            } else {
                NodeAVL temp = minValueNode(Root.getSonRight());
                Root.setId(temp.getId());
                Root.setSonRight(DeleteNode(Root.getSonRight(), temp.getName()));
            }
        }
        if (Root == null) {
            return Root;
        }
        Root.setHeight(max(NodeHeight(Root.getSonLeft()), NodeHeight(Root.getSonRight())) + 1);
        int balance = Get_Balance(Root);
        if (balance > 1 && Get_Balance(Root.getSonLeft()) >= 0) {
            return RotateRight(Root);
        }
        if (balance > 1 && Get_Balance(Root.getSonLeft()) < 0) {
            Root.setSonLeft(RotateLeft(Root.getSonLeft()));
            return RotateRight(Root);
        }
        if (balance < -1 && Get_Balance(Root.getSonRight()) <= 0) {
            return RotateLeft(Root);
        }
        if (balance < -1 && Get_Balance(Root.getSonRight()) > 0) {
            Root.setSonRight(RotateRight(Root.getSonRight()));
            return RotateLeft(Root);
        }
        return Root;
    }

    public NodeAVL SendSearchNode(String Name) {
        return SearhNode2(getRoot(), Name);
    }

    public NodeAVL SearhNode2(NodeAVL Root, String Name) {
        int Tam = toAscci(Name);
        if (Root != null) {
            if (Root.getId() == Tam) {
                return Root;
            }
            if (Tam < Root.getId()) {
                return SearhNode2(Root.getSonLeft(), Name);
            }
            if (Tam > Root.getId()) {
                return SearhNode2(Root.getSonRight(), Name);
            }
        }
        return null;
    }

    public void Modify(String Name, String Content) {
        NodeAVL a = SendSearchNode(Name);
        a.setDescription(Content);

    }

    public void ModifyName(String OldName, String New_Name) {
        NodeAVL a = SendSearchNode(OldName);
        String Content = a.getDescription();
        SendDelete(OldName);
        SentInsert(New_Name, Content);
    }

    public void SentGraphAVL() {
        String Dot = "";
        GraphAVL(getRoot(), Dot);
    }
    String Te = "";

    public String GraphAVL(NodeAVL Root, String Dot) {
        if (Root != null) {
            if (Te.equalsIgnoreCase("left")) {
                Dot += "Node_" + String.valueOf(Root.getId()) + ":f1; \n";
            } else if (Te.equalsIgnoreCase("right")) {
                Dot += "Node_" + String.valueOf(Root.getId()) + ":f1; \n";
            }

            Dot += "Node_" + String.valueOf(Root.getId()) + "[label= \" <f0>| <f1> Name: " + String.valueOf(Root.getName()) + "\\n Content: " + Root.getDescription() + "\\n FE: " + String.valueOf(Root.getFE()) + " Height: " + String.valueOf(Root.getHeight()) + "\\n Time:" + String.valueOf(Root.getTimeStamp()) + "|<f2> \" shape=\"record\"] ; \n";

            if (Root.getSonLeft() != null) {
                Dot += "Node_" + String.valueOf(Root.getId()) + ":f0";
                Dot += "->";
                Te = "left";
            }

            if (Root.getSonRight() != null) {
                Dot += "Node_" + String.valueOf(Root.getId()) + ":f2";
                Dot += "->";
                Te = "right";
            }
        }
        return Dot;
    }

    public void PreOrder() {
        PreOrder2(getRoot());
    }

    public void PreOrder2(NodeAVL Root) {
        if (Root != null) {
            System.out.println("Name:" + Root.getName() + " Id:" + Root.getId() + " FE:" + Root.getFE() + " Altura:" + Root.getHeight() + " Contenido:" + Root.getDescription());
            PreOrder2(Root.getSonLeft());
            PreOrder2(Root.getSonRight());
        }
    }

    public void InOrder() {
        InIrder2(getRoot());
    }

    public void InIrder2(NodeAVL Root) {
        if (Root != null) {
            PreOrder2(Root.getSonLeft());
            System.out.println("Name:" + Root.getName() + " Id:" + Root.getId() + " FE:" + Root.getFE() + " Altura:" + Root.getHeight() + " Contenido:" + Root.getDescription());
            PreOrder2(Root.getSonRight());
        }
    }

    /**
     * @return the Root
     */
    public NodeAVL getRoot() {
        return Root;
    }

    /**
     * @param Root the Root to set
     */
    public void setRoot(NodeAVL Root) {
        this.Root = Root;
    }
}
