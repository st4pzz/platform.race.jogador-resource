package insper.store.jogador;

public class JogadorParser {

    public static Jogador to(JogadorIn in) {
        return Jogador.builder()
            .id(in.id())
            .nome(in.nome())
            .time(in.time())
            .posicao(in.posicao())
            .idade(in.idade())
            .salario(in.salario())
            .build();
    }

    public static JogadorOut to(Jogador Jogador) {
        return JogadorOut.builder()
            .id(Jogador.id())
            .nome(Jogador.nome())
            .time(Jogador.time())
            .posicao(Jogador.posicao())
            .idade(Jogador.idade())
            .salario(Jogador.salario())
            .build();
    }
    
}
