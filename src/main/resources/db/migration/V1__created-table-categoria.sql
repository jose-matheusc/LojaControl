CREATE TABLE categoria (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           nome VARCHAR(255) NOT NULL,
                           descricao VARCHAR(500),
                           PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;