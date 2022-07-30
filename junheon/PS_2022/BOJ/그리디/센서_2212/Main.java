package PS_2022.BOJ.그리디.센서_2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2212
 * 알고리즘: 그리디
 * 시간복잡도: O(nlogn), n=10,000(센서의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensor = new int[n];
        for(int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        int[] diff = new int[n - 1];
        int prev = sensor[0];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = sensor[i + 1] - prev;
            prev = sensor[i + 1];
        }
        Arrays.sort(diff);

        int ans = 0;
        for(int i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
