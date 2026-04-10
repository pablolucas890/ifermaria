-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.7.23 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para db_enfermagem
DROP DATABASE IF EXISTS `db_enfermagem`;
CREATE DATABASE IF NOT EXISTS `db_enfermagem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_enfermagem`;

-- Copiando estrutura para tabela db_enfermagem.aluno
DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `alergias` varchar(100) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `cartaoSUS` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT '',
  `dataNasc` date DEFAULT NULL,
  `doencas` varchar(100) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `med_usoContinuo` varchar(100) DEFAULT NULL,
  `nomeMae` varchar(255) DEFAULT NULL,
  `nomePai` varchar(255) DEFAULT NULL,
  `telefoneAluno` varchar(20) DEFAULT NULL,
  `telefoneMae` varchar(255) DEFAULT NULL,
  `telefonePai` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `curso_idcurso` int(11) DEFAULT NULL,
  `sala_id` int(11) DEFAULT NULL,
  `procedencia` varchar(255) DEFAULT NULL,
  `alojamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAluno`),
  KEY `FK589C4EBDFFB6D35` (`curso_idcurso`),
  KEY `FK589C4EBE9C92A9F` (`sala_id`),
  CONSTRAINT `FK589C4EBDFFB6D35` FOREIGN KEY (`curso_idcurso`) REFERENCES `curso` (`idcurso`),
  CONSTRAINT `FK589C4EBE9C92A9F` FOREIGN KEY (`sala_id`) REFERENCES `sala` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=383 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.aluno: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` (`idAluno`, `nome`, `alergias`, `ano`, `area`, `cartaoSUS`, `cpf`, `dataNasc`, `doencas`, `foto`, `med_usoContinuo`, `nomeMae`, `nomePai`, `telefoneAluno`, `telefoneMae`, `telefonePai`, `tipo`, `curso_idcurso`, `sala_id`, `procedencia`, `alojamento`) VALUES
	(362, 'Pablo Lucas Silva Santos', 'DIPIRONA', 2018, '', '21211212121', '085.707.646-93', '2001-05-16', NULL, '1543402698065.jpg', 'GARDENAL', 'teste do teste', 'teste do teste', '35 99734 9768', '3259888', '35999999', 'Aluno', 1, 6, 'Borda da mata', 'NÃO'),
	(368, 'Marly Cristina Barbosa Ribeiro', 'Cetoprofeno, Plasil e tapazol', 2018, NULL, NULL, NULL, '1969-06-21', 'Hipotireoidismo', 'user.png', 'Puran T4, Lamotrigina, Propranolol ', NULL, NULL, '35 9938 5828', NULL, NULL, 'Aluno', 40, 120, NULL, NULL),
	(370, 'Ana Laura dos Santos', NULL, 2018, NULL, NULL, NULL, '2001-05-13', NULL, '1543411986653.jpg', NULL, 'Maria Nazaré de Godoi Santos', 'Jesus Zeferino dos Santos', '35 998218324', '35 9 9823 3410', '35 9 9809 3613', 'Aluno', 4, 18, NULL, NULL),
	(372, 'Luiza Aparecida Consentino', 'Nega', 2018, NULL, NULL, NULL, '2001-04-26', 'Nega', 'user.png', 'Nega', 'Patricia R Gonçalves', 'Claudio Consentino', '998329215', '35 998447795', '35 999454062', 'Aluno', 4, 15, NULL, NULL),
	(373, 'Pâmela Dinah da Silva', 'Nega						', 2018, NULL, NULL, NULL, '1997-07-12', 'Nega', 'user.png', 'Biotina e anticoncepcional', 'Rita de Cassia Pereira', 'Carlos Jos´é da Silva', '35 9986 3799', '35 9998 20796', NULL, 'Aluno', 14, 96, NULL, NULL),
	(374, 'Pamela Cristina Cesar', '', 2018, NULL, NULL, NULL, '1985-07-10', NULL, 'user.png', NULL, NULL, NULL, NULL, NULL, NULL, 'Aluno', 16, 122, NULL, NULL),
	(375, 'Ariane Helena Marciano Fernandes', 'Dipirona\nDramin\nPlasil\nBuscopam', 2018, 'enfermaria', '201220120120120', '091.467.186-30', '1989-10-01', 'DPOC\nHioertireoidismo\nCardiopatia\nHAS\nDM', '1543418512811.jpg', 'Anticoncepcional Diane\nClonazepam\nPuran \nCaptopril\nInsulina NPH', 'Renata Marciano Fernandes', 'Ademir Fernandes', '35999681361', '032146843201', '0125625000', 'Funcionario', NULL, NULL, NULL, NULL),
	(377, 'Aluyso Augusto de Sousa Francisco', 'Sulfadiazida', 2018, NULL, NULL, NULL, '1989-09-29', NULL, '1543577154024.jpg', NULL, NULL, 'Augusto Francisco ', '019 9872 5745', NULL, '19 9 9168 9123', 'Aluno', 41, 123, NULL, NULL);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.atendente
DROP TABLE IF EXISTS `atendente`;
CREATE TABLE IF NOT EXISTS `atendente` (
  `idAtendente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAtendente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.atendente: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `atendente` DISABLE KEYS */;
