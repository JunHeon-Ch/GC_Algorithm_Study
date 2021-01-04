package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_9093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < N; i++)
		{
			Stack stack = new Stack<>();
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++)
			{
				if (str.charAt(j) == ' ')
				{
					while (!stack.empty())
					{
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				} else
				{
					stack.add(str.charAt(j));
				}
			}
			while(!stack.empty())
			{
				System.out.print(stack.pop());
			}
			System.out.println();
		}
	}
}