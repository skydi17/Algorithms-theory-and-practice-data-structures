package searchTrees.binaryTreeTraversal_1;

import java.util.Scanner;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BinaryTree tree = new BinaryTree(n);
        for (int i = 0; i < n; i++) {
            tree.put(scanner.nextInt(),
                            scanner.nextInt(), scanner.nextInt());
        }
        tree.inOrderTraversal(tree.getParent());
        System.out.println();
        tree.preOrderTraversal(tree.getParent());
        System.out.println();
        tree.postOrderTraversal(tree.getParent());
    }
}

