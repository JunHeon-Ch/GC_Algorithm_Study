package problem_week6;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1707 {
	
	public static ArrayList<Integer>[] graph;
	public static boolean[] check;
	public static int[] nodeColor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		for(int i=0; i<K; i++)
		{
			int V = sc.nextInt();
			int E = sc.nextInt();
			graph = new ArrayList[V+1];
			check = new boolean[V+1];
			nodeColor = new int[V+1];
			boolean flag = true;
			
			for(int j=1; j<V+1; j++) graph[j] = new ArrayList<Integer>();
			
			for(int j=0; j<E; j++)
			{
				int n1, n2;
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				graph[n1].add(n2);
				graph[n2].add(n1);
			}
			
			while(index_of_false(check, V)!=0)
			{
				int start = index_of_false(check, V);
				nodeColor[start]=1;
				DFS(start);
			}
			
			for(int j=1; j<V+1&&flag==true; j++)
			{
				for(int k=0; k<graph[j].size(); k++)
				{
					int temp = graph[j].get(k);
					if(nodeColor[j]==nodeColor[temp])
					{
						System.out.println("NO");
						flag=false;
						break;
					}
				}
			}
			if(flag) System.out.println("YES");
		}
	}
	
	public static void DFS(int start)
	{
		check[start]=true;
		
		for(int i=0; i<graph[start].size(); i++)
		{	
			int y = graph[start].get(i);
			if(check[y]==false)
			{
				if(nodeColor[start]==1) nodeColor[y]=2;
				else nodeColor[y]=1;
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