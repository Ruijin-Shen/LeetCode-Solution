import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args){
        int[] a = new int[]{1,3};
        System.out.println("Hello World!"); // Hello World!
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}