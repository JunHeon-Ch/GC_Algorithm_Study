package problem_week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//Reference : https://bcp0109.tistory.com/156
public class Problem_13913 {
    
	public static int N, K;
    public static int[] parent = new int[100001];
    public static int[] count = new int[100001];

    public static void main(String[] args) throws Exception {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while(index!=N)
        {
            stack.push(parent[index]);
            index = parent[index];
        }

        sb.append(count[K] - 1 + "\n");
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");

        System.out.println(sb.toString());
    }

    public static void BFS()
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        count[N] = 1;

        while(!q.isEmpty())
        {
            int now = q.poll();

            if (now == K) return;
            
            for(int i=0, next; i<3; i++)
            {
                if(i==0) next = now + 1;
                else if(i==1) next = now - 1;
                else next = now * 2;

                if(next<0||next>100000) continue;

                if(count[next]==0)
                {
                    q.add(next);
                    count[next] = count[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}