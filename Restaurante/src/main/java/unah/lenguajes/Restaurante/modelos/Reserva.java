package unah.lenguajes.Restaurante.modelos;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reserva")
@Data
public class Reserva 
{
    @Id
    @Column(name = "reservaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservaId;

    @ManyToOne
    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid")
    private clienteModelo cliente;

    private LocalDateTime fecha;

    @Column(name = "cantidaddepersonas")
    private long cantidadDePersonas;

    @ManyToOne
    @JoinColumn(name = "usuarioid", referencedColumnName = "usuarioid")
    private usuarioModelo usuario;

    private String descripcion;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "reserva_mesa",
        joinColumns = @JoinColumn(name="reservaid"),
        inverseJoinColumns = @JoinColumn(name="mesaid")
    )
    private List<mesaModelo> mesas;

}