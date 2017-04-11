/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

//import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author Anthony
 */
public abstract class SortingUtils implements Runnable {
    protected int[] array;
    protected long swaps;
    private long startTime;
    private long endTime;
    private String sortName;
    
    protected int delay;
    
    final int height = 600;
    
    protected Block[] blockArray;
    protected int[] numArray;

    public SortingUtils(int[] a, String sortName, boolean isGraphic)
    {
        array = a;
        this.sortName = sortName;
        
        if(isGraphic)
        {
            generateRect();
        }
    }
    
    public synchronized void swap(int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        swaps++;
    }
    
    public abstract void sort();
    
    public synchronized void run()
    {
        try
        {
            startTime = System.nanoTime();
            sort();
            endTime = System.nanoTime();
            System.out.println(sortName + " : " + (System.nanoTime() - startTime) / Math.pow(10,9) + " , Number of swaps : " + swaps);
        }
        catch(Exception e)
        {
            System.out.println(sortName + " threw an error after " + (System.nanoTime() - startTime) / Math.pow(10,9) + " seconds");
        }
    }
    
    public void drawSort(Graphics g)
    {
        for(int i = 0; i < blockArray.length; i++)
        {
            drawBlock(g,blockArray[i]);
            g.drawString(addZero(numArray[i]), blockArray[i].x+ 6, blockArray[i].y + 20);            
        }
    }
    
    public String toString()
    {
        String str = "";
        for(int temp : array)
        {
            str += temp + " , ";
        }
        str += "\nNumber of swaps = " + swaps;
        return str;
    }
    
    public int[] genRandom(int numItems)
    {
        int[] array = new int[numItems];
        
        for(int i = 0; i < numItems; i++)
                {
                    array[i] = (int)(Math.random() * numItems) + 1;
                }
        
        return array;
    }
    
    public void drawBlock(Graphics g, Block block)
    {
        g.setColor(block.color);
        g.drawRect(block.x, block.y, block.width, block.height);
    }
    
    public String addZero(int num)
    {
        if(num < 10)
        {
            return "0" + num;
        }
        else
        {
            return num + "";
        }
    }
    
    public void generateRect()
    {
        blockArray = new Block[30];
        numArray = genRandom(blockArray.length);
        
        //Create array of rectangle with a height based on their location in array
        for(int i = 0; i < blockArray.length; i++)
        {
            blockArray[i] = new Block(30 *i + 50, height - 100, 25,  -1 * numArray[i]*15, Color.GREEN);
        }
    }
    
    public void resetColor()
    {
        for(int i = 0; i < blockArray.length; i++)
        {
            blockArray[i].color = Color.GREEN;
        }
    }
}
