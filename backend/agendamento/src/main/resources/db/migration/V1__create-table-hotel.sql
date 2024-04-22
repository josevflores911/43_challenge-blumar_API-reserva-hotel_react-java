CREATE TABLE `hotel` (
  `id_hotel` binary(50) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `ubicacao` varchar(255) DEFAULT NULL,
  `cnpj` BIGINT NOT NULL,
  `contato` BIGINT NOT NULL,
  PRIMARY KEY (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

