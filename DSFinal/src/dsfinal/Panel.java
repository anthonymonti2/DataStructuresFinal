package dsfinal;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.net.ssl.SSLPeerUnverifiedException;


/**
 * http://stackoverflow.com/questions/19480076/java-animation-stutters-when-not-moving-mouse-cursor
 * 
 * @author anthonym
 */
public class Panel extends JPanel {

    
    SelectionSort ss;
    ShellSort shs;
    CocktailShakerSort css;
    
    public Panel(int width, int height)
    {
        super();
        super.setPreferredSize(new Dimension(height,width));
        ss = new SelectionSort(new int[0], true);
        shs = new ShellSort(new int[0], true);
        css = new CocktailShakerSort(new int[0], true);
        super.setBackground(Color.WHITE);
    }
    
    public void paintComponent(Graphics g)
    {
        //method for repainting
        super.paintComponent(g);
        //ss.drawSort(g);
        //shs.drawSort(g);
        css.drawSort(g);
        
        Toolkit.getDefaultToolkit().sync(); //fixes studdering on linux systems
    }
    
    public void update()
    {
        //ss.stepSort();
        //shs.stepSort();
        css.stepSort();
    }
    
}
