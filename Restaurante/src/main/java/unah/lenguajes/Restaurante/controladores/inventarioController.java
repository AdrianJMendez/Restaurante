package unah.lenguajes.Restaurante.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.clienteModelo;
import unah.lenguajes.Restaurante.modelos.inventarioModelo;
import unah.lenguajes.Restaurante.servicios.inventarioServicio;

@RestController
@RequestMapping("/api/restaurante/inventario")
public class inventarioController {

    @Autowired
    private inventarioServicio inventarioServicio;

        @GetMapping("/prueba")
        public String getMethodName() {
            return "hola Inventario";
        }

        @PostMapping("/crear")
        public inventarioModelo crearCliente(@RequestBody inventarioModelo nvoInventario)
        {
            return this.inventarioServicio.crearInvetario(nvoInventario);
        }


}
