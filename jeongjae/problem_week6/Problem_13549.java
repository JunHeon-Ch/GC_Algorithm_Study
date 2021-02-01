package problem_week6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_13549 {
	
	public static int N, K;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N>=K) System.out.print(N-K);
		else System.out.print(BFS(N, K));
	}
	
	public static int BFS(int N, int K)
	{
		Queue<Integer> q = new LinkedList();
		int[] find = new int[100001];
		Arrays.fill(find, -1);
		
		q.add(N);
		find[N] = 0;
		
		while(!q.isEmpty())
		{
			int now = q.poll();
			int temp = now*2;
			
			if(now==K) return find[now];
			
			while(temp<=100000&&find[temp]==-1)
			{
				find[temp]=find[now];
				q.add(temp);
				temp*=2;
			}
			
			for(int i=0; i<2; i++)
			{
				int next;
				
				if(i==0) next = now -1;
				else next = now + 1;
				
				if(next>=0&&next<=100000)
				{
					if(find[next]==-1)
					{
						q.add(next);
						find[next]=find[now]+1;
					}
				}
			}
		}
		return 0;
	}
}