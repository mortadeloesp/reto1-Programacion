import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAjedrez {
    public static void main(String[] args) {

        System.out.println("Bienvenido al programa de Ajedrez Interactivo");
        System.out.println("En este programa, puedes seleccionar una pieza de ajedrez, definir su color y posición inicial en el tablero.");
        System.out.println("La casilla donde se encuentra tu pieza seleccionada se iluminará en azul.");
        System.out.println("Las casillas a las que puede moverse se iluminarán en verde.");
        System.out.println("Debajo del tablero, también se mostrarán las posibles posiciones de movimiento en formato (e.g., a1, c4, etc.).");


        char[][] tablero = Ajedrez.crearTablero();
        Pieza miPieza = introducirPieza();
        int[][] prueba = new int[1][1];
        switch(miPieza.getTipo()){
            case 'R':
                prueba = miPieza.movimientoRey();
                break;
            case 'A':
                prueba = miPieza.movimientoAlfil();
                break;
            case 'T':
                prueba = miPieza.movimientoTorre();
                break;
            case 'P':
                prueba = miPieza.movimientoPeon();
                break;
            case 'D':
                prueba = miPieza.movimientoDama();
                break;
            case 'C':
                prueba = miPieza.movimientoCaballo();
                break;
        }
        char[][] codificado = codificar(prueba);
        System.out.println("Tu pieza está en la posición " + codificarColumnaInt(miPieza.getPosJ()) + codificarFilaInt(miPieza.getPosI()));
        Ajedrez.modificarTablero(tablero, prueba, miPieza.getPosI(), miPieza.getPosJ());
        Ajedrez.imprimirTablero(tablero, miPieza.getTipo(), miPieza.isColor());
        Ajedrez.imprimirMovimientos(codificado);
    }
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la pieza (Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R)): ");
        char pieza = Character.toUpperCase(scan.next().charAt(0));
        System.out.println("Introduce el color (Blanco (0), Negro (1)): ");
        int tonalidad = scan.nextInt();
        boolean color;
        if (tonalidad == 0) {
            color = false;
        } else {
            color = true;
        }
        System.out.println("Introduce la posición inicial: ");*/

    public static boolean finaljuego() {
        Scanner scan = new Scanner(System.in);

        boolean continuar = true;

            do {
                // Preguntar al usuario si quiere continuar o cambiar de pieza
                System.out.println("¿Quieres continuar con la misma pieza y seleccionar una nueva posición (1), o cambiar de pieza (2)?");
                System.out.print("Selecciona una opción (1/2): ");
                int opcion = scan.nextInt();

                if (opcion == 1) {
                    System.out.println("Continuarás con la misma pieza. Selecciona una nueva posición para moverla.");
                    // Lógica para seleccionar una nueva posición
                } else if (opcion == 2) {
                    System.out.println("Selecciona una nueva pieza para continuar.");
                    // Reiniciar ciclo para elegir nueva pieza
                } else {
                    System.out.println("Opción inválida. El programa se cerrará.");
                    continuar = false;
                }

            }while(continuar);

            System.out.println("Gracias por jugar al Ajedrez Interactivo. ¡Hasta la próxima!");

        return continuar;
    }



    public static Pieza introducirPieza() {
        Scanner scan = new Scanner(System.in);
        Pieza nuevaPieza = new Pieza();
        boolean tipoValido = false;
        boolean colorValido = false;
        boolean filaValida = false;
        boolean columnaValida = false;
        boolean primera = true;
        boolean continuar = true;



        // Tipo
        do {
            System.out.println("Elige: Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R): ");
            String nombrePieza = scan.next();
            if (nombrePieza.length() != 1) { // Comprobamos que solamente se ha introducido una letra
                System.out.println("Longitud errónea");
            } else {
                char tipo = Character.toUpperCase(nombrePieza.charAt(0));
                if (tipo == 'T' || tipo == 'P' || tipo == 'A' || tipo == 'D' || tipo == 'R' || tipo == 'C') {
                    nuevaPieza.setTipo(tipo);
                    tipoValido = true;
                } else {
                    System.out.println("Tipo no válido, vuelva a intentarlo.");
                }
            }
        } while (!tipoValido);

        // Color
        do {
            try {
                System.out.println("Elige: Blanco (0) o Negro (1): ");
                int tonalidad = scan.nextInt();
                scan.nextLine();

                if (tonalidad == 0) { //Blanco
                    nuevaPieza.setColor(false);
                    colorValido = true;
                } else if (tonalidad == 1) { //Negro
                    nuevaPieza.setColor(true);
                    colorValido = true;
                } else {
                    throw new Exception("Error, valor no considerado (Introduce 1 o 0)");
                }
            } catch (InputMismatchException noBoolean) {
                System.out.println("Introduce un valor numérico (1 o 0)");
                scan.nextLine();
            } catch (Exception noConsiderado) {
                System.out.println(noConsiderado.getMessage());
            }
        } while (!colorValido);

        // Posición
        do {
            // Columna
            System.out.print("Columna (letra de la A a la H): ");
            String letraColumna = scan.next();
            if (letraColumna.length() != 1) {
                System.out.println("Longitud errónea");
            }
            else {
                char columna = Character.toUpperCase(letraColumna.charAt(0));
                int columnaNumerica = codificarColumnaChar(columna);
                if (columnaNumerica >= 1 && columnaNumerica <= 8) {
                    nuevaPieza.setPosJ(columnaNumerica);
                    columnaValida = true;
                } else {
                    System.out.println("Error, dato incorrecto");
                }
            }
        }while (!columnaValida);

        // Fila
        do{
            System.out.print("Fila (número del 1 al 8): ");
            String numeroFila = scan.next();
            if (numeroFila.length() != 1) {
                System.out.println("Longitud errónea");
            } else {
                char fila = numeroFila.charAt(0);
                int filaNumerica = codificarFilaChar(fila);
                if (nuevaPieza.getTipo()=='P' && nuevaPieza.isColor() && filaNumerica == 1){
                    System.out.println("Posición errónea");
                }
                if (nuevaPieza.getTipo()=='P' && !nuevaPieza.isColor() && filaNumerica == 8){
                    System.out.println("Posición errónea");
                }
                else if (filaNumerica >= 1 && filaNumerica <= 8) {
                    nuevaPieza.setPosI(filaNumerica);
                    filaValida = true;
                } else {
                    System.out.println("Error, dato incorrecto");
                }
            }

        } while (!filaValida);
        //primera = false;
        return nuevaPieza;
    }



    public static char[][] codificar(int[][] posibilidades) {
        char[][] codificado = new char[posibilidades.length][2]; // Siempre 2 columnas: letra y número

        for (int i = 0; i < posibilidades.length; i++) {
            int fila = posibilidades[i][0];
            int columna = posibilidades[i][1];

            codificado[i][0] = codificarFilaInt(fila); // Columna como letra
            codificado[i][1] = codificarColumnaInt(columna);     // Fila como número
        }
        return codificado;
    }

    public static char codificarColumnaInt(int posJ) {
        char letra = ' ';
        switch (posJ) {
            case 1:
                letra = 'A';
                break;
            case 2:
                letra = 'B';
                break;
            case 3:
                letra = 'C';
                break;
            case 4:
                letra = 'D';
                break;
            case 5:
                letra = 'E';
                break;
            case 6:
                letra = 'F';
                break;
            case 7:
                letra = 'G';
                break;
            case 8:
                letra = 'H';
                break;
        }
        return letra;
    }

    public static char codificarFilaInt(int posI) {
        char numero = ' ';
        switch (posI) {
            case 1:
                numero = '8';
                break;
            case 2:
                numero = '7';
                break;
            case 3:
                numero = '6';
                break;
            case 4:
                numero = '5';
                break;
            case 5:
                numero = '4';
                break;
            case 6:
                numero = '3';
                break;
            case 7:
                numero = '2';
                break;
            case 8:
                numero = '1';
                break;
        }
        return numero;
    }

    public static int codificarColumnaChar(char letra) {
        int posicion = 0;
        switch (letra) {
            case 'A':
                posicion = 1;
                break;
            case 'B':
                posicion = 2;
                break;
            case 'C':
                posicion = 3;
                break;
            case 'D':
                posicion = 4;
                break;
            case 'E':
                posicion = 5;
                break;
            case 'F':
                posicion = 6;
                break;
            case 'G':
                posicion = 7;
                break;
            case 'H':
                posicion = 8;
                break;
        }
        return posicion;
    }

    public static int codificarFilaChar(char numero) {
        int posicion = 0;
        switch (numero) {
            case '1':
                posicion = 8;
                break;
            case '2':
                posicion = 7;
                break;
            case '3':
                posicion = 6;
                break;
            case '4':
                posicion = 5;
                break;
            case '5':
                posicion = 4;
                break;
            case '6':
                posicion = 3;
                break;
            case '7':
                posicion = 2;
                break;
            case '8':
                posicion = 1;
                break;
        }
        return posicion;
    }
}