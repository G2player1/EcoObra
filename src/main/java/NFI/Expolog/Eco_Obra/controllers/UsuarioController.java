package NFI.Expolog.Eco_Obra.controllers;

import NFI.Expolog.Eco_Obra.exceptions.CantRegisterBuyException;
import NFI.Expolog.Eco_Obra.models.dtos.buscas.BuscaCompraDTO;
import NFI.Expolog.Eco_Obra.models.dtos.buscas.BuscaVendaDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroCompraDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroUsuarioDTO;
import NFI.Expolog.Eco_Obra.models.dtos.registros.RegistroVendaDTO;
import NFI.Expolog.Eco_Obra.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public void registraUsuario(@RequestBody RegistroUsuarioDTO registroUsuarioDTO){
        usuarioService.registraUsuario(registroUsuarioDTO);
    }

    @PostMapping("/registro_venda")
    public void registraVenda(@RequestBody RegistroVendaDTO registroVendaDTO){
        usuarioService.registraVenda(registroVendaDTO);
    }

    @PostMapping("/registro_compra")
    public void registraCompra(@RequestBody RegistroCompraDTO registroCompraDTO){
        try {
            usuarioService.registraCompra(registroCompraDTO);
        } catch (CantRegisterBuyException e){
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/busca_vendas")
    public List<BuscaVendaDTO> buscaVendas(){
        return usuarioService.buscaVendas();
    }

    @GetMapping("/{id}/vendas")
    public List<BuscaVendaDTO> buscaVendasUsuario(@PathVariable("id") Long id){
        return usuarioService.buscaVendasUsuario(id);
    }

    @GetMapping("/{id}/compras")
    public List<BuscaCompraDTO> buscaComprasUsuario(@PathVariable("id") Long id){
        return usuarioService.buscaComprasUsuario(id);
    }
}
