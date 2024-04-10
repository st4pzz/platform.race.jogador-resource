CREATE TABLE jogador
(
    id_jogador character varying(36) NOT NULL,
    id_user character varying(36) NOT NULL,
    id_partida character varying(36) NOT NULL,
    tx_nome character varying(256) NOT NULL,
    tx_time character varying(256) NOT NULL,
    tx_posicao character varying(256) NOT NULL,
    tx_idade INT NOT NULL,
    vl_salario FLOAT NOT NULL,

    CONSTRAINT jogador_pkey PRIMARY KEY (id_jogador)
);


