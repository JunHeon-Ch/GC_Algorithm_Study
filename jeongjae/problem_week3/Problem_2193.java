package problem_week3;

import java.util.Scanner;

public class Problem_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		
		int N = sc.nextInt();
		long[][] d = new long[N+1][2];
		d[1][0]=0;
		d[1][1]=1;
		/*nested loop를 사용하지 않고 1-demensional DP로도 해결할 수 있다
		 * d[i] = i자리의 이친수의 총 갯수
		 * d[i] = d[i-1]+d[i-2];
		 */
		for(int i=2; i<=N; i++)
		{
			for(int j=0; j<=1; j++)
			{
				if(j==0) d[i][j]=d[i-1][0]+d[i-1][1];
				else d[i][j]=d[i-1][0];
			}
		}
		sum = d[N][0]+d[N][1];
		System.out.print(sum);
	}
}