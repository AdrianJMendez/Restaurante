package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.OrdenCompra;
import unah.lenguajes.Restaurante.servicios.OrdenCompraServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraController 
{

    @Autowired
    private OrdenCompraServicio ordenCompraServicio;

    @GetMapping("/obtener/todos")
    public List<OrdenCompra> obtenerTodosOrdenCompra() 
    {
        return this.ordenCompraServicio.obtenerTodosOrdenCompra();
    }
    
    @PostMapping("/crear")
    public OrdenCompra crearOrdenCompra(@RequestBody OrdenCompra ordenCompra) 
    {
        return this.ordenCompraServicio.crearOrdenCompra(ordenCompra);
    }
    
    @DeleteMapping("/borrar/{ordenCompraId}")
    public String borrarOrdenCompraPorId(@PathVariable(name = "ordenCompraId") long ordenCompraId)
    {
        return this.ordenCompraServicio.borrarOrdenCompra(ordenCompraId);
    }
}