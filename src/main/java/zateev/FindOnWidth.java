package zateev;

public class FindOnWidth implements RouteFinder {
    private int[][] edges;
    BreadthFirstSearch breadthFirstSearch;
    int startPoint;
    int endPoint;
    int cols;
    int rows;
    int a;

    @Override
    public char[][] findRoute(char[][] map) {
        long s = System.currentTimeMillis();
        cols = map[0].length;
        rows = map.length;
        createGraphEdges(map);
        breadthFirstSearch = new BreadthFirstSearch(rows * cols, startPoint, edges);
        edges = null;
        breadthFirstSearch.pathTo(endPoint);
        System.out.println(breadthFirstSearch.hasPathTo(endPoint));
        System.out.println(System.currentTimeMillis()-s);
        return null;
    }

    public void createGraphEdges(char[][] masValues) {
        edges = new int[masValues.length * masValues[0].length][5];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (masValues[i][j] == '@') startPoint = i * cols + j; // сохоаняем начальную точку
                else if (masValues[i][j] == 'X') endPoint = i * cols + j; // сохраняем конечную точку
                else if (masValues[i][j] == '#') continue; // если стена то продолжаем цикл

                if (j + 1 < cols && masValues[i][j + 1] != '#') { //вправо
                    addEdge(i * cols + j, ((i * cols + j) + 1));
                }
                if (i + 1 < rows && masValues[i + 1][j] != '#') { // вниз
                    addEdge(i * cols + j, (((i + 1) * cols) + j));
                }
            }
        }

    }

    /* Добавляем ребра между вершинами в двумерный массив */
    private void addEdge(int firstVertex, int secondVertex) {
        a = edges[firstVertex][4];

        edges[firstVertex][a] = secondVertex;
        edges[firstVertex][4] = ++a;

        a = edges[secondVertex][4];

        edges[secondVertex][a] = firstVertex;
        edges[secondVertex][4] = ++a;

    }

//    char[][] createmas(char[][] mas, Stack<Integer> stack) {
//
//        while (!stack.isEmpty()) {
//
//            int val = stack.pop();
//            int i = val / cols;
//            for (int j = 0; j < cols; j++) {
//                if (i * mas[0].length + j == val && mas[i][j] != '@' && mas[i][j] != 'X') {
//                    mas[i][j] = '+';
//
//                }
//            }
//        }
//
//        return mas;
//    }
}
