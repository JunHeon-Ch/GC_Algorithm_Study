package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 야구공 {
    static int n;
    static ArrayList<Integer>[] seq = new ArrayList[9];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            seq[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                seq[j].add(Integer.parseInt(st.nextToken()));
            }
        }
        int[] s = new int[8];
        for (int i = 0; i < 8; i++) {
            s[i] = i + 1;
        }

        do {
            int[] realSeq = new int[9];
            int j = 0;
            for (int i = 0; i < 9; i++) {
                if (i == 3) {
                    realSeq[i] = 0;
                    j--;
                } else realSeq[i] = s[j];
                j++;
            }
            ans = Math.max(ans, game(realSeq));
        } while (next_permutation(s));
        System.out.println(ans);

    }

    static boolean next_permutation(int[] s) {
        int i = s.length - 1;
        while (i > 0 && s[i - 1] >= s[i]) i--;
        if (i == 0) return false;

        int j = s.length - 1;

        while (s[i - 1] >= s[j]) j--;
        int temp = s[i - 1];
        s[i - 1] = s[j];
        s[j] = temp;

        j = s.length - 1;

        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return true;

    }

    static int game(int[] realSeq) {
        int i = 0;
        int score = 0;
        for (int k = 0; k < n; k++) { // 이닝

            int l1 = 0, l2 = 0, l3 = 0;
            Queue<Integer> queue = new LinkedList<>();
            int out = 0;
            while (out != 3) {
                if (seq[realSeq[i]].get(k) == 0) {
                    out++;
                } else if (seq[realSeq[i]].get(k) == 4) {
                    score += l1 + l2 + l3 + 1;
                    l1 = 0;
                    l2 = 0;
                    l3 = 0;
                } else if (seq[realSeq[i]].get(k) == 3) {
                    score += l3 + l2 + l1;
                    l3 = 1;
                    l2 = 0;
                    l1 = 0;
                } else if (seq[realSeq[i]].get(k) == 2) {
                    score += l3 + l2;
                    l3 = l1;
                    l2 = 1;
                    l1 = 0;
                } else if (seq[realSeq[i]].get(k) == 1) {
                    score += l3;
                    l3 = l2;
                    l2 = l1;
                    l1 = 1;
                }
                i++;
                i %= 9;
            }
        }
        return score;
    }

    // 타순을 정하기

    // 3 out 될때까지 돌리기

    // 마지막 타순기억한 순을 기준으로
    // 3 out 까지 돌리기
}
