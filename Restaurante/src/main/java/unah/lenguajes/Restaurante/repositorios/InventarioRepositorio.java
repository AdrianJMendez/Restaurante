package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Inventario;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Long>
{
    
}
