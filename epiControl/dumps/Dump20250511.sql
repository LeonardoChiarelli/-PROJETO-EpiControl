CREATE DATABASE  IF NOT EXISTS `epicontrol_swing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `epicontrol_swing`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: epicontrol_swing
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `casos_epidemiologicos`
--

DROP TABLE IF EXISTS `casos_epidemiologicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casos_epidemiologicos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cidade_id` bigint NOT NULL,
  `doenca_id` bigint NOT NULL,
  `data_de_registro` date NOT NULL,
  `ultima_atualizacao` date NOT NULL,
  `numero_de_casos (mil)` decimal(5,2) NOT NULL,
  `numero_de_obitos` int NOT NULL DEFAULT '0',
  `numero_de_recuperados (mil)` decimal(5,2) NOT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_casos_epidemiologicos_cidade_id` (`cidade_id`),
  KEY `fk_casos_epidemiologicos_doenca_id` (`doenca_id`),
  CONSTRAINT `fk_casos_epidemiologicos_cidade_id` FOREIGN KEY (`cidade_id`) REFERENCES `cidades` (`id`),
  CONSTRAINT `fk_casos_epidemiologicos_doenca_id` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casos_epidemiologicos`
--

LOCK TABLES `casos_epidemiologicos` WRITE;
/*!40000 ALTER TABLE `casos_epidemiologicos` DISABLE KEYS */;
INSERT INTO `casos_epidemiologicos` VALUES (1,1,1,'2000-01-01','2025-05-11',350.00,220,347.50,1),(2,1,2,'1996-02-01','2025-05-11',8.00,420,7.40,1),(3,1,3,'1990-04-04','2025-05-11',0.95,40,0.90,1),(4,1,4,'1990-01-01','2025-03-29',32.00,1800,29.50,1),(5,2,1,'2001-05-10','2025-05-11',290.50,11,290.30,1),(6,2,2,'2002-06-21','2025-05-11',0.75,38,0.70,1),(7,2,3,'2001-12-22','2025-05-11',0.07,2,0.07,1),(8,2,4,'1997-12-12','2025-05-11',2.90,150,2.70,1),(9,3,1,'2003-03-20','2025-05-11',48.00,20,47.50,1),(10,3,2,'2000-10-01','2025-05-11',1.10,65,1.00,1),(11,3,3,'1990-04-04','2025-05-11',0.13,8,0.12,1),(12,3,4,'1998-08-15','2025-05-11',0.45,220,0.42,1),(13,4,1,'2002-07-15','2025-05-11',320.00,14,318.00,1),(14,4,2,'2001-01-05','2025-05-11',0.90,50,0.82,1),(15,4,3,'2003-11-02','2025-05-11',0.08,4,0.08,1),(16,4,4,'1997-12-12','2025-05-11',0.29,150,0.27,1);
/*!40000 ALTER TABLE `casos_epidemiologicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidades` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `população(milhões)` decimal(4,2) NOT NULL,
  `quantidade_hospitais` int NOT NULL,
  `quantidade_postos_de_saude` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (1,'São Paulo','SP',11.45,139,470),(2,'São Bernardo do Campo','SP',0.84,10,35),(3,'Guarulhos','SP',1.29,12,69),(4,'Santo André','SP',0.72,9,32);
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doencas`
--

DROP TABLE IF EXISTS `doencas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doencas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `agente_causador` varchar(75) NOT NULL,
  `sintomas` varchar(255) NOT NULL,
  `formas_de_transmissao` varchar(255) NOT NULL,
  `medidas_de_prevencao` varchar(255) NOT NULL,
  `taxa_de_mortalidade(%)` decimal(5,2) DEFAULT '0.00',
  `taxa_de_transmissao(%)` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doencas`
--

