package NFI.Expolog.Eco_Obra.models.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegistroUsuarioDTO(
         @JsonAlias("nome")
         String nome,
         @JsonAlias("email")
         String email,
         @JsonAlias("senha")
         String senha,
         @JsonAlias("telefome")
         String telefone,
         @JsonAlias("endereco")
         RegistroEnderecoDTO endereco
) {
}
