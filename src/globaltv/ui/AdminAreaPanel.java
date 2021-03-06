/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.ui;

import globaltv.controller.GlobalTvController;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Pichau
 */
public class AdminAreaPanel extends javax.swing.JPanel {

    private final JPanel contentPanel;
    private final GlobalTvController globalTvController;
    
    /**
     * Creates new form AdminAreaPanel
     */
    public AdminAreaPanel(JPanel contentPanel, GlobalTvController globalTvController) {
        this.contentPanel = contentPanel;
        this.globalTvController = globalTvController;
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

        banner = new javax.swing.JLabel();
        showUsers = new javax.swing.JButton();
        CreateChannel1 = new javax.swing.JButton();
        CreateUser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.text);

        banner.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        banner.setText("Global TV");
        banner.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemResource("images/tv-small.png")));

        showUsers.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        showUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/if_group2_309041.png"))); // NOI18N
        showUsers.setText("Listar/remover Usuarios");
        showUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersActionPerformed(evt);
            }
        });

        CreateChannel1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        CreateChannel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/if_computer_add_103449.png"))); // NOI18N
        CreateChannel1.setText("Adicionar Canal");
        CreateChannel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateChannel1ActionPerformed(evt);
            }
        });

        CreateUser.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        CreateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/if_user_full_add_103767.png"))); // NOI18N
        CreateUser.setText("Adicionar Usuário");
        CreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUserActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/if_arrow-back_216437.png"))); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 265, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(banner)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(CreateChannel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateUser, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addContainerGap(552, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "user"); // TODO add your handling code here:
    }//GEN-LAST:event_showUsersActionPerformed

    private void CreateChannel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateChannel1ActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "create-channel"); // TODO add your handling code here:
    }//GEN-LAST:event_CreateChannel1ActionPerformed

    private void CreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUserActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "create-user"); // TODO add your handling code here:
    }//GEN-LAST:event_CreateUserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "channel");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateChannel1;
    private javax.swing.JButton CreateUser;
    private javax.swing.JLabel banner;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton showUsers;
    // End of variables declaration//GEN-END:variables
}
