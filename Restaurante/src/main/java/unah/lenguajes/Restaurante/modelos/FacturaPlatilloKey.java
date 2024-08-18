package unah.lenguajes.Restaurante.modelos;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FacturaPlatilloKey implements Serializable
{
    @Column(name = "facturaid")
    private long facturaId;

    @Column(name = "platilloid")
    private long platilloId;
}