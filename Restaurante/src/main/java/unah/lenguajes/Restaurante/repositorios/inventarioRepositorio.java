package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.inventarioModelo;

@Repository

public interface inventarioRepositorio extends JpaRepository <inventarioModelo, Integer> {

    public boolean existsBynombre(String nombre);
    
    public long deleteBynombre(String nombre);

    public inventarioModelo findBynombre(String nombre);

}
