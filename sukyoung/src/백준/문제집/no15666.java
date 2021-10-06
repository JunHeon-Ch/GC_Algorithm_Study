package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no15666 {
    public static int n, m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static Set<String> list = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(0, 0,"");
        System.out.print(sb);

    }
    public static void dfs(int depth, int start, String str){
        if(depth == m){
            if(!list.contains(str)){
                list.add(str);
                sb.append(str);
                sb.append('\n');
            }
            return ;
        }
        for(int i=start; i<arr.length; i++){
            dfs(depth + 1, i, str + arr[i] + " ");
        }
    }
}
