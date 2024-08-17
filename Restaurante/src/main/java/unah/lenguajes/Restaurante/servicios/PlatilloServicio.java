package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.Platillo;
import unah.lenguajes.Restaurante.repositorios.PlatilloRepositorio;

@Service
public class PlatilloServicio 
{
    @Autowired
    private PlatilloRepositorio platilloRepositorio;

    @Autowired
    private InventarioPlatilloServicio inventarioPlatilloServicio;

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

    public String borrarPlatilloPorId(long platilloId)
    {
        if (this.platilloRepositorio.existsById(platilloId)) 
        {
            Platillo platillo = this.platilloRepositorio.findById(platilloId).get();

            this.inventarioPlatilloServicio.borrarRegistros(platillo);

            this.platilloRepositorio.deleteById(platilloId);

            return "Platillo eliminado";
        }

        return null;
    }

    public Platillo actualizarPlatillo(long platilloId, Platillo platillo)
    {
        if (this.platilloRepositorio.existsById(platilloId)) 
        {
            Platillo platilloActualizar = this.platilloRepositorio.findById(platilloId).get();    

            platilloActualizar.setPrecio(platillo.getPrecio());
            platilloActualizar.setNombre(platillo.getNombre());

            this.inventarioPlatilloServicio.borrarRegistros(platilloActualizar);

            platilloActualizar.setInventarios(platillo.getInventarios());

            for(InventarioPlatillo inventarioPlatillo : platilloActualizar.getInventarios()) 
            {
                inventarioPlatillo.setPlatillo(platilloActualizar);
            }

            return this.platilloRepositorio.save(platilloActualizar);
        }

        return null;
    }
}
