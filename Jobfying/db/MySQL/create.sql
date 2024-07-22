-- Drop and create the database
drop database if exists JobfyingTest;

create database JobfyingTest;

use JobfyingTest;

-- Create Usuario table
create table Usuario(
    id bigint not null auto_increment,
    login varchar(50) not null unique,
    senha varchar(50) not null,
    papel varchar(20) not null check (papel in ('EMPRESA', 'PROFISSIONAL')),
    primary key (id)
);

-- Create Empresa table
create table Empresa(
    id bigint not null auto_increment,
    cnpj varchar(14) not null unique,
    nome varchar(100) not null,
    descricao varchar(255) not null,
    cidade varchar(50) not null,
    usuario_id bigint not null,
    primary key (id),
    foreign key (usuario_id) references Usuario(id) on delete cascade
);

-- Create Profissional table
create table Profissional(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone varchar(15) not null,
    sexo varchar(10) not null,
    dataNascimento varchar(10) not null,
    usuario_id bigint not null,
    primary key (id),
    foreign key (usuario_id) references Usuario(id) on delete cascade
);

-- Create Vaga table
create table Vaga(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    remuneracao float not null,
    empresa_id bigint not null,
    dataLimiteInscricao varchar(10) not null,
    primary key (id),
    foreign key (empresa_id) references Empresa(id) on delete cascade
);

-- Create Candidatura table
create table Candidatura(
    id bigint not null auto_increment,
    data varchar(10) not null,
    status varchar(20) not null check (status in ('ABERTO', 'NÃO SELECIONADO', 'ENTREVISTA')),
    vaga_id bigint not null,
    profissional_id bigint not null,
    primary key (id),
    foreign key (vaga_id) references Vaga(id) on delete cascade,
    foreign key (profissional_id) references Profissional(id) on delete cascade,
    unique (vaga_id, profissional_id) -- Restrição para garantir que um profissional não se candidate mais de uma vez à mesma vaga
);

-- Insert data into Usuario table
insert into Usuario(login, senha, papel) values 
('google', 'google123', 'EMPRESA'),
('profissional1', 'prof123', 'PROFISSIONAL'),
('amazon', 'amazon234', 'EMPRESA'),
('profissional2', 'prof234', 'PROFISSIONAL'),
('microsoft', 'microsoft345', 'EMPRESA'),
('profissional3', 'prof345', 'PROFISSIONAL'),
('apple', 'apple456', 'EMPRESA'),
('profissional4', 'prof456', 'PROFISSIONAL'),
('facebook', 'facebook567', 'EMPRESA'),
('profissional5', 'prof567', 'PROFISSIONAL'),
('twitter', 'twitter678', 'EMPRESA'),
('profissional6', 'prof678', 'PROFISSIONAL'),
('netflix', 'netflix789', 'EMPRESA'),
('profissional7', 'prof789', 'PROFISSIONAL'),
('tesla', 'tesla890', 'EMPRESA'),
('profissional8', 'prof890', 'PROFISSIONAL'),
('uber', 'uber901', 'EMPRESA'),
('profissional9', 'prof901', 'PROFISSIONAL'),
('spotify', 'spotify012', 'EMPRESA'),
('profissional10', 'prof012', 'PROFISSIONAL'),
('samsung', 'samsung1234', 'EMPRESA'),
('profissional11', 'prof1234', 'PROFISSIONAL'),
('adobe', 'adobe2345', 'EMPRESA'),
('profissional12', 'prof2345', 'PROFISSIONAL'),
('ibm', 'ibm3456', 'EMPRESA'),
('profissional13', 'prof3456', 'PROFISSIONAL'),
('intel', 'intel4567', 'EMPRESA'),
('profissional14', 'prof4567', 'PROFISSIONAL'),
('oracle', 'oracle5678', 'EMPRESA'),
('profissional15', 'prof5678', 'PROFISSIONAL');

-- Insert data into Empresa table
insert into Empresa(cnpj, nome, descricao, cidade, usuario_id) values 
('12345678000199', 'Google', 'Leading search engine and tech company', 'Mountain View', 1),
('98765432000123', 'Amazon', 'E-commerce and cloud computing giant', 'Seattle', 3),
('45678912345678', 'Microsoft', 'Software and technology solutions', 'Redmond', 5),
('23456789012345', 'Apple', 'Innovative consumer electronics', 'Cupertino', 7),
('34567890123456', 'Facebook', 'Social media and technology company', 'Menlo Park', 9),
('56789012345678', 'Twitter', 'Microblogging and social networking service', 'San Francisco', 11),
('67890123456789', 'Netflix', 'Streaming service for movies and TV shows', 'Los Gatos', 13),
('78901234567890', 'Tesla', 'Electric vehicles and clean energy', 'Palo Alto', 15),
('89012345678901', 'Uber', 'Ride-hailing and food delivery service', 'San Francisco', 17),
('90123456789012', 'Spotify', 'Music streaming service', 'Stockholm', 19),
('01234567890123', 'Samsung', 'Consumer electronics and technology', 'Seoul', 21),
('34567890123456', 'Adobe', 'Software solutions for creativity and design', 'San Jose', 23),
('67890123456789', 'IBM', 'Information technology and consulting', 'Armonk', 25),
('89012345678901', 'Intel', 'Semiconductor and technology company', 'Santa Clara', 27),
('12345678901234', 'Oracle', 'Enterprise software and cloud solutions', 'Redwood City', 29);

