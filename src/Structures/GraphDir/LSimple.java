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
    private int ContadorPadre;
    private String CPadre;
    private LSimple SiguienteLista;
    public NodeLS Temporal = null;
    public int ContadorTemporal = 0;

    public LSimple() {
        this.FirtsList = null;
        this.EndList = null;
        this.Contador = 0;
        this.ContadorPadre = 0;
    }

    public boolean isEmpty() {
        return getFirtsList() == null;
    }

    public void InsertarNodeoListaS(String Name, String NombrePadre, int ContadorPadre) {
        NodeLS nuevo = crearNodo(Name, NombrePadre, ContadorPadre, getContador());
        if (isEmpty()) {
            setFirtsList(nuevo);
            setEndList(nuevo);
        } else {
            setContadorPadre(getContadorPadre() + 1);
            getEndList().setNextNode(nuevo);
            setEndList(nuevo);
        }
        setContador(getContador() + 1);

    }

    public NodeLS crearNodo(String Name, String NombrePadre, int ContadorPadre, int ContadorHijo) {
        return new NodeLS(Name, NombrePadre, ContadorPadre, ContadorHijo);
    }

    public NodeLS BuscarCarpetas(String Name) {
        NodeLS Aux = getFirtsList();
        if (Aux != null) {
            while (Aux != null) {
                if (Aux.getNameDir().equalsIgnoreCase(Name)) {
                    return Aux;
                }
                Aux = Aux.getNextNode();
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
                if (Aux.getNameDir().equals(Name)) {
                    return true;
                }
                Aux = Aux.getNextNode();
            }
        } else {
            System.out.println("No se Encontro Dentro de la Lista de Listas");
        }
        return false;
    }

    public String ArchivoCompartir(String Name) {
        NodeLS Aux = getFirtsList();
        if (Aux != null) {
            while (Aux != null) {
                if (Aux.getNameDir().equals(Name)) {
                    return Aux.getAvlTree().ContenidoCompartir(Name);
                }
                Aux = Aux.getNextNode();
            }
        } else {
            System.out.println("No se Encontro Dentro de la Lista de Listas");
        }
        return "";

    }

    public boolean remover(String Name) {
        NodeLS retirado = null;
        NodeLS actual = getFirtsList();
        if (actual.getNameDir().equals(Name)) {
            retirado = actual;
            setFirtsList(getFirtsList().getNextNode());
            return true;
        } else {
            while (actual.getNextNode() != null) {
                if (actual.getNextNode().getNameDir().equals(Name)) {
                    retirado = actual.getNextNode();
                    actual.setNextNode(retirado.getNextNode());
                    return true;
                }
                actual = actual.getNextNode();
            }
        }
        return false;
    }

    public void EliminarPorGrupo(String Padre, String Hijo) {
        NodeLS Temp = BuscarCarpetas(Hijo);
        NodeLS retirado = null;
        NodeLS actual = getFirtsList();
        if (actual.getContadorHijo() == Temp.getContadorPadre()) {
            retirado = actual;
            setFirtsList(getFirtsList().getNextNode());
        } else {
            while (actual.getNextNode() != null) {
                if (actual.getNextNode().getContadorHijo() == Temp.getContadorPadre()) {
                    retirado = actual.getNextNode();
                    actual.setNextNode(retirado.getNextNode());
                    break;
                }
                actual = actual.getNextNode();
            }
        }
    }

    public boolean ModifcarNombre(String NombreViejo, String NombreNuevo) {
        NodeLS Temp = BuscarCarpetas(NombreViejo);
        if (Temp != null) {
            if (!Existe(NombreNuevo)) {
                Temp.setNameDir(NombreNuevo);
                return true;
            } else {
                System.out.println("Ya hay Carpetas o Archivos con ese nombre");
            }
        } else {
            System.out.println("No Encontro para modificar");
        }
        return false;
    }

    public boolean Existe(String Nuevo) {
        NodeLS Temp = getFirtsList();
        if (Temp != null) {
            while (Temp != null) {
                if (Temp.getNameDir().equals(Nuevo)) {
                    return true;
                }
                Temp = Temp.getNextNode();
            }
        } else {
            System.out.println("No hay Carpetas");
        }
        return false;
    }

    public boolean EliminarPrimero(String NombreCarpeta) {
        NodeLS Aux = getFirtsList();
        if (Aux != null) {
            if (Aux.getNameDir().equals(NombreCarpeta)) {
                return true;
            }
        }
        return false;
    }

    public void Limpiar() {
        setFirtsList(null);
        setEndList(null);
    }

    public void Imprimir() {
        NodeLS Aux = getFirtsList();
        while (Aux != null) {
            System.out.println("Nombre Carpeta:" + Aux.getNameDir() + " Padre:" + Aux.getNombrePadre() + " Contador Hijo" + Aux.getContadorHijo());
            Aux = Aux.getNextNode();
        }
    }

    public String getDot(String Name) {
        NodeLS actual = getFirtsList();
        String dot = "";
        if (actual != null) {
            dot = "subgraph cluster_" + Name + "{ \n";
            while (actual != null) {
                dot += "node" + Name + actual.getNameDir() + "[label=\"" + actual.getNameDir() + "\"];\n";
                dot += "nodeC" + Name + "->" + "node" + Name + actual.getNameDir() + ";";
                actual = actual.getNextNode();
            }//fin while
            dot += "}";
        }

        return dot;
    }

    public String DotPrimer() {
        NodeLS Temp = getFirtsList();
        String dot = "";
        if (Temp != null) {
            dot = "node_" + Temp.getNameDir();
        }
        return dot;
    }

    public boolean AgregarAVLLSimple(String NombreCarpeta, String NombreArchivo, String Contenido) {
        NodeLS Aux = BuscarCarpetas(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTree().InsertarArchivo(NombreArchivo, Contenido);
            return true;
        }
        return false;
    }

    public boolean ModificarContenido(String NombreCarpeta, String NombreArchivo, String ContenidoNuevo) {
        NodeLS Aux = BuscarCarpetas(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTree().ModificarContenido(NombreArchivo, ContenidoNuevo);
            return true;
        }
        return false;
    }

    public boolean GraficarAVL(String NombreCarpeta) {
        NodeLS Aux = BuscarCarpetas(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTree().SentGraphAVL();
            return true;
        }
        return false;
    }

    public boolean DescargarArchivo(String NombreCarpeta, String Nombre) {
        NodeLS Aux = BuscarCarpetas(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTree().DescargarArchivo(Nombre);
            return true;
        }
        return false;

    }

    /*   public NodeLS RecorrerNodos(){
        NodeLS Temp = getFirtsList();
        if (Temp != null){
            if (ContadorTemporal == 0){
                Temporal = Temp;
                ContadorTemporal = 1;
                return Temporal;
            }else if (Temporal == null){
                Temporal = Temp.getNextNode();
                return Temporal;
            }
            NodeLS Aux = BuscarSiguiente(Temporal);
            Temp = Aux;
            
        }
    
    }*/
    public NodeLS BuscarSiguiente(NodeLS Node) {
        NodeLS Aux = getFirtsList();
        while (Aux != null && Aux != Node) {
            Aux = Aux.getNextNode();
        }
        return Aux.getNextNode();
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
     * @return the CPadre
     */
    public String getCPadre() {
        return CPadre;
    }

    /**
     * @param CPadre the CPadre to set
     */
    public void setCPadre(String CPadre) {
        this.CPadre = CPadre;
    }
}
