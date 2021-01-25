package problem_week5;

import java.util.Scanner;

public class Problem_9095 {
	
	public static int count = 0;
	public static int[] seq;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++)
		{	
			int n = sc.nextInt();
			seq = new int[n];
			go(0, n, seq);
			System.out.println(count);
			count = 0;
		}
	}
	
	public static void go(int index, int n, int[] seq)
	{	
		int sum = 0;
		
		for(int i=0; i<index; i++) sum += seq[i];
		
		if(sum==n)
		{	
			count++;
			return;
		}
		if(sum>n) return;
		
		for(int i=1; i<4; i++)
		{
			seq[index]=i;
			go(index+1, n, seq);
		}
	}
}
