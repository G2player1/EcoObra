package NFI.Expolog.Eco_Obra.models.dtos.buscas;

import NFI.Expolog.Eco_Obra.models.associations.Compra;
import lombok.Getter;

@Getter
public class BuscaCompraDTO {

    private Long id;
    private BuscaVendaDTO venda;
    private BuscaUsuarioDTO usuario;
    private Integer quantidadeComprada;

    public BuscaCompraDTO(Compra compra) {
        this.id = compra.getId();
        this.venda = new BuscaVendaDTO(compra.getVenda());
        this.quantidadeComprada = compra.getQuantidadeComprada();
        this.usuario = new BuscaUsuarioDTO(compra.getComprador());
    }
}
