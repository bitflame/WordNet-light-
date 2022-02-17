import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class AutoGraderTests {
    In in;
    Digraph digraph;
    Digraph digraph1;
    Digraph digraph2;
    SAP sap;
    SAP sap1;
    SAP sap2;
    int shortestDistance;
    int shortestDistance1;
    int shortestDistance2;
    int ancestor;
    List<Integer> v;
    List<Integer> w;

    private void testDigraphWordNet() {
        StdOut.println("-------------------------- Running AutoGrader Tests for DigraphWordNet --------------------------");
        in = new In("digraph-wordnet.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(64451, 25327);
        if (shortestDistance != 15)
            System.out.printf("shortest distance between 64451, and 25327 should be 15, but it is: %d \n", shortestDistance);
        shortestDistance = sap.length(35205, 21385);
        if (shortestDistance != 17)
            System.out.printf("shortest distance between 35205, and 21385 should be 17, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(53712, 61827);
        if (shortestDistance != 10)
            System.out.printf("shortest distance between 53712, and 61827 should be 10, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(45826, 73382);
        if (shortestDistance != 14)
            System.out.printf("shortest distance between 45826, and 73382 should be 14, but it is: %d\n ", shortestDistance);
        shortestDistance = sap.length(2657, 55738);
        if (shortestDistance != 15)
            System.out.printf("shortest distance between 2657, and 55738 should be 15, but it is: %d\n ", shortestDistance);
    }

    private void testSubgraphs() {
        StdOut.println("--------------------------- Running AutoGrader Tests for SubGraphs ------------------------------");
        //WordNet wordNet = new WordNet("synsets100-subgraph.txt", "hypernyms100-subgraph.txt");

    }

    private void testDigraph1() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 1 ----------------------------------");
        in = new In("digraph1.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(3, 3);
        if (shortestDistance != 0)
            System.out.printf("shortest distance between 3, and 3 should be 0, but it is: %d\n" + shortestDistance);
        ancestor = sap.ancestor(3, 3);
        if (ancestor != 3)
            System.out.printf("The value of ancestor between 3 and 3 should be 3, but it is: %d\n", ancestor);
        shortestDistance = sap.length(3, 8);
        if (shortestDistance != 1)
            System.out.printf("The value of length between 3 and 8 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(3, 8);
        if (ancestor != 3)
            System.out.printf("The value of ancestor between 3 and 8 should be 3, but it is: %d\n", ancestor);
        ancestor = sap.ancestor(3, 7);
        if (ancestor != 3)
            System.out.printf("The value of ancestor between 3 and 7 should be 3, but it is: %d\n", ancestor);
        shortestDistance = sap.length(3, 7);
        if (shortestDistance != 1)
            System.out.printf("The value of length between 7 and 3 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(8, 1);
        if (ancestor != 1)
            System.out.printf("The value of ancestor between 8 and 1 should be 1, but it is: %d\n", ancestor);
        shortestDistance = sap.length(8, 1);
        if (shortestDistance != 2)
            System.out.printf("The value of length between 8 and 1 should be 2, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(3, 1);
        if (ancestor != 1)
            System.out.printf("The value of ancestor between 3 and 1 should be 1, but it is: %d\n", ancestor);
        shortestDistance = sap.length(3, 1);
        if (shortestDistance != 1)
            System.out.printf("The value of length between 3 and 1 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(7, 1);
        if (ancestor != 1)
            System.out.printf("The value of ancestor between 7 and 1 should be 1, but it is: %d\n", ancestor);
        shortestDistance = sap.length(7, 1);
        if (shortestDistance != 2)
            System.out.printf("The value of length between 7 and 1 should be 2, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(1, 1);
        if (shortestDistance != 0)
            System.out.printf("The value of length between 1 and 1 should be 0, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(1, 1);
        if (ancestor != 1) System.out.printf("The ancestor for 1, and 1 should be 1, but it is: %d\n ", ancestor);
        shortestDistance = sap.length(3, 11);
        if (shortestDistance != 4)
            System.out.printf("The value of length between 3 and 11 should be 4, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(3, 11);
        if (ancestor != 1)
            System.out.printf("The value of ancestor of 3 and 11 should be 1, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(9, 12);
        if (shortestDistance != 3)
            System.out.printf("The value of length between the nodes 9 and 12 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(9, 12);
        if (ancestor != 5)
            System.out.printf("The value of ancestor between 9 and 12 should be 5, but it is: %d\n", ancestor);
        shortestDistance = sap.length(7, 2);
        if (shortestDistance != 4)
            System.out.printf("The value of length between the nodes 7, and 2 should be 4, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(7, 2);
        if (ancestor != 0)
            System.out.printf("The value of ancestor between 7 and 11 should be 0, but it is: %d\n", ancestor);
        ancestor = sap.ancestor(0, 2);
        if (ancestor != 0)
            System.out.printf("The value of ancestor between 0, and 2 should be 0, but it is: %d\n", ancestor);
        shortestDistance = sap.length(0, 2);
        if (shortestDistance != 1)
            System.out.printf("The value of length between the nodes 0, and 2 should be 1, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(1, 6);
        if (shortestDistance != -1)
            System.out.printf("The value of length between 1 and 6 should be -1 since they are not connected but it is: %d\n",
                    shortestDistance);
        ancestor = sap.ancestor(1, 6);
        if (ancestor != -1)
            System.out.printf("The value of ancestor between 1 and 6 should be -1 since they are not connected, but it is: %d\n", ancestor);
        try {
            shortestDistance = sap.length(-1, 0);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf(illegalArgumentException.getMessage());
        }

        try {
            ancestor = sap.ancestor(0, 13);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("Error message for non-exitant value: %s\n", illegalArgumentException.getMessage());
        }
        try {
            ancestor = sap.ancestor(13, 0);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("Error message for non-exitant value: %s\n", illegalArgumentException.getMessage());
        }
    }

    private void testDigraph2() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 2 ----------------------------------");
        in = new In("digraph2.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(4, 1);
        if (shortestDistance != 3)
            System.out.printf("Distance between 4, and 1 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(4, 1);
        if (ancestor != 0)
            System.out.printf("The value of ancestor between 4 and 1 should be 0, but it is: %d\n", ancestor);
        shortestDistance = sap.length(4, 0);
        if (shortestDistance != 2)
            System.out.printf("Distance between 4, and 0 should be 2, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(4, 0);
        if (ancestor != 0)
            System.out.printf("The value of ancestor between 4, and 0 should be 0, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(1, 1);
        if (shortestDistance != 0)
            System.out.printf("The shortest distance for the same point should be 0, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(1, 5);
        if (shortestDistance != 2)
            System.out.printf("The shortest distance between 1 and 5 should be 2, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(1, 5);
        if (ancestor != 0) System.out.printf("The ancestor for nodes 1 and 5 should be 0, but it is: %d\n", ancestor);
    }

    private void testDigraph3() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 3 ----------------------------------");
        in = new In("digraph3.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(10, 7);
        if (shortestDistance != 3)
            System.out.printf("Distance between 10 and 7 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 7);
        if (ancestor != 10)
            System.out.printf("The value of ancestor between 10 and 7 should be 10, but it is: %d\n", ancestor);
        shortestDistance = sap.length(5, 14);
        if (shortestDistance != -1)
            System.out.printf("Distance between 5 and 14 should be -1 since the two nodes are not connected, but it is: " +
                    "%d\n", shortestDistance);
        ancestor = sap.ancestor(5, 14);
        if (ancestor != -1)
            System.out.printf("The value of ancestor between 5 and 14 should be -1, but it is: %d\n", ancestor);
        shortestDistance = sap.length(2, 13);
        if (shortestDistance != -1)
            System.out.printf("Distance between 2 and 13 should be -1 since the two nodes are not connected, but it is: %d\n ", shortestDistance);
        ancestor = sap.ancestor(2, 13);
        if (ancestor != -1)
            System.out.printf("The value of ancestor between 2 and 13 should be -1, but it is: %d\n", ancestor);
        shortestDistance = sap.length(10, 3);
        if (shortestDistance != -1)
            System.out.printf("Distance between 10 and 3 should be -1 since the two nodes are not connected, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 3);
        if (ancestor != -1)
            System.out.printf("The value of ancestor between 10 and 3 should be -1, but it is: %d\n", ancestor);
        ancestor = sap.ancestor(7, 11);
        if (ancestor != 8)
            System.out.printf("The value of ancestor between 7 and 11 should be 8, but it is: %d\n", ancestor);
        shortestDistance = sap.length(7, 11);
        if (shortestDistance != 3)
            System.out.printf("The distance between 7 and 11 should be 3, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(2, 3);
        if (shortestDistance != 1)
            System.out.printf("The distance between 2 and 3 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(2, 3);
        if (ancestor != 3)
            System.out.printf("The value of ancestor between 2 and 3 should be 3, but it is: %d\n", ancestor);
        shortestDistance = sap.length(10, 9);
        if (shortestDistance != 1)
            System.out.printf("The distance between 10 and 9 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 9);
        if (ancestor != 10)
            System.out.printf("The value of ancestor between 10 and 9 should be 10, but it is: %d\n", ancestor);
        shortestDistance = sap.length(12, 13);
        if (shortestDistance != 4)
            System.out.printf("The distance between 12 and 13 should be 4, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(12, 13);
        if (ancestor != 12)
            System.out.printf("The value of ancestor between 12 and 13 should be 12, but it is: %d\n", ancestor);
        ancestor = sap.ancestor(10, 11);
        if (ancestor != 11)
            System.out.printf("The value of ancestor between 10 and 11 should be 11, but it is: %d\n", ancestor);
        shortestDistance = sap.length(10, 11);
        if (shortestDistance != 1)
            System.out.printf("The distance between 10 and 11 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 11);
        if (ancestor != 11)
            System.out.printf("The value of ancestor between 11 and 10 should be 11, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(11, 10);
        if (shortestDistance != 1)
            System.out.printf("The distance between 11 and 10 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(11, 10);
        if (ancestor != 11)
            System.out.printf("The value of ancestor between 11 and 10 should be 11, but it is: %d\n", ancestor);
        shortestDistance = sap.length(8, 13);
        if (shortestDistance != 5)
            System.out.printf("The distance between 8 and 13 should be 5, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(8, 13);
        if (ancestor != 8)
            System.out.printf("The value of ancestor between 8 and 13 should be 8, but it is: %d\n", ancestor);
        shortestDistance = sap.length(9, 2);
        if (shortestDistance != -1) System.out.printf("The distance between 9 and 2 should be -1 since they are not " +
                "connected, but it actually is: %d\n", shortestDistance);
        ancestor = sap.ancestor(9, 2);
        if (ancestor != -1)
            System.out.printf("The ancestor between the nodes 9 and 2 should be -1 since they are not " +
                    "connected, but it actually comes up as: %d\n", ancestor);
        shortestDistance = sap.length(10, 14);
        if (shortestDistance != 3)
            System.out.printf("The distance between 10 and 14 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 14);
        if (ancestor != 11)
            System.out.printf("The ancestor of 10, and 14 should be node 11, but it is: %d\n ", ancestor);
    }

    private void testDigraph4() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 4 ----------------------------------");
        in = new In("digraph4.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(1, 4);
        if (shortestDistance != 3)
            System.out.printf("The distance between 1 and 4 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(1, 4);
        if (ancestor != 4)
            System.out.printf("The value of ancestor between 1 and 4 should be 4, but it is: %d\n", ancestor);
        shortestDistance = sap.length(4, 1);
        if (shortestDistance != 3)
            System.out.printf("he distance between 4 and 1 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(4, 1);
        if (ancestor != 4)
            System.out.printf("The value of ancestor between 4 and 1 should be 4, but it is: %d\n", ancestor);
        shortestDistance = sap.length(9, 3);
        if (shortestDistance != 6)
            System.out.printf("The distance between 9 and 3 should be 6, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(9, 3);

    }

    private void testDigraph5() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 5 ----------------------------------");
        in = new In("digraph5.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(17, 21);
        if (shortestDistance != 5)
            System.out.printf("The distance between 17 and 21 should be 5, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(14, 21);
        if (shortestDistance != 8)
            System.out.printf("The distance between 14 and 21 should be 8, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(9, 20);
        if (shortestDistance != 3)
            System.out.printf("The distance between 9 and 20 should be 3, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(10, 12);
        if (ancestor != 10) System.out.printf("The value of ancestor should be 10, and it is: %d\n ", ancestor);
        shortestDistance = sap.length(10, 12);
        if (shortestDistance != 2)
            System.out.printf("The distance between 10 and 12 should be 2, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(21, 0);
        if (shortestDistance != 1)
            System.out.printf("The distance between 21, and 0 should be 1, and it is: %d\n", shortestDistance);
    }

    private void testDigraph6() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 6 ----------------------------------");
        in = new In("digraph6.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(0, 5);
        if (shortestDistance != 5)
            System.out.printf("The distance between 0 and 5 should be 5, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(7, 3);
        if (shortestDistance != 1)
            System.out.printf("The distance between 7 and 3 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(7, 3);
        if (ancestor != 3) System.out.printf("The ancestor  between 7 and 3 should be 3, but it is: %d\n", ancestor);
        shortestDistance = sap.length(7, 7);
        if (shortestDistance != 0)
            System.out.printf("The distance between 7, and 7 should be 0, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(1, 7);
        if (shortestDistance != 3)
            System.out.printf("The distance between 1 and 7 should be 3, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(4, 4);
        if (shortestDistance != 0)
            System.out.printf("The distance between the same node is should be 0, but it is: %d\n", shortestDistance);
    }

    private void testDigraph9() {
        StdOut.println("----------------------------------Running AutoGrader Tests for Digraph 9 ----------------------------------");
        in = new In("digraph9.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(7, 8);
        if (shortestDistance != -1)
            System.out.printf("The distance between 7 and 8 should be -1, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(7, 4);
        if (shortestDistance != 3)
            System.out.printf("The distance between 7, and 4 should be 3, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(4, 0);
        if (shortestDistance != 3)
            System.out.printf("The distance between 4, and 0 should be 3, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(7, 3);
        if (shortestDistance != 2)
            System.out.printf("The distance between 7, and 3 should be 2, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(4, 0);
        if (shortestDistance != 3)
            System.out.printf("The distance between 4 and 0 should be 3, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(4, 3);
        if (shortestDistance != 1)
            System.out.printf("The distance between 4, and 3 should be 1, but it is: %d\n", shortestDistance);
        shortestDistance = sap.length(0, 3);
        if (shortestDistance != 1)
            System.out.printf("The distance between 0, and 3 should be 1, but it is: %d\n", shortestDistance);
        ancestor = sap.ancestor(0, 3);
        if (ancestor != 0)
            System.out.printf("The ancestor between 0, and 3 should be 0, but it is: %d\n", ancestor);
        shortestDistance = sap.length(0, 5);
        if (shortestDistance != 4)
            System.out.printf("The distance between 0 and 5 should be 4, but it is: %d\n", shortestDistance);

    }

    private void createTwoObjects() {
        StdOut.println("-----------------------------Running AutoGrader Tests for Creating Two Objects -------------------");
        in = new In("digraph1.txt");
        digraph1 = new Digraph(in);
        in = new In("digraph2.txt");
        digraph2 = new Digraph(in);
        sap1 = new SAP(digraph1);
        sap2 = new SAP(digraph2);
        shortestDistance1 = sap1.length(0, 0);
        if (shortestDistance1 != 0)
            System.out.printf("The distance for the same node should be 0, but it is: %d\n", shortestDistance1);
        shortestDistance2 = sap2.length(0, 0);
        if (shortestDistance2 != 0)
            System.out.printf("The distance for the same node should be 0, but it is: %d\n", shortestDistance2);
        ancestor = sap1.ancestor(0, 0);
        if (ancestor != 0)
            System.out.printf("The ancestor for the same point should be itself, but it is: %d\n", ancestor);
    }

    private void testIterables() {
        StdOut.println("------------------ Running AutoGrader Tests for testIterables with WordNet -------------------");
        in = new In("digraph-wordnet.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        v = new ArrayList<>(List.of());
        w = new ArrayList<>(List.of(3464, 8331, 23405, 23889, 72520));
        shortestDistance = sap.length(v, w);
        if (shortestDistance != -1) System.out.printf("The shortest distance of two Iterables one of which has not " +
                "elements should be -1, but it is: %d\n", shortestDistance);
        v = new ArrayList<>(List.of(9675, 44260, 65806, 80452));
        w = new ArrayList<>(List.of());
        shortestDistance = sap.length(v, w);
        if (shortestDistance != -1) System.out.printf("The shortest distance of two Iterables one of which has not " +
                "elements should be -1, but it is: %d\n", shortestDistance);
        v = new ArrayList<>(List.of());
        w = new ArrayList<>(List.of());
        shortestDistance = sap.length(v, w);
        if (shortestDistance != -1) System.out.printf("The shortest distance of two Iterables one of which has not " +
                "elements should be -1, but it is: %d\n", shortestDistance);
        v = null;
        try {
            shortestDistance = sap.length(v, w);
        } catch (IllegalArgumentException ie) {
            System.out.printf("IllegalArgumentException for length() was thrown successfully when v is null : %s\n", ie.getMessage());
        }
        try {
            ancestor = sap.ancestor(v, w);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("IllegalArgumentException for ancestor() was thrown successfully when v is null : %s\n", illegalArgumentException.getMessage());
        }
        v = new ArrayList<>(List.of(0, 7, 9, 12));
        w = null;
        try {
            ancestor = sap.ancestor(v, w);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("IllegalArgumentException for ancestor() was thrown successfully when w is null : %s\n ",
                    illegalArgumentException.getMessage());
        }
        try {
            shortestDistance = sap.length(v, w);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("IllegalArgumentException for length() was thrown successfully when w is null: %s\n",
                    illegalArgumentException.getMessage());
        }
        w = null;
        v = null;
        try {
            ancestor = sap.ancestor(v, w);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("IllegalArgumentException for ancestor() was thrown successfully when both v and w are null : %s\n ",
                    illegalArgumentException.getMessage());
        }
        try {
            shortestDistance = sap.length(v, w);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.printf("IllegalArgumentException for length() was thrown successfully when both v and w are null: %s\n",
                    illegalArgumentException.getMessage());
        }
    }

    private void troubleShooting() {
        StdOut.println("------------------ Running the troubleshooting method -------------------");
        in = new In("digraph9.txt");
        digraph = new Digraph(in);
        sap = new SAP(digraph);
        shortestDistance = sap.length(4, 3);
        if (shortestDistance != 1)
            System.out.printf("The distance between 4, and 3 should be 1, but it is: %d\n", shortestDistance);
    }

    public static void main(String[] args) {
        AutoGraderTests autoGraderTests = new AutoGraderTests();
        // autoGraderTests.troubleShooting();
        autoGraderTests.testDigraphWordNet();
        autoGraderTests.testDigraph1();
        autoGraderTests.testDigraph2();
        autoGraderTests.testDigraph3();
        autoGraderTests.testDigraph4();
        autoGraderTests.testDigraph5();
        autoGraderTests.testDigraph6();
        autoGraderTests.testDigraph9();
        autoGraderTests.createTwoObjects();
        autoGraderTests.testIterables();
    }
}
