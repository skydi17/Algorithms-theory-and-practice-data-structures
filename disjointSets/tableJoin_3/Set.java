package disjointSets.tableJoin_3;

import java.util.ArrayList;

public class Set {
    int[] tables;
    int[] indexes;
    int max;

    public Set(int n) {
        tables = new int[n];
        indexes = new int[n];
        max = 0;
    }

    public void makeSet(int tableNumb, int size) {
        tables[tableNumb] = size;
        indexes[tableNumb] = tableNumb;
        if (size > max) {
            max = size;
        }
    }

    public int find(int i) {
        ArrayList<Integer> steps = new ArrayList<>();
        while (i != indexes[i]) {
                steps.add(i);
                i = indexes[i];
        }
        for (int k = 0; k < steps.size() - 1; k++) {
            indexes[steps.get(k)] = i;
        }
        return i;
    }

    public int union(int destination, int source) {
        int destination_id = find(destination);
        int source_id = find(source);
        if (destination_id == source_id) {
            return max;
        }
        tables[destination_id] = tables[destination_id] + tables[source_id];
        indexes[source_id] = destination_id;
        if (tables[destination_id] > max) {
            max = tables[destination_id];
        }
        return max;
    }
}
