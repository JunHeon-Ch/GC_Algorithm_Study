package 푼문제;

import java.util.HashMap;

public class _단체사진찍기 {
    static int n;
    static HashMap<Character, Integer> result = new HashMap<>();
    static int[] position; // 카카오프렌즈가 서는 위치
    static String[] data = {"N~F=0", "R~T>2"};
    static boolean[] visited = new boolean[8];
    static int ans;

    public static void main(String[] args) {
        n = 2;
        ans = 0;
        result.put('A', 0);
        result.put('C', 1);
        result.put('F', 2);
        result.put('J', 3);
        result.put('M', 4);
        result.put('N', 5);
        result.put('R', 6);
        result.put('T', 7);
        go(0);

        System.out.println(ans);

    }

    static void go(int index) {
        if (index == 8) {
            if (isOk()) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            position[index] = i;
            go(index + 1);
            visited[i] = false;
        }
    }

    static boolean isOk() {

        for (int t = 0; t < n; t++) {
            int a = result.get(data[t].charAt(0));
            int b = result.get(data[t].charAt(2));
            char c = data[t].charAt(3);
            int d = Integer.parseInt(data[t].substring(4));
            int dif = Math.abs(position[a] - position[b]);

            if (c == '=') {
                if (dif - 1 != d) return false;
            } else if (c == '<') {
                if (dif - 1 >= d) return false;
            } else if (c == '>') {
                if (dif - 1 <= d) return false;
            }
        }

        return true;
    }


}
