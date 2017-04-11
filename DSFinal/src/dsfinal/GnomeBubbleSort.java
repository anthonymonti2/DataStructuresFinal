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
public class GnomeBubbleSort extends SortingUtils {
    
    public GnomeBubbleSort(int[] array)
    {
        super(array, "Gnome Bubble Sort");
    }
    
    public void sort()
    {
        int pos = 0;
        
        while(pos < array.length)
        {
            if(pos == 0 || array[pos] >= array[pos - 1])
            {
                pos += 1;
            }
            else
            {
                swap(pos,pos-1);
                pos -= 1;
            }
        }
    }
    
    public void run()
    {
        super.run();
        //System.out.println(super.toString());
    }
    
}
