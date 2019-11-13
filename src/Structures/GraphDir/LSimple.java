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
public class LSimple {

    private NodeLS FirtsList;
    private NodeLS EndList;
    private String Name;
    private int Contador;
    private LSimple SiguienteLista;

    public LSimple() {
        this.FirtsList = null;
        this.EndList = null;
    }

    public boolean isEmpty() {
        return getFirtsList() == null;
    }

    public void InsertarNodeoListaS(String Name) {
        NodeLS nuevo = crearNodo(Name);
        if (isEmpty()) {
            setFirtsList(nuevo);
            setEndList(nuevo);
        } else {
            getEndList().setNextNode(nuevo);
            setEndList(nuevo);
        }
        setContador(getContador() + 1);
    }

    public NodeLS crearNodo(String Name) {
        return new NodeLS(Name, getContador());
    }

    public NodeLS BuscarCarpetas(String Name) {
        NodeLS Aux = getFirtsList();
        if (Aux != null) {
            while (Aux != null) {
                if (Aux.getNameDir().equalsIgnoreCase(Name)) {
                    return Aux;
                }
            }
        } else {
            System.out.println("No se Encontro Dentro de la Lista de Listas");
        }

        return null;

    }

    public boolean Buscar(String Name) {
        NodeLS Aux = getFirtsList();
        if (Aux != null) {
            while (Aux != null) {
                if (Aux.getNameDir().equalsIgnoreCase(Name)) {
                    return true;
                }
                Aux = Aux.getNextNode();
            }
        } else {
            System.out.println("No se Encontro Dentro de la Lista de Listas");
        }

        return false;
    }

    public NodeLS remover(String Name) {
        NodeLS retirado = null;
        NodeLS actual = getFirtsList();
        if (actual.getNameDir() == Name) {
            retirado = actual;
            setFirtsList(getFirtsList().getNextNode());
        } else {
            while (actual.getNextNode() != null) {
                if (actual.getNextNode().getNameDir() == Name) {
                    retirado = actual.getNextNode();
                    actual.setNextNode(retirado.getNextNode());
                    break;
                }
                actual = actual.getNextNode();
            }
        }
        return retirado;
    }

    public void Imprimir() {
        NodeLS Aux = getFirtsList();
        while (Aux != null) {
            System.out.println("Nombre Carpeta:" + Aux.getNameDir());
            Aux = Aux.getNextNode();
        }
    }

    public String getDot() {
        String dot = "\nnode [shape=record];\n";
        NodeLS actual = getFirtsList();
        while (actual != null) {
            dot += "node" + actual.getNameDir() + "[label=\"" + actual.getNameDir() + "\"];\n";
            if (actual.getNextNode() != null) {
                dot += "node" + actual.getNameDir() + " -> node" + actual.getNextNode().getNameDir() + ";\n";
            }//fin if
            actual = actual.getNextNode();
        }//fin while
        return dot;
    }

    /**
     * @return the FirtsList
     */
    public NodeLS getFirtsList() {
        return FirtsList;
    }

    /**
     * @param FirtsList the FirtsList to set
     */
    public void setFirtsList(NodeLS FirtsList) {
        this.FirtsList = FirtsList;
    }

    /**
     * @return the EndList
     */
    public NodeLS getEndList() {
        return EndList;
    }

    /**
     * @param EndList the EndList to set
     */
    public void setEndList(NodeLS EndList) {
        this.EndList = EndList;
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
     * @return the SiguienteLista
     */
    public LSimple getSiguienteLista() {
        return SiguienteLista;
    }

    /**
     * @param SiguienteLista the SiguienteLista to set
     */
    public void setSiguienteLista(LSimple SiguienteLista) {
        this.SiguienteLista = SiguienteLista;
    }
}
