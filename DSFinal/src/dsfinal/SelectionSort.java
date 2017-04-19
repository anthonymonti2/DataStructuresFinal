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
        
        if(isGraphic)
        {
            iNum = numArray.length-1;
            qNum = iNum - 1;
            indexNum = iNum;
        }
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
    
    public void stepSort()
    {
        if(iNum>0){
            blockArray[iNum].color=Color.GRAY;
            if(qNum >= 0){
                if(numArray[qNum] > numArray[indexNum]){
                    blockArray[indexNum].color=(indexNum==iNum)?Color.GRAY: Color.GREEN;
                    indexNum=qNum;         
                    blockArray[indexNum].color=Color.BLUE;
                }
                else{
                    blockArray[qNum].color=Color.GREEN;
                }
            } 

            qNum--;
            if(qNum < 0){
                if(numArray[iNum] != numArray[indexNum]){
                    swapGraphic(iNum, indexNum);
                }
                blockArray[iNum].isSorted = true;
                iNum--;
                qNum=iNum-1;
                indexNum=iNum;
                for(int i=0; i<blockArray.length; i++){
                    if(blockArray[i].isSorted == true)
                    {
                        blockArray[i].color=Color.ORANGE;
                    }
                    else
                    {
                        blockArray[i].color=Color.GREEN;
                    }
                }
            }
            if(qNum!=-1)
                blockArray[qNum].color=Color.RED;
        }
        
        if(iNum == 0)
        {
            blockArray[0].isSorted = true;
            blockArray[0].color=Color.ORANGE;
        }
    }
}
