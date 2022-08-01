package PS_2022.BOJ.Two_Pointer.블로그_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/21921
 * 알고리즘: 투포인터
 * 시간복잡도: O(n), n=250,000(블로그를 시작하고 지난 일수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visitor = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
            if (i > 0) visitor[i] += visitor[i - 1];
        }

        int ans = visitor[x - 1];
        int cnt = 1;
        for (int i = x; i < n; i++) {
            int cur = visitor[i] - visitor[i - x];
            if (ans < cur) {
                ans = cur;
                cnt = 1;
            } else if (ans == cur) cnt++;
        }
        if (ans == 0) System.out.println("SAD");
        else {
            System.out.println(ans);
            System.out.println(cnt);
        }
    }
}
