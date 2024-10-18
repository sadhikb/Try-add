import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static ArrayList<Integer> zigZag(Node root) {
        Stack<Node> s1 = new Stack<>(); // For levels to be printed from left to right
        Stack<Node> s2 = new Stack<>(); // For levels to be printed from right to left
        s1.push(root);

        ArrayList<Integer> arr = new ArrayList<>();
        boolean leftToRight = true;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (leftToRight) {
                while (!s1.isEmpty()) {
                    Node curr = s1.pop();
                    arr.add(curr.data);
                    // Print debug messages
                    System.out.println("Data added from s1: " + curr.data);

                    if (curr.left != null) {
                        s2.push(curr.left);
                        System.out.println("Left child pushed to s2: " + curr.left.data);
                    }
                    if (curr.right != null) {
                        s2.push(curr.right);
                        System.out.println("Right child pushed to s2: " + curr.right.data);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    Node curr = s2.pop();
                    arr.add(curr.data);
                    // Print debug messages
                    System.out.println("Data added from s2: " + curr.data);

                    if (curr.right != null) {
                        s1.push(curr.right);
                        System.out.println("Right child pushed to s1: " + curr.right.data);
                    }
                    if (curr.left != null) {
                        s1.push(curr.left);
                        System.out.println("Left child pushed to s1: " + curr.left.data);
                    }
                }
            }
            leftToRight = !leftToRight; // Toggle the direction
        }

        return arr;
    }

    public static void print(ArrayList<Integer> arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
 class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        while (input-- > 0) {
            int nodes = sc.nextInt();
            int data = sc.nextInt();
            Node root = new Node(data);

            for (int i = 1; i < nodes; i++) {
                int data1 = sc.nextInt();
                root = Node.insert(root, data1);
            }

            ArrayList<Integer> arr = Node.zigZag(root);
            Node.print(arr);
        }
    }
}
