package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.OrdenCompra;

@Repository
public interface OrdenCompraRepositorio extends JpaRepository<OrdenCompra, Long>
{
    
}