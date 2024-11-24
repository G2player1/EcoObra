package NFI.Expolog.Eco_Obra.models.dtos.registros;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegistroEnderecoDTO(
         @JsonAlias("logradouro")
         String logradouro,
         @JsonAlias("bairro")
         String bairro,
         @JsonAlias("cep")
         Integer cep,
         @JsonAlias("cidade")
         String cidade,
         @JsonAlias("uf")
         String uf,
         @JsonAlias("numero")
         Integer numero,
         @JsonAlias("complemento")
         String complemento
) {
}
