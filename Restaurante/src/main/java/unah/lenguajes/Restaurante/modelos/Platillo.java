package unah.lenguajes.Restaurante.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "platillo")
@Data
public class Platillo 
{
    @Id
    @Column(name = "platilloid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long platilloId;

    private double precio;

    private String nombre;

    @OneToOne(mappedBy = "platillo", cascade = CascadeType.ALL)
    private Oferta oferta;

    @OneToMany(mappedBy = "platillo", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<FacturaPlatillo> facturas;
}
