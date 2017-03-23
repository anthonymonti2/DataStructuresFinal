/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

 */
package dsfinal;
import java.util.ArrayList;
/**
 *
 * @author Anthony
 */
public class FinalProjectNB {
    
    final static int MAXNUM = 1000000;
    
    public static void main(String[] args) throws InterruptedException {
        
        int[] toBeSorted = new int[MAXNUM];
        ArrayList<Thread> sorts = new ArrayList<>();
        ArrayList<String> finishedSorts = new ArrayList<>();
        
        System.out.println("Generating random array of " + MAXNUM + " integers");
        for(int i = 0; i < MAXNUM; i++)
        {
            toBeSorted[i] = (int)(Math.random() * MAXNUM);
        }
         System.out.println("Done generating array");
        
        //Create new threads for each sorting alorithm
        //simple sorts
        Runnable selectionRunnable = new SelectionSort(toBeSorted);
        sorts.add(new Thread(selectionRunnable, "Selection Sort"));
        Runnable bubbleRunnable = new BubbleSort(toBeSorted);
        sorts.add(new Thread(bubbleRunnable, "Bubble Sort"));
        Runnable insertionRunnable = new InsertionSort(toBeSorted);
        sorts.add(new Thread(insertionRunnable, "Insertion Sort"));
        
        //Complex sorts
        Runnable mergeRunnable = new MergeSort(toBeSorted);
        sorts.add(new Thread(mergeRunnable, "Merge Sort"));
        Runnable quickRunnable = new QuickSort(toBeSorted);
        sorts.add(new Thread(quickRunnable, "Quick Sort"));
        Runnable heapRunnable = new HeapSort(toBeSorted);
        sorts.add(new Thread(heapRunnable, "Heap Sort"));
        
        System.out.println("\nQuickest Sorts\n");
        
        long startTime = System.nanoTime();
        
        for(Thread t : sorts)
        {
            t.start();
        }

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
