/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.net.ssl.SSLPeerUnverifiedException;


/**
 *
 * @author anthonym
 */
public class Panel extends JPanel {

    
    SelectionSort ss;
    
    public Panel(int width, int height)
    {
        super();
        super.setPreferredSize(new Dimension(height,width));
        ss = new SelectionSort(new int[0], true);
    }
    
    public void paintComponent(Graphics g)
    {
        //method for repainting
        super.paintComponent(g);
        ss.drawSort(g);
    }
    
    public void update()
    {
        ss.resetColor(ss.iNum, ss.qNum);
        ss.stepSort(ss.iNum, ss.qNum);
        //System.out.println("Panel update");
    }
    
}
