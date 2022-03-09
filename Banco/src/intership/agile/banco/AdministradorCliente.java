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
    public Cliente getCliente(Cliente cliente){
        return clientes.get(cliente.getIdCliente());
    }
}
