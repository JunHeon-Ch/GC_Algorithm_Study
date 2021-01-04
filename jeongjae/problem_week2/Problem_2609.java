package problem_week2;

import java.util.Scanner;

public class Problem_2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		System.out.println(gcd(num1, num2));
		System.out.println(lcm(num1, num2));
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