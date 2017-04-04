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
public class MergeSort extends SortingUtils {
    
    public MergeSort(int[] array)
    {
        super(array, "Merge Sort");
    }
    
    @Override
    public void sort()
    {
        mergeSort(0,array.length-1);
    }
    
    public void mergeSort(int first, int last)
    {
        if(first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(first,middle);
            mergeSort(middle+1,last);
            merge(first,middle,middle+1,last);
        }
    }
    
    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    {
        if(array[rightFirst] > array[leftLast]) return;
        
        while(leftFirst <= leftLast && rightFirst <= rightLast)
        {
            if(array[rightFirst] > array[leftFirst])
            {
                leftFirst++;
            }
            else
            {
                for(int i = rightFirst; i > leftFirst; i--)
                {
                    swap(i,i-1);
                }
                leftFirst++;
                leftLast++;
                rightFirst++;
            }
        }
    }
    
    public void run()
    {
        super.run();
    }
    
}
