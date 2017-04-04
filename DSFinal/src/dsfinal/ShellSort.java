package dsfinal;

/**
 *
 * @author anthnoym
 * code help - www.tutorialspoint.com/data_structures/shell_sort_algorithim.html
 */
public class ShellSort extends SortingUtils {
    
    public ShellSort(int[] array, String name)
    {
        super(array , "Shell Sort");
    }
    
    public void sort()
    {
        
        int h = 1;
        
        while(h < array.length/3)
        {
            h = 3*h + 1;
        }
        
        while(h > 0)
        {
            for(int outter = h; outter < array.length; outter++)
            {
                int valueToInsert = array[outter];
                int inner = outter;

                while (inner > h - 1 && array[inner - h] >= valueToInsert)
                {
                    swap(inner,(inner-h));
                    inner = inner - h;
                }
                
                array[inner] = valueToInsert;
            }
            
            h = (h-1)/3;
        }
    }
    
    public void run()
    {
        super.run();
    }
    
    
    
}
