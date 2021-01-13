package problem_week3;

import java.util.Scanner;

public class Problem_1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] d = new int[N+1];
		for(int i=1; i<=N; i++)
		{
			d[i]=i;
			for(int j=1; j*j<=i; j++)
			{
				if(d[i]>d[i-j*j]+1) d[i]=d[i-j*j]+1;
			}
		}
		System.out.print(d[N]);
	}
}