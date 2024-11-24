package NFI.Expolog.Eco_Obra.interfaces.repositorys;

import NFI.Expolog.Eco_Obra.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
}
