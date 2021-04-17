package binaryTreeAndBinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IterativeTreeTraversal {
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pollFirst();
            res.add(tmp.value);
            if(tmp.right != null){
                stack.offerFirst(tmp.right);
            }
            if(tmp.left != null){
                stack.offerFirst(tmp.left);
            }
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while(!stack.isEmpty() || helper != null){
            if(helper != null){
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.pollFirst();
                res.add(helper.value);
                helper = helper.right;
            }
        }
        return res;
    }

    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peekFirst();
            if(pre == null || cur == pre.left || cur == pre.right){
                if(cur.left != null){
                    stack.offerFirst(cur.left);
                } else if(cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(stack.pollFirst().value);
                }
            } else if (pre == cur.left) {
                if(cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(stack.pollFirst().value);
                }
            } else {
                res.add(stack.pollFirst().value);
            }
            pre = cur;
        }
        return res;
    }
}
