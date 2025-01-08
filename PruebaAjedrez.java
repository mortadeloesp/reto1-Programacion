import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAjedrez {
    public static void main(String[] args) {
        boolean mover;
        boolean seguirMoviendo = false;
        boolean continuar;
        //AQUI PON LAS COSAS BONITAS//
        do {
            Pieza miPieza = introducirPieza();
        do{
            char[][] tablero = Ajedrez.crearTablero();
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
            //AQUI usa codificado en el metodo pasado por parametro y despues comparalos con == con el scan que hagas para meterlo en el setPos//
            mover = nuevaposicion();
            if (mover) {
                modificarPosicion(miPieza, codificado);
                seguirMoviendo = true;
            }
            else{
                seguirMoviendo = false;
            }
        }while(seguirMoviendo);
        continuar = finaljuego();
        }while(continuar);
    }

    public static Pieza introducirPieza() {
        Scanner scan = new Scanner(System.in);
        Pieza nuevaPieza = new Pieza();
        boolean tipoValido = false;
        boolean colorValido = false;
        boolean filaValida = false;
        boolean columnaValida = false;

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

        return nuevaPieza;
    }

    public static boolean nuevaposicion() {
        Scanner scan = new Scanner(System.in);
        int opcion;
        boolean nueva = false;
        boolean opcionValida = false;

        System.out.println(" ");

        do{
            System.out.println("Quieres mover esta ficha (1) o elegir una ficha nueva? (2)");
            System.out.println("Seleccione una opción: ");
            opcion = scan.nextInt();

            if(opcion!=1 && opcion!=2){
                System.out.println("Opción no valida, vuelva a introducir");
            }
            else{
                if(opcion == 1){
                    nueva = true;
                    opcionValida = true;
                }
                if(opcion == 2){
                    nueva = false;
                    opcionValida = true;
                }
            }


        }while(!opcionValida);

        return nueva;
    }

    public static Pieza modificarPosicion(Pieza nuevaPieza, char[][] codificado) {
        Scanner scan = new Scanner(System.in);
        boolean posicionValida = false;
        char columna = ' ';
        char fila = ' ';

        do {
            System.out.println("Selecciona una de las siguientes posiciones disponibles:");
            Ajedrez.imprimirMovimientos(codificado); //Mostrar las posiciones válidas al usuario
            System.out.println(" ");

            System.out.print("Introduce la columna (letra de la A a la H): ");
            columna = Character.toUpperCase(scan.next().charAt(0));

            System.out.print("Introduce la fila (número del 1 al 8): ");
            fila = scan.next().charAt(0);

            for (char[] posicion : codificado) {
                if (posicion[0] == fila && posicion[1] == columna) {
                    nuevaPieza.setPosJ(codificarColumnaChar(columna)); // Actualizar columna en la pieza
                    nuevaPieza.setPosI(codificarFilaChar(fila)); // Actualizar fila en la pieza
                    posicionValida = true;
                    break;
                }
            }

            if (!posicionValida) {
                System.out.println("La posición introducida no es válida. Por favor, elige una posición de la lista.");
            }
        } while (!posicionValida);

        System.out.println("La pieza ha sido movida a la nueva posición: " + columna + fila);

        return nuevaPieza;
    }

    public static boolean finaljuego() {
        Scanner scan = new Scanner(System.in);
        boolean continuar = false;
        boolean opcionValida = false;

        System.out.println(" ");

        do {
            // Preguntar al usuario si quiere continuar o cambiar de pieza
            System.out.println("¿Quieres continuar con el programa (S/N)?");
            System.out.print("Selecciona una opción: ");
            char opcion = scan.next().toUpperCase().charAt(0);

            if (opcion == 'S') {
                System.out.println("El programa continuará");
                opcionValida = true;
                continuar = true;

            } else if (opcion == 'N') {
                System.out.println("Gracias por jugar al Ajedrez Interactivo. ¡Hasta la próxima!");
                opcionValida = true;
            }
            else{
                System.out.println("Opción no valida");
            }

        }while(!opcionValida);

        return continuar;
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
