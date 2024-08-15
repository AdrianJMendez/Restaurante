package unah.lenguajes.Restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Usuario;
import unah.lenguajes.Restaurante.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio 
{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario crearUsuario(Usuario usuario)
    {
        return this.usuarioRepositorio.save(usuario);
    }
}
