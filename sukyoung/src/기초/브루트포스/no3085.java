package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class no3085 {
    public static String[][] candy;
    public static int n;
    public static int maxCandy;

    public static void maxCandyCount(){
        for(int i=0; i<n; i++){
            int count = 1;
            for(int j=0; j<n-1; j++){
                if(candy[i][j].equals(candy[i][j+1]))
                    count++;
                else
                    count = 1;
                maxCandy = Math.max(count, maxCandy);
            }
        }
        for(int i=0; i<n; i++){
            int count = 1;
            for(int j=0; j<n-1; j++){
                if(candy[j][i].equals(candy[j+1][i]))
                    count++;
                else
                    count = 1;
                maxCandy = Math.max(count, maxCandy);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        candy = new String[n][n];

        for(int i=0; i<n; i++) {
            String[] color = br.readLine().split("");
            for(int j=0; j<n; j++){
                candy[i][j] = color[j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(!candy[i][j].equals(candy[i][j+1])){

                    String temp;
                    temp = candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = temp;

                    maxCandyCount();

                    temp = candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = temp;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(!candy[j][i].equals(candy[j + 1][i])){

                    String temp;
                    temp = candy[j][i];
                    candy[j][i] = candy[j+1][i];
                    candy[j+1][i] = temp;

                    maxCandyCount();

                    temp = candy[j][i];
                    candy[j][i] = candy[j+1][i];
                    candy[j+1][i] = temp;

                }
            }
        }

        System.out.println(maxCandy);

    }
}
