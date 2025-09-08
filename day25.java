import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class day25 {
    Integer prev = null;

    // build tree from the array (level-order)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                q.add(node.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root == null)
            return true;

        if (!inorder(root.left)) {
            return false;
        }

        if (prev != null && root.val <= prev)
            return false;
        prev = root.val;

        return inorder(root.right);
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter size of array:");
        int n= sc.nextInt();
        Integer arr[]= new Integer[n];

        System.out.println("enter the array elems- (use -1 for null)");
        for(int i=0; i<n; i++){
            int val= sc.nextInt();
            if(val==-1){
                arr[i]= null;
            } else{
                arr[i]= val;
            }
        }

        TreeNode root= buildTree(arr);

        day25 obj= new day25();
        System.out.println("is given is bst: "+ obj.isValidBST(root));
        sc.close();
    }
}