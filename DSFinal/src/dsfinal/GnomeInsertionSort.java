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
public class GnomeInsertionSort extends SortingUtils {
    
    public GnomeInsertionSort(int[] array, boolean isGraphic)
    {
        super(array, "Gnome Insertion Sort",isGraphic);
    }
    
    public void sort()
    {
        for(int i = 1; i < array.length; i++)
        {
            sortHelper(array, i);
        }
    }
    
    private void sortHelper(int[] num, int upperBound)
    {
        int pos = upperBound;
        
        while(pos > 0 && array[pos-1] > array[pos])
        {
            swap(pos-1,pos);
            pos -= 1;
        }
    }
    
    public void run()
    {
        super.run();
        //System.out.println(super.toString());
    }
    
    public void stepSort()
    {
        
    }
    
}
