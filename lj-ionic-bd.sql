-- -----------------------------------------------------
-- Table `lj-ionic-db`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cidade` (
  `id_cidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_cidade` VARCHAR(255) NULL DEFAULT NULL,
  `estado_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cidade`),
  INDEX `FKkworrwk40xj58kevvh3evi500` (`estado_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf_cnpj_cliente` VARCHAR(255) NULL DEFAULT NULL,
  `email_cliente` VARCHAR(255) NULL DEFAULT NULL,
  `nome_cliente` VARCHAR(255) NULL DEFAULT NULL,
  `tipo_cliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `UK_bx67lxmwaylshxxgx4bqafl76` (`email_cliente` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` INT(11) NOT NULL AUTO_INCREMENT,
  `bairro_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `cep_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `complemento_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `logradouro_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `numero_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `cidade_id` INT(11) NULL DEFAULT NULL,
  `cliente_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  INDEX `FK8b1kcb3wucapb8dejshyn5fsx` (`cidade_id` ASC),
  INDEX `FK8s7ivtl4foyhrfam9xqom73n9` (`cliente_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estado` (
  `id_estado` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_estado` VARCHAR(255) NULL DEFAULT NULL,
  `sigla_estado` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`item_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `item_pedido` (
  `desconto_item_pedido` DOUBLE NULL DEFAULT NULL,
  `preco_item_pedido` DOUBLE NULL DEFAULT NULL,
  `quant_item_pedido` INT(11) NULL DEFAULT NULL,
  `pedido_id` INT(11) NOT NULL,
  `produto_id` INT(11) NOT NULL,
  PRIMARY KEY (`pedido_id`, `produto_id`),
  INDEX `FKtk55mn6d6bvl5h0no5uagi3sf` (`produto_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pagamento` (
  `pedido_id` INT(11) NOT NULL,
  `estado_pagamento` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pedido_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`pagamento_boleto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pagamento_boleto` (
  `data_pagamento` DATETIME NULL DEFAULT NULL,
  `data_vencimento` DATETIME NULL DEFAULT NULL,
  `pedido_id` INT(11) NOT NULL,
  PRIMARY KEY (`pedido_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`pagamento_cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pagamento_cartao` (
  `num_parcelas` INT(11) NULL DEFAULT NULL,
  `pedido_id` INT(11) NOT NULL,
  PRIMARY KEY (`pedido_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` INT(11) NOT NULL AUTO_INCREMENT,
  `data_pedido` DATETIME NULL DEFAULT NULL,
  `cliente_id` INT(11) NULL DEFAULT NULL,
  `endereco_entrega_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id` ASC),
  INDEX `FKcrxxe5rpllxbh0sfi4a6rwphb` (`endereco_entrega_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `produto` (
  `id_produto` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` VARCHAR(255) NULL DEFAULT NULL,
  `preco` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`produto_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `produto_categoria` (
  `produto_id` INT(11) NOT NULL,
  `categoria_id` INT(11) NOT NULL,
  INDEX `FKq3g33tp7xk2juh53fbw6y4y57` (`categoria_id` ASC),
  INDEX `FK1c0y58d3n6x3m6euv2j3h64vt` (`produto_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `lj-ionic-db`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `telefone` (
  `cliente_id_cliente` INT(11) NOT NULL,
  `telefones` VARCHAR(255) NULL DEFAULT NULL,
  INDEX `FKbru3xlrlc1aea2qcgvhjy6dfa` (`cliente_id_cliente` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;

