package problem_week4;

import java.util.Scanner;

public class Problem_15651 {
	
	public static int[] a = new int[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		go(0, N, M);
	}
	
	public static void go(int index, int n, int m)
	{
		if(index==m)
		{
			for(int i=0; i<m; i++) System.out.print(a[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++)
		{
			a[index]=i;
			go(index+1, n, m);
		}
	}
}