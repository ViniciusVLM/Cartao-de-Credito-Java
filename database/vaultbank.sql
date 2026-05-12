
-- 1. Criar o banco de dados
CREATE DATABASE IF NOT EXISTS vaultbank
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- 2. Usar o banco criado
USE vaultbank;


-- Tabela de Clientes
CREATE TABLE Cliente (
    Id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(150) NOT NULL,
    CPF VARCHAR(14) NOT NULL UNIQUE,
    RG VARCHAR(15) NOT NULL,
    Email VARCHAR(200) NOT NULL,
    Telefone VARCHAR(20) NOT NULL,
    Data_Nascimento DATE NOT NULL,
    Nacionalidade VARCHAR(50) NOT NULL,
    CEP VARCHAR(10) NOT NULL,
    Estado VARCHAR(2) NOT NULL,
    isAdmin BOOLEAN NOT NULL DEFAULT FALSE,
    Senha VARCHAR(100) NOT NULL,
    Saldo DECIMAL(12,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB;

-- Tabela de Cartões
CREATE TABLE Cartao (
    Id_Cartao INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cliente INT NOT NULL,
    Numeros_Cartao VARCHAR(19) NOT NULL,
    Validade DATE NOT NULL,
    FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tabela de Compras
CREATE TABLE Compras (
    Id_Compra INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cartao INT NOT NULL,
    Transacao DATE NOT NULL,
    Valor_Compra DECIMAL(12,2) NOT NULL,
    Estabelecimento VARCHAR(200) NOT NULL,
    Descricao VARCHAR(300),
    FOREIGN KEY (Id_Cartao) REFERENCES Cartao(Id_Cartao)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tabela de Denúncias
CREATE TABLE Denuncia (
    Id_Denuncia INT AUTO_INCREMENT PRIMARY KEY,
    Id_Compra INT NOT NULL,
    Id_Cliente INT NOT NULL,
    Data_Denuncia DATE NOT NULL,
    Motivo VARCHAR(200) NOT NULL,
    Status VARCHAR(50) NOT NULL DEFAULT 'Pendente',
    FOREIGN KEY (Id_Compra) REFERENCES Compras(Id_Compra)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Tabela de Histórico de Reembolsos
CREATE TABLE HistoricoReembolso (
    Id_Reembolso INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cliente INT NOT NULL,
    Id_Compra INT NOT NULL,
    Valor_Reembolsado DECIMAL(12,2) NOT NULL,
    Data_Reembolso DATE NOT NULL,
    FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Id_Compra) REFERENCES Compras(Id_Compra)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


-- Admin padrão (senha: admin123)
INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, Data_Nascimento, Nacionalidade, CEP, Estado, isAdmin, Senha, Saldo)
VALUES ('Administrador VaultBank', '000.000.000-00', '00.000.000-0', 'admin@vaultbank.com', '(11) 99999-9999', '1990-01-01', 'Brasileiro', '01001-000', 'SP', TRUE, 'admin123', 50000.00);

-- Cliente de teste (senha: senha123)
INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, Data_Nascimento, Nacionalidade, CEP, Estado, isAdmin, Senha, Saldo)
VALUES ('João Silva', '123.456.789-00', '12.345.678-9', 'joao@email.com', '(11) 98888-7777', '1995-05-15', 'Brasileiro', '04001-000', 'SP', FALSE, 'senha123', 3500.75);

-- Cartão do João
INSERT INTO Cartao (Id_Cliente, Numeros_Cartao, Validade)
VALUES (2, '4532 8912 3456 7890', '2028-12-01');

-- Compras de exemplo
INSERT INTO Compras (Id_Cartao, Transacao, Valor_Compra, Estabelecimento, Descricao) VALUES
(1, '2026-05-01', 150.00, 'Amazon Brasil', 'Eletrônicos'),
(1, '2026-05-03', 89.90, 'iFood', 'Alimentação'),
(1, '2026-05-05', 320.00, 'Shopee', 'Roupas'),
(1, '2026-04-28', 45.00, 'Spotify', 'Assinatura'),
(1, '2026-04-20', 1200.00, 'Magazine Luiza', 'Eletrodomésticos');

-- Denúncia de exemplo (compra fraudulenta)
INSERT INTO Denuncia (Id_Compra, Id_Cliente, Data_Denuncia, Motivo, Status)
VALUES (5, 2, '2026-05-06', 'Compra Fraudulenta', 'Pendente');

