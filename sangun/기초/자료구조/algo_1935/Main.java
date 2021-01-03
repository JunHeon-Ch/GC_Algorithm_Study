package algo_1935;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Double> operator = new Stack<>();

        String s = br.readLine();
        int[] operand = new int[28];
        int temp=0;
        for (int i = 0; i < n; i++) {
            temp = 'A'-65+i;
            operand[temp] = Integer.parseInt(br.readLine());
        }
        double a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '*':
                    b = operator.pop();
                    a = operator.pop();
                    operator.push(a * b);

                    break;
                case '+':
                    b = operator.pop();
                    a = operator.pop();
                    operator.push(a + b);
                    break;
                case '/':
                    b = operator.pop();
                    a = operator.pop();
                    operator.push(a / b);
                    break;
                case '-':
                    b = operator.pop();
                    a = operator.pop();
                    operator.push(a - b);
                    break;
                default:
                    operator.push(Double.parseDouble(String.valueOf(operand[s.charAt(i)-65])));
                    break;
            }
        }
        bw.write(String.format("%.2f", operator.pop())+"");
        bw.flush();
        bw.close();

    }
}
