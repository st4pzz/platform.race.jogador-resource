package insper.store.jogador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import insper.store.account.AccountController;
import insper.store.account.AccountOut;
import insper.store.partida.PartidaController;
import insper.store.partida.PartidaOut;
import lombok.NonNull;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PartidaController partidaController;

    @Autowired
    private AccountController accountController;

    @CircuitBreaker(name = "jogadorService", fallbackMethod = "fallbackCreate")
    @CachePut(value = "jogadores", key = "#result.id")
    public Jogador create(Jogador in) {
        ResponseEntity<PartidaOut> response = partidaController.read(in.id_partida());
        if (response.getStatusCode().isError()) {
            throw new IllegalArgumentException("Invalid partida");
        }

        ResponseEntity<AccountOut> response2 = accountController.read(in.id_user());
        if (response2.getStatusCode().isError()) {
            throw new IllegalArgumentException("Invalid user");
        }

        return jogadorRepository.save(new JogadorModel(in)).to();
    }

    public Jogador fallbackCreate(Jogador in, Throwable t) {
        return new Jogador();   
    }

    @CircuitBreaker(name = "jogadorService", fallbackMethod = "fallbackRead")
    @Cacheable(value = "jogadores", key = "#id")
    public Jogador read(@NonNull String id) {
        return jogadorRepository.findById(id).map(JogadorModel::to).orElse(null);
    }

    public Jogador fallbackRead(String id, Throwable t) {
        return new Jogador();
    }
}
