import java.util.*;

public class AutomaticalProgramAnalysis {

    private static void fillTable(int a, int b,
                                  Hashtable<Integer, TreeSet<Integer>> table){
        if (!table.containsKey(a)) {
            table.put(a, new TreeSet<>());
        }
        for (Integer element : table.get(a)) {
            table.get(element).add(b);
        }
        table.get(a).add(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int d = scanner.nextInt();

        //TreeSet set = new TreeSet();
        Hashtable<Integer, TreeSet<Integer>>table = new Hashtable(n);

        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            fillTable(a, b, table);
            fillTable(b, a, table);
        }

        for (int i = 0; i < d; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (table.containsKey(a) && table.get(a).contains(b)) {
                System.out.println("0");
                return;
            }
        }

        System.out.println("1");
    }
}
