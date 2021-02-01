package problem_week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_11724 {
	
	public static ArrayList<Integer>[] graph;
	public static boolean[] check;
	public static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();

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
		
		while(index_of_false(check, N)!=0)
		{
			DFS(index_of_false(check, N));
			count++;
		}
		
		System.out.print(count);
	}
	
	public static void DFS(int V)
	{
		check[V] = true;
		
		for(int i=0; i<graph[V].size(); i++)
		{
			int y = graph[V].get(i);
			if(check[y]==false)
			{
				DFS(y);
			}
		}
	}
	
	public static int index_of_false(boolean[] check, int N)
	{	
		for(int i=1; i<N+1; i++)
		{
			if(check[i]==false) return i;
		}
		return 0;
	}
}