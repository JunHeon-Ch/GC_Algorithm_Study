package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_17299 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[] F = new int[N];
		int[] ANS = new int[N];
		sc.nextLine();
		String[] str = sc.nextLine().split(" ");
		for(int i=0; i<N; i++) F[Integer.parseInt(str[i])]+=1;
		stack.push(0);
		for(int i=1; i<N; i++)
		{
			while(!stack.empty()&&F[Integer.parseInt(str[stack.peek()])]<F[Integer.parseInt(str[i])])
			{
				ANS[stack.pop()]=Integer.parseInt(str[i]);
			}
			stack.push(i);
		}
		while(!stack.empty()) ANS[stack.pop()]=-1;
		for(int i=0; i<ANS.length; i++) sb.append((ANS[i]+" "));
		System.out.println(sb.toString());
	}
}