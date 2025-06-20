CREATE TABLE fornecedor (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            nome VARCHAR(255) NOT NULL,
                            cnpj VARCHAR(20),
                            telefone VARCHAR(20),
                            email VARCHAR(100),
                            PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;