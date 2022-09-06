package PS_2022.BOJ.String.파일_정리_20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
https://www.acmicpc.net/problem/20291
 * 알고리즘: 문자열, 자료구조
 * 시간복잡도: O(n), n=50,000(파일의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while(n-- > 0) {
            String file = br.readLine();
            String ex = file.split("\\.")[1];
            map.put(ex, map.getOrDefault(ex, 0) + 1);
        }
        Set<String> set = new TreeSet<>();
        for(String ex : map.keySet()) {
            set.add(ex);
        }
        StringBuilder sb = new StringBuilder();
        for(String ex : set) {
            sb.append(ex + " " + map.get(ex) + "\n");
        }
        System.out.println(sb.toString());
    }
}
