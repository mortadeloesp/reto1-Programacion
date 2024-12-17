public class PruebaParpadeo {
    public static void main(String[] args) throws InterruptedException {
        // Secuencias de escape ANSI para cambiar el fondo
        String fondoVerdeClaro = "\u001B[102m";  // Fondo rojo
        String fondoNormal = "\u001B[49m"; // Fondo por defecto (normal)
        String texto = "¡Fondo Parpadeante!";

        // Número de veces que queremos que parpadee
        int parpadeos = 10;

        for (int i = 0; i < parpadeos; i++) {
            // Mostrar el texto con fondo rojo
            System.out.print(fondoVerdeClaro + texto + "\r");
            Thread.sleep(500); // Espera medio segundo

            // Limpiar el fondo (vuelve al fondo normal)
            System.out.print(fondoNormal + texto + "\r");
            Thread.sleep(500); // Espera medio segundo
        }

        // Reset final para limpiar cualquier estilo
        System.out.print("\u001B[0m");
    }
    }
