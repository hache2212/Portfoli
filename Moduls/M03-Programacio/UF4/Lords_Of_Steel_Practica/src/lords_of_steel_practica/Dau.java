/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lords_of_steel_practica;

/**
 *
 * @author hugo2
 */
public class Dau {

    private int cares;

    public Dau(int cares) {
        this.cares = cares;
    }

    public int tiradaDaus() {
        return (int) (Math.random() * cares) + 1;
    }
}
