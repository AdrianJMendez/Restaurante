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

    public void borrarRegistros(Factura factura)
    {
        List<FacturaPlatillo> registros = this.facturaPlatilloRepositorio.findByFactura(factura);

        for (FacturaPlatillo facturaPlatillo : registros) 
        {
            this.facturaPlatilloRepositorio.delete(facturaPlatillo);
        }
    }

    public FacturaPlatillo crearFacturaPlatillo(FacturaPlatillo facturaPlatillo)
    {
        return this.facturaPlatilloRepositorio.save(facturaPlatillo);
    }

}