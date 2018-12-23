import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Book book = new Book();
        for (int i = 0; i < n; i++) {
            switch (scanner.next()) {
                case "add":
                    book.add(scanner.nextInt(), scanner.next());
                    break;
                case "del":
                    book.delete(scanner.nextInt());
                    break;
                case "find":
                    System.out.println(book.find(
                            scanner.nextInt()));
                    break;
            }
        }
    }
}
