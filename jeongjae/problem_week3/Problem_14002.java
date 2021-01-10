package problem_week3;

import java.util.Scanner;

public class Problem_14002 {
	
	public static int[] A;
	public static int[] d;
	public static int[] seq;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int temp = 0;
		
		int N = sc.nextInt();
		A = new int[N+1];
		d = new int[N+1];
		seq = new int[N+1];
		for(int i=1; i<=N; i++)
		{	
			A[i]=sc.nextInt();
			d[i]=1;
			seq[i]=-1;
		}
		for(int i=2; i<=N; i++)
		{	
			max = 0;
			for(int j=1; j<i; j++)
			{
				if(A[j]<A[i]&&d[j]>max)
				{
					max=d[j];
					seq[i]=j;
				}
			}
			d[i]=max+1;
		}
		for(int i=1; i<=N; i++)
		{
			if(d[i]>max) max=d[i];
			temp=i;
		}
		System.out.println(max);
		go(temp);
	}
	
	public static void go(int p)
	{
		if(p==-1) return;
		go(seq[p]);
		System.out.print(A[p]+" ");
	}
}