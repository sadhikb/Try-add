import java.io.*;
import java.util.*;
    class Node{
        int data;
        Node left;
        Node right;
    Node(int data){
        this.data=data;
        this.right=null;
        this.left=null;
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(root.data>data){
            root.left=insert(root.left,data);
        }
        if(root.data<data){
            root.right=insert(root.right,data);
        }
        return root;
    }
    public static ArrayList<Integer> zigZag(Node root){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>(); 
        s1.push(root);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean b=true;
        if(!s1.isEmpty() || !s2.isEmpty()){
            if(b){
                while(!s1.isEmpty()){
                Node curr=s1.pop();
                arr.add(curr.data);
                System.out.println("data added");
                if(curr.left!=null){
                    System.out.println("left added");
                    s2.push(curr.left);
                }
                if(curr.right!=null){
                    s2.push(curr.right);
                    System.out.println("rightaddes");
                }
                }
            }
            else{
                while(!s2.isEmpty()){
                    Node curr=s2.pop();
                    arr.add(curr.data);
                    System.out.println("dataadded");
                    if(curr.right!=null){
                        s1.push(curr.right);
                    }
                    if(curr.left!=null){
                        s1.push(curr.left);
                    }
                }
            }
        b=!b;
        }
        return arr;
    } 
    public static void print(ArrayList<Integer> arr){
        int n = arr.size();
        for(int i =0;i<n;i++){
            System.out.print(arr.get(i)+" ");
        }
    }   
    }
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        while(input-->0){
         int nodes=sc.nextInt();
         int data=sc.nextInt();
         Node root = new Node(data);
         for(int i =1;i<nodes;i++){
            int data1=sc.nextInt();
             root=Node.insert(root,data1);
         }
        ArrayList<Integer> arr= Node.zigZag(root);
        Node.print(arr);
        }
  }
}