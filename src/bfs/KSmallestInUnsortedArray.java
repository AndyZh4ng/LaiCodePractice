package bfs;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k){
        int[] res = new int[k];
        if(k == 0){//make sure k != 0, since
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        //step1: fill the maxheap
        for(int i = 0; i < k; i++){
            maxHeap.offer(array[i]);
        }
        //step2: iterate over the array,compare each element to the top of the maxHeap
        for(int i = k; i < array.length; i++){
            if(array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        //step3: move all elements from maxHeap to the resulting array
        for(int i = k - 1; i >= 0; i--){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
