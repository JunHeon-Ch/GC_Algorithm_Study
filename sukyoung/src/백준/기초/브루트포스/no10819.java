package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class no10819 {
    public static int N;
    public static int[] A;
    public static int[] temp_a;
    public static boolean[] visit;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        temp_a = new int[N];
        visit = new boolean[N];

        result=0;
        DFS(0);
        System.out.print(result);

    }
    public static void DFS(int depth){
        if(depth == N){
            int sum = 0;
            for (int i = 0; i < N-1 ; i++) {
                sum += Math.abs(temp_a[i] - temp_a[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }

        for(int i = 0 ; i < N; i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            temp_a[depth] = A[i];
            DFS(depth + 1);
            visit[i] = false;
        }
    }
}
