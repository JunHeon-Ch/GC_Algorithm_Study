package problem_week4;

import java.util.Scanner;

public class Problem_6064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++)
		{
			boolean flag = false;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x-1; j<N*M; j=j+M)
			{
				if(j%N==y-1)
				{
					System.out.println(j+1);
					flag = true;
					break;
				}
			}
			
			if(flag==false) System.out.println(-1);
		}
	}
}