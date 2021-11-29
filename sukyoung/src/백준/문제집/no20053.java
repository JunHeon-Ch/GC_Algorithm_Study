package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            int n = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int temp = Integer.parseInt(st.nextToken());
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }
            sb.append(min + " " + max);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
