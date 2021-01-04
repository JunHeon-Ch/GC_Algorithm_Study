package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_1935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Double> stack = new Stack();
		double[] operand = new double[27];
		
		int NOO = sc.nextInt();
		sc.nextLine();
		String operator = sc.nextLine();
		for(int i=0; i<NOO; i++)
		{
			int oper = sc.nextInt();
			operand[i] = (double)oper;
		}
		for(int i=0; i<operator.length(); i++)
		{
			int asci = (int)operator.charAt(i);
			if(asci>=65&&asci<=90) stack.push(operand[asci-65]);
			else
			{
				double pre = stack.pop();
				double aft = stack.pop();
				double result = 0;
				
				if(asci==42) result = aft*pre;
				else if(asci==43) result = aft+pre;
				else if(asci==47) result = aft/pre;
				else if(asci==45) result = aft-pre;
				stack.push(result);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}