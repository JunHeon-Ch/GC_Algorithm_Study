package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] times = new long[n];
        for(int i=0; i<n; i++){
            times[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(times);
        long left = 0, right = times[times.length-1] * m;
        long value = Long.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) / 2;

            long cnt = 0;
            for(long time: times) {
                cnt += mid / time;

                if(cnt >= m) {
                    break;
                }
            }

            if(cnt < m)
                left = mid + 1;
            else {
                value = Math.min(value, mid);
                right = mid - 1;
            }

        }
        System.out.println(value);
    }
}
