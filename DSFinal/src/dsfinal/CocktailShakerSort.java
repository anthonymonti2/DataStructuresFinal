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
public class CocktailShakerSort extends SortingUtils{
    
    protected int iNum;
    protected int iNumTwo;
    protected boolean swappedBol;
    protected int loops;
    protected boolean running;
    protected boolean sorted;
    
    public CocktailShakerSort(int[] array, boolean isGraphic)
    {
        super(array, "Cocktail Shaker Sort", isGraphic);
        
        if(isGraphic)
        {
            swappedBol = false;
            iNum = 0;
            iNumTwo = blockArray.length - 2;
            loops = 0;
            running = true;
            sorted = false;
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
        if(running)
        {
            if(iNum < blockArray.length - 2)
            {
                for (Block blockArray1 : blockArray) {
                    if (blockArray1.isSorted) {
                        blockArray1.color = Color.ORANGE;
                    } else {
                        blockArray1.color = Color.green;
                    }
                }
                    blockArray[iNum].color = Color.RED;
                    blockArray[iNum + 1].color = Color.RED;

                if(blockArray[iNum].value > blockArray[iNum + 1].value)
                {
                    blockArray[iNum].color = Color.BLUE;
                    blockArray[iNum + 1].color = Color.BLUE;
                    swapGraphic(iNum, iNum + 1);
                    swappedBol = true; 
                    //System.out.println("Swap forward");
                }
                iNum++;
            }
            
            /*
            if(iNum >= blockArray.length -2)
            {
                if(swappedBol == false)
                {
                    running = false;
                }
            }*/
            
            

            if(iNum >= blockArray.length - 2-loops)
            {
                if(iNumTwo <= blockArray.length - 2)
                    swappedBol = false;

                if(iNumTwo > 0)
                {
                    for (Block blockArray1 : blockArray) {
                        if (blockArray1.isSorted) {
                            blockArray1.color = Color.ORANGE;
                        } else {
                            blockArray1.color = Color.green;
                        }
                    }

                    blockArray[iNumTwo].color = Color.RED;
                    blockArray[iNumTwo + 1].color = Color.RED;

                    if(blockArray[iNumTwo].value > blockArray[iNumTwo + 1].value)
                    {
                        blockArray[iNumTwo].color = Color.BLUE;
                        blockArray[iNumTwo + 1].color = Color.BLUE;
                        swapGraphic(iNumTwo, iNumTwo + 1);
                        swappedBol = true;
                    }
                    iNumTwo--; 
                }
            }

            if(iNumTwo <= 0 + loops)
            {
                if(swappedBol == false && iNum <= blockArray.length - 2 - loops && iNumTwo >= 0 + loops)
                {
                    running = false;
                    blockArray[iNum+1].color = Color.YELLOW;
                    blockArray[iNumTwo+2].color = Color.YELLOW;
                }
                
                blockArray[iNum+1-loops].isSorted = true;
                blockArray[iNumTwo].isSorted = true;  

                iNum = loops;
                iNumTwo = blockArray.length - 2 - loops;  
                loops++;
                
                
                swappedBol = false;
            }
        }
        else
        {
            //System.out.println("Already sorted");
        }
    }
    public void run()
    {
        super.run();
        //System.out.println(super.toString());
    }
}
