package NFI.Expolog.Eco_Obra.services;

import NFI.Expolog.Eco_Obra.exceptions.CantRegisterBuyException;
import NFI.Expolog.Eco_Obra.interfaces.repositorys.ICompraRepository;
import NFI.Expolog.Eco_Obra.interfaces.repositorys.IUsuarioRepository;
import NFI.Expolog.Eco_Obra.interfaces.repositorys.IVendaRepository;
import NFI.Expolog.Eco_Obra.models.Material;
import NFI.Expolog.Eco_Obra.models.Usuario;
import NFI.Expolog.Eco_Obra.models.associations.Compra;
import NFI.Expolog.Eco_Obra.models.associations.Venda;
import NFI.Expolog.Eco_Obra.models.dtos.buscas.BuscaCompraDTO;
import NFI.Expolog.Eco_Obra.models.dtos.buscas.BuscaVendaDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroCompraDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroUsuarioDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroVendaDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IVendaRepository vendaRepository;
    @Autowired
    private ICompraRepository compraRepository;


    @Transactional
    public void registraUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        Usuario usuario = new Usuario(registroUsuarioDTO);
        this.usuarioRepository.save(usuario);
    }

    @Transactional
    public void registraUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

    @Transactional
    public void registraVenda(RegistroVendaDTO registroVendaDTO) {
        Usuario vendedor = this.usuarioRepository.getReferenceById(registroVendaDTO.vendedor_id());
        Material material = new Material(registroVendaDTO.material());
        Venda venda = new Venda(vendedor,material, registroVendaDTO.quantidade());
        material.setVenda(venda);
        vendedor.addVendas(venda);
        this.vendaRepository.save(venda);
    }

    @Transactional
    public void registraVenda(Usuario vendedor,Material material,Integer quantidade){
        Venda venda = new Venda(vendedor,material,quantidade);
        material.setVenda(venda);
        vendedor.addVendas(venda);
        this.vendaRepository.save(venda);
    }


    @Transactional
    public void registraCompra(RegistroCompraDTO registroCompraDTO) {
        Usuario comprador = this.usuarioRepository.getReferenceById(registroCompraDTO.comprador_id());
        Venda venda = this.vendaRepository.getReferenceById(registroCompraDTO.venda_id());
        Usuario vendedor = venda.getVendedor();
        int quantidadeComprada = registroCompraDTO.quantidadeComprada();
        this.avaliaCompra(comprador,vendedor,venda,quantidadeComprada);//testa se a compra é valida
        Compra compra = new Compra(comprador,venda,quantidadeComprada);
        venda.setCompra(compra);
//        if(venda.getQuantidade() > compra.getQuantidadeComprada()){
//            Venda novaVenda = new Venda(vendedor,venda.getMaterial(),venda.getQuantidade());
//            novaVenda.subtraiQuantidade(quantidadeComprada);
//            novaVenda.getMaterial().setVenda(novaVenda);
//            novaVenda.getVendedor().addVendas(venda);
//        }
        vendedor.addVendas(venda);
        comprador.addCompras(compra);
        compraRepository.save(compra);
    }

    public void avaliaCompra(Usuario comprador,Usuario vendedor,Venda venda, Integer quantidadeComprada){
        venda.mudarEstado();//muda o estado para EM_PROCESSO
        if (comprador.getEmail().equals(vendedor.getEmail())){
            venda.zerarEstado();
            throw new CantRegisterBuyException("você não pode comprar sua propria venda");
        }
        if(quantidadeComprada > venda.getQuantidade()){
            venda.zerarEstado();
            throw new CantRegisterBuyException("não há estoque o bastante para a venda");
        }
        if(quantidadeComprada <= 0){
            venda.zerarEstado();
            throw new CantRegisterBuyException("a quantidade comprada não pode ser 0 ou negativa");
        }
        venda.mudarEstado();//muda o estado para VENDIDO
    }

    @Transactional
    public List<BuscaVendaDTO> buscaVendas() {
        return vendaRepository.findAll()
                .stream()
                .map(BuscaVendaDTO::new)
                .toList();
    }

    @Transactional
    public List<BuscaVendaDTO> buscaVendasUsuario(Long id) {
        return vendaRepository.findAll()
                .stream()
                .filter(venda -> venda.getVendedor().getId() == id)
                .map(BuscaVendaDTO::new)
                .toList();
    }

    public List<BuscaCompraDTO> buscaComprasUsuario(Long id) {
        return compraRepository.findAll()
                .stream()
                .filter(compra -> compra.getComprador().getId() == id)
                .map(BuscaCompraDTO::new)
                .toList();
    }
}
