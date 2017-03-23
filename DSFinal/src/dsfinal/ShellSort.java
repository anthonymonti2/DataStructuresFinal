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
public class ShellSort<T> extends SortingUtils<T> {
    
    public ShellSort(T[] array, String name)
    {
        super(array , "Shell Sort");
    }
    
    public void sort()
    {
        
        int h = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            h = h * 3 + 1;
        }
        
        while(h > 0)
        {
            for(int outter = h; outter < array.length; outter++)
            {
                T valueToInsert = array[outter];
                int inner = outter;

                //while (inner > interval - 1 && array[inner - interval] >= valueToInsert)
                //{

                //}
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
    
    
}
