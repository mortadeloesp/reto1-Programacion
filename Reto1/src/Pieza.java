public class Pieza {
    private char tipo;
    private boolean color;
    private int posI;
    private int posJ;

    public Pieza(char tipo, boolean color, int posI, int posJ) { //Hacer try catch en el main, usar UPPERCASE para hacerla mayuscula
        if (tipo == 'T' || tipo == 'P' || tipo == 'A' || tipo == 'D' || tipo == 'R' || tipo == 'C') {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de pieza no válido");
        }
        this.color = color; //0 blanco, 1 negro
        if (posI > 0 && posI < 9) {
            this.posI = posI;
        } else {
            System.out.println("Posición de fila incorrecta");
        }
        if (posJ > 0 && posJ < 9) {
            this.posJ = posJ;
        } else {
            System.out.println("Posición de columna incorrecta");
        }
    }

    public Pieza(){
        this.tipo=' ';
        this.color=false;
        this.posI=0;
        this.posJ=0;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isColor() {
        return color;
    }

    public void getColor(){
        if(!this.color){
            System.out.println("Blanco");
        }
        else{
            System.out.println("Negro");
        }
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getPosI() {
        return posI;
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public int getPosJ() {
        return posJ;
    }

    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }

    public int[][] comprobarPosicion(int[] movimientosFila, int[] movimientosColumna, int[][] posibilidades){
        int contador = 0;

        for (int i = 0; i < movimientosFila.length; i++) {
            int nuevaFila = this.posI + movimientosFila[i];
            int nuevaColumna = this.posJ + movimientosColumna[i];

            // Comprobar que el movimiento está dentro del tablero (1 a 8)
            if (nuevaFila >= 1 && nuevaFila <= 8 && nuevaColumna >= 1 && nuevaColumna <= 8) {
                posibilidades[contador][0] = nuevaFila; // Guardar fila
                posibilidades[contador][1] = nuevaColumna; // Guardar columna
                contador++; // Incrementar el contador
            }
        }
        return posibilidades;
    }

    //Para decidir que movimiento hay que hacer hacer un switch
    public int[][] movimientoRey() {
        int[][] posibilidades = new int[8][2];
        int[] movimientosFila = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] movimientosColumna = {-1, 0, 1, -1, 1, -1, 0, 1};

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }


    /*public int[][] movimientoTorre() {
        int[][] posibilidades = new int[8][8];
        int[] movimientosFila = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] movimientosColumna = {-1, 0, 1, -1, 1, -1, 0, 1};

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }*/

    public int[][] movimientoTorre() {

        int[][] posibilidades = new int[28][2];
        int[] movimientosFila = {1, 2, 3, 4, 5, 6, 7};
        int[] movimientosColumna = {-7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 1; i < movimientosFila.length; i++) {
            for (int j = 1; j < movimientosFila[i]; j++) {
            }
        }

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }


    public int[][] movimientoTorre2() {

        int[][] posibilidades = new int[28][2];
        int[] movimientosFila = {-1, 1,-2, 2, 3,-3, 4, -4, 5,-5,  6,-6,  7 ,-7};
        int[] movimientosColumna = {1, 2, 3, 4, 5, 6, 7};

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }

    public int[][] movimientoAlfil(){
        int[][] posibilidades = new int[13][2];
        int[] movimientosFila = {-1,-1,1,1,-2,-2,2,2,-3,-3,3,3,-4,-4,4,4,-5,-5,5,5,-6,-6,6,6,-7,-7,7,7};
        int[] movimientosColumna = {-1,1,-1,1,-2,2,-2,2,-3,3,-3,3,-4,4,-4,4,-5,5,-5,5,-6,6,-6,6,-7,7,-7,7};

        return comprobarPosicion(movimientosFila,movimientosColumna,posibilidades);
    }

}
