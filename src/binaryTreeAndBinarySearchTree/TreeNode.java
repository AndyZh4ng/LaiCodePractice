package binaryTreeAndBinarySearchTree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TreeNode implements Comparable<TreeNode>{
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode target) {
        if(this.value == target.value){
            return 0;
        }
        return this.value < target.value ? -1 : 1;
    }
}