LOCK TABLES `doencas` WRITE;
/*!40000 ALTER TABLE `doencas` DISABLE KEYS */;
INSERT INTO `doencas` VALUES (1,'Dengue','VIRUS','Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos','Picada do mosquito Aedes aegypti infectado','Eliminar criadouros do mosquito, uso de repelentes, telas de proteção, campanhas de conscientização',1.80,0.03),(2,'Leptospirose','BACTERIAS','Febre prolongada, mal-estar, dor abdominal, diarreia ou prisão de ventre, manchas rosadas no tronco','Ingestão de água ou alimentos contaminados com fezes ou urina de pessoas infectadas','Higiene pessoal, saneamento básico, vacinação, cuidados com a água e alimentos',1.20,10.00),(3,'Febre Tifoide','BACTERIAS','Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos','Ingestão de alimentos e água contaminados','Higiene alimentar, saneamento básico, vacinação quando disponível',1.50,0.65),(4,'Hepatite A','VIRUS','Cansaço, febre, enjoo, vômitos, urina escura, pele e olhos amarelados (icterícia)',' via fecal-oral (alimentos ou água contaminados)','Vacinação, higiene alimentar',1.10,0.50);
/*!40000 ALTER TABLE `doencas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','create table doenca','SQL','V1__create_table_doenca.sql',-7449627,'root','2025-05-11 23:24:04',44,1),(2,'2','create table cidades','SQL','V2__create_table_cidades.sql',-1426144226,'root','2025-05-11 23:24:04',42,1),(3,'3','create-table-casos epidemiologicos','SQL','V3__create-table-casos_epidemiologicos.sql',-487807371,'root','2025-05-11 23:24:05',456,1),(4,'4','create-view-vw-dados-epidemiologicos-gerais','SQL','V4__create-view-vw-dados-epidemiologicos-gerais.sql',-1474103714,'root','2025-05-11 23:24:05',9,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_dados_epidemiologicos_gerais`
--

DROP TABLE IF EXISTS `vw_dados_epidemiologicos_gerais`;
/*!50001 DROP VIEW IF EXISTS `vw_dados_epidemiologicos_gerais`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_dados_epidemiologicos_gerais` AS SELECT 
 1 AS `cidade_id`,
 1 AS `cidade_nome`,
 1 AS `cidade_estado`,
 1 AS `populacao_milhoes`,
 1 AS `quantidade_hospitais`,
 1 AS `quantidade_postos_de_saude`,
 1 AS `doenca_id`,
 1 AS `doenca_nome`,
 1 AS `agente_causador`,
 1 AS `taxa_mortalidade`,
 1 AS `taxa_transmissao`,
 1 AS `caso_id`,
 1 AS `data_de_registro`,
 1 AS `ultima_atualizacao`,
 1 AS `numero_de_casos (mil)`,
 1 AS `numero_de_obitos`,
 1 AS `numero_de_recuperados (mil)`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'epicontrol_swing'
--

--
-- Final view structure for view `vw_dados_epidemiologicos_gerais`
--

/*!50001 DROP VIEW IF EXISTS `vw_dados_epidemiologicos_gerais`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_dados_epidemiologicos_gerais` AS select `c`.`id` AS `cidade_id`,`c`.`nome` AS `cidade_nome`,`c`.`estado` AS `cidade_estado`,`c`.`população(milhões)` AS `populacao_milhoes`,`c`.`quantidade_hospitais` AS `quantidade_hospitais`,`c`.`quantidade_postos_de_saude` AS `quantidade_postos_de_saude`,`d`.`id` AS `doenca_id`,`d`.`nome` AS `doenca_nome`,`d`.`agente_causador` AS `agente_causador`,`d`.`taxa_de_mortalidade(%)` AS `taxa_mortalidade`,`d`.`taxa_de_transmissao(%)` AS `taxa_transmissao`,`ce`.`id` AS `caso_id`,`ce`.`data_de_registro` AS `data_de_registro`,`ce`.`ultima_atualizacao` AS `ultima_atualizacao`,`ce`.`numero_de_casos (mil)` AS `numero_de_casos (mil)`,`ce`.`numero_de_obitos` AS `numero_de_obitos`,`ce`.`numero_de_recuperados (mil)` AS `numero_de_recuperados (mil)`,`ce`.`status` AS `status` from ((`cidades` `c` join `casos_epidemiologicos` `ce` on((`ce`.`cidade_id` = `c`.`id`))) join `doencas` `d` on((`ce`.`doenca_id` = `d`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-11 20:42:09
