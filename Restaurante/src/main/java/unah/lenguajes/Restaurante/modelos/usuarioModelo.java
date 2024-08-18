package unah.lenguajes.Restaurante.modelos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data

public class usuarioModelo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="usuarioid")
    private int usuarioid;

    private String user;

    private String contrasena;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="categoriapermiso", referencedColumnName = "categoriapermisoid", nullable = false)
    private categoriaPermisoModelo categoriaPermiso;

}
