package NFI.Expolog.Eco_Obra.models.associations;

import NFI.Expolog.Eco_Obra.enums.EstadoVenda;
import NFI.Expolog.Eco_Obra.models.Material;
import NFI.Expolog.Eco_Obra.models.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendas")
@Getter
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(name = "estado_venda")
    private EstadoVenda estadoVenda;

    @Column(name = "quantidade_produto")
    private Integer quantidade;

    @OneToOne(mappedBy = "venda",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Material material;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Compra compra;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Usuario vendedor;

    public Venda(Usuario vendedor, Material material, Integer quantidade) {
        this.vendedor = vendedor;
        this.material = material;
        this.quantidade = quantidade;
        this.estadoVenda = EstadoVenda.EM_ABERTO;
        this.compra = null;
    }
}
