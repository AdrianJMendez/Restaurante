package unah.lenguajes.Restaurante.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cateogria_permiso")  //Cambiar nombre de la tabla
@Data
public class CategoriaPermiso 
{
    @Id
    @Column(name = "categoriapermisoid")
    private long categoriaPermisoId;

    private String nombre;

    private String descripcion;
}
