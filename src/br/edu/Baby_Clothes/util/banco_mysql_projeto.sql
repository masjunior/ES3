CREATE SCHEMA `site_roupa` ;
USE site_roupa;

CREATE TABLE `site_roupa`.`usuario` (
  `usu_id` INT NOT NULL,
  `usu_data_criacao` DATETIME NOT NULL,
  `usu_habilitado` BOOLEAN NOT NULL,
  `usu_email` VARCHAR(45) NOT NULL,
  `usu_senha` VARCHAR(45) NOT NULL,
  `usu_nivel_acesso` INT NOT NULL,
  PRIMARY KEY (`usu_id`));

CREATE TABLE `site_roupa`.`fornecedor` (
  `frn_id` INT NOT NULL,
  `frn_data_criacao` DATETIME NOT NULL,
  `frn_habilitado` BOOLEAN NOT NULL,
  `frn_razaoSocial` VARCHAR(100) NOT NULL,
	`frn_cnpj` VARCHAR(14) NOT NULL,
  `frn_nomeFantasia` VARCHAR(100) NOT NULL,
  `frn_razaoResponsavel` VARCHAR(100) NOT NULL,
  `frn_email` VARCHAR(45) NOT NULL,
  `frn_telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`frn_id`));

CREATE TABLE `site_roupa`.`funcionario` (
  `fun_id` INT NOT NULL,	
  `fun_nome` VARCHAR(100) NOT NULL,
  `fun_cpf` VARCHAR(11) NOT NULL,
	`fun_usuario` INT NOT NULL,
  PRIMARY KEY (`fun_id`));

CREATE TABLE `site_roupa`.`lote` (
  `lot_id` INT NOT NULL,
  `lot_data_criacao` DATETIME NOT NULL,
  `lot_habilitado` BOOLEAN NOT NULL,
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
  `rou_habilitado` BOOLEAN NOT NULL,
	`rou_marca` VARCHAR(45) NOT NULL,
  `rou_preco_venda` DOUBLE NOT NULL,
  `rou_quantidade_disponivel` INT NOT NULL,
  `rou_tamanho` INT NOT NULL,
  `rou_lote` INT NOT NULL,
  PRIMARY KEY (`rou_id`));

CREATE TABLE `site_roupa`.`tamanho` (
  `tam_id` INT NOT NULL,
  `tam_descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`tam_id`));

/* NIVEL DE ACESSO */
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (4,"ADMINISTRADOR");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (1,"MODERADOR_JUNIOR");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (2,"MODERADOR_PLENO");
INSERT INTO `site_roupa`.`nivel_acesso` (`nvl_id`, `nvl_descricao`)
VALUES (3,"MODERADOR_SENIOR");

/* USUARIO */
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (1, sysdate() , true,'admin@admin.com', 11111111111, 4);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (2, sysdate() , true,'junior@admin.com', 22222222222, 1);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (3, sysdate() , true,'pleno@admin.com', 33333333333, 2);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (4, sysdate() , true,'senior@admin.com', 44444444444, 3);

/* FUNCIONARIO */
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (1,"ADMINISTRADOR",11111111111,1);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (2,"MODERADOR_JUNIOR",22222222222,2);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (3,"MODERADOR_PLENO",33333333333,3);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (4,"MODERADOR_SENIOR",44444444444,4);



/*
ALTER TABLE `site_roupa`.`funcionario` 
ADD INDEX `fk_fun_usu_idx` (`fun_usuario` ASC) VISIBLE;
;
ALTER TABLE `site_roupa`.`funcionario` 
ADD CONSTRAINT `fk_fun_usu`
  FOREIGN KEY (`fun_usuario`)
  REFERENCES `site_roupa`.`usuario` (`usu_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
DROP TRIGGER IF EXISTS `site_roupa`.`funcionario_BEFORE_INSERT`;

DELIMITER $$
USE `site_roupa`$$
$$
DELIMITER ;
*/
                        

/*DELETE FROM `site_roupa`.`usuario` WHERE (`usu_id` = '1');*/
/*DROP TABLE `site_roupa`.`usuario`;*/
/* DROP DATABASE `site_roupa`;*/


