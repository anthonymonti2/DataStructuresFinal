/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

/**
 *
 * @author Anthony
 */
public class BubbleSort extends SortingUtils implements Runnable {
    
    public BubbleSort(int[] array)
    {
        super(array,"Bubble Sort");
    }
    
    @Override 
    public void sort()
    {
        for(int i = 0; i < array.length; i++) //go through every element
        {
            for(int q = 0; q < array.length-1; q++) //go through remaining elements
            {
                if(array[q] > array[q+1])
                {
                    swap(q, q+1);
                }
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
}
