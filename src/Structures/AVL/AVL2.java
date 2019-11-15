/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.AVL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author herre
 */
public class AVL2 {

    private NodeAVL Root;
    private int Contador;

    public AVL2() {
        this.Contador = 0;
        this.Root = null;
    }

    public void EliminarArchivos(String Name) {
        System.out.println("Se eliminara " + Name);
        //eliminar(toAscci(Name));
         SendEliminarArchivo(toAscci(Name));
    }

    public boolean eliminar(int Clave) {
        System.out.println("Id " + Clave);
        NodeAVL eliminado = remover(getRoot(), Clave);
        if (eliminado != null) {

            System.out.println("SE elmino " + eliminado.getName());
        } else {
            System.out.println("No se elimino");
        }
        return eliminado != null;
    }

    public NodeAVL remover(NodeAVL Node, int Clave) {
        if (Node == null) {
            return null;
        }
        if (Clave < Node.getId()) {
            Node.setSonLeft(remover(Node.getSonLeft(), Clave));
        } else if (Clave > Node.getId()) {
            Node.setSonRight(remover(Node.getSonRight(), Clave));
        } else {
            NodeAVL izquierdo = Node.getSonLeft();
            NodeAVL derecho = Node.getSonRight();
            if (derecho == null) {
                return izquierdo;
            }
            NodeAVL menor = buscarMenor(derecho);
            menor.setSonRight(eliminarMenor(derecho));
            menor.setSonLeft(izquierdo);
            return balancear(menor);
        }
        Node.setHeight(max(obtenerAltura(Node.getSonLeft()), obtenerAltura(Node.getSonRight())) + 1);
        int balance = FactorE(Node);
        if (balance > 1 && FactorE(Node.getSonLeft()) >= 0) {
            return rotacionDerecha(Node);
        }
        if (balance > 1 && FactorE(Node.getSonLeft()) < 0) {
            Node.setSonLeft(rotacionIzquierda(Node.getSonLeft()));
            return rotacionDerecha(Node);
        }
        if (balance < -1 && FactorE(Node.getSonRight()) <= 0) {
            return rotacionIzquierda(Node);
        }
        if (balance < -1 && FactorE(Node.getSonRight()) > 0) {
            Node.setSonRight(rotacionDerecha(Node.getSonRight()));
            return rotacionIzquierda(Node);
        }

        return (Node);
    }

    public void ModificarNombre(String Name, String New_Name) {
        NodeAVL Temp = buscar(toAscci(Name), getRoot());
        if (Temp == null) {
            System.out.println("No exite este Nombre " + Name);
        } else {
            String Des = Temp.getDescription();
            EliminarArchivos(Name);
            InsertarArchivo(New_Name, Des);
        }
    }

