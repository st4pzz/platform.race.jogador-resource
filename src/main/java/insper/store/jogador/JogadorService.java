package insper.store.jogador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import insper.store.account.AccountController;
import insper.store.account.AccountOut;
import insper.store.partida.PartidaController;
import insper.store.partida.PartidaOut;
import lombok.NonNull;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository JogadorRepository;

    @Autowired
    private PartidaController PartidaController;
    
    @Autowired
    private AccountController accountController;


    
    public Jogador create(Jogador in) {

        ResponseEntity<PartidaOut> response = PartidaController.read(in.id_partida());

        if (response.getStatusCode().isError()) throw new IllegalArgumentException("Invalid partida");

        ResponseEntity<AccountOut> response2 = accountController.read(in.id_user());

        if (response2.getStatusCode().isError()) throw new IllegalArgumentException("Invalid user");
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(response2.getBody());
        System.out.println(response.getBody());
        System.out.println("------------------------------------------------------------------------------------");

        
        return JogadorRepository.save(new JogadorModel(in)).to();
        
    }

    public Jogador read(@NonNull String id) {
        return JogadorRepository.findById(id).map(JogadorModel::to).orElse(null);
    }
    
}
