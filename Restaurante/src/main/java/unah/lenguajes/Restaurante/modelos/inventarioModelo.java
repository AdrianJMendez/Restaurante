package unah.lenguajes.Restaurante.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name="inventario")
@Data
public class inventarioModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventarioid")
    private int inventarioId ;

    private String nombre ;

    private double preciocompra ;

    private double cantidad;

    private String unidadmetrica ;

    @Column(name="minimo_recompra")
    private int minimo_recompra;


}
