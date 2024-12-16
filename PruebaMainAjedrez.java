import java.util.Scanner;

public class PruebaMainAjedrez {
    public static void main(String[] args) {
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
        color = false;

        do {
            try {
                System.out.println("Elige blanco (0) o negro (1): ");
                int tonalidad = scan.nextInt();

                if (tonalidad == 0 || tonalidad == 1) {
                    System.out.println("Has elegido el color " + (tonalidad == 0 ? "Blanco" : "Negro"));
                    color = true;
                } else {
                    System.out.println("Solo puedes elegir 0 o 1.");
                }

            } catch (Exception e) {
                System.out.println("Solo 0 o 1");
                scan.nextLine();
            }
        } while (!color);


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
                scan.nextLine();
            }
        } while (posI < 1 || posI > 8 || posJ < 1 || posJ > 8);

    }

    public static void codificar () {

    }
}
