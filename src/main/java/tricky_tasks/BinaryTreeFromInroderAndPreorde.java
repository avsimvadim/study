package tricky_tasks;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInroderAndPreorde {
    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;

    public TreeNode2 buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        // Build a map to quickly find the root in the inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode2 buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        // Base case: If there are no elements to construct the tree
        if (inorderStart > inorderEnd) {
            return null;
        }

        // Get the current root from the preorder traversal
        int rootValue = preorder[preorderIndex++];
        TreeNode2 root = new TreeNode2(rootValue);

        // Get the index of the root in the inorder traversal
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Print debug information
        System.out.println("Root: " + rootValue + ", Inorder Index: " + inorderIndex);
        System.out.println("Building left subtree for root " + rootValue + " with inorder range " + inorderStart + " to " + (inorderIndex - 1));
        System.out.println("Building right subtree for root " + rootValue + " with inorder range " + (inorderIndex + 1) + " to " + inorderEnd);

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, inorderStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInroderAndPreorde solution = new BinaryTreeFromInroderAndPreorde();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode2 root = solution.buildTree(preorder, inorder);
        printTree(root); // Custom method to print tree structure
    }

    private static void printTree(TreeNode2 node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode(int x) {
        val = x;
    }
}
