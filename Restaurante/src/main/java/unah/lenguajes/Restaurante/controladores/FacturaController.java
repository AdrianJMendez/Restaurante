package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.servicios.FacturaServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





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

    @GetMapping("/obtener/cliente/{clienteId}")
    public List<Factura> buscarFacturaPorClienteId(@PathVariable(name = "clienteId") Integer clienteId) 
    {
        return this.facturaServicio.buscarFacturaPorClienteId(clienteId);
    }

    @GetMapping("/obtener/{facturaId}")
    public Factura buscarFacturaPorId(@PathVariable(name = "facturaId") long facturaId) 
    {
        return this.facturaServicio.buscarFacturaPorId(facturaId);
    }

    @GetMapping("/obtener/cliente/nombre/{nombreCliente}")
    public List<Factura> buscarFacturaPorNombreCliente(@PathVariable(name = "nombreCliente") String nombreCliente) 
    {
        return this.facturaServicio.buscarFacturaPorNombreCliente(nombreCliente);
    }
    
    
    
        
    @PostMapping("/crear")
    public Factura crearFactura(@RequestBody Factura nuevaFactura) 
    {   
        return this.facturaServicio.crearFactura(nuevaFactura);
    }

    @PutMapping("actualizar/{facturaId}")
    public Factura actualizarFactura(@PathVariable(name = "facturaId") Long facturaId, @RequestBody Factura factura) 
    {
        
        return this.facturaServicio.actualizarFactura(facturaId, factura);
    }

    @DeleteMapping("borrar/{facturaId}")
    public String borrarFactura(@PathVariable(name = "facturaId") Long facturaId)
    {
        return this.facturaServicio.borrarFactura(facturaId);
    }
    
}