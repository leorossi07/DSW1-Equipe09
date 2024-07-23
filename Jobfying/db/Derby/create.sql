-- Connect to the database
connect 'jdbc:derby:JobfyingTest;create=true;user=root;password=root';

-- Create Usuario table
CREATE TABLE Usuario(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    papel VARCHAR(20) NOT NULL CHECK (papel IN ('EMPRESA', 'PROFISSIONAL')),
    PRIMARY KEY (id)
);

-- Create Empresa table
CREATE TABLE Empresa(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Create Profissional table
CREATE TABLE Profissional(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    dataNascimento VARCHAR(10) NOT NULL,
    usuario_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Create Vaga table
CREATE TABLE Vaga(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    titulo VARCHAR(100) NOT NULL,
    remuneracao FLOAT NOT NULL,
    empresa_id BIGINT NOT NULL,
    dataLimiteInscricao VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (empresa_id) REFERENCES Empresa(id) ON DELETE CASCADE
);

-- Create Candidatura table
CREATE TABLE Candidatura(
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    data VARCHAR(10) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('ABERTO', 'NÃO SELECIONADO', 'ENTREVISTA')),
    vaga_id BIGINT NOT NULL,
    profissional_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vaga_id) REFERENCES Vaga(id) ON DELETE CASCADE,
    FOREIGN KEY (profissional_id) REFERENCES Profissional(id) ON DELETE CASCADE
);

-- Insert data into Usuario table
INSERT INTO Usuario(login, senha, papel) VALUES
('google', 'google123', 'EMPRESA'),
('profissional1', 'prof123', 'PROFISSIONAL'),
('amazon', 'amazon234', 'EMPRESA'),
('profissional2', 'prof234', 'PROFISSIONAL'),
('microsoft', 'microsoft345', 'EMPRESA'),
('profissional3', 'prof345', 'PROFISSIONAL');

-- Insert data into Empresa table
INSERT INTO Empresa(cnpj, nome, descricao, cidade, usuario_id) VALUES
('12345678000199', 'Google', 'Leading search engine and tech company', 'Mountain View', (SELECT id FROM Usuario WHERE login = 'google')),   
('98765432000123', 'Amazon', 'E-commerce and cloud computing giant', 'Seattle', (SELECT id FROM Usuario WHERE login = 'amazon')),
('45678912345678', 'Microsoft', 'Software and technology solutions', 'Redmond', (SELECT id FROM Usuario WHERE login = 'microsoft'));

-- Insert data into Profissional table
INSERT INTO Profissional(nome, cpf, telefone, sexo, dataNascimento, usuario_id) VALUES        
('Joao Silva', '12345678901', '(11) 98765-4321', 'Masculino', '1990-01-01', (SELECT id FROM Usuario WHERE login = 'profissional1')),
('Maria Souza', '98765432100', '(21) 98765-4322', 'Feminino', '1985-05-15', (SELECT id FROM Usuario WHERE login = 'profissional2')),
('Carlos Lima', '45678912345', '(31) 98765-4323', 'Masculino', '1992-03-10', (SELECT id FROM Usuario WHERE login = 'profissional3'));

-- Insert data into Vaga table
INSERT INTO Vaga(titulo, remuneracao, empresa_id, dataLimiteInscricao) VALUES
('Software Engineer', 120000, (SELECT id FROM Empresa WHERE nome = 'Google'), '2024-12-31'),
('Data Scientist', 115000, (SELECT id FROM Empresa WHERE nome = 'Amazon'), '2024-12-31'),
('Project Manager', 90000, (SELECT id FROM Empresa WHERE nome = 'Microsoft'), '2024-12-31');

-- Insert data into Candidatura table
INSERT INTO Candidatura(data, status, vaga_id, profissional_id) VALUES
('2024-01-01', 'ABERTO', (SELECT id FROM Vaga WHERE titulo = 'Software Engineer'), (SELECT id FROM Profissional WHERE nome = 'Joao Silva')),
('2024-01-02', 'ENTREVISTA', (SELECT id FROM Vaga WHERE titulo = 'Data Scientist'), (SELECT id FROM Profissional WHERE nome = 'Maria Souza')),
('2024-01-03', 'NÃO SELECIONADO', (SELECT id FROM Vaga WHERE titulo = 'Project Manager'), (SELECT id FROM Profissional WHERE nome = 'Carlos Lima'));



disconnect;

quit;
