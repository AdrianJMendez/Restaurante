package unah.lenguajes.Restaurante.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mesa")
@Data
public class Mesa 
{
    @Id
    @Column(name = "mesaid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mesaId;

    private long sillas;
}
