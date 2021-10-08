package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lecture = new int[n];
        int left = Integer.MIN_VALUE, right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());

            right += lecture[i];
            left = Math.max(left, lecture[i]);
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            int cnt = 0;
            for(int time: lecture){
                if(sum + time > mid){
                    sum = 0;
                    cnt++;
                }
                sum += time;
            }
            if(sum > 0)
                cnt ++;

            if(cnt > m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }
}
