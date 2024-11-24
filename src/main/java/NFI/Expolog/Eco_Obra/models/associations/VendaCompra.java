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
public class VendaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Usuario vendedor;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Usuario comprador;
    @OneToOne(mappedBy = "venda",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Material material;
    @Enumerated
    @Column(name = "estado_venda")
    private EstadoVenda estadoVenda;
    @Column(name = "quantidade_produto")
    private Integer quantidade;
    @Column(name = "preco_compra")
    private Double precoCompra;
}