INSERT INTO `atendente` (`idAtendente`, `nome`, `login`, `senha`) VALUES
	(1, 'Ana Paula', 'ana', '123'),
	(7, 'Marly', 'marly', '456'),
	(12, 'ARIANE', 'ariane.fernandes', '22459530');
/*!40000 ALTER TABLE `atendente` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.atendimento
DROP TABLE IF EXISTS `atendimento`;
CREATE TABLE IF NOT EXISTS `atendimento` (
  `idAtendimanto` int(11) NOT NULL AUTO_INCREMENT,
  `conduta` varchar(300) DEFAULT NULL,
  `dataAtendimento` date DEFAULT NULL,
  `encaminhamento` varchar(255) DEFAULT NULL,
  `hora` varchar(255) DEFAULT NULL,
  `horaSaida` varchar(255) DEFAULT NULL,
  `queixa` varchar(300) DEFAULT NULL,
  `aluno_idAluno` int(11) DEFAULT NULL,
  `atendente_idAtendente` int(11) DEFAULT NULL,
  `quantRetirada` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAtendimanto`),
  KEY `FK_r9chhpspqsrry5rndr5sxmgn6` (`aluno_idAluno`),
  KEY `FK_9al6sbvit4jl8q0cwvaqrxg39` (`atendente_idAtendente`),
  CONSTRAINT `FK_9al6sbvit4jl8q0cwvaqrxg39` FOREIGN KEY (`atendente_idAtendente`) REFERENCES `atendente` (`idAtendente`),
  CONSTRAINT `FK_r9chhpspqsrry5rndr5sxmgn6` FOREIGN KEY (`aluno_idAluno`) REFERENCES `aluno` (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.atendimento: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
INSERT INTO `atendimento` (`idAtendimanto`, `conduta`, `dataAtendimento`, `encaminhamento`, `hora`, `horaSaida`, `queixa`, `aluno_idAluno`, `atendente_idAtendente`, `quantRetirada`) VALUES
	(104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.atendimento_enfermidade
DROP TABLE IF EXISTS `atendimento_enfermidade`;
CREATE TABLE IF NOT EXISTS `atendimento_enfermidade` (
  `atendimentos_idAtendimanto` int(11) NOT NULL,
  `enfermidades_idEnfermidade` int(11) NOT NULL,
  KEY `FK_2j14ofervqw0flhcjwg9ut9vw` (`enfermidades_idEnfermidade`),
  KEY `FK_7lh5ctcs8k4fxgu0c5qe77eks` (`atendimentos_idAtendimanto`),
  CONSTRAINT `FK_2j14ofervqw0flhcjwg9ut9vw` FOREIGN KEY (`enfermidades_idEnfermidade`) REFERENCES `enfermidade` (`idEnfermidade`),
  CONSTRAINT `FK_7lh5ctcs8k4fxgu0c5qe77eks` FOREIGN KEY (`atendimentos_idAtendimanto`) REFERENCES `atendimento` (`idAtendimanto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.atendimento_enfermidade: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `atendimento_enfermidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimento_enfermidade` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.atendimento_estoque
DROP TABLE IF EXISTS `atendimento_estoque`;
CREATE TABLE IF NOT EXISTS `atendimento_estoque` (
  `atendimentos_idAtendimanto` int(11) NOT NULL,
  `estoque_idestoque` int(11) NOT NULL,
  KEY `FK_dstbj9pxg7x2vnbuq9gfh6yab` (`estoque_idestoque`),
  KEY `FK_c1fhkhbm7re88n4w5u3gbnva7` (`atendimentos_idAtendimanto`),
  CONSTRAINT `FK_c1fhkhbm7re88n4w5u3gbnva7` FOREIGN KEY (`atendimentos_idAtendimanto`) REFERENCES `atendimento` (`idAtendimanto`),
  CONSTRAINT `FK_dstbj9pxg7x2vnbuq9gfh6yab` FOREIGN KEY (`estoque_idestoque`) REFERENCES `estoque` (`idestoque`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.atendimento_estoque: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `atendimento_estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimento_estoque` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.curso
DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.curso: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idcurso`, `nome`) VALUES
	(1, 'Técnico em Informática'),
	(2, 'Técnico em Agrimensura'),
	(3, 'Técnico em Alimentos'),
	(4, 'Técnico em Agropecuária'),
	(5, 'Tecnologia em Gestão Ambiental'),
	(6, 'Tecnologia em Redes de Computadores'),
	(7, 'Licenciatura em Ciências Biológicas'),
	(8, 'Licenciatura em Matemática'),
	(9, 'Licenciatura em Educação do Campo'),
	(10, 'Licenciatura em Pedagogia'),
	(11, 'Licenciatura em História'),
	(12, 'Engenharia Ambiental'),
	(13, 'Engenharia Agronômica'),
	(14, 'Engenharia de Agrimensura e Cartográfica'),
	(15, 'Engenharia de Alimentos'),
	(16, 'Especialização em Gestão Ambiental'),
	(17, 'Especialização em Educação Matemática'),
	(40, 'Licenciatura em Pedagogia EAD'),
	(41, 'Gestão Ambiental');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.enfermidade
DROP TABLE IF EXISTS `enfermidade`;
CREATE TABLE IF NOT EXISTS `enfermidade` (
  `idEnfermidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEnfermidade`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.enfermidade: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `enfermidade` DISABLE KEYS */;
