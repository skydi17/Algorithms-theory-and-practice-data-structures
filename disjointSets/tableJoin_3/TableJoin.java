package disjointSets.tableJoin_3;

import java.util.Scanner;

public class TableJoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set set = new Set(n + 1);
        for (int i = 1; i <= n; i++) {
            set.makeSet(i, scanner.nextInt());
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            res.append(set.union(scanner.nextInt(), scanner.nextInt()) + "\n");
        }
        System.out.println(res);
    }
}
