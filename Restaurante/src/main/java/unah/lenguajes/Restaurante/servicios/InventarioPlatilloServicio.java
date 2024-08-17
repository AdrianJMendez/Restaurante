package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.Platillo;
import unah.lenguajes.Restaurante.repositorios.InventarioPlatilloRepositorio;

@Service
public class InventarioPlatilloServicio 
{
    @Autowired
    private InventarioPlatilloRepositorio inventarioPlatilloRepositorio;

    public void borrarRegistros(Platillo platillo)
    {
        List<InventarioPlatillo> registros = this.inventarioPlatilloRepositorio.findByPlatillo(platillo);

        for (InventarioPlatillo inventarioPlatillo : registros) 
        {
            this.inventarioPlatilloRepositorio.deleteById(inventarioPlatillo.getId());    
        }

    }
}
