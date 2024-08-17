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

import unah.lenguajes.Restaurante.modelos.inventarioModelo;
import unah.lenguajes.Restaurante.servicios.inventarioServicio;



@RestController
@RequestMapping("/api/restaurante/inventario")
public class inventarioController {

    @Autowired
    private inventarioServicio inventarioServicio;

        @GetMapping("/todos")
        public List<inventarioModelo> obtenerTodos()
        {
            return this.inventarioServicio.obtenerTodo();
        }
        
        @GetMapping("/prueba")
        public String prueba() 
        {
            return "hola Inventario";
        }

        @PostMapping("/crear")
        public inventarioModelo crearInventario(@RequestBody inventarioModelo nvoInventario)
        {
            return this.inventarioServicio.crearInvetario(nvoInventario);
        }
        @DeleteMapping("/borrar/nombre/{name}")
       public boolean borrarClienteNombre(@PathVariable(name="name") String name)
        {
            return this.inventarioServicio.deleteInventarioPorNombre(name);
        }

        @DeleteMapping("/borrar/id/{id}")
        public boolean borrarCliente(@PathVariable(name="id") Integer id)
        {
            return this.inventarioServicio.deleteInventario(id);
        }

        @PutMapping("/actualizar/id/{id}")
         public inventarioModelo actualizarInventarioID(@PathVariable(name="id") Integer id, @RequestBody inventarioModelo inventario) 
         {
           return this.inventarioServicio.actualizarInventario(id, inventario);
         }

         @PutMapping("/actualizar/nombre/{nombre}")
         public inventarioModelo actualizarInventarioID(@PathVariable(name="nombre") String nombre, @RequestBody inventarioModelo inventario) 
         {
           return this.inventarioServicio.actualizarInventarioPorNombre(nombre, inventario);
         }

}
