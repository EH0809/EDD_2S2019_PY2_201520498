/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.AVL;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import com.sun.jmx.snmp.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author herre
 */
public class NodeAVL {

    private int Id;
    private int Height;
    private int FE;
    private String Name;
    private String Description;
    private String TimeStamp;
    private NodeAVL SonRight;
    private NodeAVL SonLeft;
    private NodeAVL Parent;
    //public Usuarios Usuario;

    public NodeAVL(String Name, String Description) {
        this.Id = toAscci(Name);
        this.Height = 1;
        this.FE = 0;
        this.Name = Name;
        this.Description = Description;
        this.TimeStamp = Time();
        this.SonRight = null;
        this.SonLeft = null;
        this.Parent = null;
    }

    private int toAscci(String palabra) {
        int valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            valor += (int) caracter;
        }//fin for
        return valor;
    }
    
    private String Time(){
    //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp());
    String timeStamp = "hoy";
    return  timeStamp;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Height
     */
    public int getHeight() {
        return Height;
    }

    /**
     * @param Height the Height to set
     */
    public void setHeight(int Height) {
        this.Height = Height;
    }

    /**
     * @return the FE
     */
    public int getFE() {
        return FE;
    }

    /**
     * @param FE the FE to set
     */
    public void setFE(int FE) {
        this.FE = FE;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the TimeStamp
     */
    public String getTimeStamp() {
        return TimeStamp;
    }

    /**
     * @param TimeStamp the TimeStamp to set
     */
    public void setTimeStamp(String TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    /**
     * @return the SonRight
     */
    public NodeAVL getSonRight() {
        return SonRight;
    }

    /**
     * @param SonRight the SonRight to set
     */
    public void setSonRight(NodeAVL SonRight) {
        this.SonRight = SonRight;
    }

    /**
     * @return the SonLeft
     */
    public NodeAVL getSonLeft() {
        return SonLeft;
    }

    /**
     * @param SonLeft the SonLeft to set
     */
    public void setSonLeft(NodeAVL SonLeft) {
        this.SonLeft = SonLeft;
    }

    /**
     * @return the Parent
     */
    public NodeAVL getParent() {
        return Parent;
    }

    /**
     * @param Parent the Parent to set
     */
    public void setParent(NodeAVL Parent) {
        this.Parent = Parent;
    }

}
