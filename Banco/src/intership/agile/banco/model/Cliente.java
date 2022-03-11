package intership.agile.banco.model;

public class Cliente {
    private String nombre;
    private Integer idCliente;
    private static int contador;
    private double ingresoMensual;
    private boolean isCuentaCheques;
    private boolean isCuentaInversion;
    private boolean isTarjetaCredito;

    public Cliente() {
        idCliente = ++Cliente.contador;
        isCuentaCheques = false;
        isTarjetaCredito = false;
        isCuentaInversion = false;

    }

    public Cliente(String nombre, double ingresoMensual) {
        this.nombre = nombre;
        this.ingresoMensual = ingresoMensual;
        idCliente = ++Cliente.contador;
    }

    public Cliente(String nombre, String numCliente, double ingresoMensual) {
        this.nombre = nombre;
        this.ingresoMensual = ingresoMensual;
        idCliente = ++Cliente.contador;
    }

    public String getNombre() {
        return nombre;
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

    public boolean isCuentaCheques() {
        return isCuentaCheques;
    }

    public void setCuentaCheques(boolean cuentaCheques) {
        this.isCuentaCheques = cuentaCheques;
    }

    public boolean isCuentaInversion() {
        return isCuentaInversion;
    }

    public void setCuentaInversion(boolean cuentaInversion) {
        this.isCuentaInversion = cuentaInversion;
    }

    public boolean isTarjetaCredito() {
        return isTarjetaCredito;
    }

    public void setTarjetaCredito(boolean tarjetaCredito) {
        this.isTarjetaCredito = tarjetaCredito;
    }

    @Override
    public String toString() {
        return  "Id: " + idCliente + "\n" +
                "Nombre: " + nombre + "\n" +
                "Ingreso Mensual: " + ingresoMensual + "\n" +
                "Tarjeta de credito: " + isTarjetaCredito + "\n" +
                "Cuenta de cheques: " + isCuentaCheques + "\n" +
                "Cuenta de inversión: " + isCuentaInversion + "\n";
    }
}
