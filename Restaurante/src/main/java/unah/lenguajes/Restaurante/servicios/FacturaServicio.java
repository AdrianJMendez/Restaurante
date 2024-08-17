package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Cliente;
import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.modelos.Inventario;
import unah.lenguajes.Restaurante.modelos.InventarioPlatillo;
import unah.lenguajes.Restaurante.modelos.Platillo;
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
    private InventarioServicio inventarioServicio;

    @Autowired
    private PlatilloServicio platilloServicio;

    public List<Factura> obtenerTodasFacturas()
    {
        return this.facturaRepositorio.findAll();
    }

    public Factura crearFactura(Factura factura)
    {

        double subtotalFactura = 0;
        Factura nuevaFactura = this.facturaRepositorio.save(factura);


        for(FacturaPlatillo facturaPlatillo : nuevaFactura.getPlatillos()) 
        {
            facturaPlatillo.setFactura(nuevaFactura);

            //ForEach interno para consumir el inventario por los platillos a facturar

            //Se busca el platillo para acceder a la cantidad de inventario que gasta
            Platillo platillo = this.platilloServicio.buscarPlatilloPorId(facturaPlatillo.getPlatillo().getPlatilloId());

            //Se calcula el precio total por platillo
            facturaPlatillo.setPrecioTotal(facturaPlatillo.getCantidad() * platillo.getPrecio());
            //Y se agrega al total de la factura
            subtotalFactura+= facturaPlatillo.getPrecioTotal();


            for (InventarioPlatillo inventarioPlatillo : platillo.getInventarios()) 
            {
                Inventario inventario = this.inventarioServicio.obtenerInventarioPorId(inventarioPlatillo.getInventario().getInventarioId());

                //La cantidad de platillo que se factura POR la cantidad de inventario que consume ese platillo
                double inventarioAGastar = facturaPlatillo.getCantidad() * inventarioPlatillo.getCantidad();
                inventario.setCantidad(inventario.getCantidad() - inventarioAGastar);

                this.inventarioServicio.actualizarInventario(inventario.getInventarioId(), inventario);
                
            }
        }

        if(this.facturaRepositorio.countByCliente(nuevaFactura.getCliente()) >= 10)
        {
            subtotalFactura = subtotalFactura - (0.10 * subtotalFactura);
        }

        nuevaFactura.setImpuesto(subtotalFactura * 0.25);
        nuevaFactura.setTotal(subtotalFactura + nuevaFactura.getImpuesto());
        return this.facturaRepositorio.save(nuevaFactura);
    }


    //actualizar la factura no actualiza los cambios en la tabla inventarios
    //mejor borrar la factura y volverla a crear
    public Factura actualizarFactura(Long facturaId, Factura factura)
    {
        if(this.facturaRepositorio.existsById(facturaId))
        {
            Factura facturaActualizar = this.facturaRepositorio.findById(facturaId).get();

            facturaActualizar.setCliente(factura.getCliente());
            facturaActualizar.setUsuario(factura.getUsuario());
            facturaActualizar.setOferta(factura.getOferta());

            this.facturaPlatilloServicio.borrarRegistros(facturaActualizar);
            facturaActualizar.setPlatillos(factura.getPlatillos());

            for(FacturaPlatillo facturaPlatillo : facturaActualizar.getPlatillos()) 
            {
                facturaPlatillo.setFactura(facturaActualizar);
            }

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


            //Se revierten los cambios en la tabla de inventarios
            for(FacturaPlatillo facturaPlatillo : factura.getPlatillos()) 
            {
                //ForEach interno para revertir los cambios en el inventario por los platillos a facturar
                //Se busca el platillo para acceder a la cantidad de inventario que gasta
                Platillo platillo = this.platilloServicio.buscarPlatilloPorId(facturaPlatillo.getPlatillo().getPlatilloId());

                for (InventarioPlatillo inventarioPlatillo : platillo.getInventarios()) 
                {
                    Inventario inventario = this.inventarioServicio.obtenerInventarioPorId(inventarioPlatillo.getInventario().getInventarioId());

                    //La cantidad de platillo que se factura POR la cantidad de inventario que consume ese platillo
                    double inventarioAGastar = facturaPlatillo.getCantidad() * inventarioPlatillo.getCantidad();
                    inventario.setCantidad(inventario.getCantidad() + inventarioAGastar);

                    this.inventarioServicio.actualizarInventario(inventario.getInventarioId(), inventario);
                
                }
            }



            //Se borran los registros en la tabla transaccional
            this.facturaPlatilloServicio.borrarRegistros(factura);

            //Se borra el registro de la factura
            this.facturaRepositorio.deleteById(facturaId);  
            
            return "factura eliminada";
        }
        return null;
    }

    public List<Factura> buscarFacturaPorClienteId(Long clienteId)
    {
        Cliente cliente = this.clienteServicio.buscarClientePorId(clienteId);

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
