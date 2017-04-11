/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Anthony
 */
public class SelectionSort extends SortingUtils {
    
    public SelectionSort(int[] array)
    {
        super(array, "Selection Sort");
    }
    
    @Override
    public void sort()
    {
        for(int i = array.length-1; i > 0 ; i--)
        {
            int index = i;
            for(int q = i-1; q >= 0 ; q--)
            {
                if(array[q] > array[index])
                {
                    index = q;
                }
            }
            
            if(array[i] != array[index])
            {
                swap(index,i);
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
    public void drawSort(Graphics g)
    {
        rectArray = new Rectangle[20];
        int[] numArray = genRandom(rectArray.length);
        
        for(int i = 0; i < rectArray.length; i++)
        {
            rectArray[i] = new Rectangle(20*i, 400, 50, numArray[i]*15);
        }
        
        for(Rectangle rect: rectArray)
        {
            drawRect(g,rect,Color.BLUE);
        }
    }
    
    
    
    
}
