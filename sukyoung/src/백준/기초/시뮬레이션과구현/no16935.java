package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        while(r-- > 0){
            int instruction = Integer.parseInt(st.nextToken());
            switch (instruction) {
                case 1:
                    arr = updown(arr);
                    break;
                case 2:
                    arr = leftright(arr);
                    break;
                case 3:
                    arr = turnright(arr);
                    break;
                case 4:
                    arr = turnleft(arr);
                    break;
                case 5:
                    arr = divide4_1(arr);
                    break;
                case 6:
                    arr = divide4_2(arr);
                    break;
            }
        }
        printArr(arr);
    }
    public static int[][] updown(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[n][m];
        for(int i=0; i<n/2; i++){
            temp[n-(i+1)] = arr[i];
            temp[i] = arr[n-(i+1)];
        }
//        printArr(temp);
        return temp;
    }
    public static int[][] leftright(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                temp[i][m-(j+1)] = arr[i][j];
                temp[i][j] = arr[i][m-(j+1)];
            }
        }
//        printArr(temp);
        return temp;
    }
    public static int[][] turnright(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp[j][n-(i+1)] = arr[i][j];
            }
        }
//        printArr_2(temp);
        return temp;
    }
    public static int[][] turnleft(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[m][n];
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                temp[m-(j+1)][i] = arr[i][j];
            }
        }
//        printArr_2(temp);
        return temp;
    }
    public static int[][] divide4_1(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j<m/2){
                    if(i<n/2)
                        temp[i][j+(m/2)] = arr[i][j];
                    else
                        temp[i-(n/2)][j] = arr[i][j];
                }
                else{
                    if(i<n/2)
                        temp[i+(n/2)][j] = arr[i][j];
                    else
                        temp[i][j-(m/2)] = arr[i][j];
                }
            }
        }
//        printArr(temp);
        return temp;
    }
    public static int[][] divide4_2(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i<n/2){
                    if(j<m/2)
                        temp[i+(n/2)][j] = arr[i][j];
                    else
                        temp[i][j-(m/2)] = arr[i][j];
                }
                else{
                    if(j<m/2)
                        temp[i][j+(m/2)] = arr[i][j];
                    else
                        temp[i-(n/2)][j] = arr[i][j];
                }
            }
        }
//        printArr(temp);
        return temp;
    }

    public static void printArr(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
