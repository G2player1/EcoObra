package NFI.Expolog.Eco_Obra.models.dtos.edicoes;

public record EditaUsuarioDTO(
        Long id,
        String nome,
        String email,
        String senha,
        String telefone,
        EditaEnderecoDTO endereco
) {
}
