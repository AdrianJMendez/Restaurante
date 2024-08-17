package unah.lenguajes.Restaurante.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.Restaurante.modelos.Reserva;
import unah.lenguajes.Restaurante.servicios.ReservaServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/reserva")
public class ReservaController 
{

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/obtener/todos")
    public List<Reserva> obtenerTodosReserva() 
    {
        return this.reservaServicio.obtenerTodasReservas();
    }

    @GetMapping("/obtener/cliente/{clienteId}")
    public List<Reserva> buscarPorClienteId(@PathVariable(name = "clienteId") Integer clienteId) 
    {
        return this.reservaServicio.buscarReservaPorClienteId(clienteId);
    }

    @GetMapping("/obtener/{reservaId}")
    public Reserva buscarReservaPorId(@PathVariable(name = "reservaId") long reservaId) 
    {
        return this.reservaServicio.buscarReservaPorId(reservaId);
    }
    

    @PostMapping("/crear")
    public Reserva crearReserva(@RequestBody Reserva reserva) 
    {
        return this.reservaServicio.crearReserva(reserva);
    }

    @DeleteMapping("/borrar/{reservaId}")
    public String borrarReserva(@PathVariable(name = "reservaId") long reservaId)
    {
        return this.reservaServicio.borrarReserva(reservaId);
        
    }

    
    
    
    
}