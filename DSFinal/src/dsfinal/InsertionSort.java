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
public class InsertionSort extends SortingUtils implements Runnable {
    
    public InsertionSort(int[] array)
    {
        super(array, "Insertion Sort");
    }
    
    @Override
    public void sort()
    {
        for(int i = 0; i < array.length-1; i++)
        {
            for(int q = i+1; q > 0; q--)
            {
                if(array[q] < array[q-1])
                {
                    swap(q-1,q);
                }
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
}
