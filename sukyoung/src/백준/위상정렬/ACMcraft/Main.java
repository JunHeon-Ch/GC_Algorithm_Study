package 백준.위상정렬.ACMcraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] building = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                building[i] = Integer.parseInt(st.nextToken());

            LinkedList<Integer>[] rule = new LinkedList[n];
            int[] degree = new int[n];
            for(int i=0; i<n; i++)
                rule[i] = new LinkedList<>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());

                int first = Integer.parseInt(st.nextToken())-1;
                int last = Integer.parseInt(st.nextToken())-1;

                rule[first].add(last);
                degree[last]++;
            }

            int target = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            int[] ans = new int[n];

            for(int i=0; i<n; i++){
                ans[i] = building[i];

                if(degree[i] == 0)
                    queue.add(i);
            }

            while(!queue.isEmpty()){
                int now = queue.poll();

                for(int next : rule[now]){
                    degree[next]--;
                    ans[next] = Math.max(ans[next], ans[now] + building[next]);

                    if(degree[next] == 0)
                        queue.add(next);
                }
            }

            sb.append(ans[target-1]+"\n");
        }
        System.out.print(sb);
    }
}
