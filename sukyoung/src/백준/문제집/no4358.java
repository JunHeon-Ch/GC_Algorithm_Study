package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class no4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        String tree = br.readLine();
        HashMap<String, Integer> list = new HashMap<>();
        while(true)
        {
            if(list.containsKey(tree)){
                int tree_cnt = list.get(tree) + 1;
                list.put(tree, tree_cnt);
            }
            else{
                list.put(tree, 1);
            }
            cnt++;

            tree = br.readLine();
            if(tree == null || tree.length() == 0) {
                break;
            }
        }

        ArrayList<String> treeList = new ArrayList<>(list.keySet());
        Collections.sort(treeList);
        for(String s: treeList){
            double percent = (double) list.get(s) / cnt * 100.0;
            sb.append(s+" "+String.format("%.4f", percent));
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
