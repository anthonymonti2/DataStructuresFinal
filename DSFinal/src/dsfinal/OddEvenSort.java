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
public class OddEvenSort extends SortingUtils {
    
    public OddEvenSort(int[] array, boolean isGraphic)
    {
        super(array, "Odd-Even Sort", isGraphic);
    }
    
    public void sort()
    {
        boolean sorted = false;
        
        while(!sorted)
        {
            sorted = true;
            for(int i = 1; i < array.length - 1; i += 2)
            {
                if(array[i] > array[i+1])
                {
                    swap(i,i+1);
                    sorted = false;
                }
            }
            
            for(int i = 0; i < array.length - 1; i +=2)
            {
               if(array[i] > array[i+1])
                {
                    swap(i,i+1);
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
        
    }
    
}
