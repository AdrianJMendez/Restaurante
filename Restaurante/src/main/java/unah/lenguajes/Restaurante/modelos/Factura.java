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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "factura")
@Data
public class Factura 
{
    @Id
    @Column(name = "facturaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long facturaId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuarioid", referencedColumnName = "usuarioid")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.MERGE)
    private List<FacturaPlatillo> platillos;

    private LocalDateTime fecha;

    @Column(name = "metododepago")
    private String metodoDePago;

    private double impuesto;

    private double total;
}
