package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.categoriaPermisoModelo;

@Repository
public interface categoriaPermisoRepositorio extends JpaRepository <categoriaPermisoModelo, Integer>{

}
