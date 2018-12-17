package disjointSets.tableJoin_3;

public class Set {
    int[] parent;
    int[] rank;
    int max;

    public Set(int n) {
        parent = new int[n];
        rank = new int[n];
        max = 0;
    }

    public void makeSet(int tableNumb, int i) {
        parent[tableNumb] = i;
        rank[tableNumb] = 0;
        if (i > max) {
            max = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public int union(int i, int j) {
        int i_id = find(i);
        int j_id = find(j);
        if (i_id == j_id) {
            if (max < parent[j] + parent[i]) {
                max = parent[j] + parent[i];
            }
            return max;
        }
        if (rank[i_id] > rank[j_id]) {
            parent[j_id] = i_id;
        } else {
            parent[i_id] = j_id;
            if (rank[i_id] == rank[j_id]) {
                rank[j_id] += 1;
            }
        }
        if (parent[j] + parent[i] > max) {
            max = parent[j] + parent[i];
        }
        return max;
    }
}
