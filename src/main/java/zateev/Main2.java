package zateev;

public class Main2 {
    public static void main(String[] args) {
        int n =10000;
        int m = 10000;
        int k = n*m;
        int mas [][] = new int[n][m];
        int [] mas2 = new int[k];
        long s = System.currentTimeMillis();
        for(int i=0; i<n;i++){
            for (int j=0;j<m;j++){
                if (i>1000) mas[i][j] = i+j;
                if (i>2000) mas[i][j] = i+j;
                if (i>3000) mas[i][j] = i+j;
                if (i>4000) mas[i][j] = i+j;
                mas[i][j] = i+j;
            }
        }
        System.out.println(System.currentTimeMillis()-s);
        long s2 = System.currentTimeMillis();
        for (int i=0;i<k;i++){
            if (i>1000) mas2[i] = 500;
            if (i>2000)mas2[i] = 500;
            if (i>3000)mas2[i] = 500;
            if (i>4000)mas2[i] = 500;
            mas2[i]= i;
        }
        System.out.println(System.currentTimeMillis()-s2);
    }
}
