package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] input) {//assume the input array does not include 0 element;
        this.array = array;
        heapify();
        size = input.length;
    }

    private void heapify(){
        for(int i = size / 2 - 1; i >= 0; i--){
            percolateDown(i);
        }
    }

    private void percolateDown(int index){
        while(index <= size / 2 - 1){
            int left = index * 2 + 1;
            int right = index * 2 + 2 < size - 1 ? index * 2 + 2 : left;
            int candidate = 0;
            candidate = array[left] <= array[right] ? left : right;
            if(array[index] > array[candidate]){
                swap(index, candidate);
                index = candidate;
            } else {
                break;
            }
        }
    }

    private void percolateUp(int index) {
        while((index - 1) / 2 >= 0){
            int parent = (index - 1) / 2;
            if(array[index] < array[parent]){
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public int peek(){
        if(size == 0){
            throw new NoSuchElementException("The heap is empty!");
        }
        return array[0];
    }

    public void offer(int input){
        if(size == array.length){
            resize();
        }
        array[size] = input;
        size++;
        percolateUp(size - 1);
    }

    public int poll() throws Exception{
        if(size == 0){
            throw new NoSuchElementException("The heap is empty!");
        }
        int tmp = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return tmp;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int update(int index, int input){
        if(index >= size){
            throw new IndexOutOfBoundsException("The input index is not valid!");
        }
        int tmp = array[index];
        array[index] = input;
        if (input > tmp) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return tmp;
    }

    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void resize(){
        int[] newArray = Arrays.copyOf(array, (int) (array.length * 1.5));
        array = newArray;
    }
}
