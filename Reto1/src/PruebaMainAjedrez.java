import java.util.Scanner;

public class PruebaMainAjedrez {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        /*System.out.println("Introduce la pieza (Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R)): ");
        char pieza = Character.toUpperCase(scan.next().charAt(0));
        System.out.println("Introduce el color (Blanco (0), Negro (1)): ");
        int tonalidad = scan.nextInt();
        boolean color;
        if(tonalidad==0){
            color = false;
        }
        else{
            color = true;
        }
        System.out.println("Introduce la posición inicial: ");*/


    /*char pieza = Character.toUpperCase(scan.next().charAt(0));
    boolean color = false; // false = Blanco, true = Negro
    int posI = 0, posJ = 0;

    // Mostrar título del menú
    System.out.println("╔══════════════════════════════════╗");
    System.out.println("║      🟦 Bienvenido a Ajedrez 🟦      ║");
    System.out.println("╚══════════════════════════════════╝\n");

    // Solicitar tipo de pieza
    System.out.println("Selecciona el tipo de pieza:");
    System.out.println("╔══════════════════════════════╗");
    System.out.println("║ Torre (T)  │ Alfil (A)       ║");
    System.out.println("║ Peón  (P)  │ Dama  (D)       ║");
    System.out.println("║ Caballo (C)│ Rey   (R)       ║");
    System.out.println("╚══════════════════════════════╝");
    System.out.print("Introduce tu elección: ");
    pieza = Character.toUpperCase(scan.next().charAt(0));

    switch (pieza) {
        case 'T':
        case 'A':
        case 'P':
        case 'D':
        case 'C':
        case 'R':
            break;
        default:
            System.out.println("\n🚫 Tipo de pieza no válido. Reinicia el programa.");
            return;
    }

    // Solicitar color de la pieza
    System.out.println("\nSelecciona el color de la pieza:");
    System.out.println("╔════════════════╗");
    System.out.println("║ Blanco (0)     ║");
    System.out.println("║ Negro  (1)     ║");
    System.out.println("╚════════════════╝");
    System.out.print("Introduce tu elección: ");
    int tonalidad = scan.nextInt();

    switch (tonalidad) {
        case 0:
            color = false;
            break;
        case 1:
            color = true;
            break;
        default:
            System.out.println("\n🚫 Color no válido. Reinicia el programa.");
            return;
    }

    // Solicitar posición inicial
    System.out.println("\nIntroduce la posición inicial:");
    System.out.println("╔═══════════════════════════╗");
    System.out.println("║ Fila (1-8) y Columna (1-8)║");
    System.out.println("╚═══════════════════════════╝");
    System.out.print("Fila (1-8): ");
    posI = scan.nextInt();
    System.out.print("Columna (1-8): ");
    posJ = scan.nextInt();

    if (posI < 1 || posI > 8 || posJ < 1 || posJ > 8) {
        System.out.println("\n🚫 Posición no válida. Reinicia el programa.");
        return;
    }

    // Crear el objeto Pieza con los datos ingresados
    Pieza piezaJuego = new Pieza(pieza, color, posI, posJ);

    // Mostrar los datos de la pieza creada
    System.out.println("\n🎉 Resumen de la pieza seleccionada:");
    System.out.println("╔═══════════════════════════╗");
    System.out.printf("║ Tipo de pieza: %-10s║\n", pieza);
    System.out.printf("║ Color: %-16s║\n", (color ? "Negro" : "Blanco"));
    System.out.printf("║ Posición inicial: Fila %d, Columna %d║\n", posI, posJ);
    System.out.println("╚═══════════════════════════╝");*/



