package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.categoriaPermisoModelo;
import unah.lenguajes.Restaurante.modelos.usuarioModelo;
import unah.lenguajes.Restaurante.repositorios.categoriaPermisoRepositorio;
import unah.lenguajes.Restaurante.repositorios.usuarioRepositorio;

@Service
public class usuarioServicio {


    @Autowired
    private usuarioRepositorio usuarioRepositorio;

    @Autowired
    private categoriaPermisoRepositorio categoriaPermisoRepositorio;

    public List<usuarioModelo> obtenerTodos()
    {
        return this.usuarioRepositorio.findAll();

    }

    public usuarioModelo crearUsuario(String user, String contrasena, Integer categoriaPermisoID )
    {
        if(!this.usuarioRepositorio.existsByUser(user))
        {
            categoriaPermisoModelo permiso = categoriaPermisoRepositorio.findById(categoriaPermisoID).get();
            usuarioModelo nvoUsuario = new usuarioModelo();
    
            nvoUsuario.setUser(user);
            nvoUsuario.setContrasena(contrasena);
            nvoUsuario.setCategoriaPermiso(permiso);
            return usuarioRepositorio.save(nvoUsuario);

        }
       else 
       {
        return null;
       }

    

    }

    public boolean deleteUsuario(Integer usuarioid)
    {
        if(this.usuarioRepositorio.existsById(usuarioid))
        {
            this.usuarioRepositorio.deleteById(usuarioid);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteUsuarioByNombre (String user)
    {
        if(this.usuarioRepositorio.existsByUser(user))
        {
            this.usuarioRepositorio.deleteByUser(user);
            return true;
        }
        else{
            return false;
        }
    }
/* 
    public usuarioModelo actualizarUsuario (Integer usuarioid, usuarioModelo usuario)
    {
        if(this.usuarioRepositorio.existsById(usuarioid))
        {
            usuarioModelo usuarioActualizar = this.usuarioRepositorio.findById(usuarioid).get();
            usuarioActualizar.setUser(usuario.getUser());
            usuarioActualizar.setContrasena(usuario.getContrasena());
            usuarioActualizar.setCategoriaPermiso(usuario.getCategoriaPermiso());
            
            this.usuarioRepositorio.save(usuarioActualizar);
            return usuarioActualizar;

        }
        else 
        {
            return null;
        }*/
        public usuarioModelo actualizarUsuario (Integer usuarioid, String user, String contrasena, Integer categoriaPermisoID)
        {
            if (this.usuarioRepositorio.existsById(usuarioid))
            {
                usuarioModelo usuarioActualizar = this.usuarioRepositorio.findById(usuarioid).get();
                categoriaPermisoModelo permiso = categoriaPermisoRepositorio.findById(categoriaPermisoID).get();
                usuarioActualizar.setUser(user);
                usuarioActualizar.setContrasena(contrasena);
                usuarioActualizar.setCategoriaPermiso(permiso);

                this.usuarioRepositorio.save(usuarioActualizar);
                return usuarioActualizar;

            } else{
                return null;
            }
            
    
        }

    }

