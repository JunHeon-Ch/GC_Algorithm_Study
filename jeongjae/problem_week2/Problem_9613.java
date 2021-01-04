package problem_week2;

import java.util.Scanner;

public class Problem_9613 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++)
		{
			int n = sc.nextInt();
			int[] N = new int[n];
			for(int j=0; j<n; j++) N[j]=sc.nextInt();
			long gcd_sum=0;
			for(int k=0; k<n-1; k++)
			{
				for(int l=k+1; l<n; l++) gcd_sum+= gcd(N[k], N[l]);
			}
			sb.append(gcd_sum+"\n");
		}
		System.out.print(sb);
	}
	
	public static int gcd(int n1, int n2)
	{
		while(n2!=0)
		{
			int temp = n1%n2;
			n1 = n2;
			n2 = temp;
		}
		return Math.abs(n1);
	}
}