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
    public CombSort(int[] array)
    {
        super(array, "Comb Sort");
    }
    
    public void sort()
    {
        int gap = array.length;
        double shrink = 1.3;
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
}
