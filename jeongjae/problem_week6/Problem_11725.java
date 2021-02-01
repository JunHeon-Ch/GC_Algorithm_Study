package problem_week6;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_11725 {
	
	public static int[] parent;
	public static ArrayList<Integer>[] tree;
	public static boolean[] check;
	public static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		parent = new int[N+1];
		tree = new ArrayList[N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<Integer>();
		
		for(int i=0; i<N-1; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree[a].add(b); tree[b].add(a);
		}
		
		DFS(1);
		for(int i=2; i<=N; i++) System.out.println(parent[i]);
	}
	
	public static void DFS(int v)
	{
		check[v] = true;
		
		for(int i : tree[v])
		{
			if(!check[i])
			{
				parent[i] = v;
				DFS(i);
			}
		}
	}
}