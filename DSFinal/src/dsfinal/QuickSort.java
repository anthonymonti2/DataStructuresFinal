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
public class QuickSort extends SortingUtils implements Runnable {
    
    public QuickSort(int[] array)
    {
        super(array, "Quick Sort");
    }
    
    @Override
    public void sort()
    {
        quickSort(0,array.length-1);
    }
    
    private void quickSort(int first, int last)
    {
        if(first < last)
        {
            int splitPoint = split(first,last);
            quickSort(first,splitPoint-1);
            quickSort(splitPoint+1,last);
        }
    }
    
    public int split(int first, int last)
    {
        int splitVal = array[first];
        int saveFirst = first;
        first++;
        while(first <= last)
        {
            boolean onCorrectSide = true;
            while(onCorrectSide)
            {
                if(array[first] > splitVal)
                {
                    onCorrectSide = false;
                }
                else
                {
                    first++;
                    onCorrectSide = first <= last;
                }
            }
            onCorrectSide = first <= last;
            
            while(onCorrectSide)
            {
                if(array[last] <= splitVal)
                {
                    onCorrectSide = false;
                }
                else
                {
                    last--;
                    onCorrectSide = first <= last;
                }
            }
            
            if(first < last)
            {
                swap(first,last);
                first++;
                last--;
            }
        }
        
        if(saveFirst != last)
        {
            swap(saveFirst,last);
        }
        
        return last;
    }
    
    public void run()
    {
        super.run();
    }
}
