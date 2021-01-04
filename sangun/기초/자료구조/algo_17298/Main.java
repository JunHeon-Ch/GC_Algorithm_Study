package algo_17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while(!stack.empty()&&arr[stack.peek()]<arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        for (int i=0;i<n;i++){
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
    }


}
