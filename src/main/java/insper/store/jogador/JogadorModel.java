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
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_jogador")
    private String id;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "id_partida")
    private String idPartida;

    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "tx_time")
    private String time;

    @Column(name = "tx_posicao")
    private String posicao;

    @Column(name = "tx_idade")
    private Integer idade;

    @Column(name = "vl_salario")
    private Float salario;

    public JogadorModel(Jogador o) {
        this.id = o.id();
        this.idUser = o.id_user();
        this.idPartida = o.id_partida();
        this.nome = o.nome();
        this.time = o.time();
        this.posicao = o.posicao();
        this.idade = o.idade();
        this.salario = o.salario();
    }
    
    public Jogador to() {
        return Jogador.builder()
            .id(id)
            .id_user(idUser)
            .id_partida(idPartida)
            .nome(nome)
            .time(time)
            .posicao(posicao)
            .idade(idade)
            .salario(salario)
            .build();
    }
    
}
