package problem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Problem_1874 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> array = new ArrayList<String>();
		int num = sc.nextInt();
		int[] list = new int[num];
		int index = 0;
		
		for(int i=0; i<num; i++)
		{
			list[i] = sc.nextInt();
		}
		for(int i=1; i<=num; i++) 
		{
			stack.push(i);
			array.add("+");
			while(!stack.isEmpty())
			{	
				if(stack.peek() == list[index])
				{
					stack.pop();
					array.add("-");
					index++;
				}
				else
				{
					break;
				}
			}
		}
		
		if(!stack.isEmpty())
		{
			System.out.println("NO");
		}
		else
		{
			for(String st : array)
			{
				System.out.println(st);
			}
		}
	}
}