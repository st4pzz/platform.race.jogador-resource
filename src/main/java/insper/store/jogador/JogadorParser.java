package insper.store.jogador;

import insper.store.jogador.JogadorIn;
import insper.store.jogador.JogadorOut;

public class JogadorParser {

    public static Jogador to(JogadorIn in) {
        return Jogador.builder()
            .id_jogador(in.id_jogador())
            .id_user(in.id_user())
            .id_partida(in.id_partida())
            .nome(in.nome())
            .time(in.time())
            .posicao(in.posicao())
            .idade(in.idade())
            
            .build();
    }

    public static JogadorOut to(Jogador Jogador) {
        return JogadorOut.builder()
            .id_jogador(Jogador.id_jogador())
            .id_user(Jogador.id_user())
            .id_partida(Jogador.id_partida())
            .nome(Jogador.nome())
            .time(Jogador.time())
            .posicao(Jogador.posicao())
            .idade(Jogador.idade())
            
            .build();
    }
    
}
