package problem_week6;

import java.util.ArrayList;
import java.util.Scanner;

//Reference : https://docs16.tistory.com/93
public class Problem_16964 {

	public static final int MAX = 100000;
	public static int n;
	public static int[] a = new int[MAX+1];
	public static boolean check[] = new boolean[MAX+1];
	public static int index = 1;
	public static boolean suc;
	public static ArrayList<Integer>[] e = new ArrayList[MAX+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for(int i=0, a, b; i<n-1; i++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			e[a] = new ArrayList<Integer>();
			e[b] = new ArrayList<Integer>();
			e[a].add(b);
			e[b].add(a);
		}
		
		for(int i=0; i<n; i++) a[i] = sc.nextInt();
		
		dfs(0, 1);
		
		if(suc) System.out.print(1);
		else System.out.print(0);
	}

	public static void dfs(int dep, int now)
	{
		if(index==n)
		{
			suc = true;
			return;
		}
		if(check[now]) return;
		check[now] = true;
		
		for(int i=0; i<e[now].size(); i++)
		{
			int next = e[now].get(i);
			if(!check[next])
			{
				if(next==a[index])
				{
					index++;
					dfs(dep+1, next);
					i = -1;
				}
			}
		}
	}
}
