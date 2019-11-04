/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.py2_201520498;

import Structures.AVL.AVL;
import Structures.HashTable.HashTable;
import edd.py2_201520498.User;
import Structures.GraphDir.LSimple;
import Structures.HashTable.HashTable2;
import Structures.Matrix.Matrix;
import static edd.py2_201520498.Central.Table;
import edd.py2_201520498.Win.AdminWin;

/**
 *
 * @author herre
 */
public class EDDPY2_201520498 {

    public static HashTable2 Table = new HashTable2(7);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AdminWin a = new AdminWin();
        a.setVisible(true);

    }

    public void aVL() {
        AVL a = new AVL();
        a.SentInsert("Edgar", "CarePija");
        a.SentInsert("Sopa", "CarePija");
        a.SentInsert("De", "CarePija");
        a.SentInsert("Macaco", "CarePija");
        System.out.println("PreOrder");
        a.PreOrder();
        System.out.println("InOrder");
        a.InOrder();
        //System.out.println("Eliminar");
        //a.SendDelete("De");
        System.out.println("Se Agrego Pepe");
        a.SentInsert("Pepe", "Hueco");
        a.Modify("Edgar", "puto amo");
        a.PreOrder();
        System.out.println("Eliminado");
        a.SendDelete("Pepe");
        a.PreOrder();
        a.ModifyName("Edgar", "Adriana");
        a.PreOrder();

    }

    public static void HashTTT() {
        HashTable Table = new HashTable(7);
        Table.InsertHash2(new User("Edgar", "1", "asdf"));
        Table.InsertHash2(new User("Mario", "2", "asdf"));
        Table.InsertHash2(new User("Adriana", "3", "asdf"));
        Table.InsertHash2(new User("Sofia", "4", "asdf"));
        //Table.SearchTable("Sofia", "4");
        //Table.Imprimir();
        //Table.Graph();

    }

    public static void Hash2() {
        HashTable2 T = new HashTable2(7);
        T.VerificardorPass(new User("Edgar", "12345", "a"));
        T.VerificardorPass(new User("Mario", "1234567", "a"));
        T.VerificardorPass(new User("Galindo", "12345678", "a"));
        T.VerificardorPass(new User("Rojo", "12345", "a"));
        T.VerificardorPass(new User("Creama", "12345", "a"));
        T.VerificardorPass(new User("a", "12345", "12345"));
        T.VerificardorPass(new User("b", "12345", "12345"));
        T.VerificardorPass(new User("c", "12345678", "12345678"));
        T.Imprimir();
        T.Bus("Creamaa");
        T.Graph();

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

}
