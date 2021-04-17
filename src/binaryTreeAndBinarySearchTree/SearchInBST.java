package binaryTreeAndBinarySearchTree;

public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        while(root != null && root.value != key){
            if(root.value > key){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
