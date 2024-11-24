package NFI.Expolog.Eco_Obra.services;

import NFI.Expolog.Eco_Obra.interfaces.repositorys.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
}
