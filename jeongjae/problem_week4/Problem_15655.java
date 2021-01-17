package problem_week4;

import java.util.Scanner;
import java.util.Arrays;

public class Problem_15655 {
	
	public static int N, M;
	public static int a[];
	public static int num[];
	public static boolean c[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		a = new int[N];
		c = new boolean[10000];
		
		for(int i=0; i<N; i++) num[i]=sc.nextInt();
		Arrays.sort(num);
		go(0, 0, N, M);
	}
	
	public static void go(int index, int start, int n, int m)
	{
		if(index==m)
		{
			for(int i : a)
			{
				if(i!=0) System.out.print(i+" "); 
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<n; i++)
		{
			if(c[num[i]]) continue;
			c[num[i]]=true;
			a[index]=num[i];
			go(index+1, i+1, n, m);
			c[num[i]]=false;
		}
	}
}