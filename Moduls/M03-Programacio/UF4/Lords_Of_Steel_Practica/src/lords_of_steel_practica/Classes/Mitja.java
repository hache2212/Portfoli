/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lords_of_steel_practica.Classes;

import lords_of_steel_practica.Personatges;
import lords_of_steel_practica.Armes.Arma;

/**
 *
 * @author hugo2
 */
public class Mitja extends Personatges {
    
    public Mitja(String nom,String categ,int forca,int cons,int vel,int inte,int sort, Arma armas, int lvl,int exp) {
        super(nom,categ,forca,cons,vel,inte,sort,armas,lvl,exp);
    }

    public void calculaStatsSec() {
        ps = getCons() + getForça();
        pd = (getForça() + getArma().getWpow()) / 4;
        pa = getInte() + getSort() + getArma().getWvel();
        pe = getVel() + getSort() + getInte();
    }
}
