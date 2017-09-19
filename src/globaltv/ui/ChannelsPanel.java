/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.ui;

import globaltv.controller.GlobalTvController;
import globaltv.models.ChannelModel;
import globaltv.utils.FakeChannel;
import globaltv.utils.HandlingImages;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pichau
 */
public class ChannelsPanel extends javax.swing.JPanel {

    private final JPanel contentPanel;
    private final GlobalTvController globalTvController;
    private DefaultTableModel defaultTableModel;
    private ChannelModel channelModel;
    /**
     * Creates new form channel
     */
    public ChannelsPanel(JPanel contentPanel, GlobalTvController globalTvController) {
        this.globalTvController = globalTvController;
        this.contentPanel = contentPanel;
        initComponents();
        createColumns();
        updateInformations();
    }
    
    public void updateInformations(){
        if(this.globalTvController.getUser() == null){
            loginButton.setText("Login");
            adminArea.setVisible(false);
            deleteChannel.setVisible(false);
            editChannel.setVisible(false);
            repaint();
        }else{
            loginButton.setText("LogOut");
            adminArea.setVisible(true);
            deleteChannel.setVisible(true);
            editChannel.setVisible(true);
            repaint();
        }
        populate(globalTvController.listAllChannels());
       
    }
    
    
    private void createColumns(){
        defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("Nome");
    }
    
    private void populate(List<ChannelModel> channelModels){
        defaultTableModel = (DefaultTableModel) jTable1.getModel();
        for (int i = defaultTableModel.getRowCount() - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
        }
        Object rowData [] = new Object[2];
        for(ChannelModel channel: channelModels){
            rowData[0] = channel.getId();
            rowData[1] = channel.getName();
            defaultTableModel.addRow(rowData);
        }
        
        populatePanelSecundary(channelModels.isEmpty() ? new FakeChannel().getChannel() : channelModels.get(0));
    }
    
    private void populatePanelSecundary(ChannelModel channel){
        channelModel = channel;
        nameDesc.setText( channel.getId() + " - "+channel.getName());
        urlDesc.setText(channel.getAddrChannel());
        try {
            File ic = channel.getIcon();
            if(ic == null){
                try {
                    ic = new File(getClass().getResource("images/channels/fake.png").toURI());
                } catch (URISyntaxException ex) {
                    Logger.getLogger(ChannelsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            iconDec.setIcon(new HandlingImages().resize(new javax.swing.ImageIcon(Files.readAllBytes(ic.toPath())), 175,175));
        } catch (IOException ex) {
            Logger.getLogger(ChannelsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
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
        searchChannel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelSecundary = new javax.swing.JPanel();
        descPainelSecundario = new javax.swing.JLabel();
        nameDesc = new javax.swing.JLabel();
        urlDesc = new javax.swing.JLabel();
        iconDec = new javax.swing.JLabel();
        deleteChannel = new javax.swing.JButton();
        editChannel = new javax.swing.JButton();
        watch = new javax.swing.JButton();
        adminArea = new javax.swing.JButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        banner.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        banner.setText("Global TV");
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/tv-small.png")));

        searchChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchChannelActionPerformed(evt);
            }
        });
        searchChannel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchChannelKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jLabel2.setText("Encontrar Canal:");

        loginButton.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jButton2.setText("Sobre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        descPainelSecundario.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        descPainelSecundario.setText("Descrição do Canal");

        nameDesc.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        nameDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        urlDesc.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        urlDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        iconDec.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        deleteChannel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        deleteChannel.setText("Deletar");
        deleteChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChannelActionPerformed(evt);
            }
        });

        editChannel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        editChannel.setText("Editar");

        watch.setText("Assistir");
        watch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSecundaryLayout = new javax.swing.GroupLayout(PanelSecundary);
        PanelSecundary.setLayout(PanelSecundaryLayout);
        PanelSecundaryLayout.setHorizontalGroup(
            PanelSecundaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSecundaryLayout.createSequentialGroup()
                .addGroup(PanelSecundaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelSecundaryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelSecundaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editChannel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(watch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteChannel, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(urlDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelSecundaryLayout.createSequentialGroup()
                        .addContainerGap(90, Short.MAX_VALUE)
                        .addGroup(PanelSecundaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descPainelSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconDec, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
        );
        PanelSecundaryLayout.setVerticalGroup(
            PanelSecundaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSecundaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descPainelSecundario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconDec, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(nameDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(urlDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(watch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteChannel)
                .addGap(18, 18, 18)
                .addComponent(editChannel)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        adminArea.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        adminArea.setText("Área Administrativa");
        adminArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(banner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminArea, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(searchChannel))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(PanelSecundary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(banner)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminArea, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelSecundary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addContainerGap(439, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchChannelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchChannelActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if(globalTvController.getUser() == null){
            CardLayout cl = (CardLayout)contentPanel.getLayout();
            cl.show(contentPanel, "login");
        }else{
            int decision = JOptionPane.showConfirmDialog(contentPanel, "deseja mesmo sair?");
            if(decision == 0){
                globalTvController.setUser(null);
                updateInformations();
            }
                
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout)contentPanel.getLayout();
        cl.show(contentPanel, "about");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchChannelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchChannelKeyReleased
        populate(globalTvController.listByName(searchChannel.getText()));
    }//GEN-LAST:event_searchChannelKeyReleased

    private void adminAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminAreaActionPerformed
         CardLayout cl = (CardLayout)contentPanel.getLayout();
            cl.show(contentPanel, "admin-area");
    }//GEN-LAST:event_adminAreaActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
//
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.updateInformations();
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        populatePanelSecundary(globalTvController.getChannelById((int) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)));
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void watchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchActionPerformed
        String code = "";
        if(!channelModel.getCode().isEmpty()){
                        code = JOptionPane.showInputDialog(this, "CANAL PROTEGIDO!\nDigite o codigo para continuar!");

        }
        
        if(channelModel.getCode().isEmpty() || channelModel.getCode().equals(code)){
        
        String url = channelModel.getAddrChannel();
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{  

                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("xdg-open " + url);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Codigo de proteção Incorreto");
        }
    }//GEN-LAST:event_watchActionPerformed

    private void deleteChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChannelActionPerformed
        Object[] options = {"fechar",
                     "deletar"};
        int del = JOptionPane.showOptionDialog(this, "deseja deletar o Canal "+ channelModel.getName()+" ?" , "DELETAR Canal",
                JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 options,
                 null);
        
        
        if(del == 1){
            if(globalTvController.deleteChannel(channelModel.getId())){
                populate(globalTvController.listAllChannels());
                JOptionPane.showMessageDialog(contentPanel, "Canal deletado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(contentPanel, "Ocorreu um erro ao deletar");
            }
            
        }
    }//GEN-LAST:event_deleteChannelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSecundary;
    private javax.swing.JButton adminArea;
    private javax.swing.JLabel banner;
    private javax.swing.JButton deleteChannel;
    private javax.swing.JLabel descPainelSecundario;
    private javax.swing.JButton editChannel;
    private javax.swing.JLabel iconDec;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameDesc;
    private javax.swing.JTextField searchChannel;
    private javax.swing.JLabel urlDesc;
    private javax.swing.JButton watch;
    // End of variables declaration//GEN-END:variables

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
