package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16926 {
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row_start = 0;
        int row_end = n-1;
        int col_start = 0;
        int col_end = m-1;
        while(true) {
            int size = (row_end-row_start+1)*2 + (col_end-col_start+1)*2 -4;
            turnCCW(row_start,row_end,col_start,col_end,r%size);
            row_start+=1;
            row_end-=1;
            col_start+=1;
            col_end-=1;
            if(row_start>row_end || col_start>col_end) break;
        }

        printArr(arr);
    }
    public static void turnCCW(int rowStart, int rowEnd, int colStart, int colEnd, int cnt){
        for(int k=0;k<cnt;k++) {
            int temp = arr[rowStart][colStart];

            for(int j=colStart;j<colEnd;j++) {
                arr[rowStart][j] = arr[rowStart][j+1];
            }

            for(int i=rowStart;i<rowEnd;i++) {
                arr[i][colEnd] = arr[i+1][colEnd];
            }

            for(int j=colEnd;j>colStart;j--) {
                arr[rowEnd][j] = arr[rowEnd][j-1];
            }

            for(int i=rowEnd;i>rowStart;i--) {
                arr[i][colStart] = arr[i-1][colStart];
            }
            arr[rowStart+1][colStart] = temp;
        }
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
