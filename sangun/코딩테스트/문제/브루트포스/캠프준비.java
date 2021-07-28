package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 캠프준비 {
    static int[] p;
    static int L, R, X;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        go(new ArrayList<>(), 0, 0);
        System.out.println(ans);

    }

    static void go(ArrayList<Integer> s, int selected, int index) {
        if (index == p.length) {
            if (s.size() < 2) {
                return;
            }
            ArrayList<Integer> k = new ArrayList<>();
            k.addAll(s);
            Collections.sort(k);
            if (valid(k)) {
                ans++;
            }
            return;
        }

        s.add(p[index]);
        go(s, selected + 1, index + 1);
        s.remove(selected);
        go(s, selected, index + 1);
    }

    static boolean valid(ArrayList<Integer> s) {
        int max = s.get(s.size() - 1);
        int min = s.get(0);
        int sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
        }
        if (max - min < X) return false;
        if (R < sum || sum < L) return false;
        return true;
    }
}

