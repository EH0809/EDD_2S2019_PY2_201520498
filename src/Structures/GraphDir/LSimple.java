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

    private NodeLS FirstList;
    private int Lengh;

    public LSimple() {
        this.FirstList = null;
        this.Lengh = 0;
    }

    public boolean IsEmpy() {
        return FirstList == null;
    }

    public int GetLengh() {
        return Lengh;
    }

    public void AddList(String Name) {
        NodeLS New_Node = new NodeLS();
        New_Node.setNameDir(Name);
        if (IsEmpy()) {
            FirstList = New_Node;
        } else {
            NodeLS Aux = FirstList;
            while (Aux.getNextNode() != null) {
                Aux = Aux.getNextNode();
            }
            Aux.setNextNode(New_Node);
        }
        Lengh++;
    }
    
    public void AddReference(String PDir, String Dir){
        NodeLS New_Node = new NodeLS();
        New_Node.setNameDir(Dir);
        if (!IsEmpy()){
            if (SearhNode(PDir)){
                NodeLS Temp = FirstList;
                while(!Temp.getNameDir().equalsIgnoreCase(PDir)){
                    Temp = Temp.getNextNode();
                }
                NodeLS Aux = Temp.getNextNode();
                Temp.setNextNode(New_Node);
                New_Node.setNextNode(Aux);
                Lengh++; 
            }
        }
    }

    public boolean SearhNode(String Aux) {
        NodeLS Temp = FirstList;
        boolean Encontrado = false;
        while (Temp != null && Encontrado != true) {
            if (Temp.getNameDir().equalsIgnoreCase(Aux)) {
                Encontrado = true;
            }
            Temp = Temp.getNextNode();
        }
        return Encontrado;
    }
    
    public void ModifyNode(String New_Dir, String Old_Dir){
        if(SearhNode(Old_Dir)){
            NodeLS Temp = FirstList;
            while(Temp.getNameDir().equalsIgnoreCase(Old_Dir)){
                Temp = Temp.getNextNode();
            }
            Temp.setNameDir(New_Dir);
        }
    }
    
    public void DeleteNode(String Dir){
        
        if(SearhNode(Dir)){
            if (FirstList.getNameDir().equalsIgnoreCase(Dir)){
                FirstList = FirstList.getNextNode();
            }else{
                NodeLS Aux = FirstList;
                while(Aux.getNextNode().getNameDir() != Dir){
                    Aux = Aux.getNextNode();
                }
                NodeLS Aux2 = Aux.getNextNode().getNextNode();
                Aux.setNextNode(Aux2);
            }
        }
        Lengh--;
        
    }

    public void Mostar(){
        if (!IsEmpy()){
            NodeLS Temp = FirstList;
            while(Temp != null){
                System.out.println("[ " + Temp.getNameDir() + " ]" + " ->  ");
                Temp = Temp.getNextNode();
            }
        }
    }
}
