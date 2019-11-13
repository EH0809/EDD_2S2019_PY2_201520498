package edd.py2_201520498;

import edd.py2_201520498.Sha256;
import Structures.GraphDir.LSimple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author herre
 */
public class User {

    private Sha256 En;
    private int Id;
    private String User;
    private String Password;
    private String PasswordSha;
    private int Groove;
    private String TimeUser;
    private LSimple GrafoDirigido;

    public User(String User, String Password, String TimeUser) {
        this.Id = toAscci(User);
        this.User = User;
        this.PasswordSha = Encriptacion(Password);
        this.Password = Password;
        this.TimeUser = TimeUser;
        //this.GrafoDirigido = new LSimple(User);
    }

    private String Encriptacion(String Pass) {
        En = new Sha256();
        return En.SHa(Pass);
    }

    private static int toAscci(String palabra) {
        int valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            valor += (int) caracter;
        }//fin for
        return valor;
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
     * @return the User
     */
    public String getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(String User) {
        this.User = User;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Groove
     */
    public int getGroove() {
        return Groove;
    }

    /**
     * @param Groove the Groove to set
     */
    public void setGroove(int Groove) {
        this.Groove = Groove;
    }

    /**
     * @return the TimeUser
     */
    public String getTimeUser() {
        return TimeUser;
    }

    /**
     * @param TimeUser the TimeUser to set
     */
    public void setTimeUser(String TimeUser) {
        this.TimeUser = TimeUser;
    }

    /**
     * @return the PasswordSha
     */
    public String getPasswordSha() {
        return PasswordSha;
    }

    /**
     * @param PasswordSha the PasswordSha to set
     */
    public void setPasswordSha(String PasswordSha) {
        this.PasswordSha = PasswordSha;
    }

    /**
     * @return the GrafoDirigido
     */
    public LSimple getGrafoDirigido() {
        return GrafoDirigido;
    }

    /**
     * @param GrafoDirigido the GrafoDirigido to set
     */
    public void setGrafoDirigido(LSimple GrafoDirigido) {
        this.GrafoDirigido = GrafoDirigido;
    }

}
