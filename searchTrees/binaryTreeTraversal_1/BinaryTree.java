package searchTrees.binaryTreeTraversal_1;

public class BinaryTree {
    private TreeNode[] data;
    private int next;

    BinaryTree (int size) {
        data = new TreeNode[size];
        next = 0;
    }

    static class TreeNode {
        int key;
        int leftChild;
        int rightChild;

        TreeNode (int key, int leftChild, int rightChild) {
            this.key = key;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    void put(int key, int leftChild, int rightChild) {
        if (next != data.length) {
            TreeNode node = new TreeNode(key, leftChild,rightChild);
            data[next] = node;
            next++;
        }
    }

    TreeNode getParent() {
        return data[0];
    }

    void inOrderTraversal(TreeNode root) {
        if (root.leftChild != -1) {
            inOrderTraversal(data[root.leftChild]);
        }
        System.out.print(root.key + " ");
        if (root.rightChild != -1) {
            inOrderTraversal(data[root.rightChild]);
        }
    }

    void preOrderTraversal(TreeNode root) {
        System.out.print(root.key + " ");
        if (root.leftChild != -1) {
            preOrderTraversal(data[root.leftChild]);
        }
        if (root.rightChild != -1) {
            preOrderTraversal(data[root.rightChild]);
        }
    }

    void postOrderTraversal(TreeNode root) {
        if (root.leftChild != -1) {
            postOrderTraversal(data[root.leftChild]);
        }
        if (root.rightChild != -1) {
            postOrderTraversal(data[root.rightChild]);
        }
        System.out.print(root.key + " ");
    }
}
