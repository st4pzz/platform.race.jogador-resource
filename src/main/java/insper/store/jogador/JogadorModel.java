package insper.store.jogador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "jogador")
@EqualsAndHashCode(of = "id_jogador")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_jogador")
    private String id_jogador;

    @Column(name = "id_user")
    private String id_user;

    @Column(name = "id_partida")
    private String id_partida;

    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "tx_time")
    private String time;

    @Column(name = "tx_posicao")
    private String posicao;

    @Column(name = "idade")
    private Integer idade;


    public JogadorModel(Jogador o) {
        this.id_jogador = o.id_jogador();
        this.id_user = o.id_user();
        this.id_partida = o.id_partida();
        this.nome = o.nome();
        this.time = o.time();
        this.posicao = o.posicao();
        this.idade = o.idade();
        
    }
    
    public Jogador to() {
        return Jogador.builder()
            .id_jogador(id_jogador)
            .id_user(id_user)
            .id_partida(id_partida)
            .nome(nome)
            .time(time)
            .posicao(posicao)
            .idade(idade)
            
            .build();
    }
    
}
