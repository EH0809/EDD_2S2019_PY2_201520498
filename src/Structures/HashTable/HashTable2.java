/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.HashTable;

import edd.py2_201520498.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Structures.Pila.Pila;

/**
 *
 * @author herre
 */
public class HashTable2 {

    private User TableHash[];
    private int Tamanio;
    private int Insersiones;

    public HashTable2(int Tamanio) {
        this.Tamanio = Tamanio;
        TableHash = new User[this.Tamanio];
        this.Insersiones = 0;
    }

    private boolean isEmpty() {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] != null) {
                return false;
            }
        }
        return true;
    }

    public User BuscarUser(String Name) {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] != null) {
                if (getTableHash()[i].getUser().equalsIgnoreCase(Name)) {
                    return getTableHash()[i];
                }
            }
        }
        return null;
    }

    public boolean LoginUser(String Name, String Pass) {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] != null) {
                if (getTableHash()[i].getUser().equals(Name) && getTableHash()[i].getPasswordSha().equals(Pass)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean EliminarUser(User User) {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] == User) {
                getTableHash()[i] = null;
                setInsersiones(getInsersiones() - 1);
                return true;
            }
        }
        return false;
    }

    public boolean ModificarUser(User NewUser, User OldUser) {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] == OldUser) {
                getTableHash()[i] = NewUser;
                return true;
            }
        }
        return false;
    }

    public void InsertarUser(User User) {
        int indiceArreglo = hash(User.getId());
        int contador = 2;
        while (getTableHash()[indiceArreglo] != null) {
            indiceArreglo = indiceArreglo + (contador * contador);
            if (indiceArreglo >= getTamanio()) {
                indiceArreglo = indiceArreglo % getTamanio();
            }
            contador++;
        }
        getTableHash()[indiceArreglo] = User;
        User.setGroove(indiceArreglo);
        setInsersiones(getInsersiones() + 1);
        VerficarCarga();
    }

    public boolean VerificarUsuario(String Name) {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] != null) {
                if (getTableHash()[i].getUser().equals(Name)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean VerificardorPass(User User) {
        if (!VerificarUsuario(User.getUser()) && VerPass(User.getPassword())) {
            InsertarUser(User);
            return true;
        } else {

            System.out.println("La Contraseña es menos de 8 caracteres o usuario ya ingresado:" + User.getUser());
        }
        return false;
    }

    public boolean VerPass(String Pass) {
        if (Pass.length() >= 8) {
            return true;
        }
        return false;

    }

    public boolean VerrUs(String Us) {
        User Aux = BuscarUser(Us);
        if (Aux.getUser().equals(Us)) {
            return true;
        }
        return false;
    }

    private void VerficarCarga() {
        double Insercion = getInsersiones();
        double Tam = getTamanio();
        double Fac = Insercion / Tam;
        if (Fac > 0.75) {
            ReHash();
        }
    }

    private void ReHash() {
        User New_Table[] = getTableHash();
        //setTamanio(getTamanio() * 2);
        int a = VerPrimo(getTamanio());
        setTamanio(a);
        System.out.println("Valor de la Nueva Tabla " + getTamanio());
        setTableHash(new User[getTamanio()]);
        setInsersiones(0);
        for (int i = 0; i < New_Table.length; i++) {
            if (New_Table[i] != null) {
                InsertarUser(New_Table[i]);
            }
        }
    }

    public int VerPrimo(int Tamanio) {
        int Limite = Tamanio * 2;
        int i = 0;
        for (i = Tamanio + 1; i < Limite; i++) {
            if (NextPrimo(i)) {
                System.out.println("Numero Siguiente Primo " + i);
                return i;
            }
        }
        return 0;
    }

    private boolean NextPrimo(int Tamanio) {
        int contador = 0;
        boolean Aux = false;
        for (int I = 1; I <= Tamanio; I++) {
            if ((Tamanio % I) == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            Aux = true;

        }
        return Aux;
    }

    private int hash(long Id) {
        int valorHash = 0;
        String temp = String.valueOf(Id);
        int plegamiento[] = new int[(temp.length() / getNumeroDigitos(getTamanio())) + 1];
        for (int i = 0; i < plegamiento.length; i++) {
            plegamiento[i] = (int) (Id % getDivisor());
            Id = Id / getDivisor();
        }//fin for
        for (int i = 0; i < plegamiento.length; i++) {
            valorHash += plegamiento[i];
        }//fin for
        return valorHash % getTamanio();
    }

    private int getDivisor() {
        int potencia = 1;
        for (int i = 0; i < getNumeroDigitos(getTamanio()); i++) {
            potencia *= 10;
        }
        return potencia;
    }

    private int getNumeroDigitos(int numero) {
        return String.valueOf(numero).length();
    }

    public void Imprimir() {
        for (int i = 0; i < getTableHash().length; i++) {
            if (getTableHash()[i] != null) {
                System.out.println("Ranura:" + getTableHash()[i].getGroove() + " Name:" + getTableHash()[i].getUser() + " Id:" + getTableHash()[i].getId());
            }
        }
    }

    public void Bus(String Name) {
        User B = BuscarUser(Name);
        if (B == null) {
            System.out.println("No se Encuentra " + Name);
        } else {
            System.out.println("Si se Encuentra " + B.getUser());
        }
    }

    public void Graph() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("TableHash.dot");
            pw = new PrintWriter(fichero);
            String Dot = "";
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
            String cmd = "dot -Tjpg TableHash.dot -o TableHash.jpg";
            Runtime.getRuntime().exec(cmd);
            //String cmd2 = "TableHash.jpg"; 
            //Runtime.getRuntime().exec(cmd2);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public String Dot() {
        String Cuadros = "";
        String Enlaces = "";
        String Labels = "";
        String dot = " digraph TableHash {\nnodesep=.05; \nrankdir=LR; \nnode [shape=record,width=.1,height=.1];\n";
        for (int i = 0; i < getTableHash().length; i++) {
            Cuadros += "<f" + i + "> | ";
            if (getTableHash()[i] != null) {
                Labels += "node" + i + "[label=\"<n> Index: " + getTableHash()[i].getGroove() + " | Name:" + getTableHash()[i].getUser() + " | Password:" + getTableHash()[i].getPassword() + "| Tiime:" + getTableHash()[i].getTimeUser() + "\"];\n";
                Enlaces += "tabla:f" + i + " -> node" + i + ":n;\n";
            }
        }
        dot += "tabla [label = \"" + Cuadros + "\",height=2.5];\n";
        dot += "node [width = 1.5];\n";
        dot += "\n" + Labels;
        dot += "\n" + Enlaces;
        dot += "}";
        return dot;
    }

    //////////////////////////////////////////////////CARPETAS/////////////////////////////////
    public boolean AgregarCarpetaNueva(String Name, String NombreCarpeta) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
//            Usuario.getGrafoDirigido().InsertarNodeoListaS(Usuario.getGrafoDirigido().crearNodo(NombreCarpeta));
            Usuario.getGrafoDirigido().AgregarLista(NombreCarpeta);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean AgregarCarpetaEnOtra(String Name, String CarpetaPadre, String CarpetaNueva) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().AgregarDentrodeLista(CarpetaPadre, CarpetaNueva);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean ModifcarCarpetas(String Name, String NombreViejo, String NombreNuevo) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            if (Usuario.getGrafoDirigido().Modificar(NombreViejo, NombreNuevo)) {
                return true;
            }
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean EliminarCarpetasPadre(String Name, String NombrePadre) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            if (Usuario.getGrafoDirigido().Eliminar(NombrePadre)) {
                return true;
            }
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean EliminarCarpetasHijas(String Name, String NombrePadre, String NombreHija) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            if (Usuario.getGrafoDirigido().EliminarDeCarpetas(NombrePadre, NombreHija)) {
                return true;
            }
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public void ImprimirCarpetas(String Name) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().Imprimir();
        } else {
            System.out.println("No se Encontro usuario");
        }
    }

    public boolean GraficarGrafo(String Name) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().GraficarLista();
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;

    }

    ///////////////////////////////////////////MATRIZ//////////////////////////////////////
    public boolean AgregarCarpetaARaiz(String Name, String NombreCarpeta) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getMatrixAd().AddMatrizSoloPadres(NombreCarpeta);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean AgregarCarpetaAOtraCarpeta(String Name, String CarpetaPadre, String CarpetaHija) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            //Usuario.getMatrixAd().AddMatrizSoloHijos(CarpetaHija);
            Usuario.getMatrixAd().AddMatrix(CarpetaPadre, CarpetaHija);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean VerificarUsuarioCompartir(String Name) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean GraficarMatriz(String Name) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getMatrixAd().GraphMatrix();
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    ///////////////////////////////////////////////AVL////////////////////////////////////
    public boolean AgregarAVL(String Name, String NombreCarpeta, String NombredelArchivo, String Contenido) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().AgregarAVLLLSimple(NombreCarpeta, NombredelArchivo, Contenido);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean VerificarArchivo(String Name, String nombreArchivo) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().ComparirLSimple(nombreArchivo);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;

    }

    public String TraerContenido(String Name, String NombreArchivo) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            return Usuario.getGrafoDirigido().TrerContenido(NombreArchivo);
        } else {
            System.out.println("No encontro usuario");
        }
        return "";

    }

    public boolean ModificarContenidoArchivos(String Name, String NombreCarpeta, String NombreArchivo, String NuevoContenido) {

        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().ModificarALVArchivo(NombreCarpeta, NombreArchivo, NuevoContenido);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;

    }

    public boolean GraficarAVL(String Name, String NombreCarpeta) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().GraficarArbol(NombreCarpeta);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;
    }

    public boolean DescargarArchivo(String Name, String NombreCarepta, String NombreArchivo) {
        User Usuario = BuscarUser(Name);
        if (Usuario != null) {
            Usuario.getGrafoDirigido().DescargarArchivo(NombreCarepta, NombreArchivo);
            return true;
        } else {
            System.out.println("No encontro usuario");
        }
        return false;

    }

    /**
     * @return the TableHash
     */
    public User[] getTableHash() {
        return TableHash;
    }

    /**
     * @param TableHash the TableHash to set
     */
    public void setTableHash(User[] TableHash) {
        this.TableHash = TableHash;
    }

    /**
     * @return the Tamanio
     */
    public int getTamanio() {
        return Tamanio;
    }

    /**
     * @param Tamanio the Tamanio to set
     */
    public void setTamanio(int Tamanio) {
        this.Tamanio = Tamanio;
    }

    /**
     * @return the Insersiones
     */
    public int getInsersiones() {
        return Insersiones;
    }

    /**
     * @param Insersiones the Insersiones to set
     */
    public void setInsersiones(int Insersiones) {
        this.Insersiones = Insersiones;
    }

}
