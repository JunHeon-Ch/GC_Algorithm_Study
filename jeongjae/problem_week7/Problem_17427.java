package problem_week7;

import java.util.Scanner;

public class Problem_17427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		long g_N = 0;
		
		for(int i=1; i<=N; i++) g_N += (N/i)*i;
		
		System.out.print(g_N);
	}
}