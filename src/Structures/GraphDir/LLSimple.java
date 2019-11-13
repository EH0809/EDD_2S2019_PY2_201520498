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
public class LLSimple {

    private NodeLLS FirstList;
    private NodeLLS EndList;
    private String NameFolder;
    private int Contador;

    public LLSimple() {
        this.FirstList = null;
        this.EndList = null;
    }

    public NodeLLS CreateNode(String Name) {
        NodeLLS nuevo = new NodeLLS(Name);
        return nuevo;
    }

    public boolean Vacia() {
        return FirstList == null;
    }

    public void AgregarLista(String Name) {
        NodeLLS Nuevo = CreateNode(Name);
        if (Vacia()) {
            FirstList = Nuevo;
            EndList = Nuevo;
        } else {
            EndList.setSiguienteLSS(Nuevo);
            setEndList(Nuevo);

        }
    }

    public void AgregarDentrodeLista(String CarpetaAnterior, String NuevaCarpeta) {
        NodeLLS Aux = BuscarCabecera(CarpetaAnterior);
        if (Aux != null) {
            Aux.getPunteroLS().InsertarNodeoListaS(NuevaCarpeta);
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(CarpetaAnterior);
            if (Temp != null) {
                Temp.getPunteroLS().InsertarNodeoListaS(NuevaCarpeta);

            } else {
                System.out.println("No se Encontro");
            }
        }
    }

    public NodeLLS BuscarCarpetasHijas(String Name) {
        NodeLLS Temp = getFirstList();
        while (Temp != null) {
            if (Temp.getPunteroLS().Buscar(Name)) {
                return Temp;
            }
            Temp = Temp.getSiguienteLSS();
        }
        return null;
    }

    public NodeLLS BuscarCabecera(String Name) {
        NodeLLS Temp = getFirstList();
        while (Temp != null) {
            if (Temp.getName().equals(Name)) {
                return Temp;
            }
            Temp = Temp.getSiguienteLSS();
        }
        return null;
    }

    public void Imprimir() {
        NodeLLS Temp = getFirstList();
        while (Temp != null) {
            System.out.println("CPadre:" + Temp.getName());
            System.out.println("CHijas");
            Temp.getPunteroLS().Imprimir();
            Temp = Temp.getSiguienteLSS();
        }

    }

    public void EliminarDentrodeCarpetas(String CarpetaPadre, String CarpetaHijo) {
        NodeLLS Aux = BuscarCabecera(CarpetaPadre);
        if (Aux != null) {
            Aux.getPunteroLS().remover(CarpetaHijo);
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(CarpetaPadre);
            if (Temp != null) {
                Temp.getPunteroLS().remover(CarpetaHijo);

            } else {
                System.out.println("No se Encontro");
            }
        }

    }

    public NodeLLS Eliminar(String Name) {
        NodeLLS retirado = null;
        NodeLLS actual = getFirstList();
        if (actual.getName().equals(Name)) {
            retirado = actual;
            setFirstList(getFirstList().getSiguienteLSS());
        } else {
            while (actual.getSiguienteLSS() != null) {
                if (actual.getSiguienteLSS().getName() == Name) {
                    retirado = actual.getSiguienteLSS();
                    actual.setSiguienteLSS(retirado.getSiguienteLSS());
                    break;
                }
                actual = actual.getSiguienteLSS();
            }
        }
        return retirado;
    }

    /**
     * @return the FirstList
     */
    public NodeLLS getFirstList() {
        return FirstList;
    }

    /**
     * @param FirstList the FirstList to set
     */
    public void setFirstList(NodeLLS FirstList) {
        this.FirstList = FirstList;
    }

    /**
     * @return the EndList
     */
    public NodeLLS getEndList() {
        return EndList;
    }

    /**
     * @param EndList the EndList to set
     */
    public void setEndList(NodeLLS EndList) {
        this.EndList = EndList;
    }

    /**
     * @return the NameFolder
     */
    public String getNameFolder() {
        return NameFolder;
    }

    /**
     * @param NameFolder the NameFolder to set
     */
    public void setNameFolder(String NameFolder) {
        this.NameFolder = NameFolder;
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
