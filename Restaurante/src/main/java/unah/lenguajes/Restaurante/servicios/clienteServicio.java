package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.clienteModelo;
import unah.lenguajes.Restaurante.repositorios.clienteRepositorio;

@Service
public class clienteServicio {


    @Autowired
    private clienteRepositorio clienteRepositorio;

    public List<clienteModelo> obtenerTodos(){
        return this.clienteRepositorio.findAll();
    }

    public clienteModelo crearCliente (clienteModelo nvoCliente)
    {
        if (this.clienteRepositorio.existsByidentificacion(nvoCliente.getIdentificacion()))
        {
            return this.clienteRepositorio.save(nvoCliente);
        } 
        else {
            return null;
        }
    }

    public boolean deleteClientePorDNI (String dni)
    {
        if (this.clienteRepositorio.existsByidentificacion(dni))
        {
           this.clienteRepositorio.deleteByidentificacion(dni);
           return true;

        }
        else {

            return false;
        }
    }

    public boolean deleteCliente( Integer clienteId)
    {

        if(this.clienteRepositorio.existsById(clienteId)){
            this.clienteRepositorio.deleteById(clienteId);
            return true;

        } 
        else 
        {
            return false;
        }
    }

    public clienteModelo actualizar (Integer clienteID, clienteModelo cliente)
    {
        if(this.clienteRepositorio.existsById(clienteID)){

            clienteModelo clienteActualizar = this.clienteRepositorio.findById(clienteID).get();
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setIdentificacion(cliente.getIdentificacion());
            this.clienteRepositorio.save(clienteActualizar);
            return clienteActualizar;
        } 
        else
         {
            return null;
        }
    }

    public clienteModelo actualizarPorDNI (String dni, clienteModelo cliente)
    {
        if(this.clienteRepositorio.existsByidentificacion(dni)){

            clienteModelo clienteActualizar = this.clienteRepositorio.findByidentificacion(dni);
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setIdentificacion(cliente.getIdentificacion());
            this.clienteRepositorio.save(clienteActualizar);
            return clienteActualizar;
        } 
        else
         {
            return null;
        }
    }
}
