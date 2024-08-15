package unah.lenguajes.Restaurante.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "categoria_permiso")
@Data

public class categoriaPermisoModelo {

    @Id
    @Column(name="categoriapermisoid")
    private int categoriaPermisoID;
    private String nombre;
    private String descripcion ;



}
