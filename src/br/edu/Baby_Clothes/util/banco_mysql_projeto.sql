CREATE SCHEMA `site_roupa` ;
USE site_roupa;

CREATE TABLE `site_roupa`.`usuario` (
  `usu_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `usu_data_criacao` DATETIME NOT NULL,
  `usu_habilitado` BOOLEAN NOT NULL,
  `usu_email` VARCHAR(45) NOT NULL,
  `usu_senha` VARCHAR(45) NOT NULL,
  `usu_nivel_acesso` INT NOT NULL);

CREATE TABLE `site_roupa`.`fornecedor` (
  `frn_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `frn_data_criacao` DATETIME NOT NULL,
  `frn_habilitado` BOOLEAN NOT NULL,
  `frn_razaoSocial` VARCHAR(100) NOT NULL,
	`frn_cnpj` VARCHAR(14) NOT NULL,
  `frn_nomeFantasia` VARCHAR(100) NOT NULL,
  `frn_razaoResponsavel` VARCHAR(100) NOT NULL,
  `frn_email` VARCHAR(45) NOT NULL,
  `frn_telefone` VARCHAR(45) NOT NULL);

CREATE TABLE `site_roupa`.`funcionario` (
  `fun_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,	
  `fun_nome` VARCHAR(100) NOT NULL,
  `fun_cpf` VARCHAR(11) NOT NULL,
	`fun_usuario` INT NOT NULL);

CREATE TABLE `site_roupa`.`lote` (
  `lot_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `lot_data_criacao` DATETIME NOT NULL,
  `lot_habilitado` BOOLEAN NOT NULL,
  `lot_precoCompraUnidade` DOUBLE NOT NULL,
  `lot_quantidadePecas` INT NOT NULL,
  `lot_fornecedor` INT NOT NULL );

CREATE TABLE `site_roupa`.`nivel_acesso` (
  `nvl_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nvl_descricao` VARCHAR(45) NOT NULL);

