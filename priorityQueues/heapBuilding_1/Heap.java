public class Heap {
    private int[] data;
    private int m;
    private int[][] swapIndexes;

    Heap (int size) {
        data = new int[size];
        m = 0;
        swapIndexes = new int [4*size][2];
    }

    int leftChild(int i){
        return 2*i + 1;
    }

    int rightChild(int i){
        return 2*i + 2;
    }

    int gerM() {
        return m;
    }

    int[][] getSwapIndexes(){
        return swapIndexes;
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        if (l < data.length && data[l] < data[minIndex]) {
            minIndex = l;
        }
        int r = rightChild(i);
        if (r < data.length && data[r] < data[minIndex]) {
            minIndex = r;
        }
        if (i != minIndex) {
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
            swapIndexes[m][0] = i;
            swapIndexes[m][1] = minIndex;
            m++;
            siftDown(minIndex);
        }
    }

    void buildHeap(int[] a) {
        data = a;
        for (int i = a.length/2; i >= 0; i--) {
            siftDown(i);
        }
    }
}
