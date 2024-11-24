package NFI.Expolog.Eco_Obra.models.dtos.edicoes;

public record EditaEnderecoDTO(
        Long id,
        String logradouro,
        String bairro,
        Integer cep,
        String cidade,
        String uf,
        Integer numero,
        String complemento
) {
}
