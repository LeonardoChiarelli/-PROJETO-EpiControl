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
  `numero_de_casos` int NOT NULL,
  `numero_de_recuperados` int NOT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_casos_epidemiologicos_cidade_id` (`cidade_id`),
  KEY `fk_casos_epidemiologicos_doenca_id` (`doenca_id`),
  CONSTRAINT `fk_casos_epidemiologicos_cidade_id` FOREIGN KEY (`cidade_id`) REFERENCES `cidades` (`id`),
  CONSTRAINT `fk_casos_epidemiologicos_doenca_id` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casos_epidemiologicos`
--

LOCK TABLES `casos_epidemiologicos` WRITE;
/*!40000 ALTER TABLE `casos_epidemiologicos` DISABLE KEYS */;
INSERT INTO `casos_epidemiologicos` VALUES (1,1,1,'2025-03-15','2025-04-20',12500,11300,1),(2,1,4,'2025-02-12','2025-03-29',320,290,1),(3,3,2,'2025-01-10','2025-04-15',215,172,1),(4,3,1,'2025-03-10','2025-04-18',4700,4150,1),(5,4,4,'2025-01-25','2025-04-14',180,160,1),(6,4,3,'2025-03-05','2025-04-10',25,22,1),(7,2,1,'2025-02-22','2025-04-19',3900,3450,1),(8,2,2,'2025-01-18','2025-04-15',130,95,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (1,'São Paulo','SP',11.45,139,470),(2,'São Bernardo do Campo','SP',0.84,10,35),(3,'Guarulhos','SP',1.29,12,69),(4,'Santo André','SP',0.72,9,32),(5,'São Caetano do Sul','SP',0.16,7,10);
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
  `taxa_de_mortalidade(%)` decimal(5,2) DEFAULT NULL,
  `taxa_de_transmissao(%)` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doencas`
--

LOCK TABLES `doencas` WRITE;
/*!40000 ALTER TABLE `doencas` DISABLE KEYS */;
INSERT INTO `doencas` VALUES (1,'Dengue','VIRUS','Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos','Picada do mosquito Aedes aegypti infectado','Eliminar criadouros do mosquito, uso de repelentes, telas de proteção, campanhas de conscientização',1.80,0.03),(2,'Leptospirose','BACTERIA','Febre prolongada, mal-estar, dor abdominal, diarreia ou prisão de ventre, manchas rosadas no tronco','Ingestão de água ou alimentos contaminados com fezes ou urina de pessoas infectadas','Higiene pessoal, saneamento básico, vacinação, cuidados com a água e alimentos',1.20,10.00),(3,'Febre Tifoide','BACTERIA','Febre alta, dores musculares, dor de cabeça, dor atrás dos olhos, manchas vermelhas na pele, náuseas, vômitos','Picada do mosquito Aedes aegypti infectado','Eliminar criadouros do mosquito, uso de repelentes, telas de proteção, campanhas de conscientização',1.50,0.65),(4,'Hepatite A','VIRUS','Cansaço, febre, enjoo, vômitos, urina escura, pele e olhos amarelados (icterícia)',' via fecal-oral (alimentos ou água contaminados)','Vacinação, higiene alimentar',1.10,0.50);
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
INSERT INTO `flyway_schema_history` VALUES (1,'1','create table doenca','SQL','V1__create_table_doenca.sql',792466418,'root','2025-04-21 07:44:40',34,1),(2,'2','create table cidades','SQL','V2__create_table_cidades.sql',-1426144226,'root','2025-04-21 07:47:40',46,1),(3,'3','create-table-casos epidemiologicos','SQL','V3__create-table-casos_epidemiologicos.sql',-1923884492,'root','2025-04-21 07:47:40',387,1),(4,'4','create-view-vw-dados-epidemiologicos-gerais','SQL','V4__create-view-vw-dados-epidemiologicos-gerais.sql',-1960299933,'root','2025-04-21 09:03:26',35,1),(5,'5','create-view-vw-casos-agrupados-por-cidade','SQL','V5__create-view-vw-casos-agrupados-por-cidade.sql',80735517,'root','2025-04-21 09:08:18',26,1),(6,'6','create-view-vw-casos-agrupados-por-doenca','SQL','V6__create-view-vw-casos-agrupados-por-doenca.sql',-411570455,'root','2025-04-21 09:08:18',8,1),(7,'7','create-view-vw-casos-agrupados-por-mes','SQL','V7__create-view-vw-casos-agrupados-por-mes.sql',-1649000153,'root','2025-04-21 09:08:18',6,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_casos_agrupados_por_cidade`
--

DROP TABLE IF EXISTS `vw_casos_agrupados_por_cidade`;
/*!50001 DROP VIEW IF EXISTS `vw_casos_agrupados_por_cidade`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_casos_agrupados_por_cidade` AS SELECT 
 1 AS `cidade_id`,
 1 AS `cidade_nome`,
 1 AS `cidade_estado`,
 1 AS `populacao_milhoes`,
 1 AS `quantidade_hospitais`,
 1 AS `quantidade_postos_de_saude`,
 1 AS `quantidade_doencas_registradas`,
 1 AS `total_casos`,
 1 AS `total_recuperados`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_casos_por_doenca`
--

DROP TABLE IF EXISTS `vw_casos_por_doenca`;
/*!50001 DROP VIEW IF EXISTS `vw_casos_por_doenca`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_casos_por_doenca` AS SELECT 
 1 AS `doenca_id`,
 1 AS `doenca_nome`,
 1 AS `agente_causador`,
 1 AS `taxa_mortalidade`,
 1 AS `taxa_transmissao`,
 1 AS `cidades_afetadas`,
 1 AS `total_casos`,
 1 AS `total_recuperados`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_casos_por_mes`
--

DROP TABLE IF EXISTS `vw_casos_por_mes`;
/*!50001 DROP VIEW IF EXISTS `vw_casos_por_mes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_casos_por_mes` AS SELECT 
 1 AS `mes`,
 1 AS `doenca_nome`,
 1 AS `cidade_nome`,
 1 AS `total_casos`,
 1 AS `total_recuperados`*/;
SET character_set_client = @saved_cs_client;

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
 1 AS `numero_de_casos`,
 1 AS `numero_de_recuperados`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'epicontrol_swing'
--

--
-- Final view structure for view `vw_casos_agrupados_por_cidade`
--

/*!50001 DROP VIEW IF EXISTS `vw_casos_agrupados_por_cidade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_casos_agrupados_por_cidade` AS select `c`.`id` AS `cidade_id`,`c`.`nome` AS `cidade_nome`,`c`.`estado` AS `cidade_estado`,`c`.`população(milhões)` AS `populacao_milhoes`,`c`.`quantidade_hospitais` AS `quantidade_hospitais`,`c`.`quantidade_postos_de_saude` AS `quantidade_postos_de_saude`,count(distinct `ce`.`doenca_id`) AS `quantidade_doencas_registradas`,sum(`ce`.`numero_de_casos`) AS `total_casos`,sum(`ce`.`numero_de_recuperados`) AS `total_recuperados` from (`cidades` `c` join `casos_epidemiologicos` `ce` on((`ce`.`cidade_id` = `c`.`id`))) group by `c`.`id`,`c`.`nome`,`c`.`estado`,`c`.`população(milhões)`,`c`.`quantidade_hospitais`,`c`.`quantidade_postos_de_saude` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_casos_por_doenca`
--

/*!50001 DROP VIEW IF EXISTS `vw_casos_por_doenca`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_casos_por_doenca` AS select `d`.`id` AS `doenca_id`,`d`.`nome` AS `doenca_nome`,`d`.`agente_causador` AS `agente_causador`,`d`.`taxa_de_mortalidade(%)` AS `taxa_mortalidade`,`d`.`taxa_de_transmissao(%)` AS `taxa_transmissao`,count(distinct `ce`.`cidade_id`) AS `cidades_afetadas`,sum(`ce`.`numero_de_casos`) AS `total_casos`,sum(`ce`.`numero_de_recuperados`) AS `total_recuperados` from (`doencas` `d` join `casos_epidemiologicos` `ce` on((`ce`.`doenca_id` = `d`.`id`))) group by `d`.`id`,`d`.`nome`,`d`.`agente_causador`,`d`.`taxa_de_mortalidade(%)`,`d`.`taxa_de_transmissao(%)` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_casos_por_mes`
--

/*!50001 DROP VIEW IF EXISTS `vw_casos_por_mes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_casos_por_mes` AS select date_format(`ce`.`data_de_registro`,'%Y-%m') AS `mes`,`d`.`nome` AS `doenca_nome`,`c`.`nome` AS `cidade_nome`,sum(`ce`.`numero_de_casos`) AS `total_casos`,sum(`ce`.`numero_de_recuperados`) AS `total_recuperados` from ((`casos_epidemiologicos` `ce` join `doencas` `d` on((`ce`.`doenca_id` = `d`.`id`))) join `cidades` `c` on((`ce`.`cidade_id` = `c`.`id`))) group by date_format(`ce`.`data_de_registro`,'%Y-%m'),`d`.`nome`,`c`.`nome` order by `mes`,`doenca_nome`,`cidade_nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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
/*!50001 VIEW `vw_dados_epidemiologicos_gerais` AS select `c`.`id` AS `cidade_id`,`c`.`nome` AS `cidade_nome`,`c`.`estado` AS `cidade_estado`,`c`.`população(milhões)` AS `populacao_milhoes`,`c`.`quantidade_hospitais` AS `quantidade_hospitais`,`c`.`quantidade_postos_de_saude` AS `quantidade_postos_de_saude`,`d`.`id` AS `doenca_id`,`d`.`nome` AS `doenca_nome`,`d`.`agente_causador` AS `agente_causador`,`d`.`taxa_de_mortalidade(%)` AS `taxa_mortalidade`,`d`.`taxa_de_transmissao(%)` AS `taxa_transmissao`,`ce`.`id` AS `caso_id`,`ce`.`data_de_registro` AS `data_de_registro`,`ce`.`ultima_atualizacao` AS `ultima_atualizacao`,`ce`.`numero_de_casos` AS `numero_de_casos`,`ce`.`numero_de_recuperados` AS `numero_de_recuperados`,`ce`.`status` AS `status` from ((`cidades` `c` join `casos_epidemiologicos` `ce` on((`ce`.`cidade_id` = `c`.`id`))) join `doencas` `d` on((`ce`.`doenca_id` = `d`.`id`))) */;
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

-- Dump completed on 2025-04-22 21:38:27
