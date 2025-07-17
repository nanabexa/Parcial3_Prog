import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Medicamento {
    private String codigo;
    private String nombre;
    private String laboratorio;
    private double precio;
    private int cantidad;
    private Date fechaExpiracion;

    public Medicamento(String nombre, String laboratorio, double precio, int cantidad, Date fechaExpiracion) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaExpiracion = fechaExpiracion;
        this.codigo = generarCodigo(nombre, laboratorio);
    }

    private String generarCodigo(String nombre, String laboratorio) {
        int numero = (int) (Math.random() * 900) + 100;
        char letraNombre = Character.toUpperCase(nombre.charAt(0));
        char letraLab = Character.toUpperCase(laboratorio.charAt(0));
        return "" + letraNombre + letraLab + numero;
    }

    public String verificarVencimiento() {
        Date hoy = new Date();
        if (fechaExpiracion.before(hoy)) {
            return "¡MEDICAMENTO VENCIDO! Debe ser retirado del inventario.";
        } else {
            long diff = fechaExpiracion.getTime() - hoy.getTime();
            long dias = TimeUnit.MILLISECONDS.toDays(diff);
            return "Este medicamento vence en " + dias + " días.";
        }
    }

    public void mostrarInformacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n--- Información del Medicamento ---");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Laboratorio: " + laboratorio);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Cantidad en inventario: " + cantidad);
        System.out.println("Fecha de expiración: " + sdf.format(fechaExpiracion));
        System.out.println(verificarVencimiento());
    }
}
