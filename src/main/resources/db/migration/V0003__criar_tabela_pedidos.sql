CREATE TABLE tb_pedido (
  id_pedido bigserial,
  nome varchar(255) DEFAULT NULL,
  endereco varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_pedido)
);

CREATE TABLE tb_item_pedido (
  id_item_pedido bigserial,
  id_lanche bigint DEFAULT NULL,
  id_pedido bigint NOT NULL,
  tipo_pao bigint DEFAULT NULL,
  tipo_queijo bigint DEFAULT NULL,
  tipo_recheio bigint DEFAULT NULL,
  salada varchar(15) DEFAULT NULL,
  quantidade int DEFAULT 1,
  valor decimal(15, 2) DEFAULT 0,
  PRIMARY KEY (id_item_pedido),
  FOREIGN KEY (id_lanche) REFERENCES tb_lanche(id_lanche),
  FOREIGN KEY (id_pedido) REFERENCES tb_pedido(id_pedido)
);

CREATE TABLE tb_item_molho (
  id_item_molho bigserial,
  id_item_pedido bigint,
  molho varchar(15) DEFAULT NULL,
  PRIMARY KEY (id_item_molho),
  FOREIGN KEY (id_item_pedido) REFERENCES tb_item_pedido(id_item_pedido)
);

CREATE TABLE tb_item_tempero (
  id_item_tempero bigserial,
  id_item_pedido bigint,
  tempero varchar(15) DEFAULT NULL,
  PRIMARY KEY (id_item_tempero),
  FOREIGN KEY (id_item_pedido) REFERENCES tb_item_pedido(id_item_pedido)
);