-- Insert data into Profissional table
insert into Profissional(nome, cpf, telefone, sexo, dataNascimento, usuario_id) values 
('João Silva', '12345678901', '(11) 98765-4321', 'Masculino', '1990-01-01', 2),
('Maria Souza', '98765432100', '(21) 98765-4322', 'Feminino', '1985-05-15', 4),
('Carlos Lima', '45678912345', '(31) 98765-4323', 'Masculino', '1992-03-10', 6),
('Ana Costa', '12345098765', '(41) 98765-4324', 'Feminino', '1988-12-20', 8),
('Paulo Oliveira', '98765012345', '(51) 98765-4325', 'Masculino', '1995-07-25', 10),
('Juliana Pereira', '12345067890', '(61) 98765-4326', 'Feminino', '1993-04-30', 12),
('Ricardo Santos', '98765098765', '(71) 98765-4327', 'Masculino', '1987-08-15', 14),
('Patricia Almeida', '12345678910', '(81) 98765-4328', 'Feminino', '1991-02-28', 16),
('Roberto Nunes', '98765432101', '(91) 98765-4329', 'Masculino', '1986-11-11', 18),
('Fernanda Machado', '12345098760', '(31) 98765-4330', 'Feminino', '1994-06-14', 20),
('Gustavo Ferreira', '98765012340', '(41) 98765-4331', 'Masculino', '1989-03-23', 22),
('Larissa Mendes', '12345067891', '(51) 98765-4332', 'Feminino', '1996-09-07', 24),
('Marcelo Silva', '98765098764', '(61) 98765-4333', 'Masculino', '1990-10-19', 26),
('Aline Fernandes', '12345678911', '(71) 98765-4334', 'Feminino', '1987-01-31', 28),
('Bruno Oliveira', '98765432102', '(81) 98765-4335', 'Masculino', '1992-12-05', 30);

-- Insert data into Vaga table
insert into Vaga(titulo, remuneracao, empresa_id, dataLimiteInscricao) values 
('Vaga de Estágio em Desenvolvimento Java', 1500.00, 1, '2024-06-30'),
('Analista de Sistemas Pleno', 3000.00, 1, '2024-07-15'),
('Gerente de Projetos', 5000.00, 2, '2024-08-01'),
('Desenvolvedor Frontend', 2500.00, 3, '2024-07-20'),
('Engenheiro de Dados', 4000.00, 2, '2024-09-10'),
('Administrador de Redes', 3500.00, 4, '2024-07-05'),
('Designer UX/UI', 2800.00, 5, '2024-07-25'),
('Analista de Marketing', 3200.00, 6, '2024-08-15'),
('Consultor SAP', 4500.00, 7, '2024-09-01'),
('Especialista em Segurança', 5500.00, 8, '2024-09-20'),
('Desenvolvedor Mobile', 2700.00, 9, '2024-10-10'),
('Analista de Testes', 2900.00, 10, '2024-10-25'),
('DevOps Engineer', 4200.00, 11, '2024-11-05'),
('Gerente de TI', 6000.00, 12, '2024-11-20'),
('Analista de Negócios', 3100.00, 13, '2024-12-01');

-- Insert data into Candidatura table
insert into Candidatura(data, status, vaga_id, profissional_id) values 
('2024-05-28', 'ABERTO', 1, 1),
('2024-06-15', 'ENTREVISTA', 2, 1),
('2024-06-20', 'NÃO SELECIONADO', 3, 2),
('2024-07-01', 'ABERTO', 4, 3),
('2024-07-05', 'ENTREVISTA', 5, 2),
('2024-07-10', 'ABERTO', 6, 3),
('2024-07-15', 'NÃO SELECIONADO', 7, 1),
('2024-07-20', 'ENTREVISTA', 8, 2),
('2024-07-25', 'ABERTO', 9, 3),
('2024-07-30', 'ENTREVISTA', 10, 1),
('2024-08-01', 'NÃO SELECIONADO', 11, 2),
('2024-08-05', 'ABERTO', 12, 3),
('2024-08-10', 'ENTREVISTA', 13, 1),
('2024-08-15', 'NÃO SELECIONADO', 14, 2),
('2024-08-20', 'ABERTO', 15, 3),
('2024-08-25', 'ENTREVISTA', 1, 1),
('2024-08-30', 'NÃO SELECIONADO', 2, 2),
('2024-09-01', 'ABERTO', 3, 3),
('2024-09-05', 'ENTREVISTA', 4, 1),
('2024-09-10', 'NÃO SELECIONADO', 5, 2),
('2024-09-15', 'ABERTO', 6, 3),
('2024-09-20', 'ENTREVISTA', 7, 1),
('2024-09-25', 'NÃO SELECIONADO', 8, 2),
('2024-10-01', 'ABERTO', 9, 3),
('2024-10-05', 'ENTREVISTA', 10, 1),
('2024-10-10', 'NÃO SELECIONADO', 11, 2),
('2024-10-15', 'ABERTO', 12, 3),
('2024-10-20', 'ENTREVISTA', 13, 1),
('2024-10-25', 'NÃO SELECIONADO', 14, 2),
('2024-11-01', 'ABERTO', 15, 3);

