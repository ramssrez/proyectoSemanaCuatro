package intership.agile.banco.model;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import intership.agile.banco.Principal;
import intership.agile.banco.administradors.AdministradorCliente;
import intership.agile.banco.administradors.AdministradorProducto;
import intership.agile.banco.classhelp.Configuracion;
import intership.agile.banco.classhelp.Validacion;
import intership.agile.banco.interfaces.ProductoFinanciero;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static AdministradorCliente administradorCliente = new AdministradorCliente();
    private static AdministradorProducto administradorProducto;
    public static void main(String[] args) {
        System.out.println("hola mundo");
        Cliente cliente1 = new Cliente("Jesus","123",18000.0);
        Cliente cliente2 = new Cliente("Tomas","124",19000.0);
        Cliente cliente3 = new Cliente("Rosa","125",20000.0);
        Cliente cliente4 = new Cliente("Guadalupe","126",21000.0);
        administradorCliente.agregarCliente(cliente1);
        administradorCliente.agregarCliente(cliente2);
        administradorCliente.agregarCliente(cliente3);
        administradorCliente.agregarCliente(cliente4);
        clientes = administradorCliente.listaClientes();

        for (Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
        Configuracion configuracion = new Configuracion();
        configuracion.setMaxLineaCreditoPorIngresoMensual(4);
        administradorProducto = new AdministradorProducto(configuracion);
        TarjetaCredito tarjetaCredito = new TarjetaCredito(7000);
        CuentaInversion cuentaInversion = new CuentaInversion(1000.0, 0.05,0.15);
        CuentaCheques cuentaCheques = new CuentaCheques(20000,5.0);

        TarjetaCredito tarjetaCredito1 = new TarjetaCredito(8000);
        CuentaInversion cuentaInversion1 = new CuentaInversion(2000.0, 0.05,0.15);
        CuentaCheques cuentaCheques1 = new CuentaCheques(30000,5.0);

        TarjetaCredito tarjetaCredito2 = new TarjetaCredito(9000);
        CuentaInversion cuentaInversion2 = new CuentaInversion(3000.0, 0.05,0.15);
        CuentaCheques cuentaCheques2 = new CuentaCheques(40000,5.0);

        administradorProducto.agregarProducto(cliente1,tarjetaCredito);
        administradorProducto.agregarProducto(cliente1,cuentaCheques);
        administradorProducto.agregarProducto(cliente1,cuentaInversion);

        administradorProducto.agregarProducto(cliente2,tarjetaCredito2);
        administradorProducto.agregarProducto(cliente2,cuentaCheques2);
        administradorProducto.agregarProducto(cliente2,cuentaInversion2);

        administradorProducto.agregarProducto(cliente3,tarjetaCredito1);
        administradorProducto.agregarProducto(cliente3,cuentaCheques1);
        administradorProducto.agregarProducto(cliente3,cuentaInversion1);

        List<ProductoFinanciero> productoFinancieros = administradorProducto.getProductos(3);
        ProductoFinanciero productoFinanciero = null;
        TarjetaCredito tarjetaCreditoSeleccin = null;
        CuentaCheques cuentaChequesSeleccion = null;
        CuentaInversion cuentaInversionSeleccion = null;
        //productoFinancieros.
        //System.out.println(productoFinancieros.get(1).);
        for (ProductoFinanciero producto : productoFinancieros){
            if (producto.obtenerNombreClase().equals("TarjetaCredito")){
                productoFinanciero = producto;
                break;
            }
        }
        System.out.println(productoFinanciero.obtenerNombreClase());
        if(productoFinanciero instanceof TarjetaCredito) {
            System.out.println("verdad");
            tarjetaCreditoSeleccin = (TarjetaCredito) productoFinanciero;
        }else {
            System.out.println("Falso");
        }
        if(productoFinanciero instanceof CuentaInversion) {
            cuentaInversion = (CuentaInversion) productoFinanciero;
            System.out.println("verdad");
        }else {
            System.out.println("Falso");
        }
        if(productoFinanciero instanceof CuentaCheques) {
            System.out.println("verdad");
            cuentaCheques = (CuentaCheques) productoFinanciero;
        }else {
            System.out.println("Falso");
        }
        tarjetaCredito.cargarTarjeta(100);
        //tarjetaCredito.pagarTarjeta(50);
        tarjetaCredito.imprimirEstadoCuenta();
/*
        System.out.println(clientes.contains(cliente1));
        if (clientes.contains(cliente1)){
            //clientes.get(cliente1);
            clientes.indexOf(cliente1);
            System.out.println(clientes.indexOf(cliente4));
        }

 */
    }
}