        /*Scanner scan = new Scanner(System.in);
        char pieza = Character.toUpperCase(scan.next().charAt(0));
        boolean color = false; // false = Blanco, true = Negro
        int posI = 0, posJ = 0;

        // Solicitar tipo de pieza
        System.out.println("Introduce la pieza (Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R)): ");
        pieza = Character.toUpperCase(scan.next().charAt(0));

        switch (pieza) {
            case 'T':
            case 'A':
            case 'P':
            case 'D':
            case 'C':
            case 'R':
                break;
            default:
                System.out.println("Tipo de pieza no válido.");
                return;
        }

        // Solicitar color de la pieza
        System.out.println("Introduce el color (Blanco (0), Negro (1)): ");
        int tonalidad = scan.nextInt();

        switch (tonalidad) {
            case 0:
                color = false;
                break;
            case 1:
                color = true;
                break;
            default:
                System.out.println("Color no válido.");
                return;
        }

        // Solicitar posición inicial
        System.out.println("Introduce la posición inicial (fila y columna, valores entre 1 y 8):");
        System.out.print("Fila (1-8): ");
        posI = scan.nextInt();
        System.out.print("Columna (1-8): ");
        posJ = scan.nextInt();

        if (posI < 1 || posI > 8 || posJ < 1 || posJ > 8) {
            System.out.println("Posición no válida.");
            return;
        }

        // Crear el objeto Pieza con los datos ingresados
        Pieza piezaJuego = new Pieza(pieza, color, posI, posJ);

        // Mostrar los datos de la pieza creada
        System.out.println("\nResumen de la pieza:");
        System.out.println("Tipo de pieza: " + pieza);
        System.out.println("Color: " + (color ? "Negro" : "Blanco"));
        System.out.println("Posición inicial: Fila " + posI + ", Columna " + posJ);*/

        Scanner scan = new Scanner(System.in);
        char pieza = Character.toUpperCase(scan.next().charAt(0));
        boolean color = false;
        int posI = 0, posJ = 0;


        //pieza
        do {
            try {
                System.out.println("Elige: Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R): ");
                String entradaPieza = scan.nextLine().trim();

                if (entradaPieza.length() == 1 && Character.isLetter(entradaPieza.charAt(0))) {
                    pieza = Character.toUpperCase(entradaPieza.charAt(0));

                    switch (pieza) {
                        case 'T':
                            break;
                        case 'A':
                            break;
                        case 'P':
                            break;
                        case 'D':
                            break;
                        case 'C':
                            break;
                        case 'R':
                            break;
                        default:
                            System.out.println("Pieza no válida. Vuelve a intentarlo reina");
                            pieza = ' ';
                            break;
                    }
                } else {
                    System.out.println("Eres tonto, pero te damos una segunda oportunidad. Vuelve a intenatrlo");
                }
            } catch (Exception e) {
                System.out.println("Solo letras <3");
                scan.nextLine();
            }
        } while (pieza == ' ');



        //color
        do {
            try {
                System.out.println("Elige el color Blanco (0), Negro (1): ");
                int tonalidad = scan.nextInt();

                switch (tonalidad) {
                    case 0:
                        color = false;
                        break;
                    case 1:
                        color = true;
                        break;
                    default:
                        System.out.println("Solo es poner o B o N");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Solo es un número del 0 al 1");
                scan.nextLine();
            }
        } while (color == 1 && color == 0);



        //posición
        do {
            try {
                System.out.println("Introduce la posición de la pieza del 1 al 8 tanto de fila como de columna: ");
                System.out.print("Fila (del 1 al 8): ");
                posI = scan.nextInt();
                System.out.print("Columna (del 1 al 8): ");
                posJ = scan.nextInt();

                if (posI < 1 || posI > 8 || posJ < 1 || posJ > 8) {
                    System.out.println("Vuelve a intentarlo, solo números del 1 al 8");
                    posI = 0;
                }
            } catch (Exception e) {
                System.out.println("Solo números");
                scan.nextLine();  // Limpiamos el buffer
            }
        } while (posI < 1 || posI > 8 || posJ < 1 || posJ > 8);


    //public static void codificar(){

    //}

    }
}

