package NFI.Expolog.Eco_Obra.models.dtos.registros;

public record RegistroVendaDTO(
        Long vendedor_id,
        RegistroMaterialDTO material,
        Integer quantidade
) {
}
