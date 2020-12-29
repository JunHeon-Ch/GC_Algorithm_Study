package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_1918 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String operator = sc.nextLine();
		for(int i=0; i<operator.length(); i++)
		{
			int asci = (int)operator.charAt(i);
			if(asci>=65&&asci<=90) sb.append(operator.charAt(i));
			else if(operator.charAt(i)=='*'||operator.charAt(i)=='/')
			{
				while(!stack.empty()&&(stack.peek()=='*'||stack.peek()=='/')) sb.append(stack.pop());
				stack.push(operator.charAt(i));
			}
			else if(operator.charAt(i)=='+'||operator.charAt(i)=='-')
			{
				while(!stack.empty()&&(stack.peek()=='*'||stack.peek()=='/'
						||stack.peek()=='+'||stack.peek()=='-')) sb.append(stack.pop());
				stack.push(operator.charAt(i));
			}
			else if(operator.charAt(i)=='(') stack.push(operator.charAt(i));
			else if(operator.charAt(i)==')')
			{
				while(stack.peek()!='(') sb.append(stack.pop());
				stack.pop();
			}
		}
		while(!stack.empty()) sb.append(stack.pop());
		System.out.println(sb.toString());
	}
}