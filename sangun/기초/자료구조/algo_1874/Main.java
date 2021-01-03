package algo_1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        StringBuilder result = new StringBuilder();

        int n = sc.nextInt();

        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            // top 보다 작은 값을 원할때
            if (top >= temp) {
                if (stack.contains(temp)) {
                    while (stack.peek() != temp) {
                        stack.pop();
                        result.append("-\n");
                    }
                    result.append("-\n");
                    stack.pop();
                } else {
                    temp=-1;
                    break;
                }
            }
            // top 보다 큰 값을 원할때
            else if (top < temp) {
                if (stack.isEmpty()) {
                    stack.push(++top);
                    result.append("+\n");
                }
                while (stack.peek() != temp) {
                    stack.push(++top);
                    result.append("+\n");
                }
                result.append("-\n");
                stack.pop();
            }


        }
        if (temp==-1){
            System.out.println("NO");
        }else{
        System.out.println(result);}

    }


}
