package zateev;

import java.util.ArrayDeque;
import java.util.Stack;

public class BreadthFirstSearch {
    private final boolean[] marked;
    private int[] edgeTo;
    private final int start;

    /**
     * @param V - количество вершин
     * @param startPoint - исходная точка
     *
     */
    public BreadthFirstSearch(int V, int startPoint) {
        marked = new boolean[V];
        edgeTo = new int[V];
        this.start = startPoint;
        bfs();
    }

    private void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        marked[start] = true;
        queue.addFirst(start);
        while (!queue.isEmpty()) {
            int v = queue.getLast();
            queue.removeLast();
            for (int i = 0; i < RouterFinderImpl.edges[v][4]; i++) {
                int w = RouterFinderImpl.edges[v][i];
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.addFirst(w);
                }
            }
        }
        RouterFinderImpl.edges = null;
        System.gc();
    }

    public Stack<Integer> pathTo(int endPoint) {
        if (!hasPathTo(endPoint)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = endPoint; x != start; x = edgeTo[x]) {
            stack.add(x);
        }
        stack.add(start);
        edgeTo = null;
        System.gc();
        return stack;
    }

    public boolean hasPathTo(int endPoint) {
        return marked[endPoint];
    }

}
