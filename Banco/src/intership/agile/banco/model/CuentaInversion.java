package intership.agile.banco.model;

public class CuentaInversion extends CuentaBancaria {

    private double interesAlCorte;
    private double iva ;
    private int idCuentaInversion;
    private static int contador;

    public CuentaInversion(double balanceInicial, double interesAlCorte, double iva) {
        super(balanceInicial);
        this.interesAlCorte = interesAlCorte;
        this.iva = iva;
        idCuentaInversion = ++contador;
    }

    public void aplicarCorte() {
        double balanceTotal =interesAlCorte*getBalance()*(1-iva);
        agregarFondos(balanceTotal);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("********************************");
        System.out.println("Estado de Cuenta de Inversión ...");
        System.out.println("Balance: " + getBalance());
        System.out.println("Tasa de Interés: " + interesAlCorte);
        System.out.println("Iva:  " + (iva*100) + "%");
        System.out.println("********************************");
    }

    @Override
    public String toString() {
        return "CuentaInversion{" +
                "interesAlCorte=" + interesAlCorte +
                ", iva=" + iva +
                ", idCuentaInversion=" + idCuentaInversion +
                '}';
    }
}
