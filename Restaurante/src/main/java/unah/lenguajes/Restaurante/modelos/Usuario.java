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
@Table(name = "usuario")
@Data
public class Usuario 
{
    @Id
    @Column(name = "usuarioid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    private String user;

    private String contrasena;

    @Column(name = "categoriapermiso")
    private String categoriaPermiso;
    //Relaciones
    //@OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    //@JsonIgnore
    //private List<Factura> facturas;
}
