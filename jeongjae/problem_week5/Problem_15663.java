package problem_week5;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem_15663 {
	
	public static int N;
	public static int M;
	public static int[] n;
	public static boolean[] c;
	public static int[] ans;
	public static StringBuilder sb;
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		n = new int[N];
		c = new boolean[N];
		ans = new int[N];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++)
		{
			n[i] = sc.nextInt();
		}
		Arrays.sort(n);
		
		go(0, N, M);
		for(String s: set) System.out.print(s);
	}
	
	public static void go(int index, int N, int M)
	{
		if(index==M)
		{
			for(int i=0; i<M; i++)
			{
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			set.add(sb.toString());
			sb.delete(0,sb.length());
			return;
		}
		
		for(int i=0; i<N; i++)
		{	
			if(c[i]) continue;
			ans[index]=n[i];
			c[i]=true;
			go(index+1, N, M);
			c[i]=false;
		}
	}
}