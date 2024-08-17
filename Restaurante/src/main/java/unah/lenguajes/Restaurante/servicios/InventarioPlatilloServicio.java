package unah.lenguajes.Restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.Restaurante.repositorios.InventarioPlatilloRepositorio;

@Service
public class InventarioPlatilloServicio 
{
    @Autowired
    private InventarioPlatilloRepositorio inventarioPlatilloRepositorio;
}
