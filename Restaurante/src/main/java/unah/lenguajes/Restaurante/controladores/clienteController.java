package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.servicios.clienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/restaurante/cliente")

public class clienteController {

        @Autowired
        private clienteServicio clienteServicio;

        @GetMapping("/prueba")
        public String getMethodName() {
            return "hola cliente";
        }
        

}
