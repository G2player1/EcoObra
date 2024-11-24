package NFI.Expolog.Eco_Obra.models;

import NFI.Expolog.Eco_Obra.enums.TipoMaterial;
import NFI.Expolog.Eco_Obra.models.dtos.RegistroMaterialDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materiais")
@Getter
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "preco_recomendado")
    private Double precoRecomendado;
    @Enumerated
    @Column(name = "tipo_material")
    private TipoMaterial tipoMaterial;
    @OneToMany(mappedBy = "fotoMaterial",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<FotoMaterial> fotosMaterial;

    public Material(String nome, Double preco, Double precoRecomendado, TipoMaterial tipoMaterial) {
        this.fotosMaterial = new ArrayList<>();
        this.nome = nome;
        this.preco = preco;
        this.precoRecomendado = precoRecomendado;
        this.tipoMaterial = tipoMaterial;
    }

    public Material(RegistroMaterialDTO registroMaterialDTO){
        this.nome = registroMaterialDTO.nome();
        this.preco = registroMaterialDTO.preco();
        this.precoRecomendado = registroMaterialDTO.precoRecomendado();
        this.tipoMaterial = TipoMaterial.fromString(registroMaterialDTO.tipoMaterial());
        this.fotosMaterial = registroMaterialDTO.fotosMaterial()
                .stream()
                .map(s -> new FotoMaterial(s,this))
                .toList();
    }

}
