package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위윷놀이 {
    static int[] seq;
    static int[][] board = {
            {0, 1, 2, 3, 4, 5}, //0번자리
            {2, 2, 3, 4, 5, 9},//1번자리
            {4, 3, 4, 5, 9, 10}, //2번자리
            {6, 4, 5, 9, 10, 11}, //3번자리
            {8, 5, 9, 10, 11, 12},//4번자리
            {10, 6, 7, 8, 20, 29},//5번자리
            {13, 7, 8, 20, 29, 30}, //6번자리
            {16, 8, 20, 29, 30, 31}, //7번자리
            {19, 20, 29, 30, 31, 32}, //8번자리
            {12, 10, 11, 12, 13, 14}, //9번자리
            {14, 11, 12, 13, 14, 15}, //10번자리
            {16, 12, 13, 14, 15, 16}, //11번자리
            {18, 13, 14, 15, 16, 17}, //12번자리
            {20, 18, 19, 20, 29, 30}, //13번자리
            {22, 15, 16, 17, 24, 25}, //14번자리
            {24, 16, 17, 24, 25, 26}, //15번자리
            {26, 17, 24, 25, 26, 27}, //16번자리
            {28, 24, 25, 26, 27, 28}, //17번자리
            {22, 19, 20, 29, 30, 31}, //18번자리
            {24, 20, 29, 30, 31, 32}, //19번자리
            {25, 29, 30, 31, 32, 32}, //20번자리
            {26, 20, 29, 30, 31, 32}, //21번자리
            {27, 21, 20, 29, 30, 31}, //22번자리
            {28, 22, 21, 20, 29, 30}, //23번자리
            {30, 23, 22, 21, 20, 29}, //24번자리
            {32, 26, 27, 28, 31, 32}, //25번자리
            {34, 27, 28, 31, 32, 32}, //26번자리
            {36, 28, 31, 32, 32, 32}, //27번자리
            {38, 31, 32, 32, 32, 32}, //28번자리
            {30, 30, 31, 32, 32, 32}, //29번자리
            {35, 31, 32, 32, 32, 32}, //30번자리
            {40, 32, 32, 32, 32, 32}, //31번자리
            {0, 32, 32, 32, 32, 32} //32번자리
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        seq = new int[10];
        for (int i = 0; i < 10; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int state = 0; state < (1 << 20); state++) {
            int candi = get_score(state);
            result = Math.max(result, candi);
        }
        System.out.println(result);


    }

    static int get_score(int state) {
        int ret = 0;
        boolean[] visited = new boolean[33];
        int[] pos = new int[4];

        for (int turn = 0; turn < 10; turn++) {
            int move = seq[turn];
            int horse = (state >> (turn * 2)) & 0x03;
            int cur_pos = pos[horse];
            int next_pos = board[cur_pos][move];
            int add_score = board[next_pos][0];

            if (visited[next_pos] && next_pos != 32) {
                return -1;
            }

            ret += add_score;
            visited[cur_pos] = false;
            visited[next_pos] = true;
            pos[horse] = next_pos;
        }
        return ret;
    }

}
