package BOJ.코딩테스트.문제.브루트포스.주사위_윷놀이_17825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dice;
    static int[] lineup;
    static int[] board = new int[44];
    static int ans = 0;

    public static int game() {
        String str = new String();
        for(int i = 0; i < 10; i++) {
            str += lineup[i];
        }

        int[] pos = new int[4];
        boolean[] finish = new boolean[4];
        boolean[] exist = new boolean[44];
        int res = 0;
        int i;
        for (i = 0; i < 10; i++) {
            int index = lineup[i];
            // 도착 지점에 있는 말을 선택하면 해당 라인업은 무효
            if(finish[index]) break;
            // 현재 말의 위치
            int now = pos[index];
            // 말의 다음 위치
            int next = now + dice[i];
            // 도착 지점에 도착
            exist[now] = false;
            if(now <= 20 && next > 20) finish[index] = true;
            else if(now <= 28 && next > 28) finish[index] = true;
            else if(now <= 35 && next > 35) finish[index] = true;
            else if(now <= 43 && next > 43) finish[index] = true;
            else {
                // 말의 다음 위치가 10일 경우
                if (next == 5) next = 21;
                // 말의 다음 위치가 20일 경우
                else if(next == 10) next = 29;
                // 말의 다음 위치가 30일 경우
                else if(next == 15) next = 36;
                // 말의 다음 위치에 다른 말이 있으면 불가능
                if(exist[next]) break;
                // 25 위치에 다른 말이 있는 경우
                if(next == 25 || next == 32 || next == 40) {
                    if(exist[25] || exist[32] || exist[40]) break;
                }
                // 30 위치에 다른 말이 있는 경우
                else if(next == 26 || next == 33 || next == 41) {
                    if(exist[26] || exist[33] || exist[41]) break;
                }
                // 35 위치에 다른 말이 있는 경우
                else if(next == 27 || next == 34 || next == 42) {
                    if(exist[27] || exist[34] || exist[42]) break;
                }
                // 40 위치에 다른 말이 있는 경우
                else if(next == 20 || next == 28 || next == 35 || next == 43) {
                    if(exist[20] || exist[28] || exist[35] || exist[43]) break;
                }
                pos[index] = next;
                res += board[next];
                exist[next] = true;
            }
        }
        if(i != 10) res = -1;

        return res;
    }

    public static void solve(int index) {
        if (index == 10) {
            int res = game();
            if (res != -1) ans = Math.max(ans, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            lineup[index] = i;
            solve(index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        dice = new int[10];
        lineup = new int[10];
        while (st.hasMoreTokens()) {
            dice[i++] = Integer.parseInt(st.nextToken());
        }
        // 총 4개의 루트
        // 바깥 루트: 도착 지점 20
        for (i = 0; i <= 20; i++) {
            board[i] = i * 2;
        }
        // 10 -> 40으로 가는 루트
        // 시작 지점: 21 중간 지점: 25 마지막 지점: 28
        board[21] = 10;
        board[22] = 13;
        board[23] = 16;
        board[24] = 19;
        board[25] = 25;
        board[26] = 30;
        board[27] = 35;
        board[28] = 40;
        // 20 -> 40으로 가는 루트
        // 시작 지점: 29 중간 지점: 32 마지막 지점: 35
        board[29] = 20;
        board[30] = 22;
        board[31] = 24;
        board[32] = 25;
        board[33] = 30;
        board[34] = 35;
        board[35] = 40;
        // 30 -> 40으로 가는 루트
        // 시작 지점: 36 중간 지점: 40 마지막 지점: 43
        board[36] = 30;
        board[37] = 28;
        board[38] = 27;
        board[39] = 26;
        board[40] = 25;
        board[41] = 30;
        board[42] = 35;
        board[43] = 40;

        solve(0);
        System.out.println(ans);
    }
}
