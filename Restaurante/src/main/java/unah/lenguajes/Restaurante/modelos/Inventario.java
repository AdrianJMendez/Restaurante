package unah.lenguajes.Restaurante.modelos;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data
public class Inventario 
{
    @Id
    @Column(name = "inventarioid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventarioId;

    private String nombre;

    @Column(name = "preciocompra")
    private double precioCompra;

    private double cantidad;

    @Column(name = "unidadmetrica")
    private String unidadMetrica;

    @Column(name = "minimo_recompra")
    private long minimoRecompra;
}
