/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SunCho
 */
public class OpenForm {
    public static void Open(Component c){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {}
               
        DragListener drag = new DragListener();
        c.addMouseListener( drag );
        c.addMouseMotionListener( drag );
        c.setVisible(true); 
    }
}
