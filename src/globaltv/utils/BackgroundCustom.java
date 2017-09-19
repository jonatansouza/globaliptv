/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.utils;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class BackgroundCustom {
     public Image setBackgroud(){
        Image image = null;
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("back.jpg"), "back.jpg"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(BackgroundCustom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackgroundCustom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return image;
    }
}
