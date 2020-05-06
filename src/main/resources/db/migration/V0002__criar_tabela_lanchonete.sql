CREATE TABLE tb_lanche (
  id_lanche bigserial,
  nome varchar(255) DEFAULT NULL,
  valor decimal(15,2) DEFAULT 0,
  PRIMARY KEY (id_lanche)
);

CREATE TABLE tb_adicional (
  id_adicional bigserial,
  tipo varchar(15) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_adicional)
);

insert into tb_lanche (nome, valor) values ('Hamburguer' , 10.0), ('X-Burguer', 12.0), ('X-Salada' , 13.0);

insert into tb_adicional (tipo, nome) values ('TIPO_PAO' , 'Frances'), ('TIPO_PAO' , 'Integral'), ('TIPO_PAO' , 'Baguete');

insert into tb_adicional (tipo, nome) values ('TIPO_QUEIJO' , 'Cheddar'), ('TIPO_QUEIJO' , 'Mussarela'), ('TIPO_QUEIJO' , 'Mineiro');

insert into tb_adicional (tipo, nome) values ('TIPO_RECHEIO' , 'Catupiry'), ('TIPO_RECHEIO' , 'Bacon'), ('TIPO_RECHEIO' , 'Milho');