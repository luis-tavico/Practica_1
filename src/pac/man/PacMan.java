package pac.man;

import java.time.LocalTime;
import java.util.Scanner;

public class PacMan {

    static Scanner entrada = new Scanner(System.in);
    static int opcion; //Guarda la opcion ingresada en el menu principal
    static String tablero[][] = new String[40][15]; //Tablero del juego
    static int puntos = 0; //Guarda la cantidad de puntos acumulados
    static int movimientos = 0; //Guarda la cantidad de movimientos realizados
    static int ultimaFruta = 0; //En esta variable se gurada el valor de la fruta generado aleatoriamente
    static char letra; //En esta variable se guarda el movimiento ingresado por el jugador
    static int x = 20, y = 7; //Posicion inicial del pacman en el tablero
    static String nombreJugador = "";
    static String jugadores[][] = new String[5][5]; //Tablero donde se guarda la informacion de cada jugada
    static int numeroJugador = 0;
    static LocalTime tiempo;//Este Objeto nos da el tiempo actual
    static String time; //Esta variable sirve para convertir el tiempo de objeto a String
    static String hora = ""; //Esta variable guarda la hora en que se inicio el juego y finalizo el juego
    static int numeroX, numeroY; //En estas variables se guarda la posicion de las frutas generadas aleatoriamente
    static boolean juegoTerminado = false; //Guarda el estado del juego
    static String pacman = "C";

