package intership.agile.banco.model;

public class CuentaCheques extends CuentaBancaria {

    private double comisionRetiro;
    private int idCuentaCheques;
    private static int contador;

    public CuentaCheques(double balanceInicial, double comisionRetiro) {
        super(balanceInicial);
        this.comisionRetiro = comisionRetiro;
        idCuentaCheques = ++contador;
    }

    @Override
    public void reducirFondos(double importe) {
        double importeTotal = importe + comisionRetiro;
        super.reducirFondos(importeTotal);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("********************************");
        System.out.println("Estado de Cuenta de Cheques...");
        System.out.println("Balance actual: " + getBalance());
        System.out.println("Comision retiro: " + comisionRetiro);
        System.out.println("********************************");
    }

    @Override
    public String toString() {
        return "CuentaCheques{" +
                "comisionRetiro=" + comisionRetiro +
                ", idCuentaCheques=" + idCuentaCheques +
                '}';
    }
}
