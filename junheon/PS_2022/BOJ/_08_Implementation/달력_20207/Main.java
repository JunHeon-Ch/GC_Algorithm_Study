package PS_2022.BOJ._08_Implementation.달력_20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/20207
 * 알고리즘: 구현
 * 시간복잡도: O(n), n=365
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[367];
        for(int k = 0; k < n; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int i = s; i <= e; i++) {
                arr[i]++;
            }
        }

        int w = 0, h = 0;
        int ans = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > 0) {
                w++;
                h = Math.max(h, arr[i]);
            } else {
                ans += w * h;
                w = 0;
                h = 0;
            }
        }
        System.out.println(ans);
    }
}
