package intership.agile.banco;

public class Cliente {
    private String nombre;
    private String numCliente;
    private int idCliente;
    private static int contador;
    private double ingresoMensual;

    public Cliente() {
        idCliente = ++Cliente.contador;
    }

    public Cliente(String nombre, String numCliente, double ingresoMensual) {
        this.nombre = nombre;
        this.numCliente = numCliente;
        this.ingresoMensual = ingresoMensual;
        contador++;
        idCliente = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", numCliente='" + numCliente + '\'' +
                ", idCliente=" + idCliente +
                ", ingresoMensual=" + ingresoMensual +
                '}';
    }
}
