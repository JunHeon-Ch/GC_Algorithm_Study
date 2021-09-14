package 푼문제;

public class 순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        int[][] map = new int[5][5];

        for (int[] k : results) {
            map[k[0] - 1][k[1] - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        int answer = 0;
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[j][i] == 1) {
                    result++;
                }
            }
            if (result == n - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
