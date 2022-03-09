package intership.agile.banco;

import java.util.ArrayList;
import java.util.List;

public class AdministradorCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public AdministradorCliente() {
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public List<Cliente> listaClientes(){
        return clientes;
    }
    public Cliente getCliente(int valor, List<Cliente> clientes){
        Cliente cliente = null;
        for (Cliente cli : clientes){
            if (cli.getIdCliente() == valor){
                cliente = cli;
            }
        }
        return cliente;
    }
}
