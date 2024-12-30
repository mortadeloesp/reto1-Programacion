import java.util.Scanner;

public class PruebaMainAjedrez2 {
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

    public static char[][] codificar(int[][] posibilidades){
        char[][] codificado = new char[posibilidades.length][posibilidades[0].length];
        for (int i = 0; i < posibilidades.length; i++){
            for (int j = 0; j < posibilidades[i].length; j++){
                switch(posibilidades[i][0]){
                    case 1:
                        codificado[i][j] = 56;
                        break;
                    case 2:
                        codificado[i][j] = 55;
                        break;
                    case 3:
                        codificado[i][j] = 54;
                        break;
                    case 4:
                        codificado[i][j] = 53;
                        break;
                    case 5:
                        codificado[i][j] = 52;
                        break;
                    case 6:
                        codificado[i][j] = 51;
                        break;
                    case 7:
                        codificado[i][j] = 50;
                        break;
                    case 8:
                        codificado[i][j] = 49;
                        break;
                }
                switch(posibilidades[0][j]){
                    case 1:
                        codificado[i][j] = 65;
                        break;
                    case 2:
                        codificado[i][j] = 66;
                        break;
                    case 3:
                        codificado[i][j] = 67;
                        break;
                    case 4:
                        codificado[i][j] = 68;
                        break;
                    case 5:
                        codificado[i][j] = 69;
                        break;
                    case 6:
                        codificado[i][j] = 70;
                        break;
                    case 7:
                        codificado[i][j] = 71;
                        break;
                    case 8:
                        codificado[i][j] = 72;
                        break;
                }
            }
        }
        return codificado;
    }
}
