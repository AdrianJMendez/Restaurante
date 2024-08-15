package unah.lenguajes.Restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Cliente;
import unah.lenguajes.Restaurante.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio 
{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente crearCliente(Cliente cliente)
    {
        return this.clienteRepositorio.save(cliente);
    }
}
