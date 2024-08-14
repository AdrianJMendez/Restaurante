package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.clienteModelo;

import unah.lenguajes.Restaurante.servicios.clienteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/restaurante/cliente")

public class clienteController {

        @Autowired
        private clienteServicio clienteServicio;

        @GetMapping("/todos")
        public List<clienteModelo> obtenerTodos()
        {
            return this.clienteServicio.obtenerTodos();
        }

        @GetMapping("/prueba")
        public String getMethodName() {
            return "hola cliente";
        }
        @PostMapping("/crear")
       public clienteModelo crearCliente(@RequestBody clienteModelo nvoCliente)
       {
        return this.clienteServicio.crearCliente(nvoCliente);
       }
       @DeleteMapping("/borrar/id/{id}")
       public boolean borrarCliente (@PathVariable(name="id") int id)
       {
            return this.clienteServicio.deleteCliente(id);
       }
       @DeleteMapping("/borrar/dni/{dni}")
       public boolean borrarClienteDNI (@PathVariable (name="dni") String dni)
       {
        return this.clienteServicio.deleteClientePorDNI(dni);
       }

       @PutMapping("/actualizar/id/{id}")
       public clienteModelo actualizarClienteID(@PathVariable(name="id") Integer id, @RequestBody clienteModelo cliente) {
     
        return this.clienteServicio.actualizar(id, cliente);
       }

       
       @PutMapping("/actualizar/dni/{dni}")
       public clienteModelo actualizarClienteDNI(@PathVariable(name="dni") String dni, @RequestBody clienteModelo cliente) {
     
           return this.clienteServicio.actualizarPorDNI(dni, cliente);
       }


}
