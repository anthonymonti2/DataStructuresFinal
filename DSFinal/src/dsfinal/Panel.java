package dsfinal;

import java.awt.Color;
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
    ShellSort shs;
    
    public Panel(int width, int height)
    {
        super();
        super.setPreferredSize(new Dimension(height,width));
        //ss = new SelectionSort(new int[0], true);
        //ss = new SelectionSort(new int[0], true);
        shs = new ShellSort(new int[0], true);
        super.setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g)
    {
        //method for repainting
        super.paintComponent(g);
        //ss.drawSort(g);
        shs.drawSort(g);
    }
    
    public void update()
    {
        //ss.stepSort();
        shs.stepSort();
    }
    
}