    private static void tableroJuego() {
        //Asignando valores al tablero
        for (int j = 0; j < tablero[0].length; j++) {
            for (int i = 0; i < tablero.length; i++) {
                tablero[i][j] = " ";
            }
        }
        //Creando los muros del tablero
        ///////////////////LADO IZQUIERDO//////////////////////////////
        //Primer linea horizontal al lado izquierdo
        tablero[0][3] = "=";
        tablero[1][3] = "=";
        tablero[2][3] = "=";
        //Segunda linea horizontal al lado izquierdo
        tablero[0][8] = "=";
        tablero[1][8] = "=";
        tablero[2][8] = "=";
        tablero[3][8] = "=";
        tablero[4][8] = "=";
        tablero[5][8] = "=";
        //Tercer linea horizontal al lado izquierdo
        tablero[0][11] = "=";
        tablero[1][11] = "=";
        tablero[2][11] = "=";
        tablero[3][11] = "=";
        tablero[4][11] = "=";
        tablero[5][11] = "=";
        tablero[6][11] = "=";
        ///////////////////LADO DERECHO//////////////////////////////
        //Primer linea horizontal al lado derecho
        tablero[30][3] = "=";
        tablero[31][3] = "=";
        tablero[32][3] = "=";
        tablero[33][3] = "=";
        tablero[34][3] = "=";
        tablero[35][3] = "=";
        tablero[36][3] = "=";
        tablero[37][3] = "=";
        tablero[38][3] = "=";
        tablero[39][3] = "=";
        tablero[35][1] = "|";//linea vertical
        tablero[35][2] = "|";//linea vertical
        //Segunda linea horizontal al lado derecho
        tablero[35][8] = "=";
        tablero[36][8] = "=";
        tablero[37][8] = "=";
        tablero[38][8] = "=";
        tablero[39][8] = "=";
        //Tercer linea horizontal al lado derecho
        tablero[35][11] = "=";
        tablero[36][11] = "=";
        tablero[37][11] = "=";
        tablero[38][11] = "=";
        tablero[39][11] = "=";
        ///////////////////LADO INFERIOR//////////////////////////////
        //Primer linea vertical al lado inferior
        tablero[7][13] = "|";
        tablero[7][14] = "|";
        //Segunda linea vertical al lado inferior
        tablero[14][10] = "|";
        tablero[14][11] = "|";
        tablero[14][12] = "|";
        tablero[14][13] = "|";
        tablero[14][14] = "|";
        tablero[12][10] = "=";//linea horizontal lado izquierdo
        tablero[13][10] = "=";//linea horizontal lado izquierdo
        tablero[15][10] = "=";//linea horizontal lado derecho
        tablero[16][10] = "=";//linea horizontal lado derecho
        tablero[17][10] = "=";//linea horizontal lado derecho
        tablero[18][10] = "=";//linea horizontal lado derecho
        tablero[19][10] = "=";//linea horizontal lado derecho
        tablero[20][10] = "=";//linea horizontal lado derecho
        //Tercer linea vertical al lado inferior
        tablero[24][12] = "|";
        tablero[24][13] = "|";
        tablero[24][14] = "|";
        tablero[20][12] = "=";//linea horizontal izquierdo
        tablero[21][12] = "=";//linea horizontal izquierdo
        tablero[22][12] = "=";//linea horizontal izquierdo
        tablero[23][12] = "=";//linea horizontal izquierdo
        //Cuarta linea vertical al lado inferior
        tablero[30][10] = "|";
        tablero[30][11] = "|";
        tablero[30][12] = "|";
        tablero[30][13] = "|";
        tablero[30][14] = "|";
        tablero[31][13] = "=";//linea horizontal derecho
        tablero[32][13] = "=";//linea horizontal derecho
        tablero[33][13] = "=";//linea horizontal derecho
        tablero[34][13] = "=";//linea horizontal derecho
        tablero[35][13] = "=";//linea horizontal derecho
        ///////////////////LADO SUPERIOR//////////////////////////////
        //Primer linea vertical al lado superior
        tablero[7][0] = "|";
        tablero[7][1] = "|";
        //segunda linea vertical de lado superior
        tablero[14][0] = "|";
        tablero[14][1] = "|";
        tablero[14][2] = "|";
        tablero[14][3] = "|";
        tablero[14][4] = "|";
        tablero[15][4] = "=";//linea horizontal derecho
        tablero[16][4] = "=";//linea horizontal derecho
        tablero[17][4] = "=";//linea horizontal derecho
        tablero[18][4] = "=";//linea horizontal derecho
        //Tercer linea vertical al lado superior
        tablero[24][0] = "|";
        tablero[24][1] = "|";
        tablero[24][2] = "|";
        tablero[24][3] = "|";
        tablero[24][4] = "|";
        tablero[24][5] = "|";
        tablero[24][6] = "|";
        tablero[24][7] = "|";
        tablero[18][2] = "=";//linea horizontal izquierda
        tablero[19][2] = "=";//linea horizontal izquierda
        tablero[20][2] = "=";//linea horizontal izquierda
        tablero[21][2] = "=";//linea horizontal izquierda
        tablero[22][2] = "=";//linea horizontal izquierda
        tablero[23][2] = "=";//linea horizontal izquierda
        tablero[25][6] = "=";//linea horizontal derecho
        tablero[26][6] = "=";//linea horizontal derecho
        tablero[27][6] = "=";//linea horizontal derecho
        tablero[28][6] = "=";//linea horizontal derecho
        tablero[29][6] = "=";//linea horizontal derecho
        tablero[30][6] = "=";//linea horizontal derecho
        tablero[31][6] = "=";//linea horizontal derecho
        tablero[32][6] = "=";//linea horizontal derecho
        tablero[33][6] = "=";//linea horizontal derecho
        tablero[33][5] = "|";//linea vertical
        //Cuarta linea vertical al lado superior
        tablero[30][0] = "|";
        ////////////////////CENTRO////////////////////////
        //Primer linea horizontal al centro
        tablero[3][5] = "=";
        tablero[4][5] = "=";
        tablero[5][5] = "=";
        tablero[6][5] = "=";
        tablero[7][5] = "=";
        tablero[8][5] = "=";
        tablero[9][5] = "=";
        tablero[10][5] = "|";//linea vertical superior
        tablero[10][6] = "|";//linea vertical superior
        tablero[10][7] = "|";//linea vertical superior
        tablero[10][7] = "=";
        tablero[11][7] = "=";
        tablero[12][7] = "=";
        tablero[13][7] = "=";
        tablero[14][7] = "=";
        tablero[15][7] = "=";
        tablero[16][7] = "=";
        tablero[17][7] = "=";
        //Poniendo comida en el tablero
        tablero[19][0] = "#";
        tablero[5][1] = "#";
        tablero[32][9] = "#";
        tablero[5][10] = "#";
        tablero[22][13] = "#";
        //Posicion de pacman en el tablero
        tablero[x][y] = pacman;
    }

