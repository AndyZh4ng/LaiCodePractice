package binaryTreeAndBinarySearchTree;

public class IsBST {
    public boolean isBST(TreeNode root){
        if(root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int left, int right){
        if(root == null){
            return true;
        } else if(root.value <= left || root.value >= right) {//dont forget the equal condition!
            return false;
        }
        return helper(root.left, left, root.value) && helper(root.right, root.value, right);
    }
}
