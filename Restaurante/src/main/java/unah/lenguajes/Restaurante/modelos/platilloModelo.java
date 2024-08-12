package unah.lenguajes.Restaurante.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "platillo")
@Data
public class platilloModelo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "platilloid")
    private int platilloid;

    private double precio;


}
