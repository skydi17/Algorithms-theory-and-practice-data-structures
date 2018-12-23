import java.util.Scanner;

public class ChainedHashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        HashTable table = new HashTable(m);
        for (int i = 0; i < n; i++) {
            switch (scanner.next()) {
                case "add":
                    table.add(scanner.next());
                    break;
                case "del":
                    table.delete(scanner.next());
                    break;
                case "find":
                    System.out.println(table.find(
                            scanner.next()));
                    break;
                case "check":
                    System.out.println(table.check(
                            scanner.nextInt()));
                    break;
            }
        }
    }
}
