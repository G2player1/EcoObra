package NFI.Expolog.Eco_Obra.models.dtos.buscas;

import NFI.Expolog.Eco_Obra.models.Usuario;
import lombok.Getter;

@Getter
public class BuscaUsuarioDTO {

    private String nome;
    private String email;
    private String telefone;
    private BuscaEnderecoDTO endereco;

    public BuscaUsuarioDTO(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.endereco = new BuscaEnderecoDTO(usuario.getEndereco());
    }
}
