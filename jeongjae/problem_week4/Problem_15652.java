package problem_week4;

import java.util.Scanner;

public class Problem_15652 {
	
	public static int a[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		a = new int[M];
		go(0, 1, N, M);
	}
	
	public static void go(int index, int start, int n, int m)
	{
		if(index==m)
		{
			for(int num : a) System.out.print(num+" ");
			System.out.println();
			return;
		}
		for(int i=start; i<=n; i++)
		{
			a[index]=i;
			go(index+1, i, n, m);
		}
	}
}