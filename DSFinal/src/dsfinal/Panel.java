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

    
    //protected SelectionSort ss;
    //protected ShellSort shs;
    //protected CocktailShakerSort css;
    protected boolean doneSorting;
    protected boolean graphical;
    protected SortingUtils sort = new SelectionSort(new int[0], true);
    
    public Panel(int width, int height)
    {
        super();
        super.setPreferredSize(new Dimension(height,width));
        //ss = 
        //shs = new ShellSort(new int[0], true);
        //css = new CocktailShakerSort(new int[0], true);
        super.setBackground(Color.WHITE);
        graphical = true;
        
        doneSorting = false;
    }
    
    public void paintComponent(Graphics g)
    {
        //method for repainting
        super.paintComponent(g);
        
        if(graphical)
        {
            sort.drawSort(g);
        }
        else
        {
            g.setColor(Color.white);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }
        
        Toolkit.getDefaultToolkit().sync(); //fixes studdering on linux systems
    }
    
    public void update()
    {
        if(graphical)
        {
            sort.stepSort();
            checkSort(sort);
        }
    }
    
    public void checkSort(SortingUtils sort)
    {
        int numSorted = 0;
        for(int i = 0; i < sort.numArray.length; i++)
        {
            if(sort.blockArray[i].isSorted)
            {
                numSorted++;
            }
        }
        
        if(numSorted >= sort.numArray.length - 1)
            doneSorting = true;
        else
            doneSorting = false;
    }
    
}
