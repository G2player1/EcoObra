package NFI.Expolog.Eco_Obra.models;

import NFI.Expolog.Eco_Obra.exceptions.NullObjectException;
import NFI.Expolog.Eco_Obra.models.dtos.RegistroEnderecoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")
@NoArgsConstructor
@Getter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "complemento",length = 2000)
    private String complemento;
    @OneToOne(mappedBy = "endereco",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Usuario usuario;

    public Endereco(String logradouro, String bairro, Integer cep, String cidade, String uf, Integer numero, String complemento, Usuario usuario) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
        this.usuario = usuario;
    }

    public Endereco(RegistroEnderecoDTO registroEnderecoDTO){
        this.logradouro = registroEnderecoDTO.logradouro();
        this.bairro = registroEnderecoDTO.bairro();
        this.cep = registroEnderecoDTO.cep();
        this.cidade = registroEnderecoDTO.cidade();
        this.uf = registroEnderecoDTO.uf();
        this.numero = registroEnderecoDTO.numero();
        this.complemento = registroEnderecoDTO.complemento();
    }

    public void setUsuario(Usuario usuario){
        if(usuario == null){
            throw new NullObjectException("The object of " + this.getClass() + " is null");
        }
        this.usuario = usuario;
    }
}
