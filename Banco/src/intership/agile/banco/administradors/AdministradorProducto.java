package intership.agile.banco.administradors;

import intership.agile.banco.classhelp.Configuracion;
import intership.agile.banco.interfaces.ProductoFinanciero;
import intership.agile.banco.model.Cliente;
import intership.agile.banco.model.CuentaCheques;
import intership.agile.banco.model.CuentaInversion;
import intership.agile.banco.model.TarjetaCredito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorProducto {
    private Configuracion conf;
    private Map<Integer, List<ProductoFinanciero>> mapaProductos = new HashMap<>();

    public AdministradorProducto(Configuracion conf) {
        this.conf = conf;
    }

    public void agregarProducto(Cliente cliente, ProductoFinanciero producto) {
        List<ProductoFinanciero> productos = mapaProductos.get(cliente.getIdCliente());
        if(productos == null) {
            productos = new ArrayList<>();
            mapaProductos.put(cliente.getIdCliente(), productos);
        }
        if(producto instanceof TarjetaCredito) {
            double ingresoMensual = cliente.getIngresoMensual();
            double lineaCredito = ((TarjetaCredito) producto).getLineaCredito();
            if(lineaCredito > ingresoMensual * conf.getMaxLineaCreditoPorIngresoMensual()) {
                System.out.println("Linea de crédito excesiva para este cliente");
                return;
            }
        }
        if(producto instanceof CuentaInversion){
            boolean cuentaChques = false;
            for (ProductoFinanciero pf : productos){
                if(pf instanceof CuentaCheques){
                    cuentaChques = true;
                }
            }
            if (!cuentaChques){
                System.out.println("Se necesita una cuenta de cheques para poder tener una cuenta de inversion");
                return;
            }
        }
        productos.add(producto);
    }

    public List<ProductoFinanciero> getProductos(Integer numCliente) {
        List<ProductoFinanciero> productos = mapaProductos.get(numCliente);
        if(productos == null)
            System.out.println("El cliente no tiene productos asignados");
        return productos;
    }

    public boolean puedeCancelar(Cliente cliente) {
        List<ProductoFinanciero> productos = getProductos(cliente.getIdCliente());
        boolean resultado = true;
        for(ProductoFinanciero pf : productos) {
            if(pf.getSaldo() != 0.0) {
                resultado = false;
                pf.imprimirEstadoCuenta();
            }
        }
        return resultado;
    }

}
