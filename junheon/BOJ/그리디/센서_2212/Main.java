package BOJ.그리디.센서_2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2212
 * 알고리즘: 그리디
 * 풀이: https://c-king.tistory.com/258
    1. arr[0]과 arr[1], arr[1]과 arr[2], ..., arr[n - 2]과 arr[n - 1]의 차이를 diff 배열에 넣는다.
    2. diff 배열을 오름차순하여 [0, N-K)까지 더한다.
 * 시간복잡도: O(nlogn), n=10,000(센서의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        n = set.size();
        int[] pos = new int[n];
        int i = 0;
        for (int p : set) {
            pos[i++] = p;
        }
        Arrays.sort(pos);

        int[] diff = new int[pos.length - 1];
        for(i = 1; i < pos.length; i++) {
            diff[i - 1] = pos[i] - pos[i - 1];
        }
        Arrays.sort(diff);

        int ans = 0;
        for(i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
