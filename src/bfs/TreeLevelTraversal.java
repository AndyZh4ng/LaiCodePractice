package bfs;

import binaryTreeAndBinarySearchTree.TreeNode;

import java.util.*;

public class TreeLevelTraversal {
    public List<List<Integer>> layerByLayer(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                tmp.add(cur.value);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
