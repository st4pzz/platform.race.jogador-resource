package insper.store.jogador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository JogadorRepository;


    
    public Iterable<JogadorModel> readAll() {
        return JogadorRepository.findAll();
    }

    public Jogador create(Jogador in) {
        return JogadorRepository.save(new JogadorModel(in)).to();
    }

    public Jogador read(@NonNull String id) {
        return JogadorRepository.findById(id).map(JogadorModel::to).orElse(null);
    }
    
}
