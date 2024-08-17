package unah.lenguajes.Restaurante.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ofertas")       //Nombre de la tabla deberia ser singular
@Data
public class Oferta 
{
    @Id
    @Column(name = "ofertaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ofertaId;

    private double descuento;

    @OneToOne
    @JoinColumn(name = "platilloid", referencedColumnName = "platilloid")
    private Platillo platillo;
}
