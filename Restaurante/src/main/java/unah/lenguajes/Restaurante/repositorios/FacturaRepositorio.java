package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import unah.lenguajes.Restaurante.modelos.Factura;
import unah.lenguajes.Restaurante.modelos.clienteModelo;

import java.util.List;


@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>
{

    public List<Factura> findByCliente(clienteModelo cliente);


    public long countByCliente(clienteModelo cliente);

}