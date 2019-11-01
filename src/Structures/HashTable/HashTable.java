/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.HashTable;


import edd.py2_201520498.User;

/**
 *
 * @author herre
 */
public class HashTable {

    private User HashT[];
    private int LengthHash;
    private int IntersectionsHash;

    public HashTable(int LengthHash) {
        this.LengthHash = LengthHash;
        this.IntersectionsHash = 0;
        this.HashT = new User[this.LengthHash];
    }

    private boolean IsEmpty() {
        for (int i = 0; i < getHashT().length; i++) {
            if (getHashT()[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public void InsertHash2(User User){
        //int IndiceArreglo = User.getId()% getLengthHash();
        int IndiceArreglo = FHash(User.getId());
        System.out.println("El indice es: "+ IndiceArreglo+ " Para el Elemento: "+ User.getUser());
        while(getHashT()[IndiceArreglo] != null){
            IndiceArreglo++;
            System.out.println("Ocurrio una colision en el Indice: "+ String.valueOf(IndiceArreglo-1));
            IndiceArreglo %=getLengthHash();     
        }
        getHashT()[IndiceArreglo] = User;
        User.setGroove(IndiceArreglo);
        setIntersectionsHash(getIntersectionsHash() + 1);
        VerificarCarga();
        
    
    }

    public void InsertHash(User User) {
        int IndiceArreglo = FHash(User.getId());
        System.out.println("Indice de Arreglo "+ IndiceArreglo +"  Para "+User.getUser());
        int contador = 2;
        while (getHashT()[IndiceArreglo] != null) {
            IndiceArreglo = IndiceArreglo + (contador * contador);
            System.out.println("Colicion se Cambio a indice: "+IndiceArreglo);
            if (IndiceArreglo > getLengthHash()) {
                IndiceArreglo = IndiceArreglo % getLengthHash();
                System.out.println("Muy Grande el Indice Recalculando "+ IndiceArreglo);
            }
            contador++;
        }
        getHashT()[IndiceArreglo] = User;
        User.setGroove(IndiceArreglo-1);
        setIntersectionsHash(getIntersectionsHash() + 1);
        VerificarCarga();
    }

    public void VerificarCarga() {
        double Inserciones = getIntersectionsHash();
        double Tam = getLengthHash();
        double FCarga = Inserciones / Tam;
        if (FCarga > 0.75) {
            ReHash();
        }
    }

    private void ReHash() {
        User OldHash[] = getHashT();
        int ant  = getLengthHash();
        setLengthHash(getLengthHash() * 2);
        setHashT(new User[getLengthHash()]);
        setIntersectionsHash(0);
        System.out.println("Se Rehash en marcha");
        for (int i = 0; i < OldHash.length; i++) {
            if (OldHash[i] != null) {
                System.out.println("Insertando en Nueva Tabla" + OldHash[i].getUser());
                InsertHash(OldHash[i]);
            }
        }
    }

    public int FHash(long Key) {
        int VHash = 0;
        String Temp = String.valueOf(Key);
        int PAux[] = new int[(Temp.length() / TotalNum(getLengthHash())) + 1];
        for (int i = 0; i < PAux.length; i++) {
            PAux[i] = (int) (Key % getDiv());
            Key = Key / getDiv();
        }
        for (int i = 0; i < PAux.length; i++) {
            VHash += PAux[i];
        }
        return VHash % getLengthHash();
    }

    public int TotalNum(int Num) {
        return String.valueOf(Num).length();
    }

    public int getDiv() {
        int Pot = 1;
        for (int i = 0; i < TotalNum(getLengthHash()); i++) {
            Pot *= 7;
        }
        return Pot;
    }

    public String Dot() {
        String Cuadros = "";
        String Enlaces = "";
        String Labels = "";
        String dot = "\nnodesep=.05; \nrankdir=LR; \nnode [shape=record,width=.1,height=.1];\n";
        for (int i = 0; i < getHashT().length; i++) {
            Cuadros += "<f" + i + "> | ";
            if (getHashT()[i] != null) {
                Labels += "node" + i + "[label=\"<n> " + getHashT()[i].getGroove() + " | " + getHashT()[i].getUser() + " | " + getHashT()[i].getPassword() + "|" + getHashT()[i].getTimeUser() + "\"];\n";
                Enlaces += "tabla:f" + i + " -> node" + i + ":n;\n";
            }
        }
        dot += "tabla [label = \"" + Cuadros + "\",height=2.5];\n";
        dot += "node [width = 1.5];\n";
        dot += "\n" + Labels;
        dot += "\n" + Enlaces;
        return dot;
    }

    public void Imprimir() {
        for (int i = 0; i < getHashT().length; i++) {
            if (getHashT()[i] != null) {
                System.out.println("Ranura:" + getHashT()[i].getGroove() + " Name:" + getHashT()[i].getUser());
            }
        }
    }

    /**
     * @return the HashT
     */
    public User[] getHashT() {
        return HashT;
    }

    /**
     * @param HashT the HashT to set
     */
    public void setHashT(User[] HashT) {
        this.HashT = HashT;
    }

    /**
     * @return the LengthHash
     */
    public int getLengthHash() {
        return LengthHash;
    }

    /**
     * @param LengthHash the LengthHash to set
     */
    public void setLengthHash(int LengthHash) {
        this.LengthHash = LengthHash;
    }

    /**
     * @return the IntersectionsHash
     */
    public int getIntersectionsHash() {
        return IntersectionsHash;
    }

    /**
     * @param IntersectionsHash the IntersectionsHash to set
     */
    public void setIntersectionsHash(int IntersectionsHash) {
        this.IntersectionsHash = IntersectionsHash;
    }

}
