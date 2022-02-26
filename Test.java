public class Test {
    private int count;
    private int[] id = new int[count];

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid)
            return;
        for (int index = 0; index < id.length; index++) {
            if (id[index] == pid)
                id[index] = qid;
            count--;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int i) {
        return id[i];
    }

    // quickfind complexity - (N+3) - 2(N+1)
    public int count() {
        return count;
    }
    // 1.5.23 Doubling test
}
