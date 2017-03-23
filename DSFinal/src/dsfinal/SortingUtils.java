/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

/**
 *
 * @author Anthony
 */
public abstract class SortingUtils {
    protected int[] array;
    protected long swaps;
    private long startTime;
    private long endTime;
    private String sortName;

    public SortingUtils(int[] a, String sortName)
    {
        array = a;
        this.sortName = sortName;
    }
    
    public synchronized void swap(int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        swaps++;
    }
    
    public abstract void sort();
    
    public synchronized void run()
    {
        startTime = System.nanoTime();
        sort();
        endTime = System.nanoTime();
        System.out.println(sortName + " : " + (System.nanoTime() - startTime) / Math.pow(10,9) + " , Number of swaps : " + swaps);
    }
    
    public String toString()
    {
        String str = "";
        for(int temp : array)
        {
            str += temp + " , ";
        }
        str += "\nNumber of swaps = " + swaps;
        return str;
    }
    
}
