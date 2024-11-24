package NFI.Expolog.Eco_Obra.models.dtos.registros;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegistroMaterialDTO(
        @JsonAlias("nome")
        String nome,
        @JsonAlias("preco")
        Double preco,
        @JsonAlias("preco_recomendado")
        Double precoRecomendado,
        @JsonAlias("tipo_material")
        String tipoMaterial,
        @JsonAlias("fotos_material")
        List<String> fotosMaterial
) {
}
