package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14501 {

    public static int[] T;
    public static int[] P;
    public static int N;
    public static int max_profit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        max_profit = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            quit(i,0);
        }
        System.out.print(max_profit);

    }
    public static void quit(int start, int sum){
        if(start >= N){
            max_profit = Math.max(max_profit, sum);
            return;
        }

        if(start + T[start] <= N)
            quit(start + T[start], sum + P[start]);
        else
            quit(start + T[start], sum);

        quit(start + 1, sum);
    }
}
