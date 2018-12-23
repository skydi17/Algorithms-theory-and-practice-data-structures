public class BinaryTree {
    private int[] data;
    private int next;

    BinaryTree (int size) {
        data = new int[size + 1];
        next = 0;
    }

    private int leftChild(int i){
        return 2*i + 1;
    }

    private int rightChild(int i){
        return 2*i + 2;
    }

    void put(int key, int leftChild, int rightChild) {
        if (next != data.length) {
            data[next] = key;
            //data[leftChild(next)] = leftChild;
            //data[rightChild(next)] = rightChild;
            next++;
        }
    }

    void inOrderTraversal(int root) {
        inOrderTraversal(leftChild(root));
        System.out.print(data[root] + " ");
        inOrderTraversal(rightChild(root));
    }

    void preOrderTraversal(int root) {
        System.out.print(data[root] + " ");
        preOrderTraversal(leftChild(root));
        preOrderTraversal(rightChild(root));
    }

    void postOrderTraversal(int root) {
        postOrderTraversal(leftChild(root));
        postOrderTraversal(rightChild(root));
        System.out.print(data[root] + " ");
    }
}
