CREATE TABLE tb_grupo (
  id_grupo serial,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_grupo)
);

CREATE TABLE tb_permissao (
  id_permissao serial,
  nome varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_permissao)
);

CREATE TABLE tb_usuario (
  id_usuario serial,
  nome varchar(200) DEFAULT NULL,
  email varchar(200) DEFAULT NULL,
  senha varchar(200) DEFAULT NULL,
  ativo boolean DEFAULT true,
  data_nascimento date DEFAULT NULL,
  PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_usuario_has_tb_grupo (
  id_usuario integer NOT NULL,
  id_grupo integer NOT NULL,
  PRIMARY KEY (id_usuario,id_grupo),
  FOREIGN KEY (id_grupo) REFERENCES tb_grupo(id_grupo),
  FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario)
);

CREATE TABLE tb_permissao_has_tb_grupo (
  id_permissao integer NOT NULL,
  id_grupo integer NOT NULL,
  PRIMARY KEY (id_permissao,id_grupo),
  FOREIGN KEY (id_grupo) REFERENCES tb_grupo(id_grupo),
  FOREIGN KEY (id_permissao) REFERENCES tb_permissao(id_permissao)
);

INSERT INTO tb_grupo(nome) VALUES ('Administrador');
INSERT INTO tb_permissao(nome) VALUES ('ROLE_CADASTRO_USUARIO');
INSERT INTO tb_permissao_has_tb_grupo VALUES (1,1);
INSERT INTO tb_usuario(nome, email, senha, ativo) VALUES ('Admin','admin@admin.com.br','$2a$10$5YMm3s179b8Xs98nChqRSezrt3kJlxc5xbEEfdT.u.eeis/RS4NO6',true);
INSERT INTO tb_usuario_has_tb_grupo VALUES (1,1);