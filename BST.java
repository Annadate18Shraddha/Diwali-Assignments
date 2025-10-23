package bst;

public class BST {
    static class Node {
        int data; Node left, right;
        Node(int data) { this.data = data; left = right = null; }
    }

    Node root;

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        return root;
    }

    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    public Node delete(Node root, int data) {
        if (root == null) return null;
        if (data < root.data) root.left = delete(root.left, data);
        else if (data > root.data) root.right = delete(root.right, data);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            Node temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }
        return root;
    }

    public void inorder(Node root) {
        if (root != null) { inorder(root.left); System.out.print(root.data + " "); inorder(root.right); }
    }

    public void preorder(Node root) {
        if (root != null) { System.out.print(root.data + " "); preorder(root.left); preorder(root.right); }
    }

    public void postorder(Node root) {
        if (root != null) { postorder(root.left); postorder(root.right); System.out.print(root.data + " "); }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);

        System.out.print("Inorder: "); tree.inorder(tree.root);
        System.out.print("\nPreorder: "); tree.preorder(tree.root);
        System.out.print("\nPostorder: "); tree.postorder(tree.root);

        tree.root = tree.delete(tree.root, 30);
        System.out.print("\nAfter deleting 30, Inorder: "); tree.inorder(tree.root);
    }
}
