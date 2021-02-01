package problem_week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem_2667_Jeongjae {
	
	public static ArrayList<Integer>[] graph;
	public static boolean[] check;
	public static ArrayList<Integer> group;
	public static int check_cnt = 0;
	public static int group_cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] house = new int[N+1][N+1];
		graph = new ArrayList[N*N+1];
		check = new boolean[N*N+1];
		group = new ArrayList<Integer>();
		
		for(int i=1; i<N+1; i++)
		{	
			String line = sc.next();
			for(int j=1; j<N+1; j++)
			{
				house[i][j]=Character.getNumericValue(line.charAt(j-1));
			}
		}
		
		for(int i=1; i<N*N+1; i++) graph[i] = new ArrayList<Integer>();
		
		for(int i=1; i<N+1; i++)
		{
			for(int j=1; j<N+1; j++)
			{
				if(house[i][j]==1)
				{
					if(house[i][j-1]==1)
					{
						graph[(i-1)*N+j].add((i-1)*N+(j-1));
						graph[(i-1)*N+(j-1)].add((i-1)*N+j);
					}
					if(house[i-1][j]==1)
					{	
						if(i>=2)
						{
							graph[(i-1)*N+j].add((i-2)*N+j);
							graph[(i-2)*N+j].add((i-1)*N+j);
						}
					}
				}
			}
		}
		
		for(int i=1; i<N*N+1; i++)
		{	
			check_cnt = check_count(check, N*N+1);
			if(i%N==0)
			{
				if(check[i]==false&&house[(int)(i/N)][N]==1)
				{	
					group_cnt++;
					DFS(i);
					group.add(check_count(check, N*N+1)-check_cnt);
				}
			}
			else
			{
				if(check[i]==false&&house[(int)(i/N)+1][i%N]==1)
				{	
					group_cnt++;
					DFS(i);
					group.add(check_count(check, N*N+1)-check_cnt);
				}
			}
		}
		
		System.out.println(group_cnt);
		Collections.sort(group);
		for(int i : group) System.out.println(i);
	}
	
	public static void DFS(int start)
	{
		check[start]=true;
		
		for(int i=0; i<graph[start].size(); i++)
		{
			int y = graph[start].get(i);
			if(check[y]==false)
			{				
				DFS(y);
			}
		}
	}
	
	public static int check_count(boolean[] check, int N)
	{	
		int count = 0;
		
		for(int i=1; i<N; i++)
		{
			if(check[i]==true) count++; 
		}
		
		return count;
	}
}