    public void ModificarContenido(String Name, String New_Contenido) {
        NodeAVL Temp = buscar(toAscci(Name), getRoot());
        Temp.setDescription(New_Contenido);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public NodeAVL remover2(NodeAVL Node, int Clave) {
        if (Node == null) {
            return null;
        }
        if (Clave < Node.getId()) {
            Node.setSonLeft(remover2(Node.getSonLeft(), Clave));
        } else if (Clave > Node.getId()) {
            Node.setSonRight(remover2(Node.getSonRight(), Clave));
        } else {
            NodeAVL izquierdo = Node.getSonLeft();
            NodeAVL derecho = Node.getSonRight();
            if (derecho == null) {
                return izquierdo;
            }
            NodeAVL menor = buscarMenor(derecho);
            menor.setSonRight(eliminarMenor(derecho));
            menor.setSonLeft(izquierdo);
            return balancear(menor);
        }
        return balancear(Node);
    }

    private NodeAVL buscarMenor(NodeAVL Node) {
        return (Node.getSonLeft() != null) ? buscarMenor(Node.getSonLeft()) : Node;
    }

    private NodeAVL eliminarMenor(NodeAVL Node) {
        if (Node.getSonLeft() == null) {
            return Node.getSonRight();
        }
        Node.setSonLeft(eliminarMenor(Node.getSonLeft()));
        return balancear(Node);
    }

    public boolean InsertarArchivo(String Name, String Descripcion) {
        NodeAVL Temp = buscar(toAscci(Name), getRoot());
        if (Temp == null) {
            setRoot(insertar(new NodeAVL(Name, Descripcion, getContador()), getRoot()));
        }
        return false;
    }

    public NodeAVL buscar(int clave, NodeAVL Root) {
        if (Root != null) {
            if (clave == Root.getId()) {
                return Root;
            }
            if (clave < Root.getId()) {
                return buscar(clave, Root.getSonLeft());
            }
            if (clave > Root.getId()) {
                return buscar(clave, Root.getSonRight());
            }
        }
        return null;
    }

    private NodeAVL rotacionDerecha(NodeAVL Node) {
        NodeAVL temp = Node.getSonLeft();
        Node.setSonLeft(temp.getSonRight());
        temp.setSonRight(Node);
        arreglarAltura(Node);
        arreglarAltura(temp);
        return temp;
    }

    private NodeAVL rotacionIzquierda(NodeAVL Node) {
        NodeAVL temp = Node.getSonRight();
        Node.setSonRight(temp.getSonLeft());
        temp.setSonLeft(Node);
        arreglarAltura(Node);
        arreglarAltura(temp);
        return temp;
    }

    private NodeAVL balancear(NodeAVL Node) {
        arreglarAltura(Node);
        if (FactorE(Node) == 2) {
            if (FactorE(Node.getSonRight()) < 0) {
                Node.setSonRight(rotacionDerecha(Node.getSonRight()));
            }
            return rotacionIzquierda(Node);
        }
        int a = FactorE(Node);
        if (FactorE(Node) == -2) {
            if (FactorE(Node.getSonLeft()) > 0) {
                Node.setSonLeft(rotacionIzquierda(Node.getSonLeft()));
            }
            return rotacionDerecha(Node);
        }
        return Node;
    }

    public NodeAVL insertar(NodeAVL New_Node, NodeAVL Root) {
        if (Root == null) {
            setContador(getContador() + 1);
            return New_Node;
        }
        if (New_Node.getId() < Root.getId()) {
            Root.setSonLeft(insertar(New_Node, Root.getSonLeft()));
        } else if (New_Node.getId() > Root.getId()) { //va a la derecha
            Root.setSonRight(insertar(New_Node, Root.getSonRight()));
        } else {
        }
        return balancear(Root);
    }

    int abs(int numero) {
        return numero > 0 ? numero : -numero;
    }

    private int FactorE(NodeAVL Node) {
        if (Node == null) {
            return 0;
        }
        Node.setFE(abs(obtenerAltura(Node.getSonRight()) - obtenerAltura(Node.getSonLeft())));
        return obtenerAltura(Node.getSonRight()) - obtenerAltura(Node.getSonLeft());
    }

    private int obtenerAltura(NodeAVL Node) {
        return (Node != null) ? Node.getHeight() : 0;
    }

    private void arreglarAltura(NodeAVL Node) {
        int hl = obtenerAltura(Node.getSonLeft());
        int hr = obtenerAltura(Node.getSonRight());
        Node.setHeight(((hl > hr) ? hl : hr) + 1);
    }

    private int toAscci(String Name) {
        int Value = 0;
        for (int i = 0; i < Name.length(); i++) {
            char Aux = Name.charAt(i);
            Value += (int) Aux;
        }//fin for
        return Value;
    }

    public void SentGraphAVL() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("AVL.dot");
            pw = new PrintWriter(fichero);
            String Dot = " digraph AVL{";
            GraphAVL(getRoot(), Dot);
            Dot += Ab;
            Dot += "}";
            pw.println(Dot);

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
            String cmd = "dot -Tjpg AVL.dot -o AVL.jpg";
            Runtime.getRuntime().exec(cmd);
            //String cmd2 = "TableHash.jpg"; 
            //Runtime.getRuntime().exec(cmd2);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }
    String Te = "";
    String Ab = "";

    public String GraphAVL(NodeAVL Root, String Dot) {
        if (Root != null) {
            if (Te.equalsIgnoreCase("left")) {
                Ab += "Node_" + String.valueOf(Root.getId()) + ":f1; \n";
            } else if (Te.equalsIgnoreCase("right")) {
                Ab += "Node_" + String.valueOf(Root.getId()) + ":f1; \n";
            }
            Ab += "Node_" + String.valueOf(Root.getId()) + "[label= \" <f0>| <f1> Name: " + String.valueOf(Root.getName()) + "\\n Content: " + Root.getDescription() + "\\n FE: " + String.valueOf(Root.getFE()) + " Height: " + String.valueOf(Root.getHeight()) + "\\n Time:" + String.valueOf(Root.getTimeStamp()) + "|<f2> \" shape=\"record\"] ; \n";
            if (Root.getSonLeft() != null) {
                Ab += "Node_" + String.valueOf(Root.getId()) + ":f0";
                Ab += "->";
                Te = "left";
                GraphAVL(Root.getSonLeft(), Dot);
            }

            if (Root.getSonRight() != null) {
                Ab += "Node_" + String.valueOf(Root.getId()) + ":f2";
                Ab += "->";
                Te = "right";
                GraphAVL(Root.getSonRight(), Dot);
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

    public void SendEliminarArchivo(int Clave) {
      NodeAVL Aux = Del(getRoot(), Clave);
      if (Aux != null){
          System.out.println(Aux.getName());
      }else{
          System.out.println("Me cago en la puta");
      }

    }

    public NodeAVL Del(NodeAVL Root, int key) {
        if (Root == null) {
            return Root;
        }
        if (key < Root.getId()) {
            Root.setSonLeft(Del(Root.getSonLeft(), key));
        } else if (key > Root.getId()) {
            Root.setSonRight(Del(Root.getSonRight(), key));
        } else {
            if (Root.getSonLeft() == null && Root.getSonRight() == null) {
                Root = null;
            } else if (Root.getSonLeft() == null) {
                return Root.getSonRight();
            } else if (Root.getSonRight() == null) {
                return Root.getSonLeft();
            } else {
                NodeAVL izquierdo = Root.getSonLeft();
                NodeAVL derecho = Root.getSonRight();
                NodeAVL menor = buscarMenor(derecho);
                NodeAVL Aux = eliminarMenor(derecho);
                menor.setSonRight(Aux);
                menor.setSonLeft(izquierdo);
                return balancear(menor);
            }
        }
         return balancear(Root);
    }

    NodeAVL DeleteNode(NodeAVL Root, int key) {
        System.out.println(key);
        if (Root == null) {
            return Root;
        }
        if (key < Root.getId()) {
            Root.setSonLeft(DeleteNode(Root.getSonLeft(), key));
        } else if (key > Root.getId()) {
            Root.setSonRight(DeleteNode(Root.getSonRight(), key));
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
                Root.setSonRight(DeleteNode(Root.getSonRight(), temp.getId()));
            }
        }
        if (Root == null) {
            return Root;
        }
        Root.setHeight(max(NodeHeight(Root.getSonLeft()), NodeHeight(Root.getSonRight())) + 1);
        int balance = Get_Balance(Root);
        if (balance > 1 && NodeHeight(Root.getSonLeft()) >= 0) {
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

    int NodeHeight(NodeAVL Node) {
        if (Node == null) {
            return 0;
        }
        return Node.getHeight();
    }

    int Get_Balance(NodeAVL Node) {
        if (Node == null) {
            return 0;
        }
        int temp = NodeHeight(Node.getSonLeft()) - NodeHeight(Node.getSonRight());
        Node.setFE(abs(temp));
        return NodeHeight(Node.getSonLeft()) - NodeHeight(Node.getSonRight());
    }

    NodeAVL minValueNode(NodeAVL Node) {
        NodeAVL current = Node;
        while (current.getSonLeft() != null) {
            current = current.getSonLeft();
        }
        return current;
    }

    public NodeAVL RotateRight(NodeAVL Node) {
        NodeAVL Aux = Node.getSonLeft();
        NodeAVL Aux2 = Aux.getSonRight();
        Aux.setSonRight(Node);
        Node.setSonLeft(Aux2);
        Node.setHeight(max(obtenerAltura(Node.getSonLeft()), obtenerAltura(Node.getSonRight())) + 1);
        Aux.setHeight(max(obtenerAltura(Aux.getSonLeft()), obtenerAltura(Aux.getSonRight())) + 1);
        return Aux;
    }

    public NodeAVL RotateLeft(NodeAVL Node) {
        NodeAVL Aux = Node.getSonRight();
        NodeAVL Aux2 = Aux.getSonLeft();
        Aux.setSonLeft(Node);
        Node.setSonRight(Aux2);
        Node.setHeight(max(obtenerAltura(Node.getSonLeft()), obtenerAltura(Node.getSonRight())) + 1);
        Aux.setHeight(max(obtenerAltura(Aux.getSonLeft()), obtenerAltura(Aux.getSonRight())) + 1);
        return Aux;
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

    /**
     * @return the Contador
     */
    public int getContador() {
        return Contador;
    }

    /**
     * @param Contador the Contador to set
     */
    public void setContador(int Contador) {
        this.Contador = Contador;
    }

}
