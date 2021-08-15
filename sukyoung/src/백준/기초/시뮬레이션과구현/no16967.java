package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16967 {
    public static int[][] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        a = new int[h][w];
        b = new int[h+x][w+y];
        for(int i=0; i<(h+x); i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<(w+y); j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<(h+x); i++){
            for(int j=0; j<(w+y); j++){
                if(i<x && j< w) {
                    a[i][j] = b[i][j];
                }else if(j<y && i<h) { // 왼쪽 안겹치는 거
                    a[i][j] = b[i][j];
                }else if(j>=y && i>=x  && j<w && i<h) {//겹치는 거
                    a[i][j] = b[i][j]-a[i-x][j-y];
                }
            }
        }


        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
