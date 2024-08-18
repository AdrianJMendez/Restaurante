package unah.lenguajes.Restaurante.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "oredenes_de_compra")     //Cambiar nombre de la tabla
@Data
public class OrdenCompra 
{
    @Id
    @Column(name = "ordencompraid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordenCompraId;

    @ManyToOne
    @JoinColumn(name = "inventarioid", referencedColumnName = "inventarioid")
    private inventarioModelo inventario;

    private double cantidad;

    @Column(name = "preciototal")
    private double precioTotal;
}