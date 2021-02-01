package problem_week6;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_13023 {
	
	public static ArrayList<Integer>[] graph;
	public static int ans = 0;
	public static boolean[] v;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		graph = new ArrayList[N];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) graph[i]=new ArrayList<Integer>();
		
		for(int i=0; i<M; i++)
		{	
			int n1, n2;
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i=0; i<N; i++)
		{
			if(ans==0) dfs(i, 1);
		}
		System.out.print(ans);
	}
	
	public static void dfs(int start, int depth)
	{
		if(depth==5)
		{
			ans = 1;
			return;
		}
		
		v[start] = true;
		for(int i : graph[start])
		{
			if(!v[i]) dfs(i, depth+1);
		}
		v[start] = false;
	}
}