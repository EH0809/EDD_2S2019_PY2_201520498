/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.py2_201520498;

import Structures.AVL.AVL;
import Structures.AVL.AVL2;
import Structures.HashTable.HashTable;
import edd.py2_201520498.User;
import Structures.GraphDir.LSimple;
import Structures.HashTable.HashTable2;
import Structures.Matrix.Matrix;
import static edd.py2_201520498.Central.Table;
import edd.py2_201520498.Win.AdminWin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import edd.py2_201520498.Win.Login_User;
import Structures.GraphDir.LLSimple;
import Structures.Pila.Pila;
import edd.py2_201520498.Win.Bitacora;
import edd.py2_201520498.Win.VentanaPrincipal;

/**
 *
 * @author herre
 */
public class EDDPY2_201520498 {

    public static HashTable2 Table = new HashTable2(7);
    public static Pila Pilaaaaa = new Pila();
    public static int ContadorCarga = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Bitacora bita = new Bitacora();
        Login_User a = new Login_User();
        //bita.setVisible(true);
        a.setVisible(true);
        //Matrix();
    }

    public String MostarBitacora() {
        return Pilaaaaa.Imprimir2();
    }

    public void InsertardesdeHash(String Name, String Descripcion) {
        Pilaaaaa.InsertaraPila(Name, Descripcion);

    }

    public void RegistroAdmin(String Name, String Descripcion) {
        Pilaaaaa.InsertaraPila(Name, Descripcion);
    }

    public boolean Buscar(String Name, String Pass) {
        if (Table.LoginUser(Name, Pass)) {
            Pilaaaaa.InsertaraPila(Name, "Ha Iniciado Sesion");
            return true;
        }
        return false;
    }

    public boolean AgregarNuevoUsuario(String Name, String Pass, String Time) {
        if (Table.VerificardorPass(new User(Name, Pass, Time))) {
            Pilaaaaa.InsertaraPila(Name, "Agregar un Nuevo Usuario");
            return true;
        } else {

        }
        return false;
    }

    public boolean AgregarCarpetaNueva(String Name, String NombreCarpeta) {
        if (Table.AgregarCarpetaNueva(Name, NombreCarpeta)) {
            Pilaaaaa.InsertaraPila(Name, "Se Agrego una Nueva Carpeta " + NombreCarpeta);
            if (Table.AgregarCarpetaARaiz(Name, NombreCarpeta)) {

                System.out.println("Si se Agrego a Matriz a Raiz");
            }

            return true;
        }
        return false;
    }

    public boolean AgrearEnOtra(String Name, String CarpetaPadre, String CarpertaNueva) {
        if (Table.AgregarCarpetaEnOtra(Name, CarpetaPadre, CarpertaNueva)) {
            Pilaaaaa.InsertaraPila(Name, "Se Agrego una Carpeta En una ya existente");
            if (Table.AgregarCarpetaAOtraCarpeta(Name, CarpetaPadre, CarpertaNueva)) {
                System.out.println("Si se Agrego A Matriz Agregar en Otra");
            }
            return true;
        }
        return false;
    }

    public boolean ModificarNombreCarpetas(String Name, String NombreViejo, String NombreNuevo) {
        if (Table.ModifcarCarpetas(Name, NombreViejo, NombreNuevo)) {
            Pilaaaaa.InsertaraPila(Name, "Se a Modificar el Nombre de la Carpeta " + NombreViejo + " Por " + NombreNuevo);
            return true;
        }
        return false;
    }

    public boolean AgregarArchivosACarpetas(String Name, String NombreCarpeta, String NombreArchivo, String Contenido) {
        if (Table.AgregarAVL(Name, NombreCarpeta, NombreArchivo, Contenido)) {
            Pilaaaaa.InsertaraPila(Name, "Se Agrego un Archivo a la carpeta " + NombreArchivo);
            return true;
        }
        return false;
    }

    public boolean ModificarContenidoArchivos(String Name, String NombreCarpeta, String NombreArchivo, String NuevoContenido) {
        if (Table.ModificarContenidoArchivos(Name, NombreCarpeta, NombreArchivo, NuevoContenido)) {
            Pilaaaaa.InsertaraPila(Name, "Se modifica el contenido del archivo " + NombreArchivo);
            return true;
        }
        return false;
    }

    public void ImprimirTodasLasCarpetas(String Name) {
        Table.ImprimirCarpetas(Name);
        Table.GraficarGrafo(Name);
        Table.GraficarMatriz(Name);
        Table.Graph();
    }

    public void ImprimirAVL(String Name, String NombreCarpeta) {
        if (Table.GraficarAVL(Name, NombreCarpeta)) {
            System.out.println("Si se Imprimr arbol");
        } else {
            System.out.println(" No se Imprime el Arbol");
        }
    }

    public boolean EliminarCarpetarPadre(String Name, String NombrePadre) {
        if (Table.EliminarCarpetasPadre(Name, NombrePadre)) {
            return true;
        }
        return false;

    }

    public boolean EliiminarCarpetasHijas(String Name, String NombrePadre, String NombreHija) {
        if (Table.EliminarCarpetasHijas(Name, NombrePadre, NombreHija)) {
            return true;
        }
        return false;

    }

    public String TraerContenido(String Name, String NombreArchivo){
        return Table.TraerContenido(Name, NombreArchivo);
    }
    
    
    public static void AgregarCarpetaEnCarpeta() {
        LLSimple Lista = new LLSimple();
        Lista.AgregarLista("Documentos");
        Lista.AgregarDentrodeLista("Documentos", "Musica");
        Lista.AgregarDentrodeLista("Musica", "Metallica");
        Lista.AgregarLista("Proyectos");
        Lista.AgregarDentrodeLista("Proyectos", "EDD");
        Lista.AgregarDentrodeLista("Metallica", "Fade to black");
        Lista.AgregarDentrodeLista("EDD", "P1");
        Lista.AgregarDentrodeLista("Documentos", "Imagenes");
        Lista.AgregarDentrodeLista("Metallica", "One");
        Lista.Imprimir();
        System.out.println("Despues");
        Lista.Eliminar("Documentos");
        Lista.EliminarTodasLasCarpetas("Proyectos", "EDD");
        Lista.Imprimir();

    }

    public static void aVLL() {
        AVL2 a = new AVL2();
        a.InsertarArchivo("Hola.txt", "CarePija");
        a.InsertarArchivo("Carro.h", "CarePija");
        a.InsertarArchivo("Carro.cpp", "CarePija");
        a.InsertarArchivo("Nose.exe", "CarePija");
        a.InsertarArchivo("Mec.txt", "CarePija");
        a.InsertarArchivo("Mari.mp3", "CarePija");
        a.InsertarArchivo("Al.txt", "CarePija");
        a.InOrder();
        //a.ModificarNombre("Maricon.mp3","NuevoMaricon.mp3");
        //a.InOrder();
        // a.EliminarArchivos("Mecago.txt");
        // a.InOrder();
        a.SentGraphAVL();

    }

    public void Graphdir() {

    }

    public static void Matrix() {
        Matrix M = new Matrix();
        M.AddMatrizSoloPadres("Doc");
        M.AddMatrix("Doc", "Usac");
        M.AddMatrix("Doc", "EDD");
        M.GraphMatrix();

    }

    public boolean Compartir(String Name2) {
        if (Table.VerificarUsuarioCompartir(Name2)) {
            System.out.println("Se Encontro Usuario "+Name2);
            return true;
        }
        return false;
    }

    public boolean VerificarSiExisteArchivo(String Name, String NombreArchivo) {
        if (Table.VerificarArchivo(Name, NombreArchivo)) {
            System.out.println("Si existe el Archivo "+NombreArchivo);
            return true;
        }
        return false;
    }

    public void EnviarHas(String Name, String Pass, String Time) {
        if (Table.VerificardorPass(new User(Name, Pass, Time))) {
            ContadorCarga++;
            Pilaaaaa.InsertaraPila(Name, "Se Ha agreagado " + Name);
        } else {
            Pilaaaaa.InsertaraPila(Name, "No se Ha podido Ingresar a " + Name);
        }
    }

    public int EnviarContadorCargar() {
        return ContadorCarga;
    }

    public boolean DescargarArchivo(String Name, String NombreCarpeta, String NombreArchivo) {
        if (Table.DescargarArchivo(Name, NombreCarpeta, NombreArchivo)) {
            Pilaaaaa.InsertaraPila(Name, "Se descarga " + NombreArchivo);
            return true;
        } else {
            Pilaaaaa.InsertaraPila(Name, "No se ha podido descarga " + NombreArchivo);
        }

        return false;
    }

    public void GraphTable() {
        this.Table.Graph();
    }

    public void AddNewUser(String Name, String Pass, String Time) {
        Table.VerificardorPass(new User(Name, Pass, Time));
        Pilaaaaa.InsertaraPila(Name, "Se agrego un nuevo Usuario");
    }

    public static void ab() throws IOException {
        Read();
    }

    public static void Read() throws FileNotFoundException, IOException {

        File file = new File("C:\\Users\\herre\\OneDrive\\Documentos\\NetBeansProjects\\EDD 2S 2019\\[EDD]PY2_201520498\\Carga.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String a = "";
        Scanner sc = new Scanner(file);
        while ((st = br.readLine()) != null) {
            a += st + "\n";
        }
        //System.out.println(a);
        CompletarRead(a);
    }

    public static void CompletarRead(String archivo) {
        String[] fila = archivo.split("\n");
        String[] Pi;
        String Usuario, Pass;
        for (int i = 0; i < fila.length; i++) {
            Pi = fila[i].split(";");
            Usuario = Pi[0];
            Pass = Pi[1];
            if (!Usuario.equalsIgnoreCase("Usuario") && !Pass.equalsIgnoreCase("Password")) {
                Table.InsertarUser(new User(Usuario, Pass, "0"));
                System.out.println("Usuario:" + Usuario);
            }
        }

    }
}
