package problem_week2;

import java.util.Scanner;

public class Problem_1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++)
		{
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println(lcm(num1, num2));
		}
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
	
	public static int lcm(int n1, int n2)
	{
		int gcd = gcd(n1, n2);
		if(gcd==0) return 0;
		return Math.abs((n1*n2)/gcd);
	}
}