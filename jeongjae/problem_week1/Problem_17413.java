package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_17413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		int tag = 0;
		
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		for(char c : input.toCharArray())
		{
			if(c == '<')
			{
				tag = tag + 1;
				while(!stack.isEmpty()) result.append(stack.pop());
				result.append("<");
			}
			else if(c == '>')
			{
				tag = tag - 1;
				result.append(">");
			}
			else if(c == ' ')
			{
				while(!stack.isEmpty()) result.append(stack.pop());
				result.append(" ");
			}
			else
			{
				if(tag == 0) stack.push(c);
				else result.append(c);	
			}
		}
		while(!stack.isEmpty()) result.append(stack.pop());
		System.out.println(result);
	}
}