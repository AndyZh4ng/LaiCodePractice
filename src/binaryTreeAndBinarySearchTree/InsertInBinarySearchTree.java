package binaryTreeAndBinarySearchTree;

public class InsertInBinarySearchTree {
    public TreeNode insert(TreeNode root, int key){
        TreeNode newRoot = root;
        TreeNode newNode = new TreeNode(key);
        TreeNode pre = null;
        while(root != null && root.value != key){
            pre = root;
            root = root.value > key ? root.left : root.right;
        }
        if (pre.value > key){
            pre.left = newNode;
        } else if (pre.value < key) {
            pre.right = newNode;
        }
        return newRoot;
    }
}
