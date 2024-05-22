import java.util.*;
import java.io.*;

class Codechef {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node constructTree(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        
        Node root = new Node(a[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        int idx = 0;

        while (!st.isEmpty()) {
            Pair top = st.peek();

            if (top.state == 1) {
                idx++;
                if (idx < a.length && a[idx] != -1) {
                    top.node.left = new Node(a[idx]);
                    st.push(new Pair(top.node.left, 1));
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (idx < a.length && a[idx] != -1) {
                    top.node.right = new Node(a[idx]);
                    st.push(new Pair(top.node.right, 1));
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        if (root == null)
            return;

        String s1 = "";
        if (root.left != null)
            s1 += root.left.val;
        else
            s1 += ".";

        s1 += " <-- " + root.val + " --> ";

        if (root.right != null)
            s1 += root.right.val;
        else
            s1 += ".";

        System.out.println(s1);

        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] a = new int[] { 50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1 };
        Node root = constructTree(a);
        display(root);
    }
}
