package insper.store.jogador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter @Setter @Accessors(fluent = true, chain = true)
@AllArgsConstructor @NoArgsConstructor
public class Jogador {

    private String id;
    private String id_user;
    private String id_partida;
    private String nome;
    private String time;
    private String posicao;
    private Integer idade;
    
}