package WhiteBoarding_w10;

// Given the following class, implement a recursive method named count. It returns the total number of nodes.

// class Node {
//         String data;
//         Node left;
//         Node right;

//         public Node(String data) {
//             this.data = data;
//         }

//         //int count(){...}
//     }

// Example 1:
//          1
//         / \
//        2   3
//       /
//      4
// Node n1 = new Node("1");
// Node n2 = new Node("2");
// Node n3 = new Node("3");
// Node n4 = new Node("4");

// n1.left = n2;
// n1.right = n3;
// n2.left = n4;

// n1.count(); should return 4
// n2.count(); should return 2

public class Node {

    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }


    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        System.out.println(count(n4));
    }
    public static int count(Node node) {

        if(node == null) {
            return 0;
        }

        int nodeCount = 0;
        nodeCount += count(node.left);
        nodeCount++;
        nodeCount += count(node.right);

        return nodeCount;
    }
}
