public class Torre {
    public int[][] movimientoTorre() {
        int[][] posibilidades = new int[28][2];
        int[] movimientosFila = {-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7, 0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] movimientosColumna = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1, -2, -3, -4, -5, -6, -7, 1, 2, 3, 4, 5, 6, 7};


        return comprobarPosicion(movimientosFila, movimientosColumna, posibilidades);
    }
}
