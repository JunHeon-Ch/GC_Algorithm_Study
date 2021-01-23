package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_15657 {
	
	public static int N;
	public static int M;
	public static int[] n;
	public static int[] ans;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		n = new int[N];
		ans = new int[N];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++)
		{
			n[i] = sc.nextInt();
		}
		Arrays.sort(n);
		
		go(0, 0, N, M);
		System.out.print(sb);
	}
	
	public static void go(int index, int start, int N, int M)
	{
		if(index==M)
		{
			for(int i=0; i<M; i++)
			{
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++)
		{
			ans[index]=n[i];
			go(index+1, i, N, M);
		}
	}
}