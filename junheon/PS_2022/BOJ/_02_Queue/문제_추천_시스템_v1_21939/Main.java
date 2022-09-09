package PS_2022.BOJ._02_Queue.문제_추천_시스템_v1_21939;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/21939
 * 알고리즘: 자료구조
 * 시간복잡도: O(nlogn), n=10,000(명령문 개수)
 */

public class Main {

    static class Problem {
        int no, level;

        public Problem(int no, int level) {
            this.no = no;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Problem> list = new TreeSet<>((o1, o2) -> {
            if(o1.level == o2.level) return o1.no - o2.no;
            return o1.level - o2.level;
        });
        Map<Integer, Integer> map = new HashMap<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            list.add(new Problem(no, level));
            map.put(no, level);
        }

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("add")) {
                int no = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                list.add(new Problem(no, level));
                map.put(no, level);
            } else if(op.equals("recommend")) {
                int no = Integer.parseInt(st.nextToken());
                bw.write((no == 1 ? list.last().no : list.first().no) + "\n");
            } else if(op.equals("solved")) {
                int no = Integer.parseInt(st.nextToken());
                list.remove(new Problem(no, map.get(no)));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
