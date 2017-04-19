/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;

/**
 *
 * @author anthonym
 */
public class main {
    final static int screenHeight = 600;
    final static int screenWidth = 1000;
    final static String[] sortOptionsNG = {"","Bubble","Cocktail Shaker","Comb", "Gnome Bubble", "Gnome Insertion","Heap","Insertion","Merge","Odd-Even","Quick","Radix","Selection","Shell"};
    final static String[] sortOptionsG = {"","Cocktail Shaker","Comb", "Selection", "Shell"};
    
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
    private static JCheckBox[] sortListNG;
    private static JSlider delaySlider;
    
    private static Timer timer;
    private static int delay = 500;
    final static int DELAY_MIN = 0;
    final static int DELAY_MAX = 1000;
    
    private static ArrayList<Thread> sorts = new ArrayList<>();
    protected static int lengthOfSortList;
    
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
                if(sortPanel.graphical == false)
                {
                    while(!sorts.isEmpty())
                    {
                        for(int i = 0; i < sorts.size();i++)
                        {
                            if(!sorts.get(i).isAlive())
                            {
                                sorts.remove(i);
                            }
                        }
                    }
                    stopTimer();
                }
                
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
        sortListNG = new JCheckBox[sortOptionsNG.length];
        
        ButtonGroup bg = new ButtonGroup();
        
        for(int i = 1; i < sortOptionsNG.length; i++)
        {
            JCheckBox cb = new JCheckBox(sortOptionsNG[i]);
            //cb.addActionListener(e -> setUpNG());
            sortListNG[i] = cb;
            nonGraphical.add(cb);
            
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
        for(int i = 1; i < sortListNG.length; i++)
        {
            if(sortListNG[i].isSelected() == true)
            {
                String response = JOptionPane.showInputDialog("Please enter the number of integers you want to sort. "
                        + " Numbers over 100,000 will slow down everything", "Number of Integers");
                while(true)
                {
                    try
                    {
                        lengthOfSortList = Integer.valueOf(response);
                        setUpNG();
                        break;
                    }
                    catch(Exception e)   
                    {
                        response = JOptionPane.showInputDialog("Please enter the number of integers you want to sort. "
                            + " Numbers over 100,000 will slow down everything", "Number of Integers");

                    }
                }
                
                System.out.println("\fStarting Non Graphical Sorting\n");
                sorts.forEach((t) -> {
                t.start();
                });
                            
                for(int q = 1; q < sortListNG.length; q++)
                {
                    sortListNG[q].setSelected(false);
                }
                break;
            }
        }
        
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
        delaySlider.setEnabled(true);
        sortPanel.graphical = true;
        JRadioButton source = (JRadioButton)(e.getSource());
        String sortSTR = source.getText();
        
        int[] toBeSorted = {0};
        
        if(sortSTR.equals(sortOptionsG[1]))
        {
            sortPanel.sort = new CocktailShakerSort(toBeSorted,true);
        }
        else if(sortSTR.equals(sortOptionsG[2]))
        {
            sortPanel.sort = new CombSort(toBeSorted,true);
        }
        else if(sortSTR.equals(sortOptionsG[4]))
        {
            sortPanel.sort = new ShellSort(toBeSorted,true);
        }
        else if(sortSTR.equals(sortOptionsG[3]))
        {
            sortPanel.sort = new SelectionSort(toBeSorted,true);
        }
        
        timer.stop();
    }
    
