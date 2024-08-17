package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Cliente;
import unah.lenguajes.Restaurante.modelos.Factura;
import java.util.List;


@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>
{

    public List<Factura> findByCliente(Cliente cliente);

    public long countByCliente(Cliente cliente);
}
