package NFI.Expolog.Eco_Obra.interfaces.repositorys;

import NFI.Expolog.Eco_Obra.models.associations.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<Compra,Long> {
}
