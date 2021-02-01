package problem_week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1260 {
	
	public static ArrayList<Integer>[] graph;
	public static boolean[] check;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		graph = new ArrayList[N+1];
		check = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) graph[i]=new ArrayList<Integer>();
		
		for(int i=1; i<M+1; i++)
		{
			int n1, n2;
			
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i=1; i<N+1; i++) Collections.sort(graph[i]);
		
		DFS(V);
		check = new boolean[N+1];
		System.out.println();
		BFS(V);
	}
	
	public static void DFS(int V)
	{
		check[V] = true;
		System.out.print(V+" ");
		
		for(int i=0; i<graph[V].size(); i++)
		{
			int y = graph[V].get(i);
			if(check[y]==false)
			{
				DFS(y);
			}
		}
	}
	
	public static void BFS(int V)
	{
		Queue<Integer> q = new LinkedList<>();
		
		check[V] = true;
		q.add(V);
		
		while(!q.isEmpty())
		{
			int x = q.peek();
			q.remove();
			System.out.print(x+" ");
			for(int i=0; i<graph[x].size(); i++)
			{
				int y = graph[x].get(i);
				if(check[y]==false)
				{
					check[y]=true;
					q.offer(y);
				}
			}
		}
	}
}