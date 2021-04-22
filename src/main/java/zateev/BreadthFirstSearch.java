package zateev;

import java.util.LinkedList;
import java.util.Stack;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int start;


    public BreadthFirstSearch(int V, int startPoint, int[][] edges) {
        marked = new boolean[V];
        edgeTo = new int[V];
        this.start = startPoint;
        bfs(edges, startPoint);
        edges=null;
    }

    private void bfs(int[][] edges, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[start] = true;
        queue.addFirst(start);
        while (!queue.isEmpty()) {
            int v = queue.getLast();
            queue.removeLast();
            for (int i = 0; i < edges[v][4]; i++) {
                int w = edges[v][i];
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.addFirst(w);
                }
            }
        }

    }

    public Stack<Integer> pathTo(int endPoint) {
        if (!hasPathTo(endPoint)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = endPoint; x != start; x = edgeTo[x]) {
            stack.add(x);
        }
        stack.add(start);
        edgeTo=null;
        return stack;
    }

    public boolean hasPathTo(int endPoint) {
        return marked[endPoint];
    }

}
