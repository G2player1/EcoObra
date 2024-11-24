package NFI.Expolog.Eco_Obra.models.associations;

import NFI.Expolog.Eco_Obra.models.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "quantidade_comprada")
    private Integer quantidadeComprada;

    @Column(name = "preco_compra")
    private Double precoCompra;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Venda venda;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Usuario comprador;

    public Compra(Usuario comprador, Venda venda, Integer quantidadeComprada) {
        this.comprador = comprador;
        this.venda = venda;
        this.quantidadeComprada = quantidadeComprada;
        this.precoCompra = this.quantidadeComprada * venda.getMaterial().getPreco();
    }

}
