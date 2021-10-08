package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long z =  y * 100 / x;
        if(z >= 99)
            System.out.println(-1);
        else{
            long left = 0, right = x;

            while(left <= right){
                long mid = (left + right) / 2;

                long temp_z = (y+mid) * 100 / (x+mid);
                if(temp_z != z){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            System.out.println(left);
        }
    }
}
