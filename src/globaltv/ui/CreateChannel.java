/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.ui;

import globaltv.controller.GlobalTvController;
import globaltv.models.ChannelModel;
import globaltv.utils.GlobalTvConstants;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Pichau
 */
public class CreateChannel extends javax.swing.JPanel {
    private final JPanel contentPanel;
    private final GlobalTvController globalTvController;
    private JFileChooser jFileChooser;
    /**
     * Creates new form CreateChannel
     */
    public CreateChannel(JPanel contentPanel, GlobalTvController globalTvController) {
        this.globalTvController = globalTvController;
        this.contentPanel = contentPanel;
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
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        addrChannel = new javax.swing.JTextField();
        createChannel = new javax.swing.JButton();
        code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pickFile = new javax.swing.JButton();

        banner.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        banner.setText("Global TV");
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/tv-small.png")));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Cadastro de Canais");

        jButton2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("URL do canal:");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Codigo:");

        name.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        addrChannel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        createChannel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        createChannel.setText("Enviar");
        createChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChannelActionPerformed(evt);
            }
        });

        code.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setText("Icone:");

        pickFile.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        pickFile.setText("escolher arquivo");
        pickFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner)
                .addGap(248, 248, 248)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addrChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createChannel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(code, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pickFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(banner)
                    .addComponent(jLabel5)
                    .addComponent(jButton2))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addrChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pickFile))
                .addGap(54, 54, 54)
                .addComponent(createChannel)
                .addContainerGap(251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "admin-area");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void createChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChannelActionPerformed
        ChannelModel channel = new ChannelModel();
        channel.setId(0);
        channel.setAddrChannel(addrChannel.getText());
        channel.setCode(code.getText());
        try {
            channel.setIcon(jFileChooser.getSelectedFile());
        } catch (Exception e) {
             System.out.println("insert fake icon");
             channel.setIcon(new File(getClass().getResource("images/channels/fake.png").getPath()));
        }
        channel.setName(name.getText());
        globalTvController.createChannel(channel);
        System.out.println(globalTvController.listAllChannels());
        JOptionPane.showMessageDialog(contentPanel, "Canal Registrado com sucesso!");
    }//GEN-LAST:event_createChannelActionPerformed

    private void pickFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickFileActionPerformed
        jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(this);
        
    }//GEN-LAST:event_pickFileActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addrChannel;
    private javax.swing.JLabel banner;
    private javax.swing.JTextField code;
    private javax.swing.JButton createChannel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JButton pickFile;
    // End of variables declaration//GEN-END:variables
}
