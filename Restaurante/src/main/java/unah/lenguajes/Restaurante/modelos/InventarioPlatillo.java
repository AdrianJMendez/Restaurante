package unah.lenguajes.Restaurante.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "inventario_platillo")
@Data
public class InventarioPlatillo 
{
    @EmbeddedId
    @JsonIgnore
    private InventarioPlatilloKey id = new InventarioPlatilloKey();

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("platilloId")
    @JoinColumn(name = "platilloid")
    @JsonIgnore
    private Platillo platillo;


    @ManyToOne
    @MapsId("inventarioId")
    @JoinColumn(name = "inventarioid")
    private Inventario inventario;

    private double cantidad;
}
