package NFI.Expolog.Eco_Obra.models.dtos;

public record RegistroCompraDTO(
        Long venda_id,
        Long comprador_id,
        Integer quantidadeComprada
) {
}
