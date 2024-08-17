package unah.lenguajes.Restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.Platillo;
import unah.lenguajes.Restaurante.servicios.PlatilloServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/platillo")
public class PlatilloController 
{
    @Autowired
    private PlatilloServicio platilloServicio;

    @GetMapping("/obtener/todos")
    public List<Platillo> obtenerTodosPlatillos()
    {
        return this.platilloServicio.obtenerTodosPlatillos();
    }

    @PostMapping("/crear")
    public Platillo crearPlatillo(@RequestBody Platillo platillo) 
    {
        return this.platilloServicio.crearPlatillo(platillo);
    }
    
}
