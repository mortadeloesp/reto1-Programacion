public class Ajedrez {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_TEXT = "\033[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[48;5;15m";
    public static final String ANSI_BROWN_BACKGROUND = "\u001B[48;5;94m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\033[41m";
    public static char[][] crearTablero() {

        char[][] tablero = new char [11][11];
        char letra = 65; //Se usa código ASCII, 65=A, 66=B, etc.
        char numero = 56; //Al igual, se usa código ASCII para los números, se empieza desde el 8 y se irá hacia atrás

        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                if(i==10 && j!=0 && j<9){
                    tablero[i][j] = letra;
                    letra++;
                }
                else if(j==10 && i!=0 && i<9){
                    tablero[i][j] = numero;
                    numero--;
                }
                else if((i==10 && j==0) || (i==9 && j==10) || (i==0 && j==10) || (i==10 && j==9) || (i==10 && j==10)){
                    tablero[i][j] = '.';
                }
                else if((i==0 || j==0 || i==9 || j==9)){
                    tablero[i][j] = '#';
                }
                else{
                    tablero[i][j] = ' ';
                }
            }
        }
        return tablero;
    }

    public static void imprimirTablero (char[][] tablero, char tipo, boolean color){
        int nfila = 2;
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                if(tablero[i][j]==' ' && nfila%2==0) {
                    if(j%2==1){
                        System.out.print(ANSI_BLACK_BACKGROUND + " " + tablero[i][j] + " " + ANSI_RESET);
                    }
                    else{
                        System.out.print(ANSI_WHITE_BACKGROUND + " " + tablero[i][j] + " " + ANSI_RESET);
                    }
                }
                else if (tablero[i][j]==' ' && nfila%2==1){
                    if(j%2==0){
                        System.out.print(ANSI_BLACK_BACKGROUND + " " + tablero[i][j] + " " + ANSI_RESET);
                    }
                    else{
                        System.out.print(ANSI_WHITE_BACKGROUND + " " + tablero[i][j] + " " + ANSI_RESET);
                    }
                }
                else if(tablero[i][j]=='#'){
                    System.out.print(ANSI_BROWN_BACKGROUND + "\u200B" + "  " + ANSI_RESET); //Se usa el \u200B para imprimir un espacio vacío
                }
                else if(tablero[i][j]=='.'){
                    System.out.print(" " + "\u200B" + " ");
                }
                else if(tablero[i][j]=='-'){
                    System.out.print(ANSI_GREEN_BACKGROUND + "\u200B" + "  " + ANSI_RESET);
                }
                else if(tablero[i][j]=='*' && color){
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK_TEXT + " " + tipo + " " + ANSI_RESET);
                }
                else if(tablero[i][j]=='*' && !color){
                    System.out.print(ANSI_RED_BACKGROUND + " " + tipo + " " + ANSI_RESET);
                }
                else{
                    System.out.print(" " + tablero[i][j] + " ");
                }
            }
            System.out.println(" ");
            nfila++;
        }
    }

    public static void modificarTablero(char[][] tablero, int[][] posiciones, int posI, int posJ) {
        tablero[posI][posJ] = '*';
        for (int k = 0; k < posiciones.length; k++) {
            int fila = posiciones[k][0];   // Obtiene la fila de la posición
            int columna = posiciones[k][1]; // Obtiene la columna de la posición
            if (fila > 0 && fila < tablero.length && columna > 0 && columna < tablero[fila].length) {
                tablero[fila][columna] = '-'; // Sustituye el valor en la posición especificada
            }
        }
    }

    public static void imprimirMovimientos(char[][] codificado) {
        System.out.print("Los posibles movimientos de la pieza introducida son: ");
        System.out.print("[");
        boolean primero = true; // Controla si es el primer par que imprimimos

        for (int i = 0; i < codificado.length; i++) {
            // Recoger los dos movimientos de cada fila
            char movimiento1 = codificado[i][1]; // Columna j=1
            char movimiento2 = codificado[i][0]; // Columna j=0

            // Validar que al menos uno de los valores no sea un espacio vacío (' ')
            if (movimiento1 != ' ' || movimiento2 != ' ') {
                if (!primero) {
                    System.out.print(", "); // Agrega coma solo entre pares válidos
                }
                System.out.print(movimiento1 + "" + movimiento2); // Concatenar los movimientos
                primero = false; // Marcar que ya se imprimió el primer par
            }
        }
        System.out.print("]");
    }

}