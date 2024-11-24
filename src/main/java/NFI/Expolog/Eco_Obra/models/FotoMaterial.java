package NFI.Expolog.Eco_Obra.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fotos_material")
@Getter
@NoArgsConstructor
public class FotoMaterial {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "foto_material")
    private String fotoMaterial;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Material material;

    public FotoMaterial(String fotoMaterial, Material material) {
        this.fotoMaterial = fotoMaterial;
        this.material = material;
    }
}
