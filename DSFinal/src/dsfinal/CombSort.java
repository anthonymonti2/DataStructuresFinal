/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

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
    
    public CombSort(int[] array, boolean isGraphic)
    {
        super(array, "Comb Sort", isGraphic);
        
        if(isGraphic)
        {
            gapNum = blockArray.length;
            sortedBol = false;
            iNum = 0;
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
        if(sortedBol == false)
        {
            if(iNum == 0)
            {
                gapNum = (int)(gapNum/shrink);
                System.out.println(gapNum);
                if(gapNum > 1)
                {
                    sortedBol = false;
                }
                else
                {
                    gapNum = 1;
                    sortedBol = true;
                }
            }
            
            if(iNum + gapNum < blockArray.length)
            {
                if(blockArray[iNum].value > blockArray[iNum+gapNum].value)
                {
                    swapGraphic(iNum, iNum+gapNum);
                    sortedBol = false;
                    iNum++;
                }
            }
            
            if(iNum + gapNum >= blockArray.length)
            {
                iNum = 0;
            }
        }
    }
}
