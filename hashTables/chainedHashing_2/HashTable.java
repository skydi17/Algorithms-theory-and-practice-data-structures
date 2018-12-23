import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {
    private LinkedList[] table;

    private final long P = 1000000007;
    private final int X = 263;

    HashTable(int size) {
        table = new LinkedList[size];
    }

    private int countHash(char[] str) {
        long h = 0;
        for (int i = 0; i < str.length; i++) {
            h = h + str[i] * pow(X, i);
        }
        return Math.abs((int)(Math.abs(Math.abs((Math.abs(h % P) + P) % P)
                % table.length) + table.length) % table.length);
    }

    private long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long res = a;
        for (int i = 0; i < b - 1; i++) {
            res = Math.abs(Math.abs((Math.abs(res*a % P) + P) % P));
        }
        return res;
    }

    void add(String str) {
        int ind = countHash(str.toCharArray());
        if (table[ind] == null) {
            table[ind] = new LinkedList();
        }
        if (!table[ind].contains(str)) {
            table[ind].addFirst(str);
        }
    }

    void delete(String str) {
        int ind = countHash(str.toCharArray());
        if (table[ind] != null && table[ind].contains(str)) {
            table[ind].remove(str);
        }
    }

    String find(String str) {
        int ind = countHash(str.toCharArray());
        if (table[ind] != null && table[ind].contains(str)) {
            return "yes";
        } else {
            return "no";
        }
    }

    String check(int i) {
        StringBuilder res = new StringBuilder();
        if (table[i] != null) {
            Iterator iterator = table[i].listIterator();
            while (iterator.hasNext()) {
                res.append(iterator.next() + " ");
            }
            return res.toString();
        } else {
            return "";
        }
    }
}
