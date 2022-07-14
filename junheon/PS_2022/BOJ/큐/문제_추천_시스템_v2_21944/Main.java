package PS_2022.BOJ.큐.문제_추천_시스템_v2_21944;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
https://www.acmicpc.net/problem/21944
 * 알고리즘: 자료구조
 * 시간복잡도: O(nlogn), n=10,000(명령문 개수)
 */

public class Main {

    static class Problem {
        int p, l, g;

        public Problem(int p, int l, int g) {
            this.p = p;
            this.l = l;
            this.g = g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeSet<Problem> list = new TreeSet<>((o1, o2) -> {
            if(o1.l == o2.l) return o1.p - o2.p;
            return o1.l - o2.l;
        });
        TreeSet<Problem>[] gList = new TreeSet[101];
        for(int i = 1; i <= 100; i++) {
            gList[i] = new TreeSet<>((o1, o2) -> {
                if(o1.l == o2.l) return o1.p - o2.p;
                return o1.l - o2.l;
            });
        }
        HashMap<Integer, Problem> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int p, l, g;
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            list.add(new Problem(p, l, g));
            gList[g].add(new Problem(p, l, g));
            map.put(p, new Problem(p, l, g));
        }

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("add")) {
                p = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                g = Integer.parseInt(st.nextToken());
                list.add(new Problem(p, l, g));
                gList[g].add(new Problem(p, l, g));
                map.put(p, new Problem(p, l, g));
            } else if(op.equals("solved")) {
                p = Integer.parseInt(st.nextToken());
                Problem solved = map.get(p);
                list.remove(solved);
                gList[solved.g].remove(solved);
            } else if(op.equals("recommend")) {
                g = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                bw.write((n == 1 ? gList[g].last().p : gList[g].first().p) + "\n");
            } else if(op.equals("recommend2")) {
                n = Integer.parseInt(st.nextToken());
                bw.write((n == 1 ? list.last().p : list.first().p) + "\n");
            } else if(op.equals("recommend3")) {
                n = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    Problem problem = list.ceiling(new Problem(0, l, 0));
                    if(problem == null) bw.write("-1\n");
                    else bw.write(problem.p + "\n");
                } else if(n == -1) {
                    Problem problem = list.lower(new Problem(0, l, 0));
                    if(problem == null) bw.write("-1\n");
                    else bw.write(problem.p + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
