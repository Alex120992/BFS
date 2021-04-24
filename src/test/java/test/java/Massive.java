package test.java;

public class Massive {


    public char[][] createMass(int n, int m) {
        char[][] chars = new char[n][m];
        int[][] ch = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i>1 ) && j==2 ) { chars[i][j]='#';
//                    System.out.print(chars[i][j]+"\t");
                }
                else {
                    chars[i][j] = '.';
                    chars[0][0] = 'X';
                    chars[n-1][m-1] = '@';
//                    System.out.print(chars[i][j]+"\t");
                }
            }
//            System.out.println();
        }

        return chars;
    }
    public char[][] createMass1(int n, int m) {
        char[][] chars = new char[n][m];
        int[][] ch = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    chars[i][j] = '.';
                    chars[0][0] = 'X';
                    chars[n-1][m-1] = '@';
//                    System.out.print(chars[i][j]+"\t");
                }
//            System.out.println();
            }
        return chars;
    }
    public char[][] createMass2(int n, int m) {
        char[][] chars = new char[n][m];
        int[][] ch = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i > 0 && i < n - 1) && j == 1) {
                    chars[i][j] = '#';
//                    System.out.print(chars[i][j] + "\t");
                } else {
                    chars[i][j] = '.';
                    chars[0][0] = 'X';
                    chars[n - 1][m - 1] = '@';
//                    System.out.print(chars[i][j] + "\t");
                }
            }
//            System.out.println();
        }
        return chars;
    }

}
