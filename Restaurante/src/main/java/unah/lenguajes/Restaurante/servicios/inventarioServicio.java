package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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

    public inventarioModelo obtenerInventarioPorId(Integer inventarioId)
    {
        if(this.inventarioRepositorio.existsById(inventarioId))
        {
            return this.inventarioRepositorio.findById(inventarioId).get();
        }
        return null;
    }

    public inventarioModelo obtenerInventarioPorNombre(String nombre)
    {
        return this.inventarioRepositorio.findBynombre(nombre);
    }

    @Transactional
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

    public boolean deleteInventario (Integer id)
    {
        if (this.inventarioRepositorio.existsById(id))
        {
            this.inventarioRepositorio.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }


    public inventarioModelo actualizarInventario(Integer inventarioID ,inventarioModelo inventario)
    {
        if(this.inventarioRepositorio.existsById(inventarioID))
        {
            inventarioModelo inventarioActualizar = this.inventarioRepositorio.findById(inventarioID).get();
            double cantidad = inventario.getCantidad();
            cantidad = cantidad + inventario.getCantidad();
            inventarioActualizar.setCantidad(cantidad);
            inventarioActualizar.setPreciocompra(inventario.getPreciocompra());

            this.inventarioRepositorio.save(inventarioActualizar);
            return inventarioActualizar;
        } else 
        {
            return null;
        }
    
    }
    public inventarioModelo actualizarInventarioPorNombre(String nombre, inventarioModelo inventario)
    {
        if(this.inventarioRepositorio.existsBynombre(nombre))
        {
            inventarioModelo inventarioActualizar = this.inventarioRepositorio.findBynombre(nombre);
            double cantidad = inventario.getCantidad();
            cantidad = cantidad + inventario.getCantidad();
            inventarioActualizar.setCantidad(cantidad);
            inventarioActualizar.setPreciocompra(inventario.getPreciocompra());
            this.inventarioRepositorio.save(inventarioActualizar);
            return inventarioActualizar;
        }
        else
        {
            return null;

        }
    }
}
    

