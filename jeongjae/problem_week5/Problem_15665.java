package problem_week5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_15665 {
	
	public static int N,M;
	public static int[] n,ans;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		n = new int[N];
		ans = new int[N];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) n[i]=sc.nextInt();
		Arrays.sort(n);
		
		go(0, N, M);
		System.out.print(sb);
	}
	
	public static void go(int index, int N, int M)
	{
		if(index==M)
		{
			for(int i=0; i<M; i++) sb.append(ans[i]+" ");
			sb.append("\n");
			return;
		}
		
		int prev = 0;
		for(int i=0; i<N; i++)
		{	
			if(n[i]==prev) continue;
			ans[index]=n[i];
			prev = n[i];
			go(index+1, N, M);
		}
	}
}