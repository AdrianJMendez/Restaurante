package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
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
    private ClienteServicio clienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    public List<Factura> obtenerTodasFacturas()
    {
        return this.facturaRepositorio.findAll();
    }

    //Si en el objeto factura los objetos dentro llevan un ID que no existe, crea el objeto
    //si el ID ya existe, no crea nada
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
            //Factura facturaActualizar = this.facturaRepositorio.findById(facturaId).get();
            factura.setFacturaId(facturaId);
            return this.facturaRepositorio.save(factura);
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
}
