/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class DesenhaTela extends JPanel{
     Image img;
     String Local = "file:/C:/backgound.png";


    public DesenhaTela(){
       try{
         img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource(Local), Local));
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não Carregou a Imagem (PANEL)");
       }
     }
        @Override
        public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
        else g.drawString("Image not found", 50,50);
     }

  }
