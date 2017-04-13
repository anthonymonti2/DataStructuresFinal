/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author anthonym
 */
public class main {
    final static int screenHeight = 600;
    final static int screenWidth = 1000;
    
    private static JFrame frame;
    private static Panel panel = new Panel(screenHeight, screenWidth);
    
    private static Timer timer;
    
    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setTitle("Sorting Comparisons");
        
        frame.add(panel);
        
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.pack();
        
        if(frame.getContentPane().getWidth() > screenWidth)
        {
            frame.pack();
        }
        
        timer = new Timer(500, new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                panel.update();
                panel.repaint();
                //System.out.println("Loop complete");
            }
        });
        
        timer.start();
        
    }
    
    
}