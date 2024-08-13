package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.inventarioModelo;

import unah.lenguajes.Restaurante.repositorios.inventarioRepositorio;



@Service
public class inventarioServicio {


    @Autowired
    private inventarioRepositorio inventarioRepositorio;

    public List<inventarioModelo> obtenerTodo()
    {
        return this.inventarioRepositorio.findAll();
    }

     public inventarioModelo crearInvetario(inventarioModelo nvoInventario)
    {
        if(!this.inventarioRepositorio.existsBynombre(nvoInventario.getNombre()))
        {
            return this.inventarioRepositorio.save(nvoInventario);
        } 
        else {
            return null ;
        }
    }
    public boolean deleteInventarioPorNombre (String nombre)
    {
        if (this.inventarioRepositorio.existsBynombre(nombre))
        {
           this.inventarioRepositorio.deleteBynombre(nombre);
           return true;

        }
        else {

            return false;
        }
    }


    public inventarioModelo actualizarInventario(Integer inventarioID ,inventarioModelo inventario)
    {
        if(this.inventarioRepositorio.existsById(inventarioID))
        {
            inventarioModelo inventarioActualizar = this.inventarioRepositorio.findById(inventarioID).get();
            inventarioActualizar.setCantidad(inventario.getCantidad());
            inventarioActualizar.setPreciocompra(inventario.getPreciocompra());

            this.inventarioRepositorio.save(inventarioActualizar);
            return inventarioActualizar;
        } else 
        {
            return null;
        }

    }
}
    

