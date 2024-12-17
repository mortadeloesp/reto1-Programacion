public class Pieza {
    private char tipo;
    private boolean color;
    private int posI;
    private int posJ;

    public Pieza(char tipo, boolean color, int posI, int posJ) {
        //Hacer try catch en el main, usar UPPERCASE para hacerla mayuscula

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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isColor() {
        return color;
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

        return comprobarPosicion(movimientosFila,movimientosColumna,posibilidades);
    }
}
