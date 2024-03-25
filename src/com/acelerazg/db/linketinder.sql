CREATE TABLE pais (
  id SERIAL PRIMARY KEY,
  nome varchar(100)
);

CREATE TABLE cep (
  id SERIAL PRIMARY KEY,
  cep varchar(8)
);

CREATE TABLE estados (
  id SERIAL PRIMARY KEY,
  uf char(2),
  nome varchar(100)
);

CREATE TABLE cidades (
  id SERIAL PRIMARY KEY,
  nome varchar(100),
  estado_id int
);

CREATE TABLE candidatos (
  id SERIAL PRIMARY KEY,
  nome varchar(100),
  sobrenome varchar(100),
  cpf varchar(11),
  dt_nascimento date,
  email varchar(255),
  descricao text,
  senha varchar(255),
  pais_id int,
  cep_id int,
  estado_id int
);

CREATE TABLE empresas (
  id SERIAL PRIMARY KEY,
  nome varchar(255),
  cnpj varchar(14),
  email varchar(255),
  descricao text,
  senha varchar(255),
  pais_id int,
  cep_id int,
  estado_id int
);

CREATE TABLE competencias (
  id SERIAL PRIMARY KEY,
  competencia varchar(100)
);

CREATE TABLE competencias_candidatos (
  candidato_id int,
  competencia_id int
);

CREATE TABLE vagas (
  id SERIAL PRIMARY KEY,
  nome varchar(100),
  descricao text,
  cidade_id int,
  empresa_id int
);

CREATE TABLE competencias_vaga (
  competencia_id int,
  vaga_id int
);

CREATE TABLE match (
  id SERIAL PRIMARY KEY,
  candidato_id int,
  vaga_id int
);

ALTER TABLE cidades ADD FOREIGN KEY (estado_id) REFERENCES estados (id);

ALTER TABLE candidatos ADD FOREIGN KEY (pais_id) REFERENCES pais (id);

ALTER TABLE candidatos ADD FOREIGN KEY (cep_id) REFERENCES cep (id);

ALTER TABLE candidatos ADD FOREIGN KEY (estado_id) REFERENCES estados (id);

ALTER TABLE empresas ADD FOREIGN KEY (pais_id) REFERENCES pais (id);

ALTER TABLE empresas ADD FOREIGN KEY (cep_id) REFERENCES cep (id);

ALTER TABLE empresas ADD FOREIGN KEY (estado_id) REFERENCES estados (id);

ALTER TABLE competencias_candidatos ADD FOREIGN KEY (candidato_id) REFERENCES candidatos (id);

ALTER TABLE competencias_candidatos ADD FOREIGN KEY (competencia_id) REFERENCES competencias (id);

ALTER TABLE vagas ADD FOREIGN KEY (cidade_id) REFERENCES cidades (id);

ALTER TABLE vagas ADD FOREIGN KEY (empresa_id) REFERENCES empresas (id);

ALTER TABLE competencias_vaga ADD FOREIGN KEY (competencia_id) REFERENCES competencias (id);

ALTER TABLE competencias_vaga ADD FOREIGN KEY (vaga_id) REFERENCES vagas (id);

ALTER TABLE match ADD FOREIGN KEY (candidato_id) REFERENCES candidatos (id);

ALTER TABLE match ADD FOREIGN KEY (vaga_id) REFERENCES vagas (id);

INSERT INTO competencias (competencia)
VALUES  ('Java'),
        ('Groovy'),
        ('Python'),
        ('JavaScript'),
        ('TypeScript'),
        ('Scrumban'),
        ('Angular'),
        ('Web Crawler');

INSERT INTO pais (nome)
VALUES ('Brasil');

INSERT INTO estados (uf, nome)
VALUES ('AC', 'Acre'),
       ('AL', 'Alagoas'),
       ('AP', 'Amapa'),
       ('AM', 'Amazonas'),
       ('BA', 'Bahia'),
       ('CE', 'Ceara'),
       ('DF', 'Distrito Federal'),
       ('ES', 'Espirito Santo'),
       ('GO', 'Goias'),
       ('MA', 'Maranhao'),
       ('MT', 'Mato Grosso'),
       ('MS', 'Mato Grosso do Sul'),
       ('MG', 'Minas Gerais'),
       ('PA', 'Para'),
       ('PB', 'Paraiba'),
       ('PR', 'Parana'),
       ('PE', 'Pernambuco'),
       ('PI', 'Piaui'),
       ('RJ', 'Rio de Janeiro'),
       ('RN', 'Rio Grande do Norte'),
       ('RS', 'Rio Grande do Sul'),
       ('RO', 'Rondonia'),
       ('RR', 'Roraima'),
       ('SC', 'Santa Catarina'),
       ('SP', 'Sao Paulo'),
       ('SE', 'Sergipe'),
       ('TO', 'Tocantins');

INSERT INTO cep (cep)
VALUES ('72000000');

INSERT INTO candidatos (nome, sobrenome, cpf, dt_nascimento, email, descricao, senha, pais_id, cep_id, estado_id)
VALUES
    ('Jose', 'das Couves', '11122233344', '2004-02-18', 'jose.couves@acelerazg.com.br', 'Descolado, responsavel e gosto de estudar', '123456', 1, 1, 7),
    ('Maria', 'das Orquideas', '22233344455', '2001-01-14', 'maria.orquideas@acelerazg.com.br', 'Bem correta e organizada', '123456', 1, 1, 9),
    ('Francisco', 'das Abobrinhas', '33344455566', '2006-03-20', 'francisco.abobrinhas@acelerazg.com.br', 'Bastante comunicativo, cativante', '123456', 1, 1, 13),
    ('Marcia', 'das Flores', '44455566677', '1995-05-03', 'marcia.flores@acelerazg.com.br', 'Apaixonada por desafios, focada em superar barreiras', '123456', 1, 1, 10),
    ('Joao', 'do Feijao', '55566677788', '1989-10-07', 'joao.feijao@acelerazg.com.br', 'Antenado em lançamentos tecnologicos, super entusiasmado', '123456', 1, 1, 11);

INSERT INTO empresas (nome, cnpj, email, descricao, senha, pais_id, cep_id, estado_id)
VALUES
    ('AMENDOIM LTDA', '11222333000144', 'contato@amendoim.com.br', 'Empresa de grande porte, focada em desenvolver solucoes inovadoras', '123456', 1, 1, 7),
    ('CASTANHA LTDA', '22333444000155', 'contado@castanha.com.br', 'Empresa solida, com forte atuacao em desenvolver programas', '123456', 1, 1, 14),
    ('PAO DE QUEIJO LTDA', '33444555000166', 'contado@pdq.com.br', 'Empresa homogenia no setor de tecnologia, mistura solucoes de infraestrutura e desenvolvimento', '123456', 1, 1, 13),
    ('BRIGADEIRO LTDA', '44555666000177', 'contato@brigadeiro.com.br', 'Empresa de pequeno porte, mas trazendo grandes solucoes para seus clientes', '123456', 1, 1, 25),
    ('MATE LTDA', '55666777000188', 'contato@mate.com.br', 'Empresa em expansao, buscando fluidez no mercado', '123456', 1, 1, 21);

INSERT INTO competencias_candidatos (candidato_id, competencia_id)
VALUES 	(1,1),
        (1,2),
        (1,3),
        (1,6),
        (2,6),
        (2,5),
        (2,4),
        (2,8),
        (3,4),
        (3,5),
        (3,7),
        (3,6),
        (4,1),
        (4,5),
        (4,7),
        (4,6),
        (5,7),
        (5,3),
        (5,5),
        (5,6);