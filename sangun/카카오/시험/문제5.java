package 시험;

import java.util.ArrayList;
import java.util.Arrays;

public class 문제5 {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edge = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        ArrayList<Integer>[] node = new ArrayList[info.length];
        for (ArrayList<Integer> n : node) {
            n = new ArrayList<>();
        }
        for (int[] e : edge) {
            node[e[0]].add(e[1]);
            node[e[1]].add(e[0]);
        }



    }
}
