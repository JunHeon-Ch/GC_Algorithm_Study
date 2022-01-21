package 백준.위상정렬.선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer>[] prerequisite = new LinkedList[n];
        int[] degree = new int[n];
        for(int i=0; i<n; i++)
            prerequisite[i] = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int last = Integer.parseInt(st.nextToken())-1;

            prerequisite[first].add(last);
            degree[last]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            if(degree[i] == 0)
                queue.add(i);
            ans[i] = 1;
        }

        for(int i=0; i<n; i++){
            if(queue.isEmpty())
                break;

            int now = queue.poll();
            for(int next : prerequisite[now]){
                degree[next]--;

                if(degree[next] == 0){
                    queue.add(next);
                    ans[next] = ans[now] + 1;
                }
            }
        }

        for(int i : ans)
            System.out.print(i + " ");
    }
}
