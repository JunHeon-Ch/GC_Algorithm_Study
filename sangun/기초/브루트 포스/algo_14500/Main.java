package algo_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+6][m+6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
// 1-1. 직선 case (세로 놓기)
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i + 2][j];
                sum += map[i + 3][j];
                if (max < sum) {
                    max = sum;
                }
// 1-2 직선 case (가로 놓기)
                sum = 0;
                sum += map[i][j];
                sum += map[i][j + 1];
                sum += map[i][j + 2];
                sum += map[i][j + 3];
                if (max < sum) {
                    max = sum;
                }
// 2. 네모 case
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i + 1][j + 1];
                sum += map[i][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 3-1. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i + 2][j];
                sum += map[i + 2][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 3-1-2. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)의 대칭.
                sum = 0;
                sum += map[i][j + 1];
                sum += map[i + 1][j + 1];
                sum += map[i + 2][j + 1];
                sum += map[i + 2][j];
                if (max < sum) {
                    max = sum;
                }
// 3-2. ㄴ case // 왼하단시작 오른 상단 종료.
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i][j + 1];
                sum += map[i][j + 2];
                if (max < sum) {
                    max = sum;
                }
// 3-2-2. ㄴ case // 왼하단시작 오른 상단 종료. 의 대
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j + 2];
                sum += map[i][j + 1];
                sum += map[i][j + 2];
                if (max < sum) {
                    max = sum;
                }
// 3-3. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향)
                sum = 0;
                sum += map[i][j];
                sum += map[i][j + 1];
                sum += map[i + 1][j + 1];
                sum += map[i + 2][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 3-3-2. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향) 의 대칭
                sum = 0;
                sum += map[i][j];
                sum += map[i][j + 1];
                sum += map[i + 1][j];
                sum += map[i + 2][j];
                if (max < sum) {
                    max = sum;
                }
// 3-4. ㄴ case // 오른 상단시작 왼 하단 종료
                sum = 0;
                sum += map[i][j + 2];
                sum += map[i + 1][j + 2];
                sum += map[i + 1][j + 1];
                sum += map[i + 1][j];
                if (max < sum) {
                    max = sum;
                }
// 3-4-2. ㄴ case // 오른 상단시작 왼 하단 종료 의 대칭
                sum = 0;
                sum += map[i + 1][j + 2];
                sum += map[i + 1][j + 1];
                sum += map[i + 1][j];
                sum += map[i][j];
                if (max < sum) {
                    max = sum;
                }
// 4-1. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄴㄱ)
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i + 1][j + 1];
                sum += map[i + 2][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 4-2. ㄴㄱ case // 오른 상단시작 하단 종료.
                sum = 0;
                sum += map[i][j + 2];
                sum += map[i][j + 1];
                sum += map[i + 1][j + 1];
                sum += map[i + 1][j];
                if (max < sum) {
                    max = sum;
                }
// 4-3. ㄴㄱ case // 왼하단시작 오른 상단 종료.
                sum = 0;
                sum += map[i + 2][j];
                sum += map[i + 1][j];
                sum += map[i + 1][j + 1];
                sum += map[i][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 4-4. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄱㄴ꼴)
                sum = 0;
                sum += map[i][j];
                sum += map[i][j + 1];
                sum += map[i + 1][j + 1];
                sum += map[i + 1][j + 2];
                if (max < sum) {
                    max = sum;
                }
// 5-1. ㅗ case // ㅜ
                sum = 0;
                sum += map[i][j];
                sum += map[i][j + 1];
                sum += map[i][j + 2];
                sum += map[i + 1][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 5-2. ㅗ case // ㅓ
                sum = 0;
                sum += map[i][j + 1];
                sum += map[i + 1][j + 1];
                sum += map[i + 2][j + 1];
                sum += map[i + 1][j];
                if (max < sum) {
                    max = sum;
                }
// 5-3. ㅗ case // ㅗ
                sum = 0;
                sum += map[i + 1][j];
                sum += map[i + 1][j + 1];
                sum += map[i + 1][j + 2];
                sum += map[i][j + 1];
                if (max < sum) {
                    max = sum;
                }
// 5-4. ㅗ case // ㅏ
                sum = 0;
                sum += map[i][j];
                sum += map[i + 1][j];
                sum += map[i + 2][j];
                sum += map[i + 1][j + 1];
                if (max < sum) {
                    max = sum;
                }

            }
        }
        System.out.println(max);


    }
}