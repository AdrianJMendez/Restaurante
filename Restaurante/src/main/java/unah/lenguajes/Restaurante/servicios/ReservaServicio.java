package unah.lenguajes.Restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import unah.lenguajes.Restaurante.modelos.Reserva;
import unah.lenguajes.Restaurante.modelos.clienteModelo;
import unah.lenguajes.Restaurante.repositorios.ReservaRepositorio;

@Service
public class ReservaServicio 
{
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Autowired
    private clienteServicio clienteServicio;

    public List<Reserva> obtenerTodasReservas()
    {
        return this.reservaRepositorio.findAll();
    }

    public Reserva crearReserva(Reserva reserva)
    {
        return this.reservaRepositorio.save(reserva);
    }

    public String borrarReserva(long reservaId)
    {
        if(this.reservaRepositorio.existsById(reservaId))
        {
            //Reserva reserva = this.reservaRepositorio.findById(reservaId).get();
            this.reservaRepositorio.deleteById(reservaId);
            return "Reserva Eliminada";
        }

        return null;
    }

    public List<Reserva> buscarReservaPorClienteId(Integer clienteId)
    {
        clienteModelo cliente = this.clienteServicio.buscarClientePorId(clienteId);
        if(cliente != null)
        {
            return this.reservaRepositorio.findByCliente(cliente);
        }

        return null;
    }

    public Reserva buscarReservaPorId(long reservaId)
    {
        if(this.reservaRepositorio.existsById(reservaId))
        {
            return this.reservaRepositorio.findById(reservaId).get();
        }
        return null;
    }
}