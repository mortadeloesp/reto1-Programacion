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

    public int getPosJ() {
        return posJ;
    }

    public void setPosI(int posI) {
        this.posI = posI;
    }

    public void setPosJ(int posJ) {
        this.posJ = posJ;
    }

    /*public boolean setPosI(int posI, int[][] posicionesValidas) {
        for (int[] posicion : posicionesValidas) {
            if (posI == posicion[0] && this.posJ == posicion[1]) {
                this.posI = posI;
                return true;
            }
        }
        return false;
    }

    public boolean setPosJ(int posJ, int[][] posicionesValidas) {
        for (int[] posicion : posicionesValidas) {
            if (this.posI == posicion[0] && posJ == posicion[1]) {
                this.posJ = posJ;
                return true;
            }
        }
        return false;
    }*/


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

    public int[][] movimientoAlfil(){
        int[][] posibilidades = new int[13][2];
        int[] movimientosFila = {-1,-1,1,1,-2,-2,2,2,-3,-3,3,3,-4,-4,4,4,-5,-5,5,5,-6,-6,6,6,-7,-7,7,7};
        int[] movimientosColumna = {-1,1,-1,1,-2,2,-2,2,-3,3,-3,3,-4,4,-4,4,-5,5,-5,5,-6,6,-6,6,-7,7,-7,7};

        return comprobarPosicion(movimientosFila,movimientosColumna,posibilidades);
    }

    public int[][] movimientoTorre() {
        int[][] posibilidades = new int[14][2];
        int[] movimientosFila = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] movimientosColumna = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7};


        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }

    public int[][] movimientoPeon() {
        // Inicializamos el arreglo de posibles posiciones
        int[][] posibilidades = new int[2][2];  // Ahora tiene 3 posibles movimientos: una casilla, dos casillas, captura en diagonal.
        int[] movimientosFila;  // Dirección de filas (el peón solo se mueve hacia abajo, en la parte superior y diagonal)
        int[] movimientosColumna; // Movimiento en las columnas


        // Movimiento para el peón negro
        if (!this.color) {  // Peón negro
            if (this.posI == 7) {  // Si el peón está en la fila 7, puede moverse 1 o 2 casillas hacia adelante
                movimientosFila = new int[]{-1, -2};  // Movimiento hacia arriba
                movimientosColumna = new int[]{0, 0};  // La columna no cambia
            } else {  // Si no está en la fila 7, solo puede moverse 1 casilla hacia adelante
                movimientosFila = new int[]{-1};
                movimientosColumna = new int[]{0};
            }
        }
        // Movimiento para el peón blanco
        else {  // Peón blanco
            if (this.posI == 2) {  // Si el peón está en la fila 2, puede moverse 1 o 2 casillas hacia adelante
                movimientosFila = new int[]{1, 2};  // Movimiento hacia abajo
                movimientosColumna = new int[]{0, 0};  // La columna no cambia
            } else {  // Si no está en la fila 2, solo puede moverse 1 casilla hacia adelante
                movimientosFila = new int[]{1};
                movimientosColumna = new int[]{0};
            }
        }

        // Verificación de las posiciones usando el método comprobarPosicion

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }

    public int[][] movimientoDama() {
        int[][] posibilidades = new int[28][2];
        int[] movimientosFila = {-1,-1,1,1,-2,-2,2,2,-3,-3,3,3,-4,-4,4,4,-5,-5,5,5,-6,-6,6,6,-7,-7,7,7, -1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] movimientosColumna = {-1,1,-1,1,-2,2,-2,2,-3,3,-3,3,-4,4,-4,4,-5,5,-5,5,-6,6,-6,6,-7,7,-7,7, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7};

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }

    public int[][] movimientoCaballo() {
        int[][] posibilidades = new int[8][2];
        int[] movimientosFila = {2,-2,-1,2,-2,1,-1,1};
        int[] movimientosColumna = {-1,1,-2,1,-1,2,2,-2};

        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }


}