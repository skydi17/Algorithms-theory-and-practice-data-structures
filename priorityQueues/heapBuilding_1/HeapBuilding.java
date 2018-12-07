import java.util.Scanner;

public class HeapBuilding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Heap heap = new Heap(n);
        int[] a = new int[n];
        for (int i = 0; i < n; i++ ) {
            a[i] = scanner.nextInt();
        }
        heap.buildHeap(a);
        System.out.println(heap.gerM());
        int[][] res = heap.getSwapIndexes();
        for (int i = 0; i < heap.gerM(); i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
