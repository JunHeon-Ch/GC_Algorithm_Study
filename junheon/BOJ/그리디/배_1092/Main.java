package BOJ.그리디.배_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1092
 * 알고리즘: 그리디
 * 시간복잡도: O(n*m), n=50(크레인 수), m=10,000(박스 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }
        int ans = 0;
        while(box.size() != 0) {
            int i = 0;
            int j = 0;
            while(i < box.size() && j < n) {
                if(box.get(i) <= crane.get(j)) {
                    box.remove(box.get(i));
                    j++;
                } else i++;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
