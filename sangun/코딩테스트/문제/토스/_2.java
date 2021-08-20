package 토스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _2 {
    public static void main(String[] args) {
        int servers = 2;
        boolean sticky = true;
        int[] requests = {1,2,2,3,4,1};


        HashSet<Integer>[] server = new HashSet[servers];
        ArrayList<Integer>[] result = new ArrayList[servers];
        for (int i = 0; i < servers; i++) {
            server[i] = new HashSet<>();
            result[i] = new ArrayList<>();
        }

        if (sticky) {
            for (int i = 0; i < requests.length; i++) {
                int k = -1;
                boolean chk = false;
                int minSize = Integer.MAX_VALUE;
                for (int j = 0; j < servers; j++) {
                    if (server[j].contains(requests[i])) {
                        result[j].add(requests[i]);
                        k = j;
                        chk = true;
                    }
                    if (minSize > server[j].size()) {
                        minSize = server[j].size();
                        k = j;
                    }
                }
                if (!chk) {
                    server[k].add(requests[i]);
                    result[k].add(requests[i]);
                }
            }

        } else {
            int num = 0;
            for (int i = 0; i < requests.length; i++) {
                if (num >= servers) num = 0;
//                server[num].add(requests[i]);
                result[num].add(requests[i]);
                num++;
            }
        }
        int[][] answer = new int[servers][requests.length];

        for (int i = 0; i < servers; i++) {
            for (int j = 0; j < result[i].size(); j++) {
                answer[i][j] = result[i].get(j);
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
