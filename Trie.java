public class Trie {
    private class Node {
        private Node(String i) {
            item = i;
        }

        Node leftNode;
        Node rightNode;
        String item;
        int count;

        public int count() {
            return count;
        }
    }

    Node root;
    int size;
    int leftCount;
    int rightCount;

    public Trie() {
        root = null;
        size = 0;
    }

    public void insert(String word) {
        root = insert(root, word);
    }

    public Node insert(Node h, String string) {
        if (h == null) {
            h = new Node(string);
            h.count++;
        } else {
            int cmp = string.compareTo(h.item);
            if (cmp < 0)
                h.leftNode = insert(h.leftNode, string);
            else if (cmp > 0)
                h.rightNode = insert(h.rightNode, string);
            if (cmp == 0)
                h.item = string;
            if (h.leftNode != null)
                leftCount = h.leftNode.count();
            if (h.rightNode != null)
                rightCount = h.rightNode.count();
            size = leftCount + rightCount + 1;
        }
        return h;
    }

    public boolean search(String word) {
        return true;
    }

    public boolean startsWith(String prefix) {
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] input = { "", "A", "to", "tea", "ted", "ten", "i", "in", "inn" };
        for (String string : input) {
            trie.insert(string);
        }
        trie.insert("apple");
        System.out.println("Expecting false: " + trie.search("apple"));
        System.out.println("Expecting true: " + trie.search("app"));
        System.out.println("Expecting true: " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("Expecting true: " + trie.search("app"));
    }
}