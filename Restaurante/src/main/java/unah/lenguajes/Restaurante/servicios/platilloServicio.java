package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import unah.lenguajes.Restaurante.modelos.platilloModelo;
import unah.lenguajes.Restaurante.repositorios.platilloRepositorio;

@Service
public class platilloServicio {

    @Autowired
    private platilloRepositorio platilloRepositorio;

    public List<platilloModelo> obtenerTodos()
    {
        return this.platilloRepositorio.findAll();
    }


    public platilloModelo crearPlatillo(platilloModelo nvoPlatillo)
    {
        if(!this.platilloRepositorio.existsBynombre(nvoPlatillo.getNombre()))
        {
            return this.platilloRepositorio.save(nvoPlatillo);
        } 
        else {
            return null ;
        }
    }

    public boolean deletePlatillo (Integer platilloID)
    {
        if(this.platilloRepositorio.existsById(platilloID))
        {
            this.platilloRepositorio.deleteById(platilloID);
            return true;
        } 
        else 
        {
            return false;
        }
    }

    @Transactional
    public boolean deletePlatilloPorNombre (String nombre)
    {
        if (this.platilloRepositorio.existsBynombre(nombre))
        {
           this.platilloRepositorio.deleteBynombre(nombre);
           return true;
        }
        else {
            return false;
        }
    }

    public platilloModelo actualizarPlatillo(Integer platilloID ,platilloModelo platillo)
    {
        if(this.platilloRepositorio.existsById(platilloID))
        {
            platilloModelo platilloActualizar = this.platilloRepositorio.findById(platilloID).get();
            platilloActualizar.setNombre(platillo.getNombre());
            platilloActualizar.setPrecio(platillo.getPrecio());
            platilloActualizar.setImagen(platillo.getImagen());
            this.platilloRepositorio.save(platilloActualizar);
            return platilloActualizar;
        } else 
        {
            return null;
        }

    }

    public platilloModelo actualizarPlatilloPorNombre(String nombre ,platilloModelo platillo)
    {
        if(this.platilloRepositorio.existsBynombre(nombre))
        {
            platilloModelo platilloActualizar = this.platilloRepositorio.findByNombre(nombre);
            platilloActualizar.setNombre(platillo.getNombre());
            platilloActualizar.setPrecio(platillo.getPrecio());
            platilloActualizar.setImagen(platillo.getImagen());
            this.platilloRepositorio.save(platilloActualizar);
            return platilloActualizar;
        } else 
        {
            return null;
        }

    }
}
