package 기초.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no13398 {
    public static int n;
    public static int[] arr;
    public static int[] dp_left;
    public static int[] dp_right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp_left = new int[n];
        dp_right = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp_left[0] = arr[0];
        int max = arr[0];
        for(int i=1; i<n; i++){
            dp_left[i] = Math.max(dp_left[i-1] + arr[i], arr[i]);
            max = Math.max(dp_left[i], max);
        }

        dp_right[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            dp_right[i] = Math.max(dp_right[i+1] + arr[i], arr[i]);
        }

        for(int i=1; i< n-1; i++){
            int temp = dp_left[i-1] + dp_right[i+1];
            max = Math.max(temp, max);
        }

        System.out.println(max);
    }

}
