package problem_week4;

import java.util.Scanner;

public class Problem_2133 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] d = new int[N+1];
		if(N>1&&N%2==0)
		{	
			d[0]=1;
			d[2]=3;
			
			for(int i=4; i< N+1; i=i+2)
			{
				d[i]=d[i-2]*d[2];
				for(int j=4; j<i+1; j=j+2) d[i]=d[i]+2*d[i-j];
			}
		}
		System.out.print(d[N]);
	}
}
