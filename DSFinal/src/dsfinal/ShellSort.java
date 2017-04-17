package dsfinal;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author anthnoym
 * code help - www.tutorialspoint.com/data_structures/shell_sort_algorithim.html
 */
public class ShellSort extends SortingUtils {
    
    protected int hNum;
    protected int outterNum;
    protected int innerNum;
    protected int vTINum;
    protected int compNum;
    
    
    public ShellSort(int[] array, boolean isGraphic)
    {
        super(array , "Shell Sort", isGraphic);
        
        if(isGraphic)
        {
            hNum = 1;
            while(hNum < numArray.length/3)
            {
                hNum = 3*hNum + 1;
            }
            
            outterNum = hNum;
            vTINum = numArray[outterNum];
            innerNum = outterNum;
            compNum = 0;
        }
    }
    
    public static void main (String [] args)
    {
        int[] tempArray = new int[]{2,8,11,17,1,4,2,12,12,7,17,18,10,2,6,1,3,20,7,16};
        ShellSort ss = new ShellSort(tempArray, false);
        System.out.println(ss.toString(tempArray));
        ss.sort();
        System.out.println(ss.toString(tempArray));
    }
    
    public void sort()
    {
        int h = 1;       
        while(h < array.length/3)
            h = 3*h + 1;
        
        while(h > 0)
        {
            for(int outter = h; outter < array.length; outter++)
            {
                int valueToInsert = array[outter];
                int inner = outter;
                while (inner > h - 1 && array[inner - h] >= valueToInsert)
                {
                    swap(inner,(inner-h));
                    inner = inner - h;
                }
                array[inner] = valueToInsert;
            }
            h = (h-1)/3;
        }
    }
    
    public void run()
    {
        super.run();
    }
    
    public void stepSort()
    {
        if(hNum > 0)
        {
            if(outterNum < numArray.length)
            {     
                
                for(int i = 0; i < blockArray.length; i++)
                {
                    blockArray[i].color = Color.green;
                }
                
                if(innerNum > hNum - 1)
                {
                blockArray[innerNum].color = Color.RED;
                blockArray[innerNum - hNum].color = Color.RED;
                }
                
                if(innerNum > hNum - 1 && numArray[innerNum - hNum] >= vTINum)
                {  
                    blockArray[innerNum].color = Color.BLUE;
                    blockArray[innerNum - hNum].color = Color.BLUE;
                    swapGraphic(innerNum, (innerNum-hNum));
                    innerNum = innerNum - hNum;
                }
                else
                {
                   numArray[innerNum] = vTINum;
                   outterNum++;
                   if(outterNum < numArray.length)
                   {
                        vTINum = numArray[outterNum];
                        innerNum = outterNum;
                   }
                   
                } 
                
            }

            if(outterNum >= numArray.length)
            {
                hNum = (hNum-1)/3;
                outterNum = hNum;
            } 
        }
        else
        {
            //System.out.println(compNum);
            if(compNum == 0)
            {
                for(int i = 0; i < blockArray.length; i++)
                {
                    blockArray[i].color = Color.green;
                }
                blockArray[0].color = Color.RED;
                compNum++;
            }
            else if(compNum >= 1 && compNum < blockArray.length-1)
            {
                //if((blockArray[compNum].value == blockArray[compNum+1].value) || 
                //   (blockArray[compNum].value > blockArray[compNum-1].value 
                //|| blockArray[compNum].value < blockArray[compNum+1].value))
                if((blockArray[compNum].value >= blockArray[compNum-1].value) 
                 & (blockArray[compNum].value <= blockArray[compNum+1].value))
                {
                    blockArray[compNum + 1].color = Color.RED;
                    blockArray[compNum].color = Color.orange;   
                    compNum++;
                }
            }
            
            if(blockArray[1].color == Color.ORANGE)
            {
                blockArray[0].color = Color.ORANGE;
            }
            if(blockArray[blockArray.length-2].color == Color.ORANGE)
            {
                blockArray[blockArray.length -1].color = Color.ORANGE;
            }
        }
    }
    
}
