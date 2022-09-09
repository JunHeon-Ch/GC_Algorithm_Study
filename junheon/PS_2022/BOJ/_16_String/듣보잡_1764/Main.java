package PS_2022.BOJ._16_String.듣보잡_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1764
 * 알고리즘: 문자열, 자료구조
 * 시간복잡도: O(nlogn), n=500,000(듣도 못한 사람의 수, 보도 못한 사람의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set1 = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set1.add(br.readLine());
        }
        Set<String> set2 = new HashSet<>();
        for(int i = 0; i < m; i++) {
            set2.add(br.readLine());
        }
        List<String> ans = new ArrayList<>();
        for(String s : set1) {
            if(set2.contains(s)) ans.add(s);
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + "\n");
        for(String s : ans) {
            sb.append(s + "\n");
        }
        System.out.println(sb.toString());
    }
}
