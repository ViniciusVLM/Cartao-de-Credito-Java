
package Viewer;

import Viewer.TelaEntrar;
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
import java.awt.Graphics;
import java.awt.Image;


public class TelaPrincipal extends javax.swing.JFrame {
    
    public TelaPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTelaInicial = new javax.swing.JPanel();
        panEntrar = new java.awt.Panel();
        btnEntrar = new javax.swing.JButton();
        lblEntrar1 = new javax.swing.JLabel();
        lblEntrar2 = new javax.swing.JLabel();
        panHeader = new java.awt.Panel();
        lblBoaVindas = new javax.swing.JLabel();
        panCadastrar = new java.awt.Panel();
        btnCadastrar = new javax.swing.JButton();
        lblCadastrar1 = new javax.swing.JLabel();
        lblCadastrar2 = new javax.swing.JLabel();
        panApresentacao = new javax.swing.JPanel();
        lblApresentacao = new javax.swing.JLabel();
        lblApresentacao1 = new javax.swing.JLabel();
        lblApresentacao2 = new javax.swing.JLabel();
        lblApresentacao3 = new javax.swing.JLabel();
        lblApresentacao4 = new javax.swing.JLabel();
        panImage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panTelaInicial.setBackground(new java.awt.Color(242, 218, 172));

        panEntrar.setBackground(new java.awt.Color(242, 206, 22));
        panEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnEntrar.setBackground(new java.awt.Color(2, 72, 115));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblEntrar1.setBackground(java.awt.Color.white);
        lblEntrar1.setForeground(java.awt.Color.white);
        lblEntrar1.setText("Se você já tem cadastro na VaultBank");
        lblEntrar1.setToolTipText("");

        lblEntrar2.setBackground(new java.awt.Color(255, 255, 255));
        lblEntrar2.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrar2.setText("clique no botão abaixo");

        javax.swing.GroupLayout panEntrarLayout = new javax.swing.GroupLayout(panEntrar);
        panEntrar.setLayout(panEntrarLayout);
        panEntrarLayout.setHorizontalGroup(
            panEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEntrarLayout.createSequentialGroup()
                .addGroup(panEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEntrarLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panEntrarLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblEntrar1))
                    .addGroup(panEntrarLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblEntrar2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panEntrarLayout.setVerticalGroup(
            panEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEntrarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblEntrar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEntrar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        panHeader.setBackground(new java.awt.Color(217, 165, 11));

        lblBoaVindas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBoaVindas.setForeground(new java.awt.Color(255, 255, 255));
        lblBoaVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoaVindas.setText("VENHA PARA A VAULTBANK");
        lblBoaVindas.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        javax.swing.GroupLayout panHeaderLayout = new javax.swing.GroupLayout(panHeader);
        panHeader.setLayout(panHeaderLayout);
        panHeaderLayout.setHorizontalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeaderLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(lblBoaVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panHeaderLayout.setVerticalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBoaVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panCadastrar.setBackground(new java.awt.Color(242, 206, 22));
        panCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCadastrar.setBackground(new java.awt.Color(2, 72, 115));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblCadastrar1.setBackground(java.awt.Color.white);
        lblCadastrar1.setForeground(java.awt.Color.white);
        lblCadastrar1.setText("Se você ainda não faz parte da VaultBank");
        lblCadastrar1.setToolTipText("");

        lblCadastrar2.setForeground(java.awt.Color.white);
        lblCadastrar2.setText(" é só clicar no botão abaixo ");

        javax.swing.GroupLayout panCadastrarLayout = new javax.swing.GroupLayout(panCadastrar);
        panCadastrar.setLayout(panCadastrarLayout);
        panCadastrarLayout.setHorizontalGroup(
            panCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCadastrarLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblCadastrar1)
                .addGap(17, 17, 17))
            .addGroup(panCadastrarLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(panCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCadastrar2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panCadastrarLayout.setVerticalGroup(
            panCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCadastrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblCadastrar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCadastrar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        panApresentacao.setBackground(new java.awt.Color(242, 206, 22));

        lblApresentacao.setForeground(new java.awt.Color(255, 255, 255));
        lblApresentacao.setText("VaultBank: segurança e benefícios no");

        lblApresentacao1.setForeground(new java.awt.Color(255, 255, 255));
        lblApresentacao1.setText("                      seu cartão.");
        lblApresentacao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblApresentacao2.setForeground(new java.awt.Color(255, 255, 255));
        lblApresentacao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApresentacao2.setText("Proteção avançada, cashback e zero ");

        lblApresentacao3.setForeground(new java.awt.Color(255, 255, 255));
        lblApresentacao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApresentacao3.setText("complicação. Peça o seu.");
        lblApresentacao3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblApresentacao4.setForeground(new java.awt.Color(255, 255, 255));
        lblApresentacao4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApresentacao4.setText("VaultBank – seu dinheiro protegido, sua");

        javax.swing.GroupLayout panImageLayout = new javax.swing.GroupLayout(panImage);
        panImage.setLayout(panImageLayout);
        panImageLayout.setHorizontalGroup(
            panImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panImageLayout.setVerticalGroup(
            panImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panApresentacaoLayout = new javax.swing.GroupLayout(panApresentacao);
        panApresentacao.setLayout(panApresentacaoLayout);
        panApresentacaoLayout.setHorizontalGroup(
            panApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panApresentacaoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblApresentacao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApresentacao, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(lblApresentacao4)
                    .addComponent(lblApresentacao2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(lblApresentacao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(panImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panApresentacaoLayout.setVerticalGroup(
            panApresentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panApresentacaoLayout.createSequentialGroup()
                .addComponent(panImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(lblApresentacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApresentacao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApresentacao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApresentacao3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApresentacao4)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout panTelaInicialLayout = new javax.swing.GroupLayout(panTelaInicial);
        panTelaInicial.setLayout(panTelaInicialLayout);
        panTelaInicialLayout.setHorizontalGroup(
            panTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panTelaInicialLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(panApresentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        panTelaInicialLayout.setVerticalGroup(
            panTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTelaInicialLayout.createSequentialGroup()
                .addComponent(panHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(panTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panTelaInicialLayout.createSequentialGroup()
                        .addComponent(panEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panApresentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        panApresentacao.getAccessibleContext().setAccessibleName("seu cartão.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTelaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        TelaEntrar nova = new TelaEntrar();
        nova.setVisible(true);
    }//GEN-LAST:event_btnEntrarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblApresentacao;
    private javax.swing.JLabel lblApresentacao1;
    private javax.swing.JLabel lblApresentacao2;
    private javax.swing.JLabel lblApresentacao3;
    private javax.swing.JLabel lblApresentacao4;
    private javax.swing.JLabel lblBoaVindas;
    private javax.swing.JLabel lblCadastrar1;
    private javax.swing.JLabel lblCadastrar2;
    private javax.swing.JLabel lblEntrar1;
    private javax.swing.JLabel lblEntrar2;
    private javax.swing.JPanel panApresentacao;
    private java.awt.Panel panCadastrar;
    private java.awt.Panel panEntrar;
    private java.awt.Panel panHeader;
    public static javax.swing.JPanel panImage;
    private javax.swing.JPanel panTelaInicial;
    // End of variables declaration//GEN-END:variables
}
