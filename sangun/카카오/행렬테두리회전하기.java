
public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] map = new int[rows][columns];

        int[] answer = new int[queries.length];

        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = k++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i], map);
        }


    }

    static int rotate(int[] q, int[][] map) {
        int lx = q[0] - 1;
        int ly = q[1] - 1;
        int rx = q[2] - 1;
        int ry = q[3] - 1;

        int[] tmp = new int[3];
        tmp[0] = map[lx][ry];
        tmp[1] = map[rx][ry];
        tmp[2] = map[rx][ly];
        int min = Integer.MAX_VALUE;

        // 오른쪽으로 회전
        for (int i = ry; i > ly; i--) {
            map[lx][i] = map[lx][i - 1];
            min = Math.min(min, map[lx][i]);
        }

        // 아래쪽으로 회전
        for (int i = rx; i > lx; i--) {
            if (i - 1 == lx) map[i][ry] = tmp[0];
            else map[i][ry] = map[i - 1][ry];
            min = Math.min(min, map[i][ry]);
        }

        // 왼쪽으로 회전
        for (int i = ly; i < ry; i++) {
            if (i + 1 == ry) map[rx][i] = tmp[1];
            else map[rx][i] = map[rx][i + 1];
            min = Math.min(min, map[rx][i]);
        }

        // 위쪽으로 회전
        for (int i = lx; i < rx; i++) {
            if (i + 1 == rx) map[i][ly] = tmp[2];
            else map[i][ly] = map[i + 1][ly];
            min = Math.min(min, map[i][ly]);
        }
        return min;

    }


}
