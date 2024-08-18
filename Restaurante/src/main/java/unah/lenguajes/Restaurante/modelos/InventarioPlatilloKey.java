package unah.lenguajes.Restaurante.modelos;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class InventarioPlatilloKey implements Serializable
{
    @Column(name = "inventarioid")
    private Integer inventarioId;

    @Column(name = "platilloid")
    private Integer platilloId;
}