CREATE TABLE `site_roupa`.`roupa` (
  `rou_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `rou_data_criacao` DATETIME NOT NULL,
  `rou_habilitado` BOOLEAN NOT NULL,
	`rou_marca` VARCHAR(45) NOT NULL,
  `rou_preco_venda` DOUBLE NOT NULL,
  `rou_quantidade_disponivel` INT NOT NULL,
  `rou_tamanho` INT NOT NULL,
  `rou_cor` VARCHAR(45) NOT NULL,
  `rou_lote` INT NOT NULL);

CREATE TABLE `site_roupa`.`tamanho` (
  `tam_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tam_descricao` VARCHAR(100) NOT NULL);
  
  /* INSERT */

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
							VALUES (1, sysdate() , true,'admin@admin.com', 'admin', 4);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (2, sysdate() , true,'junior@junior.com', 'junior', 1);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (3, sysdate() , true,'pleno@pleno.com', 'pleno', 2);
INSERT INTO `site_roupa`.`usuario` (`usu_id`,`usu_data_criacao`, `usu_habilitado`, `usu_email`, `usu_senha`, `usu_nivel_acesso`)
							VALUES (4, sysdate() , true,'senior@senior.com', 'senior', 3);

/* FUNCIONARIO */
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (1,"ADMINISTRADOR",84411511053,1);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (2,"MODERADOR_JUNIOR",15258065057,2);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (3,"MODERADOR_PLENO",86669975082,3);
INSERT INTO `site_roupa`.`funcionario` (`fun_id`,`fun_nome`,`fun_cpf`, `fun_usuario`)
VALUES (4,"MODERADOR_SENIOR",04157904095,4);

/* FORNECEDOR */
INSERT INTO `site_roupa`.`fornecedor`
(`frn_id`, `frn_data_criacao`, `frn_habilitado`, `frn_razaoSocial`, `frn_nomeFantasia`, `frn_razaoResponsavel`, `frn_cnpj`, `frn_email`, `frn_telefone`) 
VALUES (1,sysdate(),true,'primeiro','testeprimeiro','primeiroMarco','44030525000145','primeiro@teste.com','1111111111');

/* LOTE */
INSERT INTO `site_roupa`.`lote`
(`lot_id`,`lot_data_criacao`,`lot_habilitado`,`lot_precoCompraUnidade`,`lot_quantidadePecas`,`lot_fornecedor`)
VALUES
(1,sysdate(),1,1,3000,1);

/* TAMANHO */
INSERT INTO `site_roupa`.`tamanho` (`tam_id`,`tam_descricao`) VALUES (1,"RN");
INSERT INTO `site_roupa`.`tamanho` (`tam_id`,`tam_descricao`) VALUES (2,"P");
INSERT INTO `site_roupa`.`tamanho` (`tam_id`,`tam_descricao`) VALUES (3,"M");
INSERT INTO `site_roupa`.`tamanho` (`tam_id`,`tam_descricao`) VALUES (4,"G");
INSERT INTO `site_roupa`.`tamanho` (`tam_id`,`tam_descricao`) VALUES (5,"GG");

/* ROUPA */
INSERT INTO `site_roupa`.`roupa`
(`rou_id`,`rou_data_criacao`,`rou_habilitado`,`rou_marca`,`rou_preco_venda`,`rou_quantidade_disponivel`,`rou_tamanho`,`rou_cor`,`rou_lote`)
VALUES(1, sysdate(),1,"marca1",2,1,1,"cor1",1);

/* FOREIGN KEY */
ALTER TABLE `site_roupa`.`usuario`  ADD CONSTRAINT `FK_USU_NVL`   FOREIGN KEY (`usu_nivel_acesso`)
REFERENCES `site_roupa`.`nivel_acesso` (`nvl_id`)   ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `site_roupa`.`funcionario`  ADD CONSTRAINT `FK_FUN_USU`   FOREIGN KEY (`fun_usuario`)
REFERENCES `site_roupa`.`usuario` (`usu_id`)   ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `site_roupa`.`lote`  ADD CONSTRAINT `FK_LOT_FRN`   FOREIGN KEY (`lot_fornecedor`)
REFERENCES `site_roupa`.`fornecedor` (`frn_id`)   ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `site_roupa`.`roupa`  ADD CONSTRAINT `FK_ROU_LOT`   FOREIGN KEY (`rou_lote`)
REFERENCES `site_roupa`.`lote` (`lot_id`)   ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `site_roupa`.`roupa`  ADD CONSTRAINT `FK_ROU_TAM`   FOREIGN KEY (`rou_tamanho`)
REFERENCES `site_roupa`.`tamanho` (`tam_id`)   ON DELETE CASCADE ON UPDATE CASCADE;
                        

/* INDEX */

CREATE INDEX `FK_USU_NVL` ON `site_roupa`.`usuario` (usu_nivel_acesso);
CREATE INDEX `FK_FUN_USU` ON `site_roupa`.`funcionario` (fun_usuario);
CREATE INDEX `FK_LOT_FRN` ON `site_roupa`.`lote` (lot_fornecedor);
CREATE INDEX `FK_ROU_LOT` ON `site_roupa`.`roupa` (rou_lote);
CREATE INDEX `FK_ROU_TAM` ON `site_roupa`.`roupa` (rou_tamanho);

 
/* CREATE OR REPLACE
TRIGGER LABBD.TG_CLI_BI 
BEFORE INSERT ON LABBD.CLIENTE
FOR EACH ROW
BEGIN
  :new.cli_id := LABBD.SEQ_CLIENTE.NEXTVAL;
  :new.cli_pnome := UPPER(:new.cli_pnome);
  :new.cli_mnome := UPPER(:new.cli_mnome);
  :new.cli_unome := UPPER(:new.cli_unome);
END;
/ */

/*DELETE FROM `site_roupa`.`usuario` WHERE (`usu_id` = '1');*/
/*DROP TABLE `site_roupa`.`usuario`;*/
/*DROP DATABASE `site_roupa`;*/


