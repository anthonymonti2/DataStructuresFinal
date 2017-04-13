/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony
 */
public class SelectionSort extends SortingUtils {
    
    protected int iNum;
    protected int qNum;
    protected int indexNum;
    
    public SelectionSort(int[] array, boolean isGraphic)
    {
        super(array, "Selection Sort", isGraphic);
        iNum = numArray.length - 1;
        qNum = iNum - 1;
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
    
    public void stepSort(int i, int q)
    {
        if(i > 0)
        { 
            if(q >= 0)
            {   
                //indexNum = i;
                if(numArray[q] > numArray[indexNum])
                {
                    indexNum = q;
                    blockArray[indexNum].color = Color.BLUE;
                }
                else
                {
                     blockArray[q].color = Color.RED;
                }

                qNum -= 1;
            }
            
            if(q <= 0)
            {
                iNum -= 1;
                qNum = iNum - 1;
                if(numArray[i] != numArray[indexNum])
                {
                    swapGraphic(indexNum,i);
                    System.out.println("Swap");
                    System.out.println(i);
                    System.out.println(indexNum);
                }
                indexNum = i;
            }
            
            
        }
    }
    
    public void drawSort()
    {
        resetColor(qNum, indexNum);
    }
}
