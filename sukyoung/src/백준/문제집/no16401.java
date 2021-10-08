package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cookies = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cookies);
        int left = 1, right = cookies[cookies.length-1];
        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i=0; i<cookies.length; i++){
                cnt += cookies[i] / mid;
            }

            if(cnt < m)
                right = mid - 1;
            else
                left = mid + 1;

        }
        System.out.println(right);
    }
}
