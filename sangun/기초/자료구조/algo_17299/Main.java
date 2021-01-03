package algo_17299;

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
        int[] numbers = new int[n];
        int[] arr = new int[1000001];


        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            numbers[i]=temp;
            arr[numbers[i]]+=1;
        }
        for (int i=0;i<n;i++){
            left.push(arr[numbers[i]]);
            System.out.println(arr[numbers[i]]);
        }

        right.push(left.pop());
        result.push(-1);

        for (int i = 1; i < n; i++) {
            // 왼쪽 값이 오른쪽 값보다 작으면
            if (!right.isEmpty() && left.peek() < right.peek()) {
                result.push(right.peek());
                right.push(left.pop());
            } else { // 큰값을 찾을때까지 pop
                while (!right.isEmpty() && left.peek() >= right.peek()) {
                    right.pop();
                }// 오른쪽에 큰 값이 있다면
                if (!right.isEmpty()) {
                    result.push(right.peek());
                    right.push(left.pop());
                } else { // 오른쪽이 비어서 큰 값이 없다면
                    result.push(-1);
                    right.push(left.pop());
                }
            }

        }
//        for (int i =0;i<n;i++){
//            bw.write(result.pop()+" ");
//        }
        for (int i = 0; i < n; i++) {
            if (result.peek()==-1){
                bw.write(result.pop() + " ");
            }else {
                bw.write(numbers[i] + " ");
                result.pop();
            }
        }
        bw.flush();
        bw.close();

    }


}
