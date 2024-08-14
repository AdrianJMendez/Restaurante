package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.modelos.FacturaPlatilloKey;

@Repository
public interface FacturaPlatilloRepositorio extends JpaRepository<FacturaPlatillo, FacturaPlatilloKey>
{
    
}
