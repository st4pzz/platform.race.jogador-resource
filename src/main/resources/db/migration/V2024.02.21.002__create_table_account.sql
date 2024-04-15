CREATE TABLE jogador
(
    id_jogador character varying(36) NOT NULL,
    tx_id_user character varying(36) NOT NULL,
    tx_id_partida character varying(36) NOT NULL,
    tx_nome character varying(256) NOT NULL,
    tx_time character varying(256) NOT NULL,
    tx_posicao character varying(256) NOT NULL,
    idade INTEGER NOT NULL,

    CONSTRAINT jogador_pkey PRIMARY KEY (id_jogador)
);


