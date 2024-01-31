/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lords_of_steel_practica;

import lords_of_steel_practica.Armes.Arma;

/**
 *
 * @author hugo2s
 */
public abstract class Personatges {

    protected String nom;
    protected int força;
    protected int cons;
    protected int vel;
    protected int inte;
    protected int sort;
    protected String categ;

// stats secundaries
    
    protected int ps;
    protected int pd;
    protected int pa;
    protected int pe;
    protected int exp=0;
    protected int lvl=0;

    protected Arma armas;

    public Personatges(String nom, String categ, int força, int cons, int vel, int inte, int sort, Arma armas) {
        this.nom = nom;
        this.categ = categ;
        this.força = força;
        this.cons = cons;
        this.vel = vel;
        this.inte = inte;
        this.sort = sort;
        this.armas = null;
        this.lvl = lvl;
        this.exp = exp;
    }

    public Personatges(String nom, String categ, int força, int cons, int vel, int inte, int sort, Arma armas, int lvl, int exp) {
        this.nom = nom;
        this.categ = categ;
        this.força = força;
        this.cons = cons;
        this.vel = vel;
        this.inte = inte;
        this.sort = sort;
        this.armas = armas;
        this.lvl = lvl;
        this.exp = exp;
        calculaStatsSec();
    }

    public boolean ataca(Dau... dados) {
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tiradaDaus();
        }
        return tirada <= pa;
    }

    public boolean esquiva(Dau... dados) {
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tiradaDaus();
        }
        return tirada <= pe;
    }

    public Arma getArmas() {
        return armas;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getCateg() {
        return categ;
    }

    public void dañado(Personatges atacante) {
        ps -= atacante.getPd();
    }

    public void experienciaSubida(int expObt) {
        if (getLvl() < 5) {
            setExp(getExp() + expObt);
        }
    }

    public void subirNivel() {
        força++;
        cons++;
        vel++;
        inte++;
        sort++;
        lvl++;
        calculaStatsSec();

    }

    public void ResetVida() {
        ps = cons + força;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForça() {
        return força;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    abstract public void calculaStatsSec();

    public Arma getArma() {
        return armas;
    }

    public void setArma(Arma arma) {
        this.armas = arma;
        calculaStatsSec();
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

}
