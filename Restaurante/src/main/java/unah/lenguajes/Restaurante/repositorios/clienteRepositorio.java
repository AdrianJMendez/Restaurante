package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.clienteModelo;
import java.util.List;


@Repository
public interface clienteRepositorio extends JpaRepository <clienteModelo,Integer> {

    public boolean existsByidentificacion(String identificacion);

    public long deleteByidentificacion(String identificacion);

    //public clienteModelo findByidentificacion (String identificacion);

    public clienteModelo findByidentificacion(String identificacion);

}
