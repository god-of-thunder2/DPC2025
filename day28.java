import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class day28 {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // helper to compare mirrors
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) 
            && isMirror(t1.left, t2.right) 
            && isMirror(t1.right, t2.left);
    }

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

    public static void main(String[] args) {
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
        day28 obj = new day28();

        boolean result = obj.isSymmetric(root);
        System.out.println("is the tree symmetric? " + result);
        sc.close();
    }
}
