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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente 
{
    @Id
    @Column(name = "clienteid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteId;

    private String nombre;

    private String apellido;

    private String identificacion;


    //Relaciones
    //@OneToMany(mappedBy = "cliente",cascade = CascadeType.MERGE)
    //@JsonIgnore
    //private List<Factura> facturas;
}
