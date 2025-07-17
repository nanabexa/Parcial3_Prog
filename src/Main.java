import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = "S";

        while (opcion.equalsIgnoreCase("S")) {
            try {
                System.out.println("\n--- Registro de Medicamento ---");

                System.out.print("Ingrese el nombre del medicamento: ");
                String nombre = br.readLine().trim();

                System.out.print("Ingrese el laboratorio fabricante: ");
                String laboratorio = br.readLine().trim();

                System.out.print("Ingrese el precio por unidad: ");
                double precio = Double.parseDouble(br.readLine());

                System.out.print("Ingrese la cantidad en inventario: ");
                int cantidad = Integer.parseInt(br.readLine());

                System.out.print("Ingrese la fecha de expiración (DD/MM/AAAA): ");
                String fechaStr = br.readLine().trim();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); // Para validar bien la fecha
                Date fechaExpiracion = sdf.parse(fechaStr);

                // Crear el objeto Medicamento
                Medicamento medicamento = new Medicamento(nombre, laboratorio, precio, cantidad, fechaExpiracion);

                // Mostrar información y estado del medicamento
                medicamento.mostrarInformacion();

            } catch (Exception e) {
                System.out.println("Error en la entrada de datos: " + e.getMessage());
                continue; // Vuelve al inicio del ciclo para intentar de nuevo
            }

            // Validar que la opción sea S o N
            do {
                try {
                    System.out.print("\n¿Desea verificar otro medicamento? (S/N): ");
                    opcion = br.readLine().trim().toUpperCase();
                } catch (IOException e) {
                    System.out.println("Error al leer la opción, saliendo del programa.");
                    opcion = "N"; // Salir si hay error
                }

                if (!opcion.equals("S") && !opcion.equals("N")) {
                    System.out.println("Opción inválida. Por favor ingrese 'S' para sí o 'N' para no.");
                }
            } while (!opcion.equals("S") && !opcion.equals("N"));
        }

        System.out.println("\nGracias por usar el sistema de farmacia.");
    }
}
