package NFI.Expolog.Eco_Obra.models.dtos.buscas;

import NFI.Expolog.Eco_Obra.models.associations.Venda;
import lombok.Getter;

@Getter
public class BuscaVendaDTO {

    private Long id;
    private BuscaUsuarioDTO vendedor;
    private BuscaMaterialDTO material;
    private Integer quantidade;

    public BuscaVendaDTO(Venda venda){
        this.id = venda.getId();
        this.vendedor = new BuscaUsuarioDTO(venda.getVendedor());
        this.material = new BuscaMaterialDTO(venda.getMaterial());
        this.quantidade = venda.getQuantidade();
    }
}
