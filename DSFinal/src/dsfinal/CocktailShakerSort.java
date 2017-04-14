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
public class CocktailShakerSort extends SortingUtils{
    
    protected int iNum;
    protected int iNumTwo;
    protected boolean swappedBol;
    
    public CocktailShakerSort(int[] array, boolean isGraphic)
    {
        super(array, "Cocktail Shaker Sort", isGraphic);
        
        if(isGraphic)
        {
            swappedBol = false;
            iNum = 0;
            iNumTwo = blockArray.length - 2;
        }
    }
    
    public void sort()
    {
        boolean swapped = false;
        do
        {
            swapped = false;
            
            for(int i = 0; i < array.length-2; i++)
            {
                if(array[i] > array[i+1])
                {
                    swap(i, i+1);
                    swapped = true;
                }
            }

            if(!swapped)
            {
                break; //already sorted
            }
            
            swapped = false;
            
            for(int i = array.length - 2; i > 0; i--)
            {
                if(array[i] > array[i+1])
                {
                    swap(i, i+1);
                    swapped = true;
                }
            }
        }
        while(swapped);
        
    }
    
    public void stepSort()
    {
        if(iNum < blockArray.length - 2)
        {
            if(blockArray[iNum].value > blockArray[iNum + 1].value)
            {
                swapGraphic(iNum, iNum + 1);
                swappedBol = true; 
                System.out.println("Swap forward");
            }
            iNum++;
        }
        
        if(iNum >= blockArray.length - 2)
        {
            if(true)
            {
                if(iNumTwo > 0)
                {
                    if(blockArray[iNum].value > blockArray[iNum + 1].value)
                    {
                        swapGraphic(iNum, iNum + 1);
                        swappedBol = true;
                        System.out.println("Swap backward");
                    }
                    iNumTwo--; 
                }
            }
        }
        
        if(iNumTwo <= 0)
        {
            iNum = 0;
            iNumTwo = blockArray.length - 2;
        }
        //System.out.println(toString(numArray));
    }
    
    public void run()
    {
        super.run();
        //System.out.println(super.toString());
    }
}
