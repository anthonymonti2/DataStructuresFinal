/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsfinal;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author anthnoym
 */
public class RadixSort extends SortingUtils {
    
    private int digits = 0;
    
    public RadixSort(int[] array, int numDigits)
    {
        super(array, "Radix Sort");
        digits = numDigits;
    }
   
    public void sort()
    {
        sort(array, digits);
    }
    
    public void run()
    {
        super.run();
    }
    
    public static void main(String[] args)
    {
        int[] temp = {5,78,4,5,6,8,23,45,67,56,11};
        
        System.out.println("4,5,5,6,8,11,23,45,56,67,78");
        for(int num : sort(temp,2))
        {
            System.out.print(num + ",");
        }
    }
    
    //additional methods required to run
    /**
     * 
     * @param number
     * @param k
     * @return the digit of a number at k. if not 0
     */
    private static int getDigit(int number, int numDig)
    {
        if(numDig > number)
        {
            return 0;
        }

        number = (int)(number / Math.pow(10,numDig));
        
        return number%10;
    }
    
    private static Queue[] itemsToQueue(int[] nums, int numDig)
    {
        Queue<Integer>[] storageQueue = new Queue[10];
        
        for(int i = 0; i < storageQueue.length; i++)
        {
            storageQueue[i] = new LinkedList<Integer>();
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            int digit = getDigit(nums[i],numDig);
            storageQueue[digit].add(nums[i]); 
        }
        
        return storageQueue;
    }
    
    private static int[] queuesToArray(Queue<Integer>[] ques, int numVals)
    {
        int[] temp = new int[numVals];
        int counter = 0;
        
        for(int i = 0; i < ques.length; i++)
        {
            while(ques[i].isEmpty() == false)
            {
                temp[counter] = ques[i].remove();
                counter += 1;
            }
        }
        
        return temp;
    }
    
    private static int[] sort(int[] nums,int numDigits)
    {
        int length = nums.length;
        
        for(int i = 0; i < numDigits; i++)
        {
            nums = queuesToArray(itemsToQueue(nums,i), length);
        }
        
        return nums;
    }
}
