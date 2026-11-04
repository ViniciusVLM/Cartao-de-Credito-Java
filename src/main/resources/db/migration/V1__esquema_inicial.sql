-- Esquema inicial do banco VaultBank

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    Id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(150) NOT NULL,
    CPF VARCHAR(14) NOT NULL UNIQUE,
    RG VARCHAR(20) NOT NULL,
    Email VARCHAR(150) NOT NULL,
    Telefone VARCHAR(20) NOT NULL,
    Data_Nascimento DATETIME NOT NULL,
    Nacionalidade VARCHAR(50) NOT NULL,
    CEP VARCHAR(10) NOT NULL,
    Estado VARCHAR(50) NOT NULL,
    isAdmin BOOLEAN NOT NULL DEFAULT FALSE,
    Senha VARCHAR(255) NOT NULL,
    Saldo DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    CONSTRAINT chk_cliente_saldo CHECK (Saldo >= 0)
) ENGINE=InnoDB;

-- Tabela Cartao
CREATE TABLE IF NOT EXISTS Cartao (
    Id_Cartao INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cliente INT NOT NULL,
    Numeros_Cartao VARCHAR(25) NOT NULL UNIQUE,
    Validade DATETIME NOT NULL,
    CONSTRAINT fk_cartao_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Tabela Compras
CREATE TABLE IF NOT EXISTS Compras (
    Id_Compra INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cartao INT NOT NULL,
    Transacao DATETIME NOT NULL,
    Valor_Compra DECIMAL(12,2) NOT NULL,
    Estabelecimento VARCHAR(150) NOT NULL,
    Descricao VARCHAR(255),
    CONSTRAINT chk_compras_valor CHECK (Valor_Compra > 0),
    CONSTRAINT fk_compras_cartao FOREIGN KEY (Id_Cartao) REFERENCES Cartao(Id_Cartao)
        ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Tabela Denuncia
CREATE TABLE IF NOT EXISTS Denuncia (
    Id_Denuncia INT AUTO_INCREMENT PRIMARY KEY,
    Id_Compra INT NOT NULL,
    Id_Cliente INT NOT NULL,
    Data_Denuncia DATETIME NOT NULL,
    Motivo VARCHAR(255) NOT NULL,
    Status ENUM('Pendente', 'Resolvida', 'Cancelada') NOT NULL DEFAULT 'Pendente',
    CONSTRAINT fk_denuncia_compra FOREIGN KEY (Id_Compra) REFERENCES Compras(Id_Compra)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_denuncia_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Tabela HistoricoReembolso
CREATE TABLE IF NOT EXISTS HistoricoReembolso (
    Id_Reembolso INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cliente INT NOT NULL,
    Id_Compra INT NOT NULL,
    Valor_Reembolsado DECIMAL(12,2) NOT NULL,
    Data_Reembolso DATETIME NOT NULL,
    CONSTRAINT chk_reembolso_valor CHECK (Valor_Reembolsado > 0),
    CONSTRAINT fk_reembolso_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_reembolso_compra FOREIGN KEY (Id_Compra) REFERENCES Compras(Id_Compra)
        ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;

-- Tabela Solicitacao_Limite
CREATE TABLE IF NOT EXISTS Solicitacao_Limite (
    Id_Solicitacao INT AUTO_INCREMENT PRIMARY KEY,
    Id_Cliente INT NOT NULL,
    Valor_Solicitado DECIMAL(12,2) NOT NULL,
    Status ENUM('Pendente', 'Aprovado', 'Negado') NOT NULL DEFAULT 'Pendente',
    Data_Solicitacao DATETIME NOT NULL,
    CONSTRAINT chk_solicitacao_valor CHECK (Valor_Solicitado > 0),
    CONSTRAINT fk_solicitacao_cliente FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente)
        ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB;
