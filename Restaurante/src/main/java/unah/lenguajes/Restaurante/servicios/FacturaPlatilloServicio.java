package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.repositorios.FacturaPlatilloRepositorio;

@Service
public class FacturaPlatilloServicio 
{

    @Autowired
    private FacturaPlatilloRepositorio facturaPlatilloRepositorio;

    public void generarRegistros(Factura factura)
    {
        for(FacturaPlatillo facturaPlatillo : factura.getPlatillos()) 
        {
            System.out.println(facturaPlatillo);
            facturaPlatillo.setFactura(factura);
            //this.facturaPlatilloRepositorio.save(facturaPlatillo);
        }
        
    }
}
