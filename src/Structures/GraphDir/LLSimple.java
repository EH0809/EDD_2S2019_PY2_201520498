/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.GraphDir;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        this.Contador = 1;
    }

    public NodeLLS CreateNode(String Name) {
        NodeLLS nuevo = new NodeLLS(Name, getContador());
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
        setContador(getContador() + 1);
    }

    public void AgregarDentrodeLista(String CarpetaAnterior, String NuevaCarpeta) {
        NodeLLS Aux = BuscarCabecera(CarpetaAnterior);
        if (Aux != null) {
            Aux.getPunteroLS().InsertarNodeoListaS(NuevaCarpeta, Aux.getName(), Aux.getGrupo());
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(CarpetaAnterior);
            if (Temp != null) {
                Temp.getPunteroLS().InsertarNodeoListaS(NuevaCarpeta, CarpetaAnterior, Temp.getPunteroLS().getContadorPadre());

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
        if (Temp != null) {
            while (Temp != null) {
                System.out.println("CPadre:" + Temp.getName() + " Grupo: " + Temp.getGrupo());
                System.out.println("CHijas");
                Temp.getPunteroLS().Imprimir();
                Temp = Temp.getSiguienteLSS();
            }
        } else {
            System.out.println(" No Se ha ingreado Datos");
        }

    }

    public boolean EliminarTodasLasCarpetas(String CarpetaPadre, String CarpetaHija) {
        NodeLLS Aux = BuscarCabecera(CarpetaPadre);
        if (Aux != null) {
            Aux.getPunteroLS().remover(CarpetaHija);
            Aux.getPunteroLS().Limpiar();
            return true;
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(CarpetaPadre);
            if (Temp != null) {
                if (Temp.getPunteroLS().EliminarPrimero(CarpetaHija)) {
                    Temp.getPunteroLS().Limpiar();
                    return true;
                }
            } else {
                System.out.println("No se Encontro");
            }
        }
        return false;
    }

    public boolean Modificar(String NombreViejo, String NombreNuevo) {
        NodeLLS Aux = BuscarCabecera(NombreViejo);
        if (Aux != null) {
            Aux.setName(NombreNuevo);
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(NombreViejo);
            if (Temp.getPunteroLS().ModifcarNombre(NombreViejo, NombreNuevo)) {
                return true;
            }
        }
        return false;
    }

    public boolean EliminarDeCarpetas(String NombrePadre, String NombreCarpeta) {
        NodeLLS Temp = BuscarCabecera(NombrePadre);
        if (Temp != null) {
            Temp.getPunteroLS().remover(NombreCarpeta);
            return true;

        } else {
            System.out.println("No es el primero de la lista");
        }
        return false;
    }

    public boolean CompartirLLista(String Name) {
        NodeLLS Temp = BuscarCabecera(Name);
        if (Temp != null) {
            Temp.getAvlTreeLLS().BuscarArchivo(Name);
            return true;

        } else {
            System.out.println("No es el primero de la lista");
        }
        return false;

    }

    public boolean ComparirLSimple(String NombreArchivo) {
        NodeLLS Temp = BuscarCarpetasHijas(NombreArchivo);
        if (Temp != null) {
            Temp.getPunteroLS().Buscar(NombreArchivo);
            return true;

        } else {
            System.out.println("No es el primero de la lista");
        }
        return false;
    }

    public String TrerContenido(String NombreArchivo) {
        NodeLLS Temp = BuscarCarpetasHijas(NombreArchivo);
        if (Temp != null) {
            return Temp.getPunteroLS().ArchivoCompartir(NombreArchivo);

        } else {
            System.out.println("No es el primero de la lista");
        }
        return "";
    }

    public boolean EliminarDentrodeCarpetas(String CarpetaPadre, String CarpetaHijo) {
        if (EliminarTodasLasCarpetas(CarpetaPadre, CarpetaHijo)) {
            NodeLLS Aux = BuscarCabecera(CarpetaPadre);
            if (Aux != null) {
                Aux.getPunteroLS().remover(CarpetaHijo);
                return true;
            } else {
                NodeLLS Temp = BuscarCarpetasHijas(CarpetaPadre);
                if (Temp != null) {
                    Temp.getPunteroLS().remover(CarpetaHijo);
                    return true;

                } else {
                    System.out.println("No es el primero de la lista");
                }
            }
        } else {
            System.out.println("No es primera");
            return false;
        }
        return false;
    }

    public void GraficarLista() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("GrafoDirigido.dot");
            pw = new PrintWriter(fichero);
            pw.println(Dot());

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
            String cmd = "dot -Tjpg GrafoDirigido.dot -o GrafoDirigido.jpg";
            Runtime.getRuntime().exec(cmd);
            //String cmd2 = "TableHash.jpg"; 
            //Runtime.getRuntime().exec(cmd2);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public String Dot() {
        String dot = "";
        String Completo = "digraph GrafoDirigido{ \nnode[shape=record]; \n";
        String Rank = "{rank=same ";
        NodeLLS Aux = getFirstList();
        int conta = 0;
        if (Aux != null) {
            if (Aux != null) {
                while (Aux != null) {
                    Completo += "nodeC" + Aux.getName() + "[label=\"" + Aux.getName() + "\"];\n";
                    if (conta == 0) {
                        String a = "P";
                        Completo += "node1 [label=\"" + a + "\"]; \n";
                        Rank += "nodel;";
                        conta = 1;
                    }
                    dot += "node1 -> " + "nodeC" + Aux.getName() + ";\n";
                    Rank += Aux.getName() + ";";
                    Completo += Aux.getPunteroLS().getDot(Aux.getName());
                    Aux = Aux.getSiguienteLSS();
                }
            }

        }
        dot += "}";
        Rank += "}";

        Completo += dot;
        Completo += Rank;
        return Completo;
    }

    public boolean Eliminar(String Name) {
        NodeLLS retirado = null;
        NodeLLS actual = getFirstList();
        if (actual.getName().equals(Name)) {
            retirado = actual;
            setFirstList(getFirstList().getSiguienteLSS());
            return true;
        } else {
            while (actual.getSiguienteLSS() != null) {
                if (actual.getSiguienteLSS().getName().equalsIgnoreCase(Name)) {
                    retirado = actual.getSiguienteLSS();
                    actual.setSiguienteLSS(retirado.getSiguienteLSS());

                    return true;
                }
                actual = actual.getSiguienteLSS();
            }
        }
        return false;
    }

    public boolean AgregarAVLLLSimple(String NombreCarpeta, String NombreArchivo, String Contenido) {
        NodeLLS Aux = BuscarCabecera(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTreeLLS().InsertarArchivo(NombreArchivo, Contenido);
            return true;
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(NombreCarpeta);
            if (Temp != null) {
                Temp.getPunteroLS().AgregarAVLLSimple(NombreCarpeta, NombreArchivo, Contenido);
                return true;
            } else {
                System.out.println("No se Encontro");
            }

        }
        return false;
    }

    public boolean ModificarALVArchivo(String NombreCarpeta, String NombreArchivo, String NuevoContenido) {
        NodeLLS Aux = BuscarCabecera(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTreeLLS().ModificarContenido(NombreArchivo, NuevoContenido);
            return true;
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(NombreCarpeta);
            if (Temp != null) {
                Temp.getPunteroLS().ModificarContenido(NombreCarpeta, NombreArchivo, NuevoContenido);
                return true;
            } else {
                System.out.println("No se Encontro");
            }

        }
        return false;
    }

    public boolean GraficarArbol(String NombreCarepta) {
        NodeLLS Aux = BuscarCabecera(NombreCarepta);
        if (Aux != null) {
            Aux.getAvlTreeLLS().SentGraphAVL();
            return true;
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(NombreCarepta);
            if (Temp != null) {
                Temp.getPunteroLS().GraficarAVL(NombreCarepta);
                return true;
            } else {
                System.out.println("No se Encontro");
            }

        }
        return false;
    }

    public boolean DescargarArchivo(String NombreCarpeta, String Nombre) {
        NodeLLS Aux = BuscarCabecera(NombreCarpeta);
        if (Aux != null) {
            Aux.getAvlTreeLLS().DescargarArchivo(Nombre);
            return true;
        } else {
            NodeLLS Temp = BuscarCarpetasHijas(NombreCarpeta);
            if (Temp != null) {
                Temp.getPunteroLS().DescargarArchivo(NombreCarpeta, Nombre);
                return true;
            } else {
                System.out.println("No se Encontro");
            }

        }
        return false;
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
