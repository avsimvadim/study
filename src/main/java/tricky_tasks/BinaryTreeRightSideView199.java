package tricky_tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.right = new TreeNode2(5);
        root.right.right = new TreeNode2(4);
        //[1,2,3,null,5,null,4]
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode2 root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode2> q1 = new LinkedList<>();
        Queue<TreeNode2> q2 = new LinkedList<>();
        q1.add(root);
        list.add(root.val);

        while(!q1.isEmpty()){
            while(!q1.isEmpty()){
                TreeNode2 node = q1.poll();

                if(node.right != null){
                    q2.add(node.right);
                }
                if(node.left != null){
                    q2.add(node.left);
                }
            }
            if(q2.peek() != null){
                list.add(q2.peek().val);
            }

            q1 = new LinkedList<>(q2);
            q2 = new LinkedList<>();
        }

        return list;
    }
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}
