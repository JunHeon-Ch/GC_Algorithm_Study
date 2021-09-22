package 다시풀기;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        ArrayList<String> ans = new ArrayList<>();
        for (int len : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String str : orders) {
                char[] s = str.toCharArray();
                Arrays.sort(s);
                dfs(0, len, str.length(), 0, new String(s), "", map);
            }

            int max = 0;
            for (String s : map.keySet()) {
                if (map.get(s) >= 2 && map.get(s) > max) {
                    max = map.get(s);
                }
            }

            for (String s : map.keySet()) {
                if (map.get(s) == max) {
                    ans.add(s);
                }
            }


        }
        ans.sort(Comparator.naturalOrder());

        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        System.out.println(ans);

    }

    static void dfs(int index, int n, int m, int selected, String str, String result, Map<String, Integer> map) {
        if (selected == n) {
            if (map.containsKey(result)) {
                map.put(result, map.get(result) + 1);
            } else {
                map.put(result, 1);
            }
            return;
        }
        if (index >= m) {
            return;
        }

        dfs(index + 1, n, m, selected + 1, str, result + str.charAt(index), map);
        dfs(index + 1, n, m, selected, str, result, map);
    }
}
