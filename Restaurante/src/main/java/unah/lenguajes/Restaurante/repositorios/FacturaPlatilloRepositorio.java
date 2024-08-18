package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.FacturaPlatillo;
import unah.lenguajes.Restaurante.modelos.FacturaPlatilloKey;
import unah.lenguajes.Restaurante.modelos.Factura;
import java.util.List;


@Repository
public interface FacturaPlatilloRepositorio extends JpaRepository<FacturaPlatillo, FacturaPlatilloKey>
{
    public List<FacturaPlatillo> findByFactura(Factura factura);
}