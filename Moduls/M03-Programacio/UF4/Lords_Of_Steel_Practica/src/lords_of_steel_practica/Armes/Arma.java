/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lords_of_steel_practica.Armes;

/**
 *
 * @author hugo2
 */
public class Arma {

    private String nom;
    private int wpow;
    private int wvel;
    
    public Arma(String nom,int wpow,int wvel) {
        this.nom  = nom;
        this.wpow = wpow;
        this.wvel = wvel;
    }

    public String getNom() {
        return nom;
    }

    public int getWpow() {
        return wpow;
    }

    public int getWvel() {
        return wvel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setWpow(int wpow) {
        this.wpow = wpow;
    }

    public void setWvel(int wvel) {
        this.wvel = wvel;
    }
    
    
}


