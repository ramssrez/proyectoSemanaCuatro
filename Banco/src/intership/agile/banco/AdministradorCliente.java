package intership.agile.banco;

import java.util.ArrayList;
import java.util.List;

public class AdministradorCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public AdministradorCliente() {
    }

    public void agregarCliente(Cliente cliente){
        System.out.println("****** agregar cliente");
        clientes.add(cliente);
    }
    public List<Cliente> listaClientes(){
        System.out.println("****** lista cliente");
        return clientes;
    }
    public Cliente getCliente(Cliente cliente){
        return clientes.get(cliente.getIdCliente());
    }
}
