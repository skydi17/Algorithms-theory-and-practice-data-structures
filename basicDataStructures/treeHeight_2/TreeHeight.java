package basicDataStructures.treeHeight_2;

import java.util.Scanner;

public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }
        int maxHeight = 1;
        for (int i = 0; i < n; i++) {
            int height = 1;
            int node = tree[i];
            while (node != -1) {
                node = tree[node];
                height ++;
            }
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        System.out.println(maxHeight);
    }
}
