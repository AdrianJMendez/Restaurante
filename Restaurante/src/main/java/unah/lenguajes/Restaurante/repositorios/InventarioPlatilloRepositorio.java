package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.InventarioPlatilloKey;
import unah.lenguajes.Restaurante.modelos.Platillo;

import java.util.List;


@Repository
public interface InventarioPlatilloRepositorio extends JpaRepository<InventarioPlatillo, InventarioPlatilloKey>
{
    public List<InventarioPlatillo> findByPlatillo(Platillo platillo);   
}
