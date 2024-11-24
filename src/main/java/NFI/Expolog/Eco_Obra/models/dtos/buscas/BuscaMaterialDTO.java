package NFI.Expolog.Eco_Obra.models.dtos.buscas;

import NFI.Expolog.Eco_Obra.models.FotoMaterial;
import NFI.Expolog.Eco_Obra.models.Material;
import lombok.Getter;

import java.util.List;

@Getter
public class BuscaMaterialDTO{

    private String nome;
    private Double preco;
    private String tipoMaterial;
    private List<String> fotosMaterial;

    public BuscaMaterialDTO(Material material){
        this.nome = material.getNome();
        this.preco = material.getPreco();
        this.tipoMaterial = material.getTipoMaterial().name();
        this.fotosMaterial = material.getFotosMaterial()
                .stream()
                .map(FotoMaterial::getFotoMaterial)
                .toList();
    }
}
