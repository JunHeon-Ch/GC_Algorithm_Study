package 백준.위상정렬.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] compare = new LinkedList[n];
        int[] degree = new int[n];
        for(int i=0; i<n; i++)
            compare[i] = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken())-1;
            int last = Integer.parseInt(st.nextToken())-1;

            compare[first].add(last);
            degree[last]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(degree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            ans.add(now+1);

            for(int next: compare[now]){
                degree[next] --;

                if(degree[next] == 0)
                    queue.add(next);
            }
        }

        for(int i : ans)
            System.out.println(i);
    }
}
