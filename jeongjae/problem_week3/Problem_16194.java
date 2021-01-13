package problem_week3;

import java.util.Scanner;

public class Problem_16194 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] P = new int[N+1];
		int[] d = new int[N+1];
		for(int i=1; i<N+1; i++) P[i]=sc.nextInt();
		d[1]=P[1];
		for(int i=2; i<=N; i++)
		{	
			int min = d[i-1]+P[1];
			for(int j=i-1; j>=0; j--)
			{
				if(d[j]+P[i-j]<=min) min = d[j]+P[i-j];
			}
			d[i]=min;
		}
		System.out.print(d[N]);
	}
}