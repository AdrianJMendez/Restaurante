package unah.lenguajes.Restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.platilloModelo;
import unah.lenguajes.Restaurante.servicios.platilloServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/restaurante/platillo")

public class platilloController {

    @Autowired
    private platilloServicio platilloServicio;

    @GetMapping("/todos")
    public List<platilloModelo> obtenerTodos()
    {
        return this.platilloServicio.obtenerTodos();
    }

    @PostMapping("/crear")
    public platilloModelo crearPlatilloModelo(@RequestBody platilloModelo nvoPlatillo) {
        
        return this.platilloServicio.crearPlatillo(nvoPlatillo);
    }

    @DeleteMapping("/borrar/id/{id}") 
    public boolean borrarPlatillo(@PathVariable(name="id") int id)
    {
        return this.platilloServicio.deletePlatillo(id);
    }

    @DeleteMapping("/borrar/nombre/{nombre}") 
    public boolean borrarPlatilloNombre(@PathVariable(name="nombre") String nombre)
    {
        return this.platilloServicio.deletePlatilloPorNombre(nombre);
    }

    @PutMapping("/actualizar/id/{id}")
    public  platilloModelo actualizarPorID(@PathVariable(name="id") Integer id, @RequestBody platilloModelo platillo) {
        
        
        return this.platilloServicio.actualizarPlatillo(id, platillo);
    }

    @PutMapping("/actualizar/nombre/{nombre}")
    public  platilloModelo actualizarPorNombre(@PathVariable(name="nombre") String nombre, @RequestBody platilloModelo platillo) {
        
        
        return this.platilloServicio.actualizarPlatilloPorNombre(nombre, platillo);
    }


    
    
    

}
