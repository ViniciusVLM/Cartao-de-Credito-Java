package Connect;

import Dao.CartaoDao;
import Dao.ClienteDao;
import Dao.CompraDao;
import Dao.DenunciaDao;
import Dao.SolicitacaoLimiteDao;
import Model.Cartao;
import Model.Cliente;
import Model.Compras;
import Model.Denuncia;
import Model.SolicitacaoLimite;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.json.JavalinJackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ApiServer {

    public static void iniciar() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.jsonMapper(new JavalinJackson(mapper, false));
        });

        ClienteDao clienteDao = new ClienteDao();
        CartaoDao cartaoDao = new CartaoDao();
        CompraDao compraDao = new CompraDao();
        DenunciaDao denunciaDao = new DenunciaDao();
        SolicitacaoLimiteDao solicitacaoLimiteDao = new SolicitacaoLimiteDao();

        app.post("/api/login", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            String cpf = body.get("cpf");
            String senha = body.get("senha");

            Cliente c = clienteDao.autenticar(cpf, senha);
            if (c != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", c.getIdCliente());
                response.put("nome", c.getNome());
                response.put("cpf", c.getCPF());
                response.put("isAdmin", c.getIsAdmin());
                response.put("saldo", c.getSaldo());
                ctx.json(response);
            } else {
                ctx.status(401).result("Credenciais inválidas");
            }
        });

        app.post("/api/clientes", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Cliente novoCliente = new Cliente();
            novoCliente.setNome(body.get("nome"));
            novoCliente.setCPF(body.get("cpf"));
            novoCliente.setRG(body.get("rg"));
            novoCliente.setEmail(body.get("email"));
            novoCliente.setTelefone(body.get("telefone"));
            novoCliente.setDataNascimento(LocalDate.parse(body.get("dataNascimento")));
            novoCliente.setNacionalidade(body.get("nacionalidade"));
            novoCliente.setCEP(body.get("cep"));
            novoCliente.setEstado(body.get("estado"));
            novoCliente.setSenha(body.get("senha"));
            novoCliente.setIsAdmin(false);
            novoCliente.setSaldo(new java.math.BigDecimal("2000.0"));
            
            try {
                boolean sucesso = clienteDao.CadastrarUsuario(novoCliente);
                if (sucesso) {
                    Cliente clienteRegistrado = clienteDao.autenticar(novoCliente.getCPF(), novoCliente.getSenha());
                    if (clienteRegistrado != null) {
                        Cartao novoCartao = new Cartao();
                        novoCartao.setIdCliente(clienteRegistrado.getIdCliente());
                        novoCartao.setValidade(LocalDate.now().plusYears(4));
                        String num = "";
                        for(int i=0; i<4; i++) num += String.format("%04d", (int)(Math.random() * 10000)) + " ";
                        novoCartao.setNumerosCartao(num.trim());
                        cartaoDao.cadastrarCartao(novoCartao);
                    }
                    ctx.status(201).result("Cliente cadastrado com sucesso");
                } else {
                    ctx.status(400).result("Erro ao cadastrar cliente. Retorno false.");
                }
            } catch (Exception e) {
                ctx.status(400).result("Erro SQL: " + e.getMessage());
            }
        });

        app.get("/api/clientes", ctx -> {
            ctx.json(clienteDao.listarClientes());
        });

        app.get("/api/cartoes/{idCliente}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("idCliente"));
            ctx.json(cartaoDao.buscarCartoesPorCliente(id));
        });

        app.post("/api/compras", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Compras compra = new Compras();
            compra.setIdCartao(((Number) body.get("idCartao")).intValue());
            compra.setTransacao(LocalDate.now());
            compra.setValorCompra(((Number) body.get("valorCompra")).doubleValue());
            compra.setEstabelecimento((String) body.get("estabelecimento"));
            compra.setDescricao((String) body.get("descricao"));

            if (compraDao.cadastrarCompra(compra)) {
                ctx.status(201).result("Compra registrada");
            } else {
                ctx.status(400).result("Erro ao registrar compra (saldo insuficiente ou erro)");
            }
        });

        app.get("/api/compras/{idCliente}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("idCliente"));
            ctx.json(compraDao.listarComprasPorCliente(id));
        });

        app.post("/api/denuncias", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Denuncia d = new Denuncia();
            d.setIdCompra(((Number) body.get("idCompra")).intValue());
            d.setIdCliente(((Number) body.get("idCliente")).intValue());
            d.setMotivo((String) body.get("motivo"));
            d.setDataDenuncia(LocalDate.now());

            if (denunciaDao.cadastrarDenuncia(d)) {
                ctx.status(201).result("Denúncia registrada");
            } else {
                ctx.status(400).result("Erro ao registrar denúncia");
            }
        });

        app.get("/api/denuncias/pendentes", ctx -> {
            ctx.json(denunciaDao.listarDenunciasPendentes());
        });

        app.post("/api/denuncias/{id}/reembolsar", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            if (denunciaDao.processarReembolso(id)) {
                ctx.status(200).result("Reembolso efetuado");
            } else {
                ctx.status(400).result("Erro ao processar reembolso");
            }
        });

        app.get("/api/reembolsos/{idCliente}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("idCliente"));
            ctx.json(denunciaDao.listarReembolsosPorCliente(id));
        });

        app.get("/api/reembolsos", ctx -> {
            ctx.json(denunciaDao.listarTodosReembolsos());
        });
        
        app.get("/api/clientes/{cpf}/{senha}", ctx -> {
            String cpf = ctx.pathParam("cpf");
            String senha = ctx.pathParam("senha");
            Cliente c = clienteDao.autenticar(cpf, senha);
            if (c != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", c.getIdCliente());
                response.put("nome", c.getNome());
                response.put("cpf", c.getCPF());
                response.put("isAdmin", c.getIsAdmin());
                response.put("saldo", c.getSaldo());
                ctx.json(response);
            } else {
                ctx.status(404).result("Não encontrado");
            }
        });

        // ================= ROTAS DE SOLICITAÇÃO DE LIMITE =================
        app.post("/api/solicitacoes-limite", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            SolicitacaoLimite s = new SolicitacaoLimite();
            s.setIdCliente(((Number) body.get("idCliente")).intValue());
            s.setValorSolicitado(((Number) body.get("valorSolicitado")).doubleValue());
            s.setStatus("Pendente");
            s.setDataSolicitacao(LocalDate.now());

            if (solicitacaoLimiteDao.cadastrarSolicitacao(s)) {
                ctx.status(201).result("Solicitação registrada");
            } else {
                ctx.status(400).result("Erro ao registrar solicitação");
            }
        });

        app.get("/api/solicitacoes-limite/pendentes", ctx -> {
            ctx.json(solicitacaoLimiteDao.listarPendentes());
        });

        app.post("/api/solicitacoes-limite/{id}/aprovar", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            SolicitacaoLimite solicitacao = solicitacaoLimiteDao.buscarPorId(id);
            if (solicitacao != null && "Pendente".equals(solicitacao.getStatus())) {
                if (solicitacaoLimiteDao.atualizarStatus(id, "Aprovado")) {
                    clienteDao.adicionarSaldo(solicitacao.getIdCliente(), solicitacao.getValorSolicitado());
                    ctx.status(200).result("Solicitação aprovada e limite atualizado.");
                } else {
                    ctx.status(400).result("Erro ao atualizar o status da solicitação.");
                }
            } else {
                ctx.status(404).result("Solicitação não encontrada ou não está pendente.");
            }
        });

        app.post("/api/solicitacoes-limite/{id}/negar", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            if (solicitacaoLimiteDao.atualizarStatus(id, "Negado")) {
                ctx.status(200).result("Solicitação negada.");
            } else {
                ctx.status(400).result("Erro ao atualizar o status da solicitação.");
            }
        });

        app.start(7071);
        System.out.println("Servidor Web rodando em: http://localhost:7071");
    }
}
