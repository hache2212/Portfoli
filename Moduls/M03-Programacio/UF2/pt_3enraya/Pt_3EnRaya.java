/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pt_3enraya;
import java.util.Scanner;
/**
 *
 * @author hugo2
 */
public class Pt_3EnRaya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sortir = false;
        boolean instruccionesMostradas = false;
        do {
            if (!instruccionesMostradas) {
                instrucciones3EnRaya();
                instruccionesMostradas = true;
            }
            char[][] tablero3enRaya = new char[3][3];
            String comienzo = sc.next().toLowerCase();
            switch (comienzo) {
                case "start":
                    creacionTablero(tablero3enRaya);
                    muestraTablero(tablero3enRaya);
                    boolean ganador = false;
                    do {
                        System.out.println("Jugador 1, te toca:");
                        movimientoJugador1(tablero3enRaya);
                        muestraTablero(tablero3enRaya);
                        ganador = comprobarGanador('O', tablero3enRaya);
                        if (ganador == true) {
                            System.out.println("El jugador 1 ha ganado!");
                            break;
                        }
                        ganador = empate(tablero3enRaya);
                        if (ganador == false) {
                            System.out.println("Empate :0");
                            break;
                        }

                        System.out.println("Jugador 2, te toca:");
                        movimientoJugador2(tablero3enRaya);
                        muestraTablero(tablero3enRaya);
                        ganador = comprobarGanador('X', tablero3enRaya);
                        if (ganador == true) {
                            System.out.println("El jugador 2 ha ganado!");
                            break;
                        }
                    } while (true);

                    // Preguntar si se desea jugar otra vez una vez terminada la partida, se sale del bucle do-while del que esta dentro del case
                    System.out.println("¿Quieres jugar otra vez? (S/N)");
                    String respuesta = sc.next().toUpperCase();
                    if (respuesta.equals("S")) {
                        System.out.print("Escriba start: ");
                        sortir = false;
                        instruccionesMostradas = true; // para q no vuelva a salir el mensaje de bienvenida
                    } else {
                        sortir = true;
                        System.out.println("Gracias por jugar!");
                    }
                    break;
                case "exit":
                    sortir = true;
                    System.out.println("Nos vemos pronto!");
                    break;
                default:
                    System.out.println("Incorrecto");
                    break;
            }
        } while (!sortir);
    }


        public static void instrucciones3EnRaya(){
            
            System.out.println("Benvenido al 3 en raya.");
            System.out.println("A continuación te mostrare una pequeña expliacion de como se juega.");
            System.out.println("Cada jugador tendrá o las X's o las O's.");
            System.out.print("En su turno debe poner una, intentando conseguir");
            System.out.println(" 3 seguidas, en vertical, horizontal o diagonal.");
            System.out.println("El tablero es el siguiente:");
            muestraInsTablero3enRaya(new int[3][3]);
            System.out.println("Empecemos! (start/exit)");
        }
        
        public static void muestraInsTablero3enRaya(int[][] tablero3enRaya) {
            //Esta funcion mostrara un tablero como con el q se jugara (ponemos un contador para q dentro de las celdas
            //cada vez q se haga el bucle salga el numero correspondiente de cada celda
            int contador = 1;
            for (int fila = 0; fila < 3; fila++) {
                for (int columna = 0; columna < 3; columna++) {
                tablero3enRaya[fila][columna] = '_';
                }
            }
            for (int fila = 0; fila < 3; fila++) {
            System.out.print("| ");
                for (int columna = 0; columna < 3; columna++) {
                    tablero3enRaya[fila][columna] = contador;
                    System.out.print(tablero3enRaya[fila][columna] + " | ");
                    contador++;
                }
            System.out.println();
            }
        }
        
        public static void creacionTablero(char[][] tablero3enRaya) {
            for (int fila = 0; fila < tablero3enRaya.length; fila++) {
                for (int columna = 0; columna < tablero3enRaya.length; columna++) {
                tablero3enRaya[fila][columna] = '-';
                }
            }
        }
        
        public static void muestraTablero(char[][] tablero3enRaya) {
            for (int fila = 0; fila < tablero3enRaya.length; fila++) {
                System.out.print("| ");
                for (int columna = 0; columna < tablero3enRaya.length; columna++) {
                    System.out.print(tablero3enRaya[fila][columna] + " | ");
                }
            System.out.println( );
            }
        }
        
        public static void movimientoJugador1(char[][] tablero3enRaya) {
            Scanner sc = new Scanner(System.in);
            int fila, columna;
            do {
                do {
                    System.out.print("Elige la fila: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrada inválida. Debe ser un número entre 1 y 3.");
                        sc.next(); // descarta entrada no numérica
                    }
                    fila = sc.nextInt();
                        if (fila < 1 || fila > 3) {
                            System.out.println("Fila fuera de rango. Debe ser un número entre 1 y 3.");
                            continue;
                        }
                  //if (fila>=1 && fila<=3)seria lo mismo que este do-while (es mas facil de leer con un if)
                  //pero es lo mismo este do hara todo lo de adentro si se cumple con la condicion de abajo
                } while (fila < 1 || fila > 3);
                fila--;
                //ponemos fila-- para que en vez de poner un 0
                //para el jugador sea mas facil y tenga q poner 1, 2 o 3

                do {
                    System.out.print("Elige la columna: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrada inválida. Debe ser un número entre 1 y 3.");
                        sc.next(); // descartar entrada no numérica
                    }
                    columna = sc.nextInt();
                        if (columna < 1 || columna > 3) {
                            System.out.println("Columna fuera de rango. Debe ser un número entre 1 y 3.");
                            continue;
                        }
                } while (columna < 1 || columna > 3);
                columna--;
            } while (tablero3enRaya[fila][columna] != '-');
                tablero3enRaya[fila][columna] = 'O';
        }
        
        public static void movimientoJugador2(char[][] tablero3enRaya) {
        Scanner sc = new Scanner(System.in);
        int fila, columna;
            do {
                do {
                    System.out.print("Elige la fila: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrada inválida. Debe ser un número entre 1 y 3.");
                        sc.next();
                    }
                    fila = sc.nextInt();
                        if (fila < 1 || fila > 3) {
                            System.out.println("Fila fuera de rango. Debe ser un número entre 1 y 3.");
                            continue;
                        }
                } while (fila < 1 || fila > 3);
                fila--;

                do {
                    System.out.print("Elige la columna: ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Entrada no válida. Debe ser un número entre 1 y 3.");
                            sc.next();
                        }
                    columna = sc.nextInt();
                        if (columna < 1 || columna > 3) {
                            System.out.println("Columna fuera de rango. Debe ser un número entre 1 y 3.");
                            continue;
                        }
                } while (columna < 1 || columna > 3);
                columna--;
            } while (tablero3enRaya[fila][columna] != '-');
                tablero3enRaya[fila][columna] = 'X';
        }
        
        public static boolean comprobarGanador(char jugador, char[][] tablero3enRaya ) {
            //Comprobacion para las filas cada if recorera su respectiva fila/columna/diagonal
            //si se cumple retornara el valor como de true, y tendremos un ganador
            if (tablero3enRaya[0][0] == jugador && tablero3enRaya[0][1] == jugador && tablero3enRaya[0][2] == jugador) {
                return true;
            }
            else if (tablero3enRaya[1][0] == jugador && tablero3enRaya[1][1] == jugador && tablero3enRaya[1][2] == jugador) {
                return true;
            }
            else if (tablero3enRaya[2][0] == jugador && tablero3enRaya[2][1] == jugador && tablero3enRaya[2][2] == jugador) {
                return true;
            }
            //Comprobacion columnas
            else if (tablero3enRaya[0][0] == jugador && tablero3enRaya[1][0] == jugador && tablero3enRaya[2][0] == jugador) {
                return true;
            }
            else if (tablero3enRaya[0][1] == jugador && tablero3enRaya[1][1] == jugador && tablero3enRaya[2][1] == jugador) {
                return true;
            }
            else if (tablero3enRaya[0][2] == jugador && tablero3enRaya[1][2] == jugador && tablero3enRaya[2][2] == jugador) {
                return true;
            }
            //Comprobacion de las dos diagonales
            else if (tablero3enRaya[0][0] == jugador && tablero3enRaya[1][1] == jugador && tablero3enRaya[2][2] == jugador) {
                return true;
            }
            else if (tablero3enRaya[0][2] == jugador && tablero3enRaya[1][1] == jugador && tablero3enRaya[2][0] == jugador) {
                return true;
            }
            else {
                return false;
            }
        }
        
        public static boolean empate(char[][] tablero3enRaya) {
            //antes de terminar el juego busca si hay una celda vacia en caso de que la encuentre seguira
            // si no la encuntra returnara un false, en 'ganador' por lo tanto habra empate
            for (int fila = 0; fila < tablero3enRaya.length; fila++) {
                for (int columna = 0; columna < tablero3enRaya.length; columna++) {
                    if ( tablero3enRaya[fila][columna] == '-') {
                        return true; 
                    }
                }
            }
            return false;
        }

    
              
}