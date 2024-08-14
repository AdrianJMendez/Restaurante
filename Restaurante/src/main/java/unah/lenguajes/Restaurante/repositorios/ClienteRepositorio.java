package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>
{
    
}
