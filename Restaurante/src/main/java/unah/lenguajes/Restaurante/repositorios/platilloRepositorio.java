package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.platilloModelo;
import java.util.List;


@Repository
public interface platilloRepositorio extends JpaRepository<platilloModelo,Integer>{

    public boolean existsBynombre(String nombre);

    public long deleteBynombre (String nombre);

    public platilloModelo findByNombre(String nombre);

}
