package disjointSets.automaticalProgramAnalysis_4;

import java.util.Scanner;

public class AutomaticalProgramAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int d = scanner.nextInt();

        Set set = new Set(n + 1);

        for (int i = 1; i <= n; i++) {
            set.makeSet(i);
        }

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            set.union(a, b);
        }

        for (int i = 0; i < d; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (set.find(a) == set.find(b)) {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");
    }
}
