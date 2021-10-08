package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] costs = new int[n];
        int left = 0, right = 0;
        for(int i=0; i<n; i++) {
            costs[i] = Integer.parseInt(br.readLine());

            right += costs[i];
            left = costs[i] > left ? costs[i] : left;
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            int cnt = 0;
            for(int cost: costs){
                if(sum + cost > mid){
                    sum = 0;
                    cnt++;
                }
                sum += cost;
            }
            if(sum != 0)
                cnt++;

            if(cnt <= m)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(left);
    }
}
