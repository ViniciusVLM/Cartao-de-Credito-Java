package com.mycompany.cartaodecredito.config;

import java.math.BigDecimal;

public class AppConfig {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private final int port;
    private final String appEnv;
    private final String adminCpf;
    private final String adminSenha;
    private final BigDecimal saldoInicial;

    public AppConfig(String dbUrl, String dbUser, String dbPassword, int port,
                     String appEnv, String adminCpf, String adminSenha, BigDecimal saldoInicial) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.port = port;
        this.appEnv = appEnv;
        this.adminCpf = adminCpf;
        this.adminSenha = adminSenha;
        this.saldoInicial = saldoInicial;
    }

    public static AppConfig carregar() {
        String dbUrl = System.getenv("DB_URL");
        if (dbUrl == null || dbUrl.isBlank()) {
            throw new IllegalStateException("Variável de ambiente obrigatória não definida: DB_URL");
        }

        String dbUser = System.getenv("DB_USER");
        if (dbUser == null || dbUser.isBlank()) {
            throw new IllegalStateException("Variável de ambiente obrigatória não definida: DB_USER");
        }

        String dbPassword = System.getenv("DB_PASSWORD");
        if (dbPassword == null) {
            throw new IllegalStateException("Variável de ambiente obrigatória não definida: DB_PASSWORD");
        }

        int port = 7071;
        String portEnv = System.getenv("PORT");
        if (portEnv != null && !portEnv.isBlank()) {
            try {
                port = Integer.parseInt(portEnv.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Valor inválido para variável PORT: " + portEnv, e);
            }
        }

        String appEnv = System.getenv("APP_ENV");
        if (appEnv == null || appEnv.isBlank()) {
            appEnv = "dev";
        }

        String adminCpf = System.getenv("ADMIN_CPF");
        String adminSenha = System.getenv("ADMIN_SENHA");

        BigDecimal saldoInicial = BigDecimal.ZERO;
        String saldoEnv = System.getenv("SALDO_INICIAL");
        if (saldoEnv != null && !saldoEnv.isBlank()) {
            try {
                saldoInicial = new BigDecimal(saldoEnv.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Valor inválido para variável SALDO_INICIAL: " + saldoEnv, e);
            }
        }

        return new AppConfig(dbUrl, dbUser, dbPassword, port, appEnv, adminCpf, adminSenha, saldoInicial);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public int getPort() {
        return port;
    }

    public String getAppEnv() {
        return appEnv;
    }

    public boolean isDev() {
        return "dev".equalsIgnoreCase(appEnv);
    }

    public boolean isProd() {
        return "prod".equalsIgnoreCase(appEnv);
    }

    public String getAdminCpf() {
        return adminCpf;
    }

    public String getAdminSenha() {
        return adminSenha;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }
}
