package NFI.Expolog.Eco_Obra.models.dtos.buscas;

import NFI.Expolog.Eco_Obra.models.Endereco;
import lombok.Getter;

@Getter
public class BuscaEnderecoDTO {

    private Long id;
    private String logradouro;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String uf;
    private Integer numero;
    private String complemento;

    public BuscaEnderecoDTO(Endereco endereco){
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }
}