    public static void setUpNG()
    {
        stopTimer();
        sortPanel.graphical = false;
        
        int typeofSort = 0;
        
        String response = JOptionPane.showInputDialog("Please enter the type of array you want to sort\n1.)Random\n2.)Backwards\n3.)Almost Sorted\n");
                while(true)
                {
                    try
                    {
                        typeofSort = Integer.valueOf(response);
                        if(typeofSort == 1 || typeofSort == 2 ||typeofSort == 3)
                        {
                            break;
                        }
                    }
                    catch(Exception e)   
                    {
                        response = JOptionPane.showInputDialog("Please enter the type of array you want to sort\n1.)Random\n2.)Backwards\n3.)Almost Sorted\n");

                    }
                }
        
        
        int[] toBeSorted = generateArray(typeofSort, 10000);
        sorts.clear();
        sorts.ensureCapacity(sortListNG.length);
        for(int i = 1; i < sortListNG.length; i++)
        {
            if(sortListNG[i].isSelected())// sortListNG[i].&& sorts.size() == i-1 && sorts.get(i).getName().equals(sortListNG[i].getText() + " Sort") == false)
            {
                String sortSTR = sortListNG[i].getText();

                if(sortSTR.equals(sortOptionsNG[1]))
                {
                    Runnable bubbleRunnable = new BubbleSort(toBeSorted,false);
                    sorts.add(new Thread(bubbleRunnable, "Bubble Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[2]))
                {
                    Runnable cocktailShakerRunnable = new CocktailShakerSort(toBeSorted,false);
                    sorts.add(new Thread (cocktailShakerRunnable, "Cocktail Shaker Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[3]))
                {
                    Runnable combRunnable = new CombSort(toBeSorted,false);
                    sorts.add(new Thread(combRunnable, "Comb Sort")); 
                }
                else if(sortSTR.equals(sortOptionsNG[4]))
                {
                    Runnable gnomeBubbleRunnable = new GnomeBubbleSort(toBeSorted,false);
                    sorts.add(new Thread(gnomeBubbleRunnable, "Gnome Bubble Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[5]))
                {
                    Runnable gnomeInsertionRunnable = new GnomeInsertionSort(toBeSorted,false);
                    sorts.add(new Thread(gnomeInsertionRunnable, "Gnome Insertion Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[6]))
                {
                    Runnable heapRunnable = new HeapSort(toBeSorted,false);
                    sorts.add(new Thread(heapRunnable, "Heap Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[7]))
                {
                    Runnable insertionRunnable = new InsertionSort(toBeSorted,false);
                    sorts.add(new Thread(insertionRunnable, "Insertion Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[8]))
                {
                    Runnable mergeRunnable = new MergeSort(toBeSorted,false);
                    sorts.add(new Thread(mergeRunnable, "Merge Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[9]))
                {
                    Runnable oddEvenRunnable = new OddEvenSort(toBeSorted,false);
                    sorts.add(new Thread(oddEvenRunnable, "Odd-Even Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[10]))
                {
                    Runnable quickRunnable = new QuickSort(toBeSorted,false);
                    sorts.add(new Thread(quickRunnable, "Quick Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[11]))
                {
                    Runnable radixRunnable = new RadixSort(toBeSorted, getNumDigits(toBeSorted.length),false);
                    sorts.add(new Thread(radixRunnable, "Radix Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[12]))
                {
                    Runnable selectionRunnable = new SelectionSort(toBeSorted,false);
                    sorts.add(new Thread(selectionRunnable, "Selection Sort"));
                }
                else if(sortSTR.equals(sortOptionsNG[13]))
                {
                    Runnable shellRunnable = new ShellSort(toBeSorted,false);
                    sorts.add(new Thread(shellRunnable, "Shell Sort"));
                }
                else
                {
                    System.out.println("Error finding " + sortSTR);
                }
            }
        }

        delay = 0;
        delaySlider.setEnabled(false);
    }
    public static int[] generateArray(int type, int max)
    {
        int[] tBSort = new int[max];
        switch(type)
        {
            case 1: 
                //random
                for(int i = 0; i < max; i++)
                {
                    tBSort[i] = (int)(Math.random() * max);
                }
                break;
            case 2:
                //backwards
                for(int i = 0; i < max; i++)
                {
                    tBSort[max-1-i] = i;
                }
                break;
            case 3:
                //almost sorted
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
        }
        
        return tBSort;
    }
    
    private static int getNumDigits(int num)
    {
        if(num == 0)
        {
            return 0;
        }
        else
        {
            return 1+ getNumDigits(num/10);
        }
    }
}
