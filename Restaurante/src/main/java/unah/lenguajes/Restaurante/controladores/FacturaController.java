package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.servicios.FacturaServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/factura")
public class FacturaController 
{

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/obtener/todos")
    public List<Factura> obtenerTodasFacturas() 
    {
        return this.facturaServicio.obtenerTodasFacturas();
    }
        
    @PostMapping("/crear")
    public Factura crearFactura(@RequestBody Factura nuevaFactura) 
    {   
        return this.facturaServicio.crearFactura(nuevaFactura);
    }
    
}
