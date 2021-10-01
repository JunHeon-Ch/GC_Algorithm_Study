package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] treeList = new int[n];
        st = new StringTokenizer(br.readLine());

        int min = 0, max = 0;
        for(int i=0; i<n; i++) {
            treeList[i] = Integer.parseInt(st.nextToken());

            if(max < treeList[i])
                max = treeList[i];
        }

        while(min < max){
            int mid = (min + max) / 2;

            long sum = 0;
            for(int tree: treeList) {
                if(tree > mid)
                    sum += tree - mid;
            }

            if(sum < m)
                max = mid;
            else
                min = mid + 1;
        }

        System.out.print(min - 1);
    }
}
