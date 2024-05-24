package insper.store.jogador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<JogadorModel, String> {
    
}
