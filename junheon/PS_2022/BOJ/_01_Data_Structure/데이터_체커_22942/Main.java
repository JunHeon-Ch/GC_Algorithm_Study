package PS_2022.BOJ._01_Data_Structure.데이터_체커_22942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/22942
 * 알고리즘: 스택
 * 시간복잡도: O(nlogn), n=200,000(원의 개수)
 */
public class Main {

    static class Circle {
        int idx, val;

        public Circle(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Circle> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new Circle(i, x - r));
            pq.add(new Circle(i, x + r));
        }

        Stack<Integer> stack = new Stack<>();
        int prev = 2000000;
        while(!pq.isEmpty()) {
            Circle cur = pq.poll();
            if(prev == cur.val) {
                System.out.println("NO");
                return;
            }
            if(stack.isEmpty()) stack.push(cur.idx);
            else {
                if(stack.peek() == cur.idx) stack.pop();
                else stack.push(cur.idx);
            }
        }
        if(stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
