package problem_week2;

import java.util.Scanner;

public class Problem_17087 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++)
		{
			int bro = sc.nextInt();
			A[i]=Math.abs(S-bro);
		}
		int max = A[0];
		for(int i=1; i<N; i++) max = gcd(max, A[i]);
		System.out.print(max);
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