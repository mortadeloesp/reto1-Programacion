public class PruebaAjedrez{
    public static void main(String[] args) {
        char[][] tablero = Ajedrez.crearTablero();
        Ajedrez.imprimirTablero(tablero);
        Pieza REY = new Pieza('R',true,6,6);
        int[][] prueba = REY.movimientoRey();
        for(int i = 0; i < prueba.length; i++){
            for(int j = 0; j < prueba[i].length; j++){
                if(prueba[i][j] != 0) {
                    System.out.print(prueba[i][j] + ", ");
                }
            }
            System.out.println();
        }
    }
}
