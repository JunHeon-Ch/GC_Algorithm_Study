package problem_week2;

import java.util.Scanner;

public class Problem_10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int factorial = 1;
		while(N!=0)
		{
			factorial*=N;
			N--;
		}
		System.out.print(factorial);
	}
}