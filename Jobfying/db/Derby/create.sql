connect 'jdbc:derby:JobfyingTest;create=true;user=root;password=root';
-- Criação da tabela Usuario
CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    papel VARCHAR(20) NOT NULL CHECK (papel IN ('EMPRESA', 'PROFISSIONAL')),
    CONSTRAINT Usuario_PK PRIMARY KEY(id)
);

-- Inserção de dados na tabela Usuario
INSERT INTO Usuario (login, senha, papel) VALUES
('empresa1', 'empresa123', 'EMPRESA'),
('profissional1', 'prof123', 'PROFISSIONAL');

-- Criação da tabela Empresa
CREATE TABLE Empresa (
    id BIGINT AUTO_INCREMENT,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT Empresa_PK PRIMARY KEY (id),
    CONSTRAINT Usuario_FK FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Inserção de dados na tabela Empresa
INSERT INTO Empresa (cnpj, nome, descricao, cidade, usuario_id) VALUES
('12345678000199', 'Empresa A', 'Descrição da Empresa A', 'São Paulo', 1);

-- Criação da tabela Profissional
CREATE TABLE Profissional (
    id BIGINT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    dataNascimento VARCHAR(10) NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT Profissional_PK PRIMARY KEY (id),
    CONSTRAINT Usuario_FK FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Inserção de dados na tabela Profissional
INSERT INTO Profissional (nome, cpf, telefone, sexo, dataNascimento, usuario_id) VALUES
('João Silva', '12345678901', '(11) 98765-4321', 'Masculino', '1990-01-01', 2);

-- Criação da tabela Vaga
CREATE TABLE Vaga (
    id BIGINT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    remuneracao FLOAT NOT NULL,
    empresa_id BIGINT NOT NULL,
    dataLimiteInscricao VARCHAR(10) NOT NULL,
    CONSTRAINT Vaga_PK PRIMARY KEY (id),
    CONSTRAINT Empresa_FK FOREIGN KEY (empresa_id) REFERENCES Empresa(id) ON DELETE CASCADE
);

-- Inserção de dados na tabela Vaga

--INSERT INTO Vaga (empresa_id, descricao, remuneracao, dataLimiteInscricao) VALUES

INSERT INTO Vaga (titulo, remuneracao, empresa_id, dataLimiteInscricao) VALUES
('Vaga de Estágio em Desenvolvimento Java', 1500.00, 1, '2024-06-30');

-- Criação da tabela Candidatura
CREATE TABLE Candidatura (
    id BIGINT AUTO_INCREMENT,
    data VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('ABERTO', 'NÃO SELECIONADO', 'ENTREVISTA')),
    vaga_id BIGINT NOT NULL,
    profissional_id BIGINT NOT NULL,
    CONSTRAINT Candidatura_PK PRIMARY KEY (id),
    CONSTRAINT Vaga_FK FOREIGN KEY (vaga_id) REFERENCES Vaga(id) ON DELETE CASCADE,
    CONSTRAINT Profissional_FK FOREIGN KEY (profissional_id) REFERENCES Profissional(id) ON DELETE CASCADE,
    UNIQUE (vaga_id, profissional_id) -- Restrição para garantir que um profissional não se candidate mais de uma vez à mesma vaga
);

-- Inserção de dados na tabela Candidatura
INSERT INTO Candidatura (data, status, vaga_id, profissional_id) VALUES
('2024-05-28', 'ABERTO', 1, 1);
disconnect;
quit;