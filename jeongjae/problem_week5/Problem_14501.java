package problem_week5;

import java.util.Scanner;

public class Problem_14501 {
	
	public static int[] schedule;
	public static int max = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] T = new int[N];
		int[] P = new int[N];
		schedule = new int[N];
		
		for(int i=0; i<N; i++)
		{
			T[i]=sc.nextInt();
			P[i]=sc.nextInt();
		}
		go(0, 0, N, T, P, schedule);
		System.out.print(max);
	}
	
	public static void go(int index, int start, int N, int[] T, int[] P, int[] schedule)
	{
		if(start>N) return;
		else
		{	
			int sum = 0;
			for(int i=0; i<index; i++) sum+=P[schedule[i]];
			if(sum>max) max = sum;
				
		}
		for(int i=start; i<N; i++)
		{
			schedule[index]=i;
			go(index+1, i+T[i], N, T, P, schedule);
		}
	}

}