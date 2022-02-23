import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class SAP {
    private final Digraph digraphDFCopy;
    private int ancestor;
    private int minDistance;
    private int from;
    private int to;
    private final int n;
    private boolean[] marked;

    private int[] edgeTo;
    private int[] fromDistTo;
    private int[] toDistTo;
    private final int[] id;
    private static final int INFINITY = Integer.MAX_VALUE;
    private final boolean print = false;

    // constructor takes a digraph ( not necessarily a DAG )
    public SAP(Digraph digraph) {
        if (digraph == null)
            throw new IllegalArgumentException("Digraph value can not be null");
        digraphDFCopy = new Digraph(digraph);
        n = digraphDFCopy.V();
        id = new int[n];
    }

    // length of the shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        // System.out.println("length(): Calculating the distance between : " + v + " "
        // + w);
        if (v < 0 || v >= digraphDFCopy.V())
            throw new IllegalArgumentException("The node ids should be within acceptable range.\n");
        if (w < 0 || w >= digraphDFCopy.V())
            throw new IllegalArgumentException("The node ids should be within acceptable range.\n");
        if (v == from && w == to && v != w)
            return minDistance;
        from = v;
        to = w;
        if (v == w) {
            ancestor = v;
            minDistance = 0;
            return 0;
        }
        if ((digraphDFCopy.indegree(from) == 0 && digraphDFCopy.outdegree(from) == 0)
                || (digraphDFCopy.indegree(to) == 0 &&
                        digraphDFCopy.outdegree(to) == 0)) {
            ancestor = -1;
            return minDistance = -1;
        }
        lockStepBFS(from, to);
        return minDistance;
    }

    // length of the shortest ancestral path between any vertex in v and any vertex
    // in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null)
            throw new IllegalArgumentException("Iterable value to SAP.length() can not be null.\n");
        int currentDistance = 0;
        int prevDistance = INFINITY;
        // System.out.printf("sap triggers ancestor() with iterables ");
        Iterator<Integer> i = v.iterator();
        Iterator<Integer> j = w.iterator();
        if ((!i.hasNext()) || (!j.hasNext())) {
            return minDistance = -1;
        }
        int source;
        int destination;
        Object obj;
        while (i.hasNext()) {
            obj = i.next();
            if (obj == null)
                throw new IllegalArgumentException("The values Iterables give to length() can not be null.");
            else
                source = (Integer) obj;
            while (j.hasNext()) {
                obj = j.next();
                if (obj == null)
                    throw new IllegalArgumentException("The values Iterables give to length() can not be null.");
                destination = (Integer) obj;
                currentDistance = length(source, destination);
                // System.out.printf("Current Distance: %d \n", currentDistance);
                if (currentDistance != -1 && currentDistance < prevDistance) {
                    prevDistance = currentDistance;
                }
            }
            j = w.iterator();
        }
        // System.out.printf("Here is the last value in previous distance: %d\n" ,
        // prevDistance);
        if (prevDistance != INFINITY)
            minDistance = prevDistance;
        return minDistance;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path;
    // -1 if no such path
    public int ancestor(int v, int w) {
        // System.out.println("Calculating the ancestor between : " + v + " " + w);
        if (v < 0 || v >= digraphDFCopy.V())
            throw new IllegalArgumentException("The node ids should be within acceptable range.\n");
        if (w < 0 || w >= digraphDFCopy.V())
            throw new IllegalArgumentException("The node ids should be within acceptable range.\n");
        if (v < 0 || w < 0)
            throw new IllegalArgumentException("The node ids should be within acceptable range.\n");
        if (this.from == v && this.to == w && v != w)
            return ancestor;
        from = v;
        to = w;
        if (v == w) {
            return ancestor = v;
        }
        if ((digraphDFCopy.indegree(from) == 0 && digraphDFCopy.outdegree(from) == 0)
                || (digraphDFCopy.indegree(to) == 0 &&
                        digraphDFCopy.outdegree(to) == 0)) {
            minDistance = -1;
            return ancestor = -1;
        }
        lockStepBFS(from, to);
        return ancestor;
    }

    private void updateAncestor(int v, int w) {
        if (id[v] == w) {
            ancestor = v;
            minDistance = toDistTo[v];
        } else if (id[w] == v) {
            ancestor = w;
            minDistance = fromDistTo[w];
        }

    }

    // a common ancestor that participates in the shortest ancestral path; -1 if no
    // such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null)
            throw new IllegalArgumentException("Iterable value to SAP.ancestor() can not be null.\n");

        int len = 0;
        int prevLen = INFINITY;
        int currentAncestor = 0;
        Iterator<Integer> i = v.iterator();
        Iterator<Integer> j = w.iterator();
        if ((!i.hasNext()) || (!j.hasNext())) {
            return ancestor = -1;
        }
        int source;
        int destination;
        Object obj;
        while (i.hasNext()) {
            obj = i.next();
            if (obj == null)
                throw new IllegalArgumentException("The values Iterables give to length() can not be null.");
            else
                source = (Integer) obj;
            while (j.hasNext()) {
                obj = j.next();
                if (obj == null)
                    throw new IllegalArgumentException("The values Iterables give to length() can not be null.");
                destination = (Integer) obj;
                len = length(source, destination);
                if (len != -1 && len < prevLen) {
                    currentAncestor = ancestor;
                    prevLen = len;
                }
            }
            j = w.iterator();
        }
        ancestor = currentAncestor;
        minDistance = prevLen;
        return ancestor;
    }

    // v is the ancestor and w is source or destination
    private int countHops(int v, int w) {
        if (v == w || v == edgeTo[v])
            return 0;
        int hops = 0;
        while (edgeTo[v] != w) {
            v = edgeTo[v];
            hops++;
        }
        hops++;
        return hops;
    }

    private void lockStepBFS(int f, int t) {
        /* todo - you can use digraph indegree to set edgeTo f and t maybe */
        marked = new boolean[n];
        edgeTo = new int[n];
        fromDistTo = new int[n];
        toDistTo = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            edgeTo[i] = i;
        }
        // fromDistTo = new int[n];
        // toDistTo = new int[n];
        Queue<Integer> fromQueue = new Queue<>();
        Queue<Integer> toQueue = new Queue<>();
        fromQueue.enqueue(f);
        toQueue.enqueue(t);
        marked[f] = true;
        marked[t] = true;
        fromDistTo[f] = 0;
        toDistTo[t] = 0;
        int currentDistance = INFINITY;
        int currentAncestor = -1;
        while (!(fromQueue.isEmpty() && toQueue.isEmpty())) {
            if (!fromQueue.isEmpty()) {
                int v = fromQueue.dequeue();
                if (print)
                    System.out.printf("took %d from fromQueue \n", v);
                for (int j : digraphDFCopy.adj(v)) {
                    if (!marked[j]) {
                        marked[j] = true;
                        fromDistTo[j] = fromDistTo[v] + 1;
                        id[j] = id[v];
                        edgeTo[j] = v;
                        fromQueue.enqueue(j);
                    }
                    if (id[j] == id[t]) {
                        currentAncestor = j;
                        // if j==t just add 0, if not
                        currentDistance = countHops(j, t) + countHops(v, f) + 1;
                    }
                }
            }
/* if the id[] has a node entery same as f or t, then I can skip lock-step and just traverse edgeTo to 
that node */
            if (!toQueue.isEmpty()) {
                int w = toQueue.dequeue();
                if (print)
                    System.out.printf("took %d from toQueue \n", w);
                for (int k : digraphDFCopy.adj(w)) {
                    if (!marked[k]) {
                        marked[k] = true;
                        toDistTo[k] = toDistTo[w] + 1;
                        id[k] = id[w];
                        edgeTo[k] = w;
                        toQueue.enqueue(k);
                    }
                    if (id[k] == id[f]) {
                        currentAncestor = k;
                        currentDistance = countHops(w, t) + countHops(k, f) + 1;
                    }
                }
            }
        }
        if (currentDistance == INFINITY) {
            // System.out.println("setting minDistance to -1 becuase currentDistance is
            // INFINITY ");
            minDistance = -1;
            ancestor = -1;
            // return minDistance;
        } else {
            minDistance = currentDistance;
            ancestor = currentAncestor;
        }
        // return currentDistance;
    }

    // testEdgeTo(ancestor, x) and preAncestor'sNode like v, and w to the other end
    private boolean testEdgeTo(int ancestor, int destination) {
        // System.out.printf("inside testEdge for " + from + " and " + to);
        if (ancestor == destination)
            return true;
        int i = ancestor;
        int counter = 0;
        for (; i != destination && counter < n; i = edgeTo[i]) {
            if (i == -1)
                break;
            counter++;
            // System.out.print(" " + i);
        }
        // if (i != -1) System.out.print(" " + i);

        return (i == destination);
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In("digraph3.txt"));
        SAP sap = new SAP(digraph);
        System.out.printf("%b\n", sap.testEdgeTo(11, 12));
        System.out.printf("%b\n", sap.testEdgeTo(11, 8));
    }
}
