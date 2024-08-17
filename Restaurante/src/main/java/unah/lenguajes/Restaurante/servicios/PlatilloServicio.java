package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.Platillo;
import unah.lenguajes.Restaurante.repositorios.PlatilloRepositorio;

@Service
public class PlatilloServicio 
{
    @Autowired
    private PlatilloRepositorio platilloRepositorio;

    public List<Platillo> obtenerTodosPlatillos()
    {
        return this.platilloRepositorio.findAll();
    }

    public Platillo crearPlatillo(Platillo platillo)
    {
        Platillo nuevoPlatillo = this.platilloRepositorio.save(platillo);
        for (InventarioPlatillo inventarioPlatillo : nuevoPlatillo.getInventarios()) 
        {
            inventarioPlatillo.setPlatillo(nuevoPlatillo);
        }
        return this.platilloRepositorio.save(nuevoPlatillo);
    }

    public Platillo buscarPlatilloPorId(long platilloId)
    {
        if(this.platilloRepositorio.existsById(platilloId))
        {
            return this.platilloRepositorio.findById(platilloId).get();
        }
        return null;
    }
}
