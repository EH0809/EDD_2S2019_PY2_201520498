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
/**
 *
 * @author herre
 */
public class EDDPY2_201520498 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
        HashTTT();
        Graphdir();

    }
    
    public void aVL(){
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
        a.Modify("Edgar","puto amo");
        a.PreOrder();
        System.out.println("Eliminado");
        a.SendDelete("Pepe");
        a.PreOrder();
        a.ModifyName("Edgar","Adriana");
        a.PreOrder();
        
    }
    
    public static void HashTTT(){
        HashTable Table = new HashTable(7);
        Table.InsertHash(new User("Edgar", "1", "asdf"));
        Table.InsertHash(new User("Mario", "2", "asdf"));
        Table.InsertHash(new User("Adrina", "3", "asdf"));
        Table.InsertHash(new User("Sofia", "4", "asdf"));
        Table.InsertHash(new User("Maria", "5", "asdf"));
        Table.InsertHash(new User("Mariaaa", "6", "asdf"));
        Table.InsertHash(new User("M", "7", "asdf"));
        Table.InsertHash(new User("Mariad", "8", "asdf"));     
        //Table.Imprimir();
    
    }
    
    public static void Graphdir(){
        LSimple L = new LSimple();
        L.AddList("/");
        L.AddList("Documentos");
        L.AddList("Musica");
        L.AddList("Edgar");
        L.AddReference("/", "LALA");
        L.Mostar();
    
    }
}
