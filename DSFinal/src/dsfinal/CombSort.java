/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import java.awt.Color;

/**
 *
 * @author anthnoym
 */
public class CombSort extends SortingUtils
{
    protected int gapNum;
    protected boolean sortedBol;
    protected int iNum;
    final double shrink = 1.3;
    protected boolean finishedLoop;
    protected int qNum;
    protected int numZero;
    
    public CombSort(int[] array, boolean isGraphic)
    {
        super(array, "Comb Sort", isGraphic);
        
        if(isGraphic)
        {
            gapNum = blockArray.length;
            gapNum = (int)(gapNum/shrink);
            sortedBol = false;
            iNum = 0;
            qNum = 0;
            numZero = 0;
            finishedLoop = false;
        }
    }
    
    public void sort()
    {
        int gap = array.length;
        boolean sorted = false;
        
        while(!sorted)
        {
            gap = (int)(gap/shrink);
            if(gap > 1)
            {
                sorted = false;
            }
            else
            {
                gap = 1;
                sorted = true;
            }
            
            for(int i = 0; i + gap < array.length; i++)
            {
                if(array[i] > array[i+gap])
                {
                    swap(i,i+gap);
                    sorted = false;
                }
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
    public void stepSort()
    {       
        if(gapNum > -1)
        {
            for(int i = 0; i < blockArray.length; i++)
            {
                blockArray[i].color = Color.green;
            }
            
            if(iNum + gapNum < blockArray.length)
            {
                blockArray[iNum].color = Color.RED;
                blockArray[iNum+gapNum].color = Color.RED;
                
                if(blockArray[iNum].value > blockArray[iNum+gapNum].value)
                {
                    blockArray[iNum].color = Color.BLUE;
                    blockArray[iNum + gapNum].color = Color.BLUE;
                    swapGraphic(iNum, iNum+gapNum);
                    sortedBol = false;
                }
                iNum++;
            }
            else
            {
                iNum = 0;
                gapNum = (int)(gapNum/shrink);
                
                if(gapNum == 0)
                {
                    gapNum = 1;
                    numZero++;
                }
                if(numZero > 1)
                {
                    gapNum = -1;
                    sortedBol = true;
                }
                
            }
            
            
            
            
        }
        else
        {
            if(qNum < blockArray.length)
            {
                blockArray[qNum].color = Color.ORANGE;
                //blockArray[qNum].isSorted = true;
                qNum++;
                
            }
        }
    }
}
