package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 로마숫자만들기 {
    static int[] dx = {1, 5, 10, 50};
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        go(n, 0, 0, 0);
        System.out.println(set.size());

    }

    static void go(int n, int total, int cnt, int index) {
        if (cnt == n) {
            set.add(total);
            return;
        }
        for (int i = index; i < 4; i++) {
            go(n, total + dx[i], cnt + 1, i);
        }
    }
}
