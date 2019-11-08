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

/**
 *
 * @author herre
 */
public class EDDPY2_201520498 {

    public static HashTable2 Table = new HashTable2(7);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        //AdminWin a = new AdminWin();
        //a.setVisible(true);
        //aVLL();
        //Hash2();
       // ab();

    }

    public static void aVLL() {
        AVL2 a = new AVL2();
        a.InsertarArchivo("Hola.txt", "CarePija");
        a.InsertarArchivo("Carro.h", "CarePija");
        a.InsertarArchivo("Carro.cpp", "CarePija");
        a.InsertarArchivo("Hijuputaa.exe", "CarePija");
        a.InsertarArchivo("Mecago.txt", "CarePija");
        a.InsertarArchivo("Maricon.mp3", "CarePija");
        a.InsertarArchivo("Al.txt", "CarePija");
        a.InOrder();
        //a.ModificarNombre("Maricon.mp3","NuevoMaricon.mp3");
        //a.InOrder();
        a.EliminarArchivos("Mecago.txt");
        a.InOrder();
        // a.SentGraphAVL();

    }

    public static void Hash2() {
       /*
         HashTable2 T = new HashTable2(7);
        T.VerificardorPass(new User("Edgar", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("Mario", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("Galindo", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("Rojo", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("Creama", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("a", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("b", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("c", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("d", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("e", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("f", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("g", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("h", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("i", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("j", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("k", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("l", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("g", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("h", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("i", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("j", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("k", "12345asdfasdfasd", "a"));
        T.VerificardorPass(new User("l", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("m", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("n", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("ñ", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("o", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("p", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("q", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("r", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("s", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("t", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("u", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("v", "12345asdfasdfasd", "12345678"));
        T.VerificardorPass(new User("t", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("u", "12345asdfasdfasd", "12345"));
        T.VerificardorPass(new User("v", "12345asdfasdfasd", "12345678"));
        T.Imprimir();
*/
    }

    public static void Graphdir() {
        LSimple L = new LSimple();
        L.AddList("/");
        L.AddList("Documentos");
        L.AddList("Musica");
        L.AddList("Edgar");
        L.AddReference("/", "LALA");
        L.Mostar();

    }

    public static void Matrix() {
        Matrix M = new Matrix();
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                M.AddMatrix(j, i, "Contador" + i, "Contador" + j);
            }
        }
        M.GraphMatrix();

    }

    public void EnviarHas(String Name, String Pass, String Time) {
        Table.VerificardorPass(new User(Name, Pass, Time));
    }

    public void GraphTable() {
        this.Table.Imprimir();
        this.Table.Graph();
    }

    public void AddNewUser(String Name, String Pass, String Time) {
        this.Table.VerificardorPass(new User(Name, Pass, Time));
        this.Table.Graph();
    }

    public static void ab () throws IOException{
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
                System.out.println("Usuario:" +Usuario);
            }
        }
        
      
    }
}
