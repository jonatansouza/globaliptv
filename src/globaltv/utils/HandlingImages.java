/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.utils;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
/**
 *
 * @author Pichau
 */
public class HandlingImages {
    
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
   
    /*
     * @param receber icone, largura e altura desejeda
     * @return retorna a imagem redimensionada
     */
    public ImageIcon resize(ImageIcon img, int heigth, int width){
       
        img.setImage(img.getImage().getScaledInstance(width, heigth, 100));
       
        return img;
    }
   
}