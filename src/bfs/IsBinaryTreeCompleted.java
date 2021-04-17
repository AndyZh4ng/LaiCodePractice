package bfs;

import binaryTreeAndBinarySearchTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsBinaryTreeCompleted {
    public boolean isCompleted(TreeNode root){
        if(root == null) {
            return true;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                if(!flag){
                    q.offer(cur.left);
                } else {
                    return false;
                }
            } else {
                flag = true;
            }

            if(cur.right != null){
                if(!flag){
                    q.offer(cur.right);
                } else {
                    return false;
                }
            } else {
                flag = true;
            }
        }
        return true;
    }
}
