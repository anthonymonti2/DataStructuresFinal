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
    
    @Override
    public void drawSort(Graphics g)
    {
        delay = 5 * (int)(Math.pow(10,8)); //set the delay between updates
        
        blockArray = new Block[30];
        //numDisplayArray = new Rectangle[rectArray.length];
        int[] numArray = genRandom(blockArray.length);
        
        //Create array of rectangle with a height based on their location in array
        for(int i = 0; i < blockArray.length; i++)
        {
            blockArray[i] = new Block(30 *i + 50, height - 100, 25,  -1 * numArray[i]*15, Color.BLUE);
            //numDisplayArray[i] = new Rectangle(30 *i + 50, height - 75, 25,  -1 * 30);
        }
        
        //Show initial array
        for(int i = 0; i < blockArray.length; i++)
        {
            drawBlock(g,blockArray[i]);
            g.drawString(addZero(numArray[i]), blockArray[i].x+ 6, blockArray[i].y + 20);
            long oldTime = System.nanoTime();
            while(oldTime + delay > System.nanoTime())
            {
                //do nothing
                //kill time
            }
        }
        
        for(int i = 0; i < blockArray.length; i++)
        {
            //blockArray[i].color = Color.RED;
            drawBlock(g,blockArray[i]);
            g.drawString(addZero(numArray[i]), blockArray[i].x+ 6, blockArray[i].y + 20);
           
        }
        
        /*
        //Modified sort from above
        for(int i = numArray.length-1; i > 0 ; i--)
        {
            int index = i;
            //color current block
            blockArray[i].color = Color.RED;
            drawBlock(g, blockArray[i]);
            for(int q = i-1; q >= 0 ; q--)
            {
                //color changing block
                blockArray[q].color = Color.RED;
                drawBlock(g, blockArray[q]);
                
                if(numArray[q] > numArray[index])
                {
                    index = q;
                }
                else
                {                 
                blockArray[q].color = Color.BLUE;
                drawBlock(g, blockArray[q]);
                }
                
                Thread.sleep(1000);
            }
            
            if(numArray[i] != numArray[index])
            {
                swap(index,i);
                blockArray[index].color = Color.BLUE;
                blockArray[i].color = Color.BLUE;
            }
        }*/
    }
}
