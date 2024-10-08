package unah.lenguajes.Restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.dto.userDTO;
import unah.lenguajes.Restaurante.modelos.usuarioModelo;

import unah.lenguajes.Restaurante.servicios.usuarioServicio;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/restaurante/usuario")

public class usuarioController {

    @Autowired
    private usuarioServicio usuarioServicio;

    @GetMapping("/todos")
    public List<usuarioModelo> obtenerTodos()
    {
        return this.usuarioServicio.obtenerTodos();
    }

<<<<<<< HEAD
    @GetMapping("/unos/{id}")
    public usuarioModelo obtenerPorDni(@PathVariable Integer id)
    {
        return this.usuarioServicio.obtenerPorDni(id);
    }
=======
    @GetMapping("/obtener/user/{user}")
    public usuarioModelo buscarUsuarioPorNombre(@PathVariable(name = "user") String user) 
    {
        return this.usuarioServicio.buscarUsuarioPorNombre(user);
    }
    
>>>>>>> 4373df570394b7027bcad4090b36368e4ab893b5

    @PostMapping("/crear")
    public usuarioModelo crearUsuario(@RequestBody userDTO nvoUsuario) {
        
        return this.usuarioServicio.crearUsuario(nvoUsuario.getUser(),nvoUsuario.getContrasena(),nvoUsuario.getCategoriapermiso());
    }

    @DeleteMapping("/borrar/id/{id}") 
    public boolean borrarUsuario(@PathVariable(name="id") int id)
    {
        return this.usuarioServicio.deleteUsuario(id);
    }
    @DeleteMapping("/borrar/user/{user}") 
    public boolean borrarUsuarioPorNombre(@PathVariable(name="user") String user)
    {
        return this.usuarioServicio.deleteUsuarioByNombre(user);
    }

    @PutMapping("/actualizar/id/{id}")
    public  usuarioModelo actualizarPorID(@PathVariable(name="id") Integer id, @RequestBody userDTO usuario) {
        
        
        return this.usuarioServicio.actualizarUsuario(id, usuario.getUser(),usuario.getContrasena(),usuario.getCategoriapermiso());
    }


}
