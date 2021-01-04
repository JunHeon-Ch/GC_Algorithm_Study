package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_10828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int N;
		
		N = sc.nextInt();
		sc.nextLine();
		
		for(int i=N; i>0; i--)
		{
			String order = sc.nextLine();
			if(order.contains("push")) stack.push(Integer.parseInt(order.substring(5)));
			else if(order.equals("pop")) System.out.println(stack.isEmpty()?-1:stack.pop());
			else if(order.equals("size")) System.out.println(stack.size());
			else if(order.equals("empty")) System.out.println(stack.isEmpty()?1:0);
			else if(order.equals("top")) System.out.println(stack.isEmpty()?-1:stack.peek());
		}
	}
}
