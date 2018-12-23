public class Book {
    private String[] names;
    private final int BOOK_SIZE = 10000000;

    Book() {
        names = new String[BOOK_SIZE];
    }

    void add(Integer phoneNumber, String name) {
        names[phoneNumber] = name;
    }

    void delete(Integer phoneNumber) {
        names[phoneNumber] = "not found";
    }

    String find(Integer phoneNumber) {
        return (names[phoneNumber] == null) ?
                "not found" : names[phoneNumber];
    }
}
