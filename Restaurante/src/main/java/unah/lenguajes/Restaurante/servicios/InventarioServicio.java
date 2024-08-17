package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.modelos.Inventario;
import unah.lenguajes.Restaurante.repositorios.InventarioRepositorio;

@Service
public class InventarioServicio 
{
    @Autowired
    private InventarioRepositorio inventarioRepositorio;

    public List<Inventario> obtenerTodos()
    {
        return this.inventarioRepositorio.findAll();
    }

    public Inventario obtenerInventarioPorId(long inventarioId)
    {
        if(this.inventarioRepositorio.existsById(inventarioId))
        {
            return this.inventarioRepositorio.findById(inventarioId).get();
        }
        return null;
    }

    public Inventario actualizarInventario(long inventarioId, Inventario inventario)
    {
        if(this.inventarioRepositorio.existsById(inventarioId))
        {
            Inventario actualizarInventario = this.inventarioRepositorio.findById(inventarioId).get();

            actualizarInventario.setNombre(inventario.getNombre());
            actualizarInventario.setPrecioCompra(inventario.getPrecioCompra());
            actualizarInventario.setCantidad(inventario.getCantidad());
            actualizarInventario.setUnidadMetrica(inventario.getUnidadMetrica());
            actualizarInventario.setMinimoRecompra(inventario.getMinimoRecompra());

            return this.inventarioRepositorio.save(actualizarInventario);
        }

        return null;
    }
}
