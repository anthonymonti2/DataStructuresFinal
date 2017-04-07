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
public class CocktailShakerSort extends SortingUtils{
    
    public CocktailShakerSort(int[] array)
    {
        super(array, "Cocktail Shaker Sort");
    }
    
    public void sort()
    {
        boolean swapped = false;
        do
        {
            swapped = false;
            
            for(int i = 0; i < array.length-2; i++)
            {
                if(array[i] > array[i+1])
                {
                    swap(i, i+1);
                    swapped = true;
                }
            }

            if(!swapped)
            {
                break; //already sorted
            }
            
            swapped = false;
            
            for(int i = array.length - 2; i > 0; i--)
            {
                if(array[i] > array[i+1])
                {
                    swap(i, i+1);
                    swapped = true;
                }
            }
        }
        while(swapped);
        
    }
    
    public void run()
    {
        super.run();
        //System.out.println(super.toString());
    }
}
