package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] budget = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budget);
        int left = 0, right = budget[budget.length-1];
        while(left <= right){
            int mid = (left + right) / 2;

            long sum = 0;
            for(int i=0; i<budget.length; i++){
                if(budget[i] < mid)
                    sum += budget[i];
                else
                    sum += mid;
            }

            if(sum > m)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(right);

    }
}
