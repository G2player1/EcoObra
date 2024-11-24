package NFI.Expolog.Eco_Obra.models;

import NFI.Expolog.Eco_Obra.exceptions.NullObjectException;
import NFI.Expolog.Eco_Obra.models.associations.VendaCompra;
import NFI.Expolog.Eco_Obra.models.dtos.RegistroUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String nome;
    @Column(name = "email",nullable = false)
    private String email;
    @Getter(AccessLevel.NONE)
    @Column(name = "senha",nullable = false)
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @OneToOne(mappedBy = "usuario",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Endereco endereco;
    @OneToMany(mappedBy = "vendedor",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<VendaCompra> vendas;
    @OneToMany(mappedBy = "comprador",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<VendaCompra> compras;

    public Usuario(String nome, String email, String senha, String telefone, Endereco endereco) {
        this.vendas = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Usuario(RegistroUsuarioDTO registroUsuarioDTO){
        this.vendas = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.nome = registroUsuarioDTO.nome();
        this.email = registroUsuarioDTO.email();
        this.senha = registroUsuarioDTO.senha();
        this.telefone = registroUsuarioDTO.telefone();
        this.endereco = new Endereco(registroUsuarioDTO.endereco());
        this.endereco.setUsuario(this);
    }

    public void addVendas(VendaCompra vendaCompra){
        if(vendaCompra == null){
            throw new NullObjectException("The object of " + this.getClass() + " is null");
        }
        this.vendas.add(vendaCompra);
    }

    public void addCompras(VendaCompra vendaCompra){
        if(vendaCompra == null){
            throw new NullObjectException("The object of " + this.getClass() + " is null");
        }
        this.compras.add(vendaCompra);
    }
}
