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
public class HeapSort extends SortingUtils implements  Runnable{
    
    public HeapSort(int[] array)
    {
        super(array, "Heap Sort");
    }
    
    @Override
    public void sort()  // ascending
    {
        for(int i = array.length/2-1; i >= 0; i--)
        {
            reheapDown(array[i],i,array.length-1);
        }
        
        for(int i = array.length -1; i>= 0; i--)
        {
            swap(0,i);
            if(i < 4 && isSorted()) return;
            reheapDown(array[0],0,i-1);
        }
    }
    
    private boolean isSorted()
    {
        for(int i = 4; i > 0; i--)
        {
            if(array[i] < array[i-1])
            {
                return false;
            }
        }
        return true;
    }
    
    private void reheapDown(int item, int root, int lastIndex)
    {
        int hole = root;    // current index of hole
        int newhole;        // index where the hole should move to

        newhole = newHole(hole, lastIndex, item);       // find next hole
        while(newhole != hole)
        {
            swap(hole, newhole);                        // move element up
            hole = newhole;                             // move hole down
            newhole = newHole(hole, lastIndex, item);   // find next hole
        }
        array[hole] = item;                             // fill in the final hole
    }

    // if either child of hole is larger than element, return the index
    // of the larger child; otherwise, return the index of the hole.
    private int newHole(int hole, int lastIndex, int item)
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if(left > lastIndex)            // hole has no children
            return hole;
        else if(left == lastIndex)      // hole has left child only
            if(item < array[left]) // item < left child
                return left;
            else                        // item >= left child
                return hole;
            else                        // hole has two children
            if(array[left] < array[right])   // left child < right child
                if(array[right] <= item)         // right child <= item
                    return hole;
                else                    // item < right child
                    return right;
                else                    // left child >= right child
                if(array[left] <= item)         // left child <= item
                    return hole;
                else                    // item < left child
                    return left;
    }
    
    public void run()
    {
        super.run();
    }
    
}
