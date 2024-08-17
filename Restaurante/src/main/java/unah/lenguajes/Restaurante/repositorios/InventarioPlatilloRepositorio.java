package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.InventarioPlatilloKey;

@Repository
public interface InventarioPlatilloRepositorio extends JpaRepository<InventarioPlatillo, InventarioPlatilloKey>
{
    
}
