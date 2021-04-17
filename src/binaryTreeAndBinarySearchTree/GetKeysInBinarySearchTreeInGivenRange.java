package binaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, min, max);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int min, int max){
        if(root == null) {
            return;
        }
        if(root.value > min){
            helper(root.left, res, min, max);
        }
        if(root.value >= min && root.value <= max){
            res.add(root.value);
        }
        if (root.value < max){
            helper(root.right, res, min, max);
        }
    }
}
