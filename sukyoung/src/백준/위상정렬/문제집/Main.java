package 백준.위상정렬.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] problems = new LinkedList[n];
        int[] degree = new int[n];
        for(int i=0; i<n; i++)
            problems[i] = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken())-1;
            int last = Integer.parseInt(st.nextToken())-1;

            problems[first].add(last);
            degree[last]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(degree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            ans.add(now+1);

            for(int next : problems[now]){
                degree[next]--;

                if(degree[next] == 0)
                    queue.add(next);
            }
        }
        for(int i: ans)
            System.out.print(i+" ");

    }
}
