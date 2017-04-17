/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author anthonym
 */
public class main {
    final static int screenHeight = 600;
    final static int screenWidth = 1000;
    final static String[] sortOptionsNG = {"","Bubble","Cocktail Shaker","Comb", "Gnome Bubble", "Gnome Insertion","Heap","Insertion","Merge","Odd-Even","Quick","Radix","Selection","Shell"};
    final static String[] sortOptionsG = {"","Cocktail Shaker", "Selection", "Shell"};
    
    private static JFrame frame;
    private static Panel sortPanel = new Panel(screenHeight, screenWidth);
    private static JPanel bottomBar;
    private static JButton start;
    private static JButton stop;
    private static JButton next;
    private static JMenuBar menuBar;
    private static JMenu sortsMenu;
    private static JMenu nonGraphical;
    private static JMenu graphical;
    //private static JCheckBox[] sortListNGSimple;
    //private static JCheckBox[] sortListNGComplex;
    private static ButtonGroup sortListG;
    private static JCheckBox[] sortListNG;
    private static JSlider delaySlider;
    
    private static String sortListNGSimpleString;
    private static String sortListNGComplexString;
    private static String sortListGString;
    
    private static Timer timer;
    private static int delay = 1000;
    final static int DELAY_MIN = 0;
    final static int DELAY_MAX = 2000;
    
    public static void main(String[] args)
    {
        setUpMenus();
        //Jframe stuff
        frame = new JFrame();
        frame.setTitle("Sorting Comparisons");
        frame.setLayout(new BorderLayout());
        
        frame.add(sortPanel,BorderLayout.CENTER);
        frame.add(bottomBar,BorderLayout.SOUTH);
        
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.setJMenuBar(menuBar);
        
        frame.pack();
        
        if(frame.getContentPane().getWidth() > screenWidth)
        {
            frame.pack();
        }
        
        timer = new Timer(delay, new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                sortPanel.update();
                sortPanel.repaint();
                if(sortPanel.doneSorting)
                {
                    timer.stop();
                    start.setEnabled(true);
                    stop.setEnabled(false);
                    next.setEnabled(false);
                }
            }
        });        
    }
    
    public static void setUpMenus()
    {
        menuBar = new JMenuBar();
        
        sortsMenu = new JMenu("Sorts");
        nonGraphical = new JMenu("Non-Graphical Sorting");
        graphical = new JMenu("Graphical Sorting");
        
        ButtonGroup bg = new ButtonGroup();
        
        for(int i = 1; i < sortOptionsNG.length; i++)
        {
            nonGraphical.add(new JCheckBox(sortOptionsNG[i]));
            
        }
        
        for(int i = 1; i < sortOptionsG.length; i++)
        {
            JRadioButton rb = new JRadioButton(sortOptionsG[i]);
            rb.addActionListener(e -> setUpGraphical(e));
            bg.add(rb);
            graphical.add(rb);
        }
        
        
        menuBar.add(sortsMenu);
        sortsMenu.add(nonGraphical);
        sortsMenu.add(graphical);
        
        bottomBar = new JPanel();
        start = new JButton("Start");
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                startTimer();
            }
        });
        stop = new JButton("Stop");
        stop.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timer.stop();
                start.setEnabled(true);
                stop.setEnabled(false);
                next.setEnabled(true);
            }
        });
        next = new JButton("Next");
        next.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(timer.isRunning())
                {
                    timer.stop();
                }
                sortPanel.update();
                sortPanel.repaint();
                start.setEnabled(true);
                stop.setEnabled(false);
                
                if(sortPanel.doneSorting)
                {
                    stopTimer();
                }
            }
        });
        bottomBar.add(start);
        bottomBar.add(stop);
        bottomBar.add(next);
        
        delaySlider = new JSlider(JSlider.HORIZONTAL, DELAY_MIN, 
                                            DELAY_MAX, delay);
        delaySlider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
               if(delaySlider.getValueIsAdjusting())
                {
                    int newDelay = (int)delaySlider.getValue();
                    if(newDelay == 0)
                        timer.stop();
                    else
                        if(!timer.isRunning())
                            startTimer();
                        timer.setDelay(newDelay);
                } 
            }
        });
        delaySlider.setMajorTickSpacing(500);
        delaySlider.setMinorTickSpacing(100);
        delaySlider.setPaintTicks(true);
        delaySlider.setPaintLabels(true);
        
        bottomBar.add(delaySlider);
        
    }
    
    public static void startTimer()
    {
        timer.start();
        start.setEnabled(false);
        stop.setEnabled(true);
        next.setEnabled(false);
    }
    
    public static void stopTimer()
    {
        timer.stop();
        start.setEnabled(true);
        stop.setEnabled(false);
        next.setEnabled(false);
    }
    
    public static void setUpGraphical(ActionEvent e)
    {
        JRadioButton source = (JRadioButton)(e.getSource());
        String sortSTR = source.getText();
        
        int[] toBeSorted = generateArray(0, 30);
        
        if(sortSTR.equals(sortOptionsG[1]))
        {
            sortPanel.sort = new CocktailShakerSort(toBeSorted,true);
        }
        else if(sortSTR.equals(sortOptionsG[2]))
        {
            sortPanel.sort = new SelectionSort(toBeSorted,true);
        }
        else if(sortSTR.equals(sortOptionsG[3]))
        {
            sortPanel.sort = new ShellSort(toBeSorted,true);
        }
        
        timer.stop();
    }
    
    public static int getIndex(ActionEvent e)
    {
        JCheckBox source = (JCheckBox)(e.getSource());
        
        if(source.isSelected())
        {
           
        }
        return 0;
    }
    
    public static int[] generateArray(int type, int max)
    {
        int[] tBSort = new int[max];
        switch(type)
        {
            case 1: 
                //random
                System.out.println("\nGenerating random array of " + max + " integers");
                for(int i = 0; i < max; i++)
                {
                    tBSort[i] = (int)(Math.random() * max);
                }
                break;
            case 2:
                //backwards
                System.out.println("\nGenerating backwards array of " + max + " integers");
                for(int i = 0; i < max; i++)
                {
                    tBSort[max-1-i] = i;
                }
                break;
            case 3:
                //almost sorted
                System.out.println("\nGenerating almost sorted array of " + max + " integers");
                for(int i = 0; i < max; i++)
                {
                    if(i < (int)(max * .75))
                    {
                        tBSort[i] = i;
                    }
                    else
                    {
                        tBSort[i] = (int)(Math.random() * max);
                    }
                }
                break;
            case 4:
                //few unique
                for(int i = 0; i < 5; i++)
                {
                    for(int q = 0; q < max/5; q++)
                    {
                        //doesn't work yet...
                    }
                }
                break;
        }
        
        return tBSort;
    }
}
