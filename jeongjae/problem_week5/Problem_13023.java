package problem_week5;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_13023 {
    
	static int N, M, ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans = 0;
        graph = new ArrayList[N];
        visit = new boolean[N];
        
        for (int i = 0; i < N; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
         
        for (int i = 0; i < N; i++)
        {
            go(i, 1);
            if (ans == 1) break;
        }
        System.out.println(ans);
    }

    public static void go(int i, int depth)
    {
        if (depth == 5 || ans == 1)
        {
            ans = 1;
            return;
        }
        
        visit[i] = true;
        
        for (int j = 0; j < graph[i].size(); j++)
        {
            if (!visit[graph[i].get(j)])
            {
                visit[graph[i].get(j)] = true;
                go(graph[i].get(j), depth + 1);
                visit[graph[i].get(j)] = false;
            }
        }
        visit[i] = false;
    }
}