    public static void nuevoJuego() {
        //Estado del juego actual
        juegoTerminado = false;
        //Tomando el timpo
        tiempo = LocalTime.now();
        //Convirtiendo de objeto a string
        time = String.valueOf(tiempo);
        //Pasando el tiempo a horas y segundos
        for (int i = 0; i < 5; i++) {
            hora += time.charAt(i);
        }
        tableroJuego(); //Creando el tablero para asignar comida, muros y posicion del pacman
        do {
            //Imprimiendo el tablero 
            System.out.println(" ________________________________________");
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print("|");
                for (int i = 0; i < tablero.length; i++) {
                    System.out.print(tablero[i][j]);
                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("|________________________________________|");
            //Impresion de menu de resultados durante el juego
            System.out.println(" ________________________________________ ");
            System.out.println("|>Puntos: " + puntos + "\t" + "                         |");
            System.out.println("|>Movimientos: " + movimientos + "\t" + "                 |");
            System.out.println("|>Ultima fruta: " + ultimaFruta + "\t" + "                 |");
            System.out.println("|________________________________________|");
            //////////////////////////////////////////////
            tablero[x][y] = " ";//Deja en blanco las casillas por las que pasa pacman
            if (puntos < 30) {
                System.out.println("Ingrese una tecla: (W: arriba, S: abajo, A: izquierda, D: derecha, M: salir)");
                letra = entrada.next().charAt(0);
            } else {
                letra = 'm';
            }
            if (letra == 'w') {
                y--;
                if (y < 0) {
                    y = 14;
                }
                if (tablero[x][y].equals(" ")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                } else if (tablero[x][y].equals("#")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                    ultimaFruta = (int) (Math.random() * 5 + 1); //Asigna valor a la fruta
                    puntos += ultimaFruta;
                    posicionComida();
                } else { //entra a esta parte cuando el pacman quiere atraversar un muro
                    y++; //le suma lo que le resto al inicio, asi el pacman sigue en el mismo lugar y no atraviesa el muro
                    tablero[x][y] = pacman; //imprime el pacman de nuevo
                }
            } else if (letra == 's') {
                y++;
                if (y > 14) {
                    y = 0;
                }
                if (tablero[x][y].equals(" ")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                } else if (tablero[x][y].equals("#")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                    ultimaFruta = (int) (Math.random() * 5 + 1);
                    puntos += ultimaFruta;
                    posicionComida();
                } else {
                    y--;
                    tablero[x][y] = pacman;
                }
            } else if (letra == 'a') {
                x--;
                if (x < 0) {
                    x = 39;
                }
                if (tablero[x][y].equals(" ")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                } else if (tablero[x][y].equals("#")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                    ultimaFruta = (int) (Math.random() * 5 + 1);
                    puntos += ultimaFruta;
                    posicionComida();
                } else {
                    x++;
                    tablero[x][y] = pacman;
                }
            } else if (letra == 'd') {
                x++;
                if (x > 39) {
                    x = 0;
                }
                if (tablero[x][y].equals(" ")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                } else if (tablero[x][y].equals("#")) {
                    movimientos++;
                    tablero[x][y] = pacman;
                    ultimaFruta = (int) (Math.random() * 5 + 1);
                    puntos += ultimaFruta;
                    posicionComida();
                } else {
                    x--;
                    tablero[x][y] = pacman;
                }
            } else if (letra == 'm') {
                //Tomando el timpo
                tiempo = LocalTime.now();
                //Convirtiendo de objeto a string
                time = String.valueOf(tiempo);
                //Agregando un signo de separacion 
                hora += "-";
                //Pasando el tiempo a horas y segundos
                for (int i = 0; i < 5; i++) {
                    hora += time.charAt(i);
                }
                //Pidiendo nombre al usuario
                System.out.println("¡Juego Finalizado!");
                System.out.print("Ingrese su nombre: ");
                nombreJugador = entrada.next();
                numeroJugador++;
                //Si el numero de jugador es 6 entonces, se reinicia el conteo y vuelve a ser 1
                if (numeroJugador == 6) {
                    numeroJugador = 1;
                }
                //Asignando valores al tablero de jugadores
                jugadores[0][numeroJugador - 1] = Integer.toString(numeroJugador);
                jugadores[1][numeroJugador - 1] = nombreJugador;
                jugadores[2][numeroJugador - 1] = Integer.toString(puntos);
                jugadores[3][numeroJugador - 1] = Integer.toString(movimientos);
                jugadores[4][numeroJugador - 1] = hora;
                //Reiniciando valores a las variables
                puntos = 0;
                movimientos = 0;
                ultimaFruta = 0;
                hora = "";
                //Poniendo al pacman al centro del tablero
                x = 20;
                y = 7;
                //Actualizando el estado del juego
                juegoTerminado = true;
            } else {
                System.out.println("¡Ingrese una tecla valida!");
                tablero[x][y] = pacman;
            }
        } while (juegoTerminado == false);
    }

    public static void posicionComida() {
        do {
            numeroX = (int) (Math.random() * 39);
            numeroY = (int) (Math.random() * 14);
            //} while (tablero[numeroX][numeroY].equals("\033[31m" + "#" + "\u001B[0m") || tablero[numeroX][numeroY].equals("=") || tablero[numeroX][numeroY].equals("|") || tablero[numeroX][numeroY].equals(pacman));
        } while (!tablero[numeroX][numeroY].equals(" "));
        tablero[numeroX][numeroY] = ("#");
    }

    public static void tableroJugadores() {
        //Asignando valores vacios al tablero de puntuaciones
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                jugadores[i][j] = " ";
            }
        }
    }

    public static void verPuntuaciones() {
        System.out.println(" ________________________________________________________ ");
        System.out.println("|No.| NOMBRE | PUNTEO | No MOVIMIENTOS | MARCA DE TIEMPO |");
        System.out.println("|___|________|________|________________|_________________|");
        for (int j = 0; j < 5; j++) {
            System.out.print("|");
            System.out.printf("%4s %8s %8s %16s %18s", jugadores[0][j] + " |", jugadores[1][j] + " |", jugadores[2][j] + "    |", jugadores[3][j] + "        |", jugadores[4][j] + "   | ");
            System.out.println("");
            System.out.println("|___|________|________|________________|_________________|");
        }
    }

    public static void main(String[] args) {
        //Creando el tablero de puntucaciones de jugadores
        tableroJugadores();
        ///////////////////////////
        do {
            //Menu principal
            System.out.println(" ______________________________");
            System.out.println("|       MENU PRINCIPAL         |");
            System.out.println("|1. Iniciar nuevo juego        |");
            System.out.println("|2. Ver ultimas 5 puntuaciones |");
            System.out.println("|3. Salir                      |");
            System.out.println("|______________________________|");
            System.out.println("Por favor, ingrese el numero de la accion a realizar: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    nuevoJuego();
                    break;
                case 2:
                    verPuntuaciones();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("¡Ingrese un numero valido!");
                    break;
            }
        } while (opcion != 3);
    }
}
