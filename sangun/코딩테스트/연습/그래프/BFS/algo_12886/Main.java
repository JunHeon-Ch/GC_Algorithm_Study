package algo_12886;

import java.io.*;
import java.util.*;

public class Main {

    static HashSet<String> set = new HashSet<>();
    static boolean ans = false;

    static class stone {
        int a, b, c;

        stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
// hash set을 사용하지 않으면 시간초과가 계속 나타남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Integer[] num = {a, b, c};

        if ((a + b + c) % 3 != 0) {
            bw.write(0 + "\n");
            bw.close();
            System.exit(0);
        }

        Arrays.sort(num, Collections.reverseOrder());
        set.add(String.valueOf(num[0] * 1000000 + num[1] * 1000 + num[0]));
        bfs(num[0], num[1], num[2]);


        if (ans) bw.write(1 + "\n");
        else bw.write(0 + "\n");
        bw.close();
    }

    static void bfs(int a, int b, int c) {
        Queue<stone> q = new LinkedList<>();
        q.offer(new stone(a, b, c));
        while (!q.isEmpty()) {
            stone temp = q.poll();
            int na = temp.a;
            int nb = temp.b;
            int nc = temp.c;

            if (na == nb && nb == nc) {
                ans = true;
                return;
            }
            // 중간값과 가장 작은 값
            if (nb != nc) {
                Integer[] num = {na, nb - nc, nc * 2};
                if (num[1] > 0) {
                    Arrays.sort(num, Collections.reverseOrder());
                    if (!find(num[0], num[1], num[2])) {
                        q.offer(new stone(num[0], num[1], num[2]));
                        set.add(String.valueOf(na * 1000000 + nb * 1000 + nc));
                    }
                }
            }
            // 가장 큰 값과 가장 작은 값
            if (na != nc) {
                Integer[] num = {na - nc, nb, nc * 2};
                if (num[0] > 0) {
                    Arrays.sort(num, Collections.reverseOrder());
                    if (!find(num[0], num[1], num[2])) {
                        q.offer(new stone(num[0], num[1], num[2]));
                        set.add(String.valueOf(na * 1000000 + nb * 1000 + nc));
                    }
                }
            }

        }
        return;
    }
    // 썼던것인지 확인
    static boolean find(int a, int b, int c) {
        String temp = String.valueOf(a * 1000000 + b * 1000 + c);
        if (set.contains(temp)) return true;
        else return false;
    }

}
