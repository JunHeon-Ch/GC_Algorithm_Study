package 푼문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 불량사용자 {
    static int ans = 0;
    static HashSet<String> set = new HashSet<>();
    static boolean[] visited;

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        visited = new boolean[user_id.length];

        go(0, 0, user_id, banned_id, new ArrayList<>());
        System.out.println(ans);
        System.out.println(set);
    }

    static void go(int index, int selected, String[] user_id, String[] banned_id, ArrayList<String> result) {
        if (index == banned_id.length) {
            String tmp = result.toString();
            if (!set.contains(tmp)) {
                ans++;
                set.add(tmp);
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (valid(banned_id[index], user_id[i])) {
                visited[i] = true;
                result.add(user_id[i]);
                Collections.sort(result);
                go(index + 1, selected + 1, user_id, banned_id, result);
                result.remove(user_id[i]);
                visited[i] = false;
            }
        }

    }

    static boolean valid(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;

    }
}
