package PS_2022.BOJ._01_Data_Structure.AC_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/5430
 * 알고리즘: 덱
 * 시간복잡도: O(n), n=100,000(수행할 함수 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            char[] op = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while(st.hasMoreElements()) deque.add(Integer.parseInt(st.nextToken()));

            boolean rev = false;
            boolean fin = false;
            for(int i = 0; i < op.length; i++) {
                if(op[i] == 'R') {
                    if(rev) rev = false;
                    else rev = true;
                } else if(op[i] == 'D') {
                    if(deque.isEmpty()) {
                        sb.append("error\n");
                        fin = true;
                        break;
                    }
                    if(rev) deque.removeLast();
                    else deque.removeFirst();
                }
            }
            if(fin) continue;
            StringBuilder res = new StringBuilder("[");
            while(!deque.isEmpty()) {
                if(rev) res.append(deque.removeLast() + ",");
                else res.append(deque.removeFirst() + ",");
            }
            if(res.lastIndexOf(",") != -1) res.deleteCharAt(res.lastIndexOf(","));
            res.append("]\n");
            sb.append(res);
        }
        System.out.println(sb.toString());
    }
}
