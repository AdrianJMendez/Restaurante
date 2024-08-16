package unah.lenguajes.Restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.Restaurante.modelos.Cliente;
import unah.lenguajes.Restaurante.modelos.Reserva;
import java.util.List;


@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long>
{
    List<Reserva> findByCliente(Cliente cliente);

    List<Reserva> findAllByCliente(Cliente cliente);
}
