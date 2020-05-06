ALTER TABLE tb_pedido 
  ADD COLUMN troco varchar(15) DEFAULT NULL,
  ADD COLUMN forma_pagamento varchar(15) DEFAULT NULL;