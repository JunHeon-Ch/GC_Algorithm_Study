package problem_week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1697 {
    
	public static int N;
    public static int K;
    public static int[] check = new int[100001];

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        if(N==K) System.out.println(0);
        else BFS(N);
    }

    public static void BFS(int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = 1;

        while(!q.isEmpty())
        {
            int temp = q.poll();

            for(int i = 0, next; i < 3; i++)
            {
                if (i==0) next = temp + 1;   
                else if (i==1) next = temp - 1; 
                else next = temp * 2;

                if(next==K)
                {
                    System.out.println(check[temp]);
                    return;
                }

                if(next>=0&&next<check.length&&check[next]==0)
                {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}