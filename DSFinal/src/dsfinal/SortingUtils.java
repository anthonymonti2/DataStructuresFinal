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

    public SortingUtils(int[] a, String sortName)
    {
        array = a;
        this.sortName = sortName;
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
    
    public abstract void drawSort(Graphics g);
    
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
}
