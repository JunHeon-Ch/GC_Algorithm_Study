package problem_week4;

import java.util.Scanner;

public class Problem_15649 {
	
	public static boolean c[];
	public static int a[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		c = new boolean[N+1];
		a = new int[M];
		
		go(0, N, M);
	}
	
	public static void go(int index, int n, int m)
	{
		if(index==m)
		{
			for(int num : a) System.out.print(num+" ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++)
		{
			if(c[i]) continue;
			c[i]=true;
			a[index]=i;
			go(index+1, n, m);
			c[i]=false;
		}
	}
}