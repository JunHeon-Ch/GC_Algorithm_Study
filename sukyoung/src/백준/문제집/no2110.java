package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] home = new long[n];
        for(int i=0; i<n; i++){
            home[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(home);

        long ans = 0;
        long left = 1, right = home[home.length-1] - home[0];
        while(left <= right){
            long mid = (left + right) / 2;
            long start = home[0];

            int cnt = 1;
            for(int i=1; i<n; i++){
                long d = home[i] - start;
                if(d >= mid){
                    ++cnt;
                    start = home[i];
                }
            }

            if(cnt >= c){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
