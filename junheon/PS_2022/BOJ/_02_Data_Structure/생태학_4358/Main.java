package PS_2022.BOJ._02_Data_Structure.생태학_4358;

import java.util.*;

/*
https://www.acmicpc.net/problem/4358
 * 알고리즘: 해시
 * 시간복잡도: O(n), n=1,000,000(나무의 수)
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            total++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        Set<String> set = new TreeSet<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            String res = String.format("%.4f", (float) map.get(str) / total * 100);
            sb.append(str + " " + res + "\n");
        }
        System.out.println(sb.toString());
    }
}
