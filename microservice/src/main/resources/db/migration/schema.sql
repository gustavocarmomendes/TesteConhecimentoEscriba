CREATE TABLE situacao (
    id VARCHAR(20),
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO situacao (id, nome) VALUES ('SIT_ATIVO', 'Ativo');
INSERT INTO situacao (id, nome) VALUES ('SIT_BLOQUEADO', 'Bloqueado');

CREATE TABLE atribuicao (
    id VARCHAR(20),
    nome VARCHAR(50) NOT NULL,
    situacao BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id)
);

CREATE TABLE cartorio (
    id INT AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    observacao VARCHAR(250),
    situacao_id VARCHAR(20),
    CONSTRAINT fk_situacao FOREIGN KEY (situacao_id) REFERENCES situacao(id),
    PRIMARY KEY (id)
);

CREATE TABLE cartorio_atribuicao (
    cartorio_id INT,
    atribuicao_id VARCHAR(20),
    PRIMARY KEY (cartorio_id, atribuicao_id),
    CONSTRAINT fk_cartorio FOREIGN KEY (cartorio_id) REFERENCES cartorio(id),
    CONSTRAINT fk_atribuicao FOREIGN KEY (atribuicao_id) REFERENCES atribuicao(id)
);
