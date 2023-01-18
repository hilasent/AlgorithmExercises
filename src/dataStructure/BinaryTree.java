package dataStructure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public TreeNode root;
//    public TreeNode temp;

    public void createNode(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.right = second;
        first.left = third;
        second.right = fourth;
        third.left= fifth;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");

    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);

    }

    public void preOrderIterative(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.data + " ---> ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }

    }

    public void inOrderIterative(){
        if(root == null){
            return;
        }

        Stack<TreeNode> stackInOrder = new Stack<>();
        TreeNode temp = root;

        while(!stackInOrder.isEmpty() || temp != null ){
            if(temp != null){
                stackInOrder.push(temp);
                temp = temp.left;
            }
            else {
                temp = stackInOrder.pop();
                System.out.println(temp.data + " ");
                temp = temp.right;
            }
        }
    }
    // left - right - root
    public void postOrderIterative() {
        TreeNode current = root;
        Stack<TreeNode> stackk = new Stack<>();

        while (current != null || !stackk.isEmpty()) {
            if (current != null) {
                stackk.push(current);
                current = current.left;
            } else {
                TreeNode temp = stackk.peek().right;
                if (temp == null) {
                    temp = stackk.pop();
                    System.out.print(temp.data + " ");
                    while (!stackk.isEmpty() && temp == stackk.peek().right) {
                        temp = stackk.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

        public void levelOrder(){
            if(root == null){
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.println(temp.data + " --->");

              if(temp.right != null){
                  queue.offer(temp.right);
                 }
              if(temp.left != null){
                  queue.offer(temp.left);
              }
        }

    }














}











