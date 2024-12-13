import java.util.Scanner;

public class PruebaMainAjedrez {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la pieza (Torre (T), Alfil (A), Peón (P), Dama (D), Caballo (C), Rey (R)): ");
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
        System.out.println("Introduce la posición inicial: ");


    }

    public static void codificar(){

    }
}
