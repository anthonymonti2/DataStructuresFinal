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
            blockArray[i].drawBlock(g);
        }
        
        
    }
    
    public String toString(int[] array)
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
        int numlength = 30;
        blockArray = new Block[numlength];
        numArray = genRandom(blockArray.length);
        //numArray = new int[]{2,8,11,17,1,4,2,12,12,7,17,18,10,2,6,1,3,20,7,16};
        
        //Create array of rectangle with a height based on their location in array
        for(int i = 0; i < blockArray.length; i++)
        {
            //blockArray[i] = new Block(30 *i + 50, height - 100, 25,  -1 * numArray[i], Color.GREEN, false);
            blockArray[i] = new Block(30*i+50, height-100, 25, numArray[i], Color.GREEN, false);
        }
    }
    
    public void resetColor()
    {
        for(int i = 0; i < blockArray.length; i++)
        {
            blockArray[i].color = Color.GREEN;
        }
    }
    
    public void swapGraphic(int a, int b)
    {
        int temp = numArray[a];
        numArray[a] = numArray[b];
        numArray[b] = temp;
        
        /*
        Block tempBlock = blockArray[a]; int tempAX=blockArray[a].x, tempBX=blockArray[b].x;
        blockArray[a] = blockArray[b];
        blockArray[a].x = tempAX;
        blockArray[b] = tempBlock;
        blockArray[b].x = tempBX;*/
        
        int tempValue = blockArray[a].value;
        blockArray[a].value = blockArray[b].value;
        blockArray[b].value = tempValue;
        
    }
}
