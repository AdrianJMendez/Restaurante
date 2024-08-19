package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.OrdenCompra;
import unah.lenguajes.Restaurante.modelos.inventarioModelo;
import unah.lenguajes.Restaurante.repositorios.OrdenCompraRepositorio;

@Service
public class OrdenCompraServicio 
{

    @Autowired
    private OrdenCompraRepositorio ordenCompraRepositorio;

    @Autowired
    private inventarioServicio inventarioServicio;

    public List<OrdenCompra> obtenerTodosOrdenCompra()
    {
        return this.ordenCompraRepositorio.findAll();
    }

    public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra)
    {
        inventarioModelo inventario = this.inventarioServicio.obtenerInventarioPorId(ordenCompra.getInventario().getInventarioId());
        inventario.setCantidad(inventario.getCantidad() + ordenCompra.getCantidad());

        this.inventarioServicio.actualizarInventario(inventario.getInventarioId(), inventario);

        ordenCompra.setPrecioTotal(ordenCompra.getCantidad() * inventario.getPreciocompra());
        return this.ordenCompraRepositorio.save(ordenCompra);
    }

    public String borrarOrdenCompra(long ordenCompraId)
    {
        if (this.ordenCompraRepositorio.existsById(ordenCompraId)) 
        {
            OrdenCompra ordenCompra = this.ordenCompraRepositorio.findById(ordenCompraId).get();
            
            inventarioModelo inventario = this.inventarioServicio.obtenerInventarioPorId(ordenCompra.getInventario().getInventarioId());
            inventario.setCantidad(inventario.getCantidad() - ordenCompra.getCantidad());
            this.inventarioServicio.actualizarInventario(inventario.getInventarioId(), inventario);
            
            this.ordenCompraRepositorio.deleteById(ordenCompraId);
            return "Orden de compra eliminada, cambios revertidos";
        }

        return null;
    }
}