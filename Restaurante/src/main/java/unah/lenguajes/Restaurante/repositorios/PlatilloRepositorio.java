package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Platillo;

@Repository
public interface PlatilloRepositorio extends JpaRepository<Platillo, Long>
{
    
}
