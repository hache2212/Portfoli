/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lords_of_steel_practica;

import lords_of_steel_practica.Armes.Arma;
import lords_of_steel_practica.Classes.Categories;
import lords_of_steel_practica.Classes.Huma;
import lords_of_steel_practica.Classes.Maia;
import lords_of_steel_practica.Classes.Mitja;
import lords_of_steel_practica.Classes.Nan;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author hugo2
 */
public class LordsOfSteel {
    
    private static ArrayList<Personatges> personatges;
    private static ArrayList<Arma> armas;
    private static ArrayList<Categories> categoria;
    private int[] niveles = {100, 200, 500, 1000, 2000};
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String args[]) {
        
        LordsOfSteel juego = new LordsOfSteel();
        juego.jugar();
    }
    
    public LordsOfSteel() {

        armas = new ArrayList();
        categoria = new ArrayList();
        armas.add(0, new Arma("Daga", 5, 15));
        armas.add(1, new Arma("Espasa", 10, 10));
        armas.add(2, new Arma("Martell de combat", 15, 5));
        personatges = new ArrayList();
        categoria.add( new Categories("Huma"));
        categoria.add( new Categories("Nan"));
        categoria.add( new Categories("Mitja"));
        categoria.add( new Categories("Maia"));
        
    }
    
    public void jugar(){
        boolean sortir = false;
        System.out.println("Benvingut a Lords of Steel.");
        System.out.println("Que vols fer?");
        System.out.println("1 - Afegir personatge");
        System.out.println("2 - Esborrar personatge");
        System.out.println("3 - Editar personatge");
        System.out.println("4 - Iniciar combat");
        System.out.println("5 - Sortir");
        
        do {
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    crearPersonatge();
                    System.out.println("");
                    jugar();
                    break;
                case 2:
                    eliminarPersonatge();
                    System.out.println("");
                    jugar();
                    break;
                case 3:
                    modificarPersonatge();
                    System.out.println("");
                    jugar();
                    break;
                case 4:
                    lluita();
                    System.out.println("");
                    jugar();
                    break;
                case 5:
                    System.out.println("Nos vemos pronto!");
                    sortir = true;
                    break;
                default:
                    System.out.println("Escoge un numero entre los valores.");
                    break;
            }
        } while (!sortir);
    }
    
    public static void crearPersonatge() {
        
        int puntos = 60;
        
        // Verificar el número máximo de puntos
        if (puntos < 0) {
            System.out.println("Error: no es poden assignar més de 60 punts.");
            return;
        }

        System.out.println("Introdueix el nom d'un personatge: ");
        String nom = sc.nextLine();

        System.out.println("Escriu la classe del personatge: ");
        if (categoria == null) {
            categoria = new ArrayList<>();
        }
        for (int i = 0; i < categoria.size(); i++) {
            System.out.println("- " + categoria.get(i).getNom());
        }
        String classe = sc.nextLine();

        System.out.println("Introdueix el numero de l'arma del personatge: ");
        System.out.println(" 0. " + armas.get(0).getNom() + "\n 1. " + armas.get(1).getNom() + "\n 2. " + armas.get(2).getNom());
        int arma = sc.nextInt();

        System.out.println("Força del personatge [3-18]");
        int forca = sc.nextInt();
        if (forca < 3 || forca > 18) {
            System.out.println("Error: la força ha d'estar entre 3 i 18.");
            return;
        }
        puntos -= forca;

        System.out.println("Constitució del personatge [3-18]");
        int constitucio = sc.nextInt();
        if (constitucio < 3 || constitucio > 18) {
            System.out.println("Error: la constitució ha d'estar entre 3 i 18.");
            return;
        }
        puntos = -constitucio;

        System.out.println("Velocitat del personatge [3-18]");
        int velocitat = sc.nextInt();
        if (velocitat < 3 || velocitat > 18) {
            System.out.println("Error: la velocitat ha d'estar entre 3 i 18.");
            return;
        }
        puntos = -velocitat;

        System.out.println("Intel·ligència del personatge [3-" + (puntos) + "]");
        int intelligencia = sc.nextInt();
        if (intelligencia < 3 || intelligencia > 18) {
            System.out.println("Error: la intel·ligència ha d'estar entre 3 i 18.");
            return;
        }
        puntos = -intelligencia;

        System.out.println("Sort del personatge [3-" + (puntos) + "]");
        int sort = sc.nextInt();
        if (sort < 3 || sort > 18) {
            System.out.println("Error: la sort ha d'estar entre 3 i 18.");
            return;
        }
        puntos = -sort;

        int exp = 0, lvl = 0;
        Personatges personatge = null;
        switch (classe) {
            case "Huma":
                personatge = new Huma(nom, classe, forca, constitucio, velocitat,intelligencia, sort, armas.get(arma), lvl, exp);
                break;
            case "Maia":
                personatge = new Maia(nom, classe, forca, constitucio, velocitat,intelligencia, sort, armas.get(arma), lvl, exp);
                break;
            case "Mitja":
                personatge = new Mitja(nom, classe, forca, constitucio, velocitat,intelligencia, sort, armas.get(arma), lvl, exp);
                break;
            case "Nan":
                personatge = new Nan(nom, classe, forca, constitucio, velocitat,intelligencia, sort, armas.get(arma), lvl, exp);
                break;
        }
        System.out.println("");
        System.out.println("    Els STATS de " + personatge.getNom());
        System.out.println("Classe --> " + personatge.getCateg());
        System.out.println("Arma --> " + personatge.armas.getNom());
        System.out.println("Força --> " + personatge.getForça());
        System.out.println("Constitució --> " + personatge.getCons());
        System.out.println("Velocitat --> " + personatge.getVel());
        System.out.println("Intel·ligència --> " + personatge.getInte());
        System.out.println("Sort --> " + personatge.getSort());

        personatges.add(personatge);
        
    }
    
    public static void lluita() {
        System.out.println("");
        Dau dau1 = new Dau(25);
        Dau dau2 = new Dau(25);
        Dau dau3 = new Dau(25);
        int valor = dau1.tiradaDaus() + dau2.tiradaDaus() + dau3.tiradaDaus();
        System.out.println("Valor tirada: " + valor);

        System.out.println("Tria el teu personatge...");
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println(i + " " + personatges.get(i).getNom());
        }

        System.out.println("-->");
        int personaje = sc.nextInt();
        System.out.println("El personatge " + personatges.get(personaje).getNom() + " lluitará vs ...");
        Personatges atacante = personatges.remove(personaje);

        for (int i = 0; i < personatges.size(); i++) {
            System.out.println(i + " " + personatges.get(i).getNom());
        }

        int enemigo = sc.nextInt();
        System.out.println("L'enemic será " + personatges.get(enemigo).getNom());
        Personatges defensor = personatges.remove(enemigo);
        
        while (defensor.getPs() > 0) {
            if (atacante.getVel() >= defensor.getVel()) {
                if (atacante.ataca(dau1, dau2, dau3)) {
                    System.out.println(atacante.getNom() + " Ha atacado");
                    if (!defensor.esquiva(dau1, dau2, dau3)) {
                        defensor.dañado(atacante);
                        System.out.println(defensor.getNom() + " No ha esquivat, ha rebut el cop --> " + atacante.getPd());
                        int PuntoSalud = defensor.getPs();
                        System.out.println("Punts de vida restants --> " + PuntoSalud);
                    } else {
                        System.out.println(defensor.getNom() + "Ha esquivat. No ha rebut el cop!");
                        int PuntoSalud = defensor.getPs();
                        System.out.println("Punts de vida restatants  --> " + PuntoSalud);
                    }
                } else {
                    System.out.println("L'atac no ha tingut exit");
                }

            }
            if (defensor.getPs() <= 0) {
                System.out.println("Has mort " + defensor.getNom() + " --> " + defensor.getPs() + " de salut");
            } else {
                Personatges cambio = atacante;
                atacante = defensor;
                defensor = cambio;
            }
        }
        System.out.println("El victorios d'aquesta lluita és... " + atacante.getNom()+ "!");

        System.out.println("El perdedor ha sigut " + defensor.getNom()+" :/ ");
        personatges.add(atacante);
        personatges.add(defensor);

        atacante.ResetVida();
        defensor.ResetVida();
        atacante.experienciaSubida(defensor.getPs());
        
    }
    
    public static void eliminarPersonatge() {
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println(i + " " + personatges.get(i).getNom());
        }
        System.out.println("Numero del personatge que vols eliminar?");
        int nom = sc.nextInt();

        System.out.println("Has eliminat a " + personatges.get(nom).getNom());
        personatges.remove(personatges.get(nom));  
    }
    
    public static void modificarPersonatge() {
        int puntos = 60;
        for (int i = 0; i < personatges.size(); i++) {
            Personatges avatar = personatges.get(i);
            System.out.println(i + " " + avatar.getNom());
        }
        System.out.println("Introdueix el numero del personatge que vols modificar:");
        int personaje = sc.nextInt();

        System.out.println("Introdueix el nom d'un personatge: ");
        String nom = sc.nextLine();
        personatges.get(personaje).setNom(nom);

        System.out.println("Introdueix la classe del personatge: ");
        for (int i = 0; i < categoria.size(); i++) {
            System.out.println("- " + categoria.get(i).getNom());
        }
        String classe = sc.nextLine();
        personatges.get(personaje).setCateg(classe);

        System.out.println("Introdueix l'arma del personatge: ");
        System.out.println(" 0. " + armas.get(0).getNom() + "\n 1. " + armas.get(1).getNom() + "\n 2. " + armas.get(2).getNom());
        int armes = sc.nextInt();
        armas.get(armes).setNom(nom);

        System.out.println("     NOUS STATS:     ");
        System.out.println("Força del personatge --> [3-18] ");
        int força = sc.nextInt();
        personatges.get(personaje).setForça(força);
        puntos = -força;
        
        
        System.out.println("Constitucio del personatge --> [3-18] ");
        int constitucio = sc.nextInt();
        personatges.get(personaje).setCons(constitucio);
        puntos = -constitucio;
        

        System.out.println("Velocitat del personatge --> [3-18] ");
        int velocitat = sc.nextInt();
        personatges.get(personaje).setVel(velocitat);
        puntos = -velocitat;


        System.out.println("Intel·ligencia del personatge --> [3-" + (puntos) + "]");
        int intelligencia = sc.nextInt();
        personatges.get(personaje).setInte(intelligencia);
        puntos = -intelligencia;


        System.out.println("Sort del personatge --> [3-" + (puntos) + "]");
        int sort = sc.nextInt();
        personatges.get(personaje).setSort(sort);
        puntos = -sort;
    }
}
