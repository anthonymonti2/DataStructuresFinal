/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

Do To
counting sort
comb sort
bucket sort
radix sort
odd even sort
gnome sort
cocktail shaker sort
smooth sort
intro sort

done
shell sort

 */
package dsfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Anthony
 */
public class FinalProjectNB {
    
    final static String[] sortOptions = {"","Bubble","Comb", "Heap","Insertion","Merge","Quick","Selection","Shell"};
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Thread> sorts = new ArrayList<>();

        System.out.println("Please enter the number of integers you want to sort");
        System.out.println("Large number (> 100,000) take a long time. Be aware");
        int MAXNUM = sc.nextInt();
        
        System.out.println("What type of array would you like to sort");
        System.out.println("1.)Random\n2.)Almost Sorted\n3.)Backwards\n4.)Few Unique\n");
        int arrayType = sc.nextInt();
        
        int[] toBeSorted = generateArray(arrayType,MAXNUM);
        
        System.out.println("\nWhich sorts would you like to compare times for?");
        System.out.println(createListString(sortOptions));
        System.out.println("If your number of ints to be sorted if very large (> 100,000)\n"
                          +"selecting more than 4 sorts will cause massive slow downs\n"
                          +"but will still work. Be aware");
        System.out.println("Enter each number with a comma between the numbers");
        
        sc.nextLine(); //reset scanner
        
        StringTokenizer st = new StringTokenizer(sc.nextLine(),",");
        
        while(st.hasMoreElements())
        {
            try
            {
                int num = Integer.valueOf(st.nextToken());
                getSort(num,sorts,toBeSorted);
            }
            catch(Exception e){}
        }

        System.out.println("\nQuickest Sorts\n");
        
        long startTime = System.nanoTime();
        
        sorts.forEach((t) -> {
            t.start();
        });
        
        while(!sorts.isEmpty())
        {
            for(int i = 0; i < sorts.size();i++)
            {
                if(!sorts.get(i).isAlive())
                {
                    sorts.remove(i);
                }
            }
        }
        
        System.out.println("\nDone sorting all");
        long stopTime = System.nanoTime();
        
        System.out.println("Elapsed time in seconds : " + (stopTime - startTime) / Math.pow(10,9));
    }
    
    public static String printArray(int [] array)
    {
        String str = "";
        for(int temp : array)
        {
            str += temp + " , ";
        }
        return str;
    }
    
    public static void getSort(int toFind, ArrayList<Thread> arrayList, int[] toBeSorted)
    {
        if(indexOf(sortOptions,"Selection") == toFind)
        {
            Runnable selectionRunnable = new SelectionSort(toBeSorted);
            arrayList.add(new Thread(selectionRunnable, "Selection Sort"));  
        }
        else if(indexOf(sortOptions, "Bubble") == toFind)
        {
            Runnable bubbleRunnable = new BubbleSort(toBeSorted);
            arrayList.add(new Thread(bubbleRunnable, "Bubble Sort"));
        }
        else if(indexOf(sortOptions, "Insertion") == toFind)
        {
            Runnable insertionRunnable = new InsertionSort(toBeSorted);
            arrayList.add(new Thread(insertionRunnable, "Insertion Sort"));
        }
        else if(indexOf(sortOptions, "Shell") == toFind)
        {
            Runnable shellRunnable = new ShellSort(toBeSorted);
            arrayList.add(new Thread(shellRunnable, "Shell Sort"));
        }
        else if(indexOf(sortOptions, "Merge") == toFind)
        {
            Runnable mergeRunnable = new MergeSort(toBeSorted);
            arrayList.add(new Thread(mergeRunnable, "Merge Sort"));
        }
        else if(indexOf(sortOptions, "Quick") == toFind)
        {
            Runnable quickRunnable = new QuickSort(toBeSorted);
            arrayList.add(new Thread(quickRunnable, "Quick Sort"));
        }
        else if(indexOf(sortOptions, "Heap") == toFind)
        {    
            Runnable heapRunnable = new HeapSort(toBeSorted);
            arrayList.add(new Thread(heapRunnable, "Heap Sort"));
        }
        else if(indexOf(sortOptions, "Comb") == toFind)
        {
           Runnable combRunnable = new CombSort(toBeSorted);
            arrayList.add(new Thread(combRunnable, "Comb Sort")); 
        }
        
    }
    
    public static String createListString(String[] array)
    {
        String str = "";
        for(int i = 1; i < array.length; i++)
        {
            str += i + ".)" + array[i] + " ";
            if(i % 1 == 0)
            {
                str += "\n";
            }
        }
        
        return str;
    }
    
    public static int[] generateArray(int type, int max)
    {
        int[] tBSort = new int[max];
        switch(type)
        {
            case 1: 
                //random
                System.out.println("\nGenerating random array of " + max + " integers");
                for(int i = 0; i < max; i++)
                {
                    tBSort[i] = (int)(Math.random() * max);
                }
                break;
            case 2:
                //backwards
                System.out.println("\nGenerating backwards array of " + max + " integers");
                for(int i = 0; i < max; i++)
                {
                    tBSort[max-i] = i;
                }
                break;
            case 3:
                //almost sorted
                System.out.println("\nGenerating almost sorted array of " + max + " integers");
                for(int i = 0; i < (double)(max * .75) ; i++)
                {
                    tBSort[i] = i;
                }
                for(int i = 0; i < max/4; i++)
                {
                    tBSort[i] = (int)(Math.random() * max);
                }
                break;
            case 4:
                //few unique
                for(int i = 0; i < 5; i++)
                {
                    for(int q = 0; q < max/5; q++)
                    {
                        //doesn't work yet...
                    }
                }
                break;
        }
        
        return tBSort;
    }
    
    public static int indexOf(String[] array, String item)
    {
        for(int i = 1; i < array.length;i++)
        {
            if(array[i].compareTo(item) == 0)
            {
                return i;
            }
        }
        return -1;
    }
}