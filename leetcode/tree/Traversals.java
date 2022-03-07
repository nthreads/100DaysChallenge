
import java.util.LinkedList;
import java.util.Queue;

/*
                1
              /   \
            2       3
          /   \
        4       5              

 1. Depth First Traversals: 
    (a) Inorder (Left, Root, Right) : 4 2 5 1 3
    (b) Preorder (Root, Left, Right) : 1 2 4 5 3 (DFS)
    (c) Postorder (Left, Right, Root) : 4 5 2 3 1 

 2. Breadth First or Level Order Traversal : 1 2 3 4 5

 3. Height of tree is edges count from root to the leaf : 2
*/
public class Traversals {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.right = new Node(9);

        System.out.print("\nHeight =>");

        System.out.println("Height = " + findHeight(root));

        System.out.print("\nPre Order =>");
        preOrderTraversal(root);
        System.out.print("\nIn Order =>");
        inOrderTraversal(root);
        System.out.print("\nPost order =>");
        postOrderTraversal(root);
        System.out.print("\nLevel Order =>");
        levelOrderTraversal(root);

        System.out.println("\n - Output should be 1 2 4 9");
        printOnlyLeftNodes(root);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        }

        if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static int findHeight(Node root) {
        int h = 0;
        if(root == null) return h;
        
        if(root.left != null)
            h = 1 + findHeight(root.left);
        
        if(root.right != null)
            h = 1 + findHeight(root.right);
        
        return h;        
    }

    public static void preOrderTraversal(Node node) {

        if(node == null) return;

        // Visit the root node
        System.out.print(node.data + " ");

        // Visit the left nodes
        preOrderTraversal(node.left);

        // Visit the right nodes
        preOrderTraversal(node.right);


        
    }

    public static void inOrderTraversalWithoutRecursion(Node node) {

    }
    
    public static void inOrderTraversal(Node node) {
        if(node == null) return;
        
        //Traverse left sub tree
        inOrderTraversal(node.left);

        //Visit the root node
        System.out.print(node.data + " "); 

        //Traverse right sub tree
        inOrderTraversal(node.right);
    }
    
    public static void postOrderTraversal(Node node) {
        if(node == null) return;
        
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);

        System.out.print(node.data + " ");

    }

    public static void levelOrderTraversal(Node node) {
        if(node == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){

            // Dequeue 
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            //Enqueue left child
            if(temp.left != null) queue.add(temp.left);

            //Enqueue right child
            if(temp.right != null) queue.add(temp.right);
        }
    }

    public static void printOnlyLeftNodes(Node node) {

        if(node == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                Node temp = queue.poll();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                if(i==size-1) System.out.print(temp.data + " ");        
            }
            
        }
        
    }
}

class Node {
    int data;

    Node left;
    Node right;
    

    public Node() {}

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;        
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }    
}
