/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.py2_201520498;

import Structures.HashTable.HashTable2;

/**
 *
 * @author herre
 */
public class Central {
    public static HashTable2 Table = new HashTable2(7);

    public Central() {
       
    }
    
    public void EnviarHas(String Name, String Pass, String Time){
        Table.VerificardorPass(new User(Name, Pass, Time));
    }
    
    public void GraphTable(){
        this.Table.Imprimir();
        this.Table.Graph();
    }
    
    public void AddNewUser(String Name, String Pass, String Time){
        this.Table.VerificardorPass(new User(Name, Pass, Time));
        this.Table.Graph();
    }
    
    
    
     
     
    
}