INSERT INTO `enfermidade` (`idEnfermidade`, `nome`) VALUES
	(5, 'Sinusite'),
	(7, 'Dor em MMII'),
	(8, 'Dor muscular '),
	(10, 'Torção em pé'),
	(11, 'Tosse');
/*!40000 ALTER TABLE `enfermidade` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.estoque
DROP TABLE IF EXISTS `estoque`;
CREATE TABLE IF NOT EXISTS `estoque` (
  `idestoque` int(11) NOT NULL AUTO_INCREMENT,
  `dataEntrada` date DEFAULT NULL,
  `dataValidade` date DEFAULT NULL,
  `lote` varchar(255) DEFAULT NULL,
  `quantAntiga` int(11) DEFAULT NULL,
  `quant_atual` int(11) DEFAULT NULL,
  `medicamento_idmedicamento` int(11) DEFAULT NULL,
  `quantRetirada` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idestoque`),
  KEY `FK_q652yob29gg3giwaheteukrtq` (`medicamento_idmedicamento`),
  CONSTRAINT `FK_q652yob29gg3giwaheteukrtq` FOREIGN KEY (`medicamento_idmedicamento`) REFERENCES `medicamento` (`idmedicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.estoque: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.log
DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acao` varchar(850) DEFAULT NULL,
  `dataEvento` date DEFAULT NULL,
  `horaEvento` time DEFAULT NULL,
  `tabela` varchar(255) DEFAULT NULL,
  `atendente_idAtendente` int(11) DEFAULT NULL,
  `aluno_idAluno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK12B24925A21C7` (`atendente_idAtendente`),
  KEY `FK12B24B6B4FB22` (`aluno_idAluno`),
  CONSTRAINT `FK12B24925A21C7` FOREIGN KEY (`atendente_idAtendente`) REFERENCES `atendente` (`idAtendente`),
  CONSTRAINT `FK12B24B6B4FB22` FOREIGN KEY (`aluno_idAluno`) REFERENCES `aluno` (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=669 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.log: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.medicamento
DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE IF NOT EXISTS `medicamento` (
  `idmedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `catmat` int(11) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `quantTotal` int(11) DEFAULT NULL,
  `quant_Antiga` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `unidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idmedicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.medicamento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;

-- Copiando estrutura para tabela db_enfermagem.sala
DROP TABLE IF EXISTS `sala`;
CREATE TABLE IF NOT EXISTS `sala` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sala` varchar(255) DEFAULT NULL,
  `curso_idcurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35C043DFFB6D35` (`curso_idcurso`),
  CONSTRAINT `FK35C043DFFB6D35` FOREIGN KEY (`curso_idcurso`) REFERENCES `curso` (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_enfermagem.sala: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` (`id`, `sala`, `curso_idcurso`) VALUES
	(1, '1°E1', 1),
	(2, '1°E2', 1),
	(3, '2°E1', 1),
	(4, '2°E2', 1),
	(5, '3°E1', 1),
	(6, '3°E2', 1),
	(7, '1°F', 2),
	(8, '2°F', 2),
	(9, '3°F', 2),
	(10, '1°I', 3),
	(11, '2°I', 3),
	(12, '3°I', 3),
	(13, '1°A', 4),
	(14, '2°A', 4),
	(15, '3°A', 4),
	(16, '1°B', 4),
	(17, '2°B', 4),
	(18, '3°B', 4),
	(19, '1ºPeriodo', 5),
	(20, '2ºPeriodo', 5),
	(21, '3ºPeriodo', 5),
	(22, '4ºPeriodo', 5),
	(23, '5ºPeriodo', 5),
	(24, '6ºPeriodo', 5),
	(25, '1ºPeriodo', 6),
	(26, '2ºPeriodo', 6),
	(27, '3ºPeriodo', 6),
	(28, '4ºPeriodo', 6),
	(29, '5ºPeriodo', 6),
	(30, '6ºPeriodo', 6),
	(31, '1ºPeriodo', 7),
	(32, '2ºPeriodo', 7),
	(33, '3ºPeriodo', 7),
	(34, '4ºPeriodo', 7),
	(35, '5ºPeriodo', 7),
	(36, '6ºPeriodo', 7),
	(37, '7ºPeriodo', 7),
	(38, '8ºPeriodo', 7),
	(39, '9ºPeriodo', 7),
	(40, '1ºPeriodo', 8),
	(41, '2ºPeriodo', 8),
	(42, '3ºPeriodo', 8),
	(43, '4ºPeriodo', 8),
	(44, '5ºPeriodo', 8),
	(45, '6ºPeriodo', 8),
	(46, '7ºPeriodo', 8),
	(47, '8ºPeriodo', 8),
	(48, '1ºPeriodo', 9),
	(49, '2ºPeriodo', 9),
	(50, '3ºPeriodo', 9),
	(51, '4ºPeriodo', 9),
	(52, '5ºPeriodo', 9),
	(53, '6ºPeriodo', 9),
	(54, '7ºPeriodo', 9),
	(55, '8ºPeriodo', 9),
	(56, '1ºPeriodo', 10),
	(57, '2ºPeriodo', 10),
	(58, '3ºPeriodo', 10),
	(59, '4ºPeriodo', 10),
	(60, '5ºPeriodo', 10),
	(61, '6ºPeriodo', 10),
	(62, '7ºPeriodo', 10),
	(63, '8ºPeriodo', 10),
	(64, '1ºPeriodo', 11),
	(65, '2ºPeriodo', 11),
	(66, '3ºPeriodo', 11),
	(67, '4ºPeriodo', 11),
	(68, '5ºPeriodo', 11),
	(69, '6ºPeriodo', 11),
	(70, '7ºPeriodo', 11),
	(71, '8ºPeriodo', 11),
	(72, '1ºPeriodo', 12),
	(73, '2ºPeriodo', 12),
	(74, '3ºPeriodo', 12),
	(75, '4ºPeriodo', 12),
	(76, '5ºPeriodo', 12),
	(77, '6ºPeriodo', 12),
	(78, '7ºPeriodo', 12),
	(79, '8ºPeriodo', 12),
	(80, '9ºPeriodo', 12),
	(81, '10ºPeriodo', 12),
	(82, '1ºPeriodo', 13),
	(83, '2ºPeriodo', 13),
	(84, '3ºPeriodo', 13),
	(85, '4ºPeriodo', 13),
	(86, '5ºPeriodo', 13),
	(87, '6ºPeriodo', 13),
	(88, '7ºPeriodo', 13),
	(89, '8ºPeriodo', 13),
	(90, '9ºPeriodo', 13),
	(91, '10ºPeriodo', 13),
	(92, '1ºPeriodo', 14),
	(93, '2ºPeriodo', 14),
	(94, '3ºPeriodo', 14),
	(95, '4ºPeriodo', 14),
	(96, '5ºPeriodo', 14),
	(97, '6ºPeriodo', 14),
	(98, '7ºPeriodo', 14),
	(99, '8ºPeriodo', 14),
	(100, '9ºPeriodo', 14),
	(101, '10ºPeriodo', 14),
	(102, '1ºPeriodo', 15),
	(103, '2ºPeriodo', 15),
	(104, '3ºPeriodo', 15),
	(105, '4ºPeriodo', 15),
	(106, '5ºPeriodo', 15),
	(107, '6ºPeriodo', 15),
	(108, '7ºPeriodo', 15),
	(109, '8ºPeriodo', 15),
	(110, '9ºPeriodo', 15),
	(111, '10ºPeriodo', 15),
	(112, '1ºPeriodo', 16),
	(113, '2ºPeriodo', 16),
	(114, '3ºPeriodo', 16),
	(115, '1ºPeriodo', 17),
	(116, '2ºPeriodo', 17),
	(117, '3ºPeriodo', 17),
	(120, '4 Período', 40),
	(122, '4ºPeriodo', 16),
	(123, '3ºP', 41);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
