package NFI.Expolog.Eco_Obra.interfaces.repositorys;

import NFI.Expolog.Eco_Obra.models.associations.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendaRepository extends JpaRepository<Venda,Long> {
}
