package problem_week3;

import java.util.Scanner;

public class Problem_1463 {
	
	static int[] d = new int[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.print(go(N));
	}
	
	public static int go(int n)
	{	
		if(n==1) return 0;
		if(d[n]>0) return d[n];
		d[n] = go(n-1) + 1;
		if(n%2==0)
		{
			int temp = go(n/2) + 1;
			if(d[n]>temp) d[n] = temp;
		}
		if(n%3==0)
		{
			int temp = go(n/3) + 1;
			if(d[n] > temp) d[n] = temp;
		}
		return d[n];
	}
}