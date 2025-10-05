
CREATE TYPE usuario_papel AS ENUM ('SUPERVISOR', 'FUNCIONARIO');

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    senha_hash TEXT NOT NULL,
    papel usuario_papel NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE supervisor (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL UNIQUE,
    nome TEXT NOT NULL,
    telefone TEXT,
    observacoes TEXT,
    CONSTRAINT fk_supervisor_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE setor (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL UNIQUE,
    descricao TEXT,
    supervisor_id INT,
    CONSTRAINT fk_setor_supervisor
    FOREIGN KEY (supervisor_id) REFERENCES supervisor(id)
);

CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY,
    usuario_id INT UNIQUE,
    nome TEXT NOT NULL,
    matricula TEXT NOT NULL UNIQUE,
    email_corporativo TEXT,
    setor_id INT NOT NULL,
    telefone TEXT,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_funcionario_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_funcionario_setor
    FOREIGN KEY (setor_id) REFERENCES setor(id)
);

CREATE TYPE usuario_papel AS ENUM ('SUPERVISOR', 'FUNCIONARIO');


CREATE TABLE usuario (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(150) UNIQUE NOT NULL,
    senha_hash TEXT NOT NULL,
    papel usuario_papel NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT NOW(),
    atualizado_em TIMESTAMP DEFAULT NOW()
);


CREATE TABLE supervisor (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID UNIQUE NOT NULL REFERENCES usuario(id),
    nome VARCHAR(150) NOT NULL,
    telefone VARCHAR(20),
    observacoes TEXT
);


CREATE TABLE setor (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) UNIQUE NOT NULL,
    descricao TEXT,
    supervisor_id UUID REFERENCES supervisor(id)
);


CREATE TABLE funcionario (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID UNIQUE REFERENCES usuario(id),
    nome VARCHAR(150) NOT NULL,
    matricula VARCHAR(50) UNIQUE NOT NULL,
    email_corporativo VARCHAR(150),
    setor_id UUID NOT NULL REFERENCES setor(id),
    telefone VARCHAR(20),
    ativo BOOLEAN DEFAULT TRUE
);
