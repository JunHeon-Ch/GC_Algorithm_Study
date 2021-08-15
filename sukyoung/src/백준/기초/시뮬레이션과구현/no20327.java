package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no20327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int length = (int) Math.pow(2, n);
        int[][] A = new int[length][length];
        for(int i=0; i<length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<length; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int instruction = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            int box_size = (int) Math.pow(2, level);
            switch (instruction){
                case 1:
                    A = updown(A, box_size);
                    break;
                case 2:
                    A = leftright(A, box_size);
                    break;
                case 3:
                    A = turnright(A, box_size);
                    break;
                case 4:
                    A = turnleft(A,box_size);
                    break;
                case 5:
                    A = updown(A, length);
                    A = updown(A, box_size);
                    break;
                case 6:
                    A = leftright(A, length);
                    A = leftright(A, box_size);
                    break;
                case 7:
                    A = turnright(A, length);
                    A = turnleft(A, box_size);
                    break;
                case 8:
                    A = turnleft(A, length);
                    A = turnright(A, box_size);
                    break;
            }
        }
        printArr(A);
    }
    public static int[][] updown(int[][] arr, int box_size){
        int n = arr.length;
        int cnt = 0;

        int[][] temp = new int[n][n];
        for(int i=0; i<n; i = i + box_size){
            for(int j=0; j<n; j = j + box_size){
                int r = i + box_size;
                int c = j + box_size;

                for(int a=i; a<r; a++){
                    for(int b=j; b<c; b++){
                        temp[r-1-a + box_size*cnt][b] = arr[a][b];
                    }
                }
            }
            cnt++;
        }

        return temp;
    }

    public static int[][] leftright(int[][] arr, int box_size){
        int n = arr.length;
        int cnt = 0;

        int[][] temp = new int[n][n];
        for(int i=0; i<n; i = i + box_size){
            for(int j=0; j<n; j = j + box_size){
                int r = i + box_size;
                int c = j + box_size;

                for(int a=i; a<r; a++){
                    for(int b=j; b<c; b++){
                        temp[a][c-1-b + box_size*cnt] = arr[a][b];
                    }
                }
                cnt++;
            }
            cnt = 0;
        }

        return temp;
    }
    public static int[][] turnright(int[][] arr, int box_size){
        int n = arr.length;
        int cnt = 0;
        int gap_c = 0;
        int gap_r = 0;

        int[][] temp = new int[n][n];
        for(int i=0; i<n; i = i + box_size){
            for(int j=0; j<n; j = j + box_size){
                int r = i + box_size;
                int c = j + box_size;

                for(int a=i; a<r; a++){
                    for(int b=j; b<c; b++){
                        temp[b-box_size*gap_r+box_size*cnt][r-1-a + box_size*gap_c] = arr[a][b];
                    }
                }
                gap_r++;
                gap_c++;
            }
            cnt++;
            gap_c = 0;
            gap_r = 0;
        }

        return temp;
    }
    public static int[][] turnleft(int[][] arr, int box_size){
        int n = arr.length;
        int cnt = 0;
        int gap_c = 0;
        int gap_r = 0;

        int[][] temp = new int[n][n];
        for(int i=0; i<n; i = i + box_size){
            for(int j=0; j<n; j = j + box_size){
                int r = i + box_size;
                int c = j + box_size;

                for(int a=i; a<r; a++){
                    for(int b=j; b<c; b++){
                        temp[c-1-b + box_size*gap_r][a+box_size*gap_c-box_size*cnt] = arr[a][b];
                    }
                }
                gap_c++;
            }
            cnt++;
            gap_r++;
            gap_c = 0;

        }

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
