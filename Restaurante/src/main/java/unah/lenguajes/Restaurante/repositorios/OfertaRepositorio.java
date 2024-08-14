package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Oferta;

@Repository
public interface OfertaRepositorio extends JpaRepository<Oferta, Long>
{
    
}
