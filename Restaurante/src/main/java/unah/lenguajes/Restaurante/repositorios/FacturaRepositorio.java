package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Factura;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>
{
    
}
