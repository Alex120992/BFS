package zateev;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RouterFinderImpl implements RouteFinder {
    static  Object object;
    ExecutorService executorService;
    public static int[][] edges;
    private char[][] map;
    private BreadthFirstSearch breadthFirstSearch;
    private Integer startPoint;
    private Integer endPoint;
    private int cols;
    private int rows;
    private int deleteOnPart;
    private int a;

    /*
     * @param map - исходный массив;
     * @return - возвращает готовый результат;
     */

    @Override
    public char[][] findRoute(char[][] map) {
        object = new Object();
        synchronized (object) {
            executorService = Executors.newSingleThreadExecutor();
            cols = map[0].length;
            rows = map.length;
            deleteOnPart = formule();
            this.map = map;
            map = null;
            createGraphEdges();
            return markPath(breadthFirstSearch.pathTo(endPoint));
        }
    }

    public  void createGraphEdges() {

        synchronized (object) {
            edges = new int[cols * rows][5];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j] == '@') {
                        startPoint = i * cols + j;
                        // сохраняем начальную точку
                    } else if (map[i][j] == 'X') {
                        endPoint = i * cols + j;
                        // сохраняем конечную точку
                    } else if (map[i][j] == '#') {
                        continue;
                        // если стена, то продолжаем цикл
                    }
                    if (j + 1 < cols && map[i][j + 1] != '#') {
                        addEdge(i * cols + j, ((i * cols + j) + 1));
                        //вправо
                    }
                    if (i + 1 < rows && map[i + 1][j] != '#') {
                        addEdge(i * cols + j, (((i + 1) * cols) + j));
                        // вниз
                    }
                }
//                if (deleteOnPart>0 && i==deleteOnPart)
            }
            breadthFirstSearch = new BreadthFirstSearch(rows * cols, startPoint);
            executorService.execute(breadthFirstSearch);
        System.gc();
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
        }
    }

    /*
     * @param firstVertex  - исходная вершина;
     * @param secondVertex - вершина смещения;
     */

    private void addEdge(int firstVertex, int secondVertex) {
        a = edges[firstVertex][4];
        edges[firstVertex][a] = secondVertex;
        edges[firstVertex][4] = ++a;

        a = edges[secondVertex][4];
        edges[secondVertex][a] = firstVertex;
        edges[secondVertex][4] = ++a;
    }

    /*
     * @param stack - путь от одной вершину в другую;
     * @return map - путь с отмеченными "+" верщинами;
     */

    char[][] markPath(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int val = stack.pop();
            int i = val / cols;
            for (int j = 0; j < cols; j++) {
                if (i * map[0].length + j == val && map[i][j] != '@' && map[i][j] != 'X') {
                    map[i][j] = '+';
                }
            }
        }
        return map;
    }
    private int formule (){
        int size = cols*rows*20; // количество байт
        int r;
        if (size > 1000000) return size/1000000;
        else return 0;

    }

}
