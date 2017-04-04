/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

 */
package dsfinal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Anthony
 */
public class FinalProjectNB {
    
    public static void main(String[] args) throws InterruptedException {
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Thread> sorts = new ArrayList<>();
        ArrayList<String> finishedSorts = new ArrayList<>();
        
        System.out.println("Please enter the number of integers you want to sort");
        int MAXNUM = sc.nextInt();
        int[] toBeSorted = new int[MAXNUM];
        
        System.out.println("Ready?");
        
        
        System.out.println("\nGenerating random array of " + MAXNUM + " integers");
        for(int i = 0; i < MAXNUM; i++)
        {
            toBeSorted[i] = (int)(Math.random() * MAXNUM);
        }
         System.out.println("Done generating array");

        //Create new threads for each sorting alorithm
        //simple sorts
        //Runnable selectionRunnable = new SelectionSort(toBeSorted);
        //sorts.add(new Thread(selectionRunnable, "Selection Sort"));
        //Runnable bubbleRunnable = new BubbleSort(toBeSorted);
        //sorts.add(new Thread(bubbleRunnable, "Bubble Sort"));
        //Runnable insertionRunnable = new InsertionSort(toBeSorted);
        //sorts.add(new Thread(insertionRunnable, "Insertion Sort"));
        Runnable shellRunnable = new ShellSort(toBeSorted, "Shell Sort");
        sorts.add(new Thread(shellRunnable, "Shell Sort"));
        
        
        //Complex sorts
        //Runnable mergeRunnable = new MergeSort(toBeSorted);
        //sorts.add(new Thread(mergeRunnable, "Merge Sort"));
        //Runnable quickRunnable = new QuickSort(toBeSorted);
        //sorts.add(new Thread(quickRunnable, "Quick Sort"));
        //Runnable heapRunnable = new HeapSort(toBeSorted);
        //sorts.add(new Thread(heapRunnable, "Heap Sort"));
        
        System.out.println("\nQuickest Sorts\n");
        
        long startTime = System.nanoTime();
        
        sorts.forEach((t) -> {
            t.start();
        });

        //int count = 1;
        
        while(!sorts.isEmpty())
        {
            for(int i = 0; i < sorts.size();i++)
            {
                if(!sorts.get(i).isAlive())
                {
                    //finishedSorts.add(sorts.get(i).getName() + " , " + (System.nanoTime() - startTime) / Math.pow(10,9));
                    //System.out.println(count + "). " + sorts.get(i).getName() + " : " + (System.nanoTime() - startTime) / Math.pow(10,9));
                    sorts.remove(i);
                    //count++;
                }
            }
        }
        
        System.out.println("\nDone sorting all");
        long stopTime = System.nanoTime();
        //System.out.println("Elapsed time in seconds : " + (stopTime - startTime));
        
        
        
        //for(String str : finishedSorts)
        //{
        //    System.out.println(str);
        //}
        System.out.println("Elapsed time in seconds : " + (stopTime - startTime) / Math.pow(10,9));
        //t1.join();
        //t1.setName("SelectionSort");
        //System.out.println(t1.getName());
        
        //System.out.println(selectionRunnable.toString());
        
        
        
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
    
}
