CREATE SCHEMA `site_roupa` ;

USE site_roupa;


CREATE TABLE `site_roupa`.`usuario` (
  `usu_id` INT NOT NULL,
  `usu_data_criacao` DATETIME NOT NULL,
  `usu_nome` VARCHAR(100) NOT NULL,
  `usu_cpf` VARCHAR(11) NOT NULL,
  `usu_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usu_id`));


CREATE TABLE `site_roupa`.`fornecedor` (
  `frn_id` INT NOT NULL,
  `frn_razaoSocial` VARCHAR(100) NOT NULL,
  `frn_nomeFantasia` VARCHAR(100) NOT NULL,
  `frn_razaoResponsavel` VARCHAR(100) NOT NULL,
  `frn_cnpj` VARCHAR(14) NOT NULL,
  `frn_email` VARCHAR(45) NOT NULL,
  `frn_telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`frn_id`));

CREATE TABLE `site_roupa`.`funcionario` (
  `fun_id` INT NOT NULL,
  `fun_nivel_acesso` INT NOT NULL,
  PRIMARY KEY (`fun_id`));


CREATE TABLE `site_roupa`.`lote` (
  `lot_id` INT NOT NULL,
  `lot_data_criacao` DATETIME NOT NULL,
  `lot_precoCompraUnidade` DOUBLE NOT NULL,
  `lot_quantidadePecas` INT NOT NULL,
  `lot_fornecedor` INT NOT NULL,
  PRIMARY KEY (`lot_id`));

CREATE TABLE `site_roupa`.`nivel_acesso` (
  `nvl_id` INT NOT NULL,
  `nvl_descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nvl_id`));

CREATE TABLE `site_roupa`.`roupa` (
  `rou_id` INT NOT NULL,
  `rou_data_criacao` DATETIME NOT NULL,
  `roupacol` VARCHAR(45) NOT NULL,
  `rou_preco_venda` DOUBLE NOT NULL,
  `rou_quantidade_disponivel` INT NOT NULL,
  `rou_tamanho` INT NOT NULL,
  `rou_lote` INT NOT NULL,
  PRIMARY KEY (`rou_id`));


CREATE TABLE `site_roupa`.`tamanho` (
  `tam_id` INT NOT NULL,
  `tam_descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`tam_id`));


INSERT INTO `site_roupa`.`usuario` (`usu_id`, `usu_data_criacao` , `usu_nome`, `usu_cpf`, `usu_email`) VALUES (1, sysdate() , 'ADMINISTRADOR', 11111111111, 'admin@admin.com');
INSERT INTO `site_roupa`.`usuario` (`usu_id`, `usu_data_criacao` , `usu_nome`, `usu_cpf`, `usu_email`) VALUES (2, sysdate() , 'MODERADOR_JUNIOR', 11111111111, 'admin@admin.com');
INSERT INTO `site_roupa`.`usuario` (`usu_id`, `usu_data_criacao` , `usu_nome`, `usu_cpf`, `usu_email`) VALUES (3, sysdate() , 'MODERADOR_PLENO', 11111111111, 'admin@admin.com');
INSERT INTO `site_roupa`.`usuario` (`usu_id`, `usu_data_criacao` , `usu_nome`, `usu_cpf`, `usu_email`) VALUES (4, sysdate() , 'MODERADOR_SENIOR', 11111111111, 'admin@admin.com');

INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (1,"ADMINISTRADOR");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (2,"MODERADOR_JUNIOR");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (3,"MODERADOR_PLENO");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (4,"MODERADOR_SENIOR");


INSERT INTO `site_roupa`.`funcionario` (`fun_id`, `fun_nivel_acesso`)
VALUES (1,1);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`, `fun_nivel_acesso`)
VALUES (2,2);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`, `fun_nivel_acesso`)
VALUES (3,3);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`, `fun_nivel_acesso`)
VALUES (4,4);



/*DELETE FROM `site_roupa`.`usuario` WHERE (`usu_id` = '1');
DROP TABLE `site_roupa`.`usuario`;*/


