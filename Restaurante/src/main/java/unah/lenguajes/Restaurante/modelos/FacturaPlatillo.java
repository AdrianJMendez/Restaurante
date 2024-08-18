package unah.lenguajes.Restaurante.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "factura_platillo")
@Data
public class FacturaPlatillo 
{
    @EmbeddedId
    @JsonIgnore
    private FacturaPlatilloKey id = new FacturaPlatilloKey();

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("facturaId")
    @JoinColumn(name = "facturaid")
    @JsonIgnore
    private Factura factura;

    @ManyToOne
    @MapsId("platilloId")
    @JoinColumn(name = "platilloid")
    private platilloModelo platillo;

    private long cantidad;

    @Column(name = "preciototal")
    private double precioTotal;
}