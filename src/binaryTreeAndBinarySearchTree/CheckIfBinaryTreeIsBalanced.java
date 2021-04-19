package binaryTreeAndBinarySearchTree;

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        return helper(root) == -1 ? false : true;
    }

    private int helper(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        if(leftH == -1 || rightH == -1){
            return -1;
        } else if(Math.abs(leftH - rightH) > 1){
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
}
