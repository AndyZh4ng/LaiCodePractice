package binaryTreeAndBinarySearchTree;

public class DeleteInBST {
    public TreeNode deleteTree(TreeNode root, int key){
        if(root == null){
            return root;
        }
        //step1: dive deep to search for the target node
        if(root.value < key){
            root.right = deleteTree(root.right, key);
            return root;
        } else if (root.value > key){
            root.left = deleteTree(root.left, key);
            return root;
        }

        //step2: at this time, root is the target node. now delete it.
        //case1, 2, 3: the target node either has no child or one child
        if(root.left == null){
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        //case4: neither left nor right child is null, so we need to find the smallest larger node to replace the deleted node.
        //case4.1: the target's right child has no left child, in other words, this right child is the smallest larger.
        if(root.right.left == null){
            root.right.left = root.left;
            return root.right;
        } else {
            TreeNode replacement = findSmallestLarger(root.right);
            replacement.left = root.left;
            replacement.right = root.right;
            return root;
        }
    }
    private TreeNode findSmallestLarger(TreeNode root) {
        TreeNode pre = null;
        while(root.left != null){
            pre = root;
            root = root.left;
        }
        pre.left = root.right;
        return root;
    }
}
