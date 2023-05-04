package WhiteBoarding_w8;

// Given the following BinaryNodeTree class:
//     -perform a level order traversal (queue) 
//     -iterative preorder traversal (stack)

// public class BinaryNodeTree {
//     class Node {
//         int data;
//         Node left, right;

//         public Node(int data) {
//             this.data = data;
//             left = right = null;
//         }
//     }

//     Node root;

//     public BinaryNodeTree(int data) {
//         root = new Node(data);
//     }

//     public void insert(int data) {
//         root = insertRecursively(root, data);
//     }

//     private Node insertRecursively(Node node, int data) {
//         if (node == null) return new Node(data);

//         if (data < node.data) {
//             node.left = insertRecursively(node.left, data);
//         } else if (data > node.data) {
//             node.right = insertRecursively(node.right, data);
//         }

//         return node;
//     }

//     public static void main(String[] args) {
//         BinaryNodeTree tree = new BinaryNodeTree(5);
//         tree.insert(2);
//         tree.insert(3);
//         tree.insert(4);
//         tree.insert(6);
//         tree.insert(7);
//         tree.insert(8);
//         tree.insert(9);
//     }
// }

public class QueueStackTraversal {
    
}
