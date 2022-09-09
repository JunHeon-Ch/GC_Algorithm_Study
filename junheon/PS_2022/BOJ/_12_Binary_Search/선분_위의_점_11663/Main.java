package PS_2022.BOJ._12_Binary_Search.선분_위의_점_11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11663
 * 알고리즘: 이분탐색
 * 시간복잡도: O(mlogn), m=100,000(선분의 개수), n=100,000(점의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dot = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int l = 0, r = n - 1;
            int end = 0, start = n - 1;
            while(l <= r) {
                int mid = (l + r) / 2;
                if(dot[mid] <= max) l = mid + 1;
                else r = mid - 1;
            }
            end = r;

            l = 0;
            r = n - 1;
            while(l <= r) {
                int mid = (l + r) / 2;
                if(dot[mid] >= min) r = mid - 1;
                else l = mid + 1;
            }
            start = l;

            sb.append((end - start + 1) + "\n");
        }
        System.out.println(sb.toString());
    }
}