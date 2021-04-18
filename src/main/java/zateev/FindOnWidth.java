package zateev;

public class FindOnWidth implements RouteFinder {
    private int[][] edges;
    //    private Stack<Integer>[] edges;
    int startPoint;
    int endPoint;

    @Override
    public char[][] findRoute(char[][] map) {
        createGraphEdges(map);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(map.length * map[0].length, startPoint, edges);
        System.out.println(breadthFirstSearch.hasPathTo(endPoint));
        breadthFirstSearch.pathTo(endPoint);
        return new char[0][];
    }

    public void createGraphEdges(char[][] masValues) {
        edges = new int[masValues.length * masValues[0].length][5];
        for (int i = 0; i < masValues.length; i++) {
            for (int j = 0; j < masValues[0].length; j++) {

                if (masValues[i][j] == 'S') startPoint = i * masValues[0].length + j; // сохоаняем начальную точку
                else if (masValues[i][j] == 'X') endPoint = i * masValues[0].length + j; // сохраняем конечную точку
                else if (masValues[i][j] == '#') continue; // если стена то продолжаем цикл

                if (j + 1 < masValues[0].length && masValues[i][j + 1] != '#') { //вправо

                    addEdge(i * masValues[0].length + j, ((i * masValues[0].length + j) + 1));

                }
                if (i + 1 < masValues.length && masValues[i + 1][j] != '#') { // вниз

                    addEdge(i * masValues[0].length + j, (((i + 1) * masValues[0].length) + j));

                }
            }
        }

    }

    /* Добавляем ребра между вершинами в двумерный массив */
    private void addEdge(int firstVertex, int secondVertex) {
        int a = edges[firstVertex][4];

        edges[firstVertex][a] = secondVertex;
        edges[firstVertex][4] = ++a;

        a = edges[secondVertex][4];

        edges[secondVertex][a] = firstVertex;
        edges[secondVertex][4] = ++a;

    }

//    char[][] createmas(char[][] mas) {
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[0].length; j++) {
//
//            }
//        }
//
//
//    }
}
