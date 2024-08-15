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

    @PostMapping("/crear")
    public usuarioModelo crearUsuario(@RequestBody userDTO nvoUsuario) {
        
        return this.usuarioServicio.crearUsuario(nvoUsuario.getUser(),nvoUsuario.getContrasena(),nvoUsuario.getCategoriapermiso());
    }

    @DeleteMapping("/borrar/id/{id}") 
    public boolean borrarPlatillo(@PathVariable(name="id") int id)
    {
        return this.usuarioServicio.deleteUsuario(id);
    }

    @PutMapping("/actualizar/id/{id}")
    public  usuarioModelo actualizarPorID(@PathVariable(name="id") Integer id, @RequestBody usuarioModelo usuario) {
        
        
        return this.usuarioServicio.actualizarUsuario(id, usuario);
    }


}
