package zateev;

public class Massive {


    public char[][] createMass(int n, int m) {
        char[][] chars = new char[n][m];
        int[][] ch = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if ((j == m/2) && j==1 ) { chars[i][j]='#';
                }
                else {
                    chars[i][j] = '.';
                    chars[0][0] = '@';
                    chars[n - 1][m - 1] = 'X';
                }
            }
        }

        return chars;
    }


}
