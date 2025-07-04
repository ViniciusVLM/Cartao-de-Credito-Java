
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Viewer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Model.Cartao;
import Model.Cliente;
import Model.Compras;
import Model.Denuncia;
import Dao.CartaoDao;
import Dao.ClienteDao;
import Dao.CompraDao;
import Dao.DenunciaDao;
import com.mycompany.cartaodecredito.Usuario;
import java.math.BigDecimal;
/**
 *
 * @author Vinip
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastro = new javax.swing.JPanel();
        venhaParaAVaultBank = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelTelaCadastro = new javax.swing.JPanel();
        lblDadosPessoais = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCadstro = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        lblNacionalidade = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        nascimentoLabel = new javax.swing.JLabel();
        nacionalidadeText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        nomeCadastro1 = new javax.swing.JLabel();
        nomeCadastro2 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        estadoText = new javax.swing.JTextField();
        labelCpf6 = new javax.swing.JLabel();
        telefoneText = new javax.swing.JTextField();
        cepLabel = new javax.swing.JLabel();
        cepText = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();
        emailLabel1 = new javax.swing.JLabel();
        PasswordSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelCadastro.setBackground(new java.awt.Color(242, 218, 172));

        venhaParaAVaultBank.setBackground(new java.awt.Color(217, 165, 11));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENHA PARA A VAULTBANK");

        javax.swing.GroupLayout venhaParaAVaultBankLayout = new javax.swing.GroupLayout(venhaParaAVaultBank);
        venhaParaAVaultBank.setLayout(venhaParaAVaultBankLayout);
        venhaParaAVaultBankLayout.setHorizontalGroup(
            venhaParaAVaultBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(venhaParaAVaultBankLayout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel1)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        venhaParaAVaultBankLayout.setVerticalGroup(
            venhaParaAVaultBankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(venhaParaAVaultBankLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        painelTelaCadastro.setBackground(new java.awt.Color(242, 206, 22));
        painelTelaCadastro.setForeground(new java.awt.Color(242, 206, 22));

        lblDadosPessoais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDadosPessoais.setForeground(new java.awt.Color(0, 0, 0));
        lblDadosPessoais.setText("Dados Pessoais");

        txtNome.setBackground(new java.awt.Color(115, 185, 221));
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblCadstro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCadstro.setForeground(new java.awt.Color(255, 255, 255));
        lblCadstro.setText("Cadastro");

        txtRg.setBackground(new java.awt.Color(115, 185, 221));
        txtRg.setForeground(new java.awt.Color(255, 255, 255));
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("CPF:");

        txtCpf.setBackground(new java.awt.Color(115, 185, 221));
        txtCpf.setForeground(new java.awt.Color(255, 255, 255));
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        lblRg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRg.setForeground(new java.awt.Color(255, 255, 255));
        lblRg.setText("RG:");

        lblNacionalidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNacionalidade.setForeground(new java.awt.Color(255, 255, 255));
        lblNacionalidade.setText("Nacionalidade:");

        txtNascimento.setBackground(new java.awt.Color(115, 185, 221));
        txtNascimento.setForeground(new java.awt.Color(255, 255, 255));
        txtNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNascimentoActionPerformed(evt);
            }
        });

        nascimentoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nascimentoLabel.setForeground(new java.awt.Color(255, 255, 255));
        nascimentoLabel.setText("Data de nascimento:");

        nacionalidadeText.setBackground(new java.awt.Color(115, 185, 221));
        nacionalidadeText.setForeground(new java.awt.Color(255, 255, 255));
        nacionalidadeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacionalidadeTextActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email:");

        nomeCadastro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nomeCadastro1.setForeground(new java.awt.Color(255, 255, 255));
        nomeCadastro1.setText("Nome:");

        nomeCadastro2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeCadastro2.setForeground(new java.awt.Color(0, 0, 0));
        nomeCadastro2.setText("Contato");

        emailText.setBackground(new java.awt.Color(115, 185, 221));
        emailText.setForeground(new java.awt.Color(255, 255, 255));
        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        estadoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        estadoLabel.setForeground(new java.awt.Color(255, 255, 255));
        estadoLabel.setText("Estado:");

        estadoText.setBackground(new java.awt.Color(115, 185, 221));
        estadoText.setForeground(new java.awt.Color(255, 255, 255));
        estadoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoTextActionPerformed(evt);
            }
        });

        labelCpf6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCpf6.setForeground(new java.awt.Color(255, 255, 255));
        labelCpf6.setText("Telefone");

        telefoneText.setBackground(new java.awt.Color(115, 185, 221));
        telefoneText.setForeground(new java.awt.Color(255, 255, 255));
        telefoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTextActionPerformed(evt);
            }
        });

        cepLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cepLabel.setForeground(new java.awt.Color(255, 255, 255));
        cepLabel.setText("CEP:");

        cepText.setBackground(new java.awt.Color(115, 185, 221));
        cepText.setForeground(new java.awt.Color(255, 255, 255));
        cepText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepTextActionPerformed(evt);
            }
        });

        cadastrarButton.setBackground(new java.awt.Color(2, 72, 115));
        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        emailLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emailLabel1.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel1.setText("Crie sua senha:");

        PasswordSenha.setBackground(new java.awt.Color(115, 185, 221));
        PasswordSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTelaCadastroLayout = new javax.swing.GroupLayout(painelTelaCadastro);
        painelTelaCadastro.setLayout(painelTelaCadastroLayout);
        painelTelaCadastroLayout.setHorizontalGroup(
            painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(lblCadstro))
                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(lblNacionalidade)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nacionalidadeText, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nascimentoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                        .addComponent(nomeCadastro1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                        .addComponent(lblCpf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(lblRg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRg))
                                    .addComponent(lblDadosPessoais))
                                .addComponent(nomeCadastro2)
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(cepLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cepText, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(estadoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(estadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(emailLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelCpf6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(telefoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(emailLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        painelTelaCadastroLayout.setVerticalGroup(
            painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadstro)
                .addGap(13, 13, 13)
                .addComponent(lblDadosPessoais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCadastro1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacionalidade)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nascimentoLabel)
                    .addComponent(nacionalidadeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(nomeCadastro2)
                .addGap(18, 18, 18)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCpf6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoLabel)
                    .addComponent(estadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepLabel)
                    .addComponent(cepText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel1)
                    .addComponent(PasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(venhaParaAVaultBank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(painelTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addComponent(venhaParaAVaultBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(painelTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNascimentoActionPerformed

    private void nacionalidadeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacionalidadeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacionalidadeTextActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

    private void estadoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoTextActionPerformed

    private void telefoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTextActionPerformed

    private void cepTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepTextActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // TODO add your handling code here:
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText());
        cliente.setCPF(txtCpf.getText());
        cliente.setRG(txtRg.getText());
        cliente.setEmail(emailText.getText());
        cliente.setTelefone(telefoneText.getText());
        cliente.setDataNascimento(LocalDate.parse(txtNascimento.getText())); // formato: "yyyy-MM-dd"
        cliente.setNacionalidade(nacionalidadeText.getText());
        cliente.setCEP(cepText.getText());
        cliente.setEstado(estadoText.getText());
    
        //Isso pega a senha que o usuario preenchere
        cliente.setSenha(new String(PasswordSenha.getPassword()));
        cliente.setSaldo(BigDecimal.ZERO);
        cliente.setIsAdmin(false);

        Cliente model = new Cliente();
        ClienteDao dao = new ClienteDao();
        dao.CadastrarUsuario(cliente);
        
        this.dispose(); // fecha tela após cadastro

    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void PasswordSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordSenha;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cepText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField estadoText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCpf6;
    private javax.swing.JLabel lblCadstro;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDadosPessoais;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblRg;
    private javax.swing.JTextField nacionalidadeText;
    private javax.swing.JLabel nascimentoLabel;
    private javax.swing.JLabel nomeCadastro1;
    private javax.swing.JLabel nomeCadastro2;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelTelaCadastro;
    private javax.swing.JTextField telefoneText;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRg;
    private javax.swing.JPanel venhaParaAVaultBank;
    // End of variables declaration//GEN-END:variables
}
