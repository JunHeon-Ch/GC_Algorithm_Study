package problem_week3;

import java.util.Scanner;

public class Problem_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			int n = sc.nextInt();
			int[] d = new int[n+3];
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			for(int j=4; j<=n; j++) d[j] = d[j-1]+d[j-2]+d[j-3];
			System.out.println(d[n]);
		}
	}
}