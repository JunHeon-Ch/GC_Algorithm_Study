package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_17298 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		int[] A = new int[N];
		int[] ANS = new int[N];
		for(int i=0; i<N; i++) A[i]=sc.nextInt();
		for(int i=N-1; i>=0; i--)
		{
			while(!stack.isEmpty()&&stack.peek()<=A[i]) stack.pop();
			if(stack.isEmpty()) ANS[i]=-1;
			else ANS[i]=stack.peek();
			stack.push(A[i]);
		}
		for(int i : ANS) sb.append((i+" "));
		System.out.println(sb.toString());
	}

}
