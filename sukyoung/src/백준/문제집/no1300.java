package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 0; long right = k;
        while(left <= right){
            long mid = (left + right) / 2;
            long cnt = 0;

            for(int i=1 ; i<=n ; i++)
                cnt += Math.min(mid / i, n);

            if(cnt < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }
}
