/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.main;

import javax.swing.UIManager;
import sgalfa.visao.Login;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

  try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception x) {
        }

        new Login().setVisible(true);


    
                    // TODO code application logic here
    }

}
