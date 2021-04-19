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
    //recursion
    public TreeNode insertRecursion(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }

        if(root.value > key) {
            root.left = insertRecursion(root.left, key);
        } else if(root.value < key){
            root.right = insertRecursion(root.right, key);
        }
        return root;
    }
}
