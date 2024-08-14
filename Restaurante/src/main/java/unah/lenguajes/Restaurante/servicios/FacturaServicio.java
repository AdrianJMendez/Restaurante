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
    private FacturaPlatilloRepositorio facturaPlatilloRepositorio;

    public List<Factura> obtenerTodasFacturas()
    {
        return this.facturaRepositorio.findAll();
    }

    public Factura crearFactura(Factura factura)
    {
        //this.facturaPlatilloServicio.generarRegistros(factura);
        this.facturaRepositorio.save(factura);
        for(FacturaPlatillo facturaPlatillo : factura.getPlatillos()) 
        {
            
            facturaPlatillo.setFactura(factura);
            //this.facturaPlatilloRepositorio.save(facturaPlatillo);
            //System.out.println(facturaPlatillo);
        }
        return this.facturaRepositorio.save(factura);
    }
}
