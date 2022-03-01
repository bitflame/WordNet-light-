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

    public boolean matches(String s1, String s2) {
        int count = 0;
        char[] firstStringArray = s1.toCharArray();
        char[] secondStringArray = s2.toCharArray();
        while (count < Math.min(s1.length(), s2.length())) {
            if (firstStringArray[count] != secondStringArray[count])
                return false;
        }
        return true;
    }

    // 1.5.23 Doubling test
    public static void main(String[] args) {
        String first = "bb";
        String second = "bb";
        System.err.println(first.compareTo(second));
        int i = 0;
        for (; i < second.length(); ++i) {
            System.out.println("i: " + i);
        }
    }
}
