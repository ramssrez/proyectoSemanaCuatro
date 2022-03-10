package intership.agile.banco.model;

public class Cliente {
    private String nombre;
    private String numCliente;
    private Integer idCliente;
    private static int contador;
    private double ingresoMensual;

    public Cliente() {
        idCliente = ++Cliente.contador;
    }

    public Cliente(String nombre, double ingresoMensual) {
        this.nombre = nombre;
        this.ingresoMensual = ingresoMensual;
        idCliente = ++Cliente.contador;
    }

    public Cliente(String nombre, String numCliente, double ingresoMensual) {
        this.nombre = nombre;
        this.numCliente = numCliente;
        this.ingresoMensual = ingresoMensual;
        idCliente = ++Cliente.contador;
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

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + "\n" +
                "Id: " + idCliente + "\n" +
                "Ingreso: " + ingresoMensual;
    }
}
