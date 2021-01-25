package problem_week5;

import java.util.Scanner;

public class Problem_1182 {
	
	public static int N, S, count = 0;
	public static int[] ans;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		S=sc.nextInt();
		ans=new int[N];
		
		for(int i=0; i<N; i++) ans[i] = sc.nextInt();
		
		go(0, 0);
		
		if(S==0)
		{
			count--;
			System.out.println(count);
		}
		else
		{
			System.out.println(count);
		}
	}
	
	public static void go(int index, int s)
	{
		if(index==N)
		{
			if(s==S) count++;
			return;
		}
		
		go(index+1, s+ans[index]);
		go(index+1, s);
	}
}