package intership.agile.banco.model;

import intership.agile.banco.interfaces.ProductoFinanciero;

public class TarjetaCredito implements ProductoFinanciero {

    private double lineaCredito;
    private double saldo;
    private int idTarjetaCredito;
    private static int contador;

    public TarjetaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
        this.saldo = 0;
        idTarjetaCredito = ++contador;
    }

    public double getLineaCredito() {
        return lineaCredito;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("********************************");
        System.out.println("Estado de Cuenta - Tarjeta de Credito");
        System.out.println("Saldo: " + saldo);
        System.out.println("Línea de crédito: " + lineaCredito);
        System.out.println("********************************");
    }

    public void pagarTarjeta(double importe) {
        saldo += importe;
    }

    public void cargarTarjeta(double importe) {
        if(saldo - importe < lineaCredito * -1)
            System.out.println("Linea de credito insuficiente");
        else
            saldo -= importe;
    }

    @Override
    public String toString() {
        return "Tarjeta Credito" + getClass().getName();
    }
    public String obtenerNombreClase(){
        return getClass().getSimpleName();
    }
}
