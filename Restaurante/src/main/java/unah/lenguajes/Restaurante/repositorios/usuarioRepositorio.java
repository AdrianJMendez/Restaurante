package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import unah.lenguajes.Restaurante.modelos.usuarioModelo;

@Repository
public interface usuarioRepositorio extends JpaRepository<usuarioModelo,Integer>{


    public boolean existsByUser(String user);

    public long deleteByUser(String user);

    public usuarioModelo findByUser(String user);
}
