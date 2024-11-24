package NFI.Expolog.Eco_Obra.models.associations;

import NFI.Expolog.Eco_Obra.models.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras")
@Getter
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "compra",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Venda venda;
    @OneToOne(mappedBy = "compra",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Usuario comprador;
    @Column(name = "quantidade_comprada")
    private Integer quantidadeComprada;
    @Column(name = "preco_compra")
    private Double precoCompra;

    public Compra(Usuario comprador, Venda venda, Integer quantidadeComprada) {
        this.comprador = comprador;
        this.venda = venda;
        this.quantidadeComprada = quantidadeComprada;
        this.precoCompra = this.quantidadeComprada * venda.getMaterial().getPreco();
    }

}
