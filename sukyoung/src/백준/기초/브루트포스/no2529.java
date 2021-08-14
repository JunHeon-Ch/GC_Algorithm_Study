package 기초.브루트포스;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class no2529 {
    public static int k;
    public static String[] var;
    public static boolean[] visit = new boolean[10];
    public static List<String> ans = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        var = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++)
            var[i] = st.nextToken();

        DFS("", 0);
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1)); //최댓값
        System.out.println(ans.get(0)); //최솟값

    }
    public static void DFS(String str, int depth){
        if(depth == k+1){
            ans.add(str);
            return;
        }
        for(int i=0; i<10; i++){
            if(visit[i])
                continue;
            if(depth ==0 || isValid(Character.getNumericValue(str.charAt(depth-1)),i,var[depth-1].charAt(0))){
                visit[i] = true;
                DFS(str+i, depth+1);
                visit[i] = false;
            }
        }
    }
    public static boolean isValid(int i, int j, char c){
        if(c == '>')
            return i>j;
        else
            return i<j;
    }
}
