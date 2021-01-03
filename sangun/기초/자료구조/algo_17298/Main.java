package algo_17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> right = new Stack<>();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> result = new Stack<>();


        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            left.push(temp);
        }

        right.push(left.pop());
        result.push(-1);

        for (int i = 1; i < n; i++) {
            // 왼쪽 값이 오른쪽 값보다 작으면
            if (!right.isEmpty() && left.peek() < right.peek()) {
                result.push(right.peek());
                right.push(left.pop());
            } else {
                while ( !right.isEmpty() && left.peek() >= right.peek()) {
                    right.pop();
                }
                if (!right.isEmpty()) {
                    result.push(right.peek());
                    right.push(left.pop());
                } else {
                    result.push(-1);
                    right.push(left.pop());
                }


            }

        }
        for (int i = 0; i < n; i++) {
            bw.write(result.pop() + " ");
        }
        bw.flush();
        bw.close();


    }
}
