import java.util.Arrays;

public class 삼각달팽이 {
    public static void main(String[] args) {

        int n = 4;

        int[][] arr = new int[n][n];

        int row = -1;
        int col = 0;
        int cnt = 1;
        for (int i = n; i > 0; i -= 3) {

            for (int j = 0; j < i; j++) {
                arr[++row][col] = cnt++;
            }

            for (int j = 0; j < i - 1; j++) {
                arr[row][++col] = cnt++;
            }

            for (int j = 0; j < i - 2; j++) {
                arr[--row][--col] = cnt++;
            }
        }
        int[] answer = new int[cnt];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[index++] = arr[i][j];
            }
        }
        System.out.println(Arrays.toString(answer));
    }

}
