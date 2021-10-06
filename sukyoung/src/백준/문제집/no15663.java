package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no15663 {
    public static int n, m;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(0, "");
        System.out.print(sb);

    }
    public static void dfs(int depth, String str){
        if(depth == m){
            if(!list.contains(str)) {
                list.add(str);
                sb.append(str);
                sb.append('\n');
            }

            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth + 1, str + arr[i] + " ");
                visit[i] = false;
            }
        }
    }
}
