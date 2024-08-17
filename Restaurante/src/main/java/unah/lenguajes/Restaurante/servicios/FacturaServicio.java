package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.modelos.clienteModelo;
import unah.lenguajes.Restaurante.repositorios.FacturaPlatilloRepositorio;
import unah.lenguajes.Restaurante.repositorios.FacturaRepositorio;

@Service
public class FacturaServicio 
{
    @Autowired
    private FacturaRepositorio facturaRepositorio;

    @Autowired
    private FacturaPlatilloServicio facturaPlatilloServicio;

    @Autowired
    private clienteServicio clienteServicio;

    @Autowired
    private usuarioServicio usuarioServicio;

    public List<Factura> obtenerTodasFacturas()
    {
        return this.facturaRepositorio.findAll();
    }

    public Factura crearFactura(Factura factura)
    {
        Factura nuevaFactura = this.facturaRepositorio.save(factura);
        for(FacturaPlatillo facturaPlatillo : nuevaFactura.getPlatillos()) 
        {
            facturaPlatillo.setFactura(nuevaFactura);

            //this.facturaPlatilloServicio.crearFacturaPlatillo(facturaPlatillo);
        }
        return this.facturaRepositorio.save(nuevaFactura);
    }

    public Factura actualizarFactura(Long facturaId, Factura factura)
    {
        if(this.facturaRepositorio.existsById(facturaId))
        {
            Factura facturaActualizar = this.facturaRepositorio.findById(facturaId).get();

            facturaActualizar.setCliente(factura.getCliente());
            facturaActualizar.setUsuario(factura.getUsuario());
            facturaActualizar.setOferta(factura.getOferta());
            //Falta hacer que funcione bien a la hora de modificar la tabla transaccional
            //facturaActualizar.setPlatillos(factura.getPlatillos());

            facturaActualizar.setFecha(factura.getFecha());
            facturaActualizar.setMetodoDePago(factura.getMetodoDePago());
            facturaActualizar.setImpuesto(factura.getImpuesto());
            facturaActualizar.setTotal(factura.getTotal());

            return this.facturaRepositorio.save(facturaActualizar);
        }
        return null;
    }

    public String borrarFactura(Long facturaId)
    {
        if (this.facturaRepositorio.existsById(facturaId)) 
        {
            Factura factura = this.facturaRepositorio.findById(facturaId).get();

            this.facturaPlatilloServicio.borrarRegistros(factura);

            this.facturaRepositorio.deleteById(facturaId);  
            
            return "factura eliminada";
        }
        return null;
    }

    public List<Factura> buscarFacturaPorClienteId(Integer clienteId)
    {
        clienteModelo cliente = this.clienteServicio.buscarClientePorId(clienteId);
        

        if(cliente != null)
        {
            return this.facturaRepositorio.findByCliente(cliente);
        }

        return null;
        
    }

    public Factura buscarFacturaPorId(long facturaId)
    {
        if(this.facturaRepositorio.existsById(facturaId))
        {
            return this.facturaRepositorio.findById(facturaId).get();
        }
        return null;
    }
}