package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long left = 0, right = n, min = Long.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) / 2;
            long value = (long) Math.pow(mid, 2);

            if(value >= n){
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.print(min);
    }
}
