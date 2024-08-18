package unah.lenguajes.Restaurante.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private String nombre;

    private String imagen;
     @OneToMany(mappedBy = "platillo", cascade = CascadeType.MERGE)
    private List<InventarioPlatillo> inventarios;


}
