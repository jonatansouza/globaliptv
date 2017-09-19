/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv;

import globaltv.controller.GlobalTvController;
import globaltv.ui.About;
import globaltv.ui.AdminAreaPanel;
import globaltv.ui.ChannelsPanel;
import globaltv.ui.CreateChannel;
import globaltv.ui.CreateUser;
import globaltv.ui.EditChannelPanel;
import globaltv.ui.Login;
import globaltv.ui.UsersPanel;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pichau
 */
public class Globaltv {
    private GlobalTvController globalTvController;
    /**
     * @param args the command line arguments
     */
    
    /**
     * este metodo inicia a interface grafica e os controles necessarios para o funcionamento da aplicação
     */
    private void displayGUI(){
        
        globalTvController = new GlobalTvController();
        globalTvController.initialize();
        JFrame frame = new JFrame("Global TV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
        BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        contentPane.add(new ChannelsPanel(contentPane, globalTvController), "channel");
        contentPane.add(new UsersPanel(contentPane, globalTvController), "user");
        contentPane.add(new Login(contentPane, globalTvController), "login");
        contentPane.add(new About(contentPane), "about");
        contentPane.add(new CreateUser(contentPane, globalTvController), "create-user");
        contentPane.add(new CreateChannel(contentPane, globalTvController), "create-channel");
        contentPane.add(new AdminAreaPanel(contentPane, globalTvController), "admin-area");
        contentPane.add(new EditChannelPanel(contentPane, globalTvController), "edit-channel");
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(true);
    }
    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Globaltv().displayGUI();
            }
        });
    }
    
    
}


