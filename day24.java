// lowest common ancestor (LCA) of the tree
import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data= data;
    }
}

public class day24 {
    // build tree from the array (level-order)
    public static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node node = q.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                node.left = new Node(arr[i]);
                q.add(node.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                node.right = new Node(arr[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    // finding node by value
     public static Node findNode(Node root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;
        Node left = findNode(root.left, val);
        return (left != null) ? left : findNode(root.right, val);
    }

    // finding lca
    public Node lowestCommonAncestor(Node root, Node p, Node q){
        // base case 
        if(root == null || root==p || root==q){
            return root;
        }

        // find on left and right
        Node left= lowestCommonAncestor(root.left, p, q);
        Node right= lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return(left!=null)? left: right;
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

        Node root= buildTree(arr);

        // input p and q
        System.out.println("enter p:");
        int pVal= sc.nextInt();

        System.out.println("enter q:");
        int qVal= sc.nextInt();

        day24 obj= new day24();

        Node p= findNode(root, pVal);
        Node q= findNode(root, qVal);

        Node lca= obj.lowestCommonAncestor(root, p, q);
        if(lca != null){
            System.out.println("LCA: "+ lca.data);
        } else{
            System.out.println("one or both nodes not found...");
        }

        sc.close();
    }
}
