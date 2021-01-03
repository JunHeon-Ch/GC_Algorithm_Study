package algo_1406;

import java.util.Scanner;

public class time_over {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = sc.nextInt();
        int cursor = s.length();
        char cmd;
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            cmd = sc.next().charAt(0);
            switch (cmd) {
                case 'L':
                    if (cursor != 0) {
                        cursor--;
                    }
                    break;
                case 'D':
                    if (cursor < s.length()) {
                        cursor++;
                    }
                    break;
                case 'B':
                    if (cursor > 0 && cursor <= s.length()) {
                        s = s.substring(0, cursor - 1) + s.substring(cursor);
                        cursor--;
                    }
                    break;
                case 'P':
                    char temp = sc.next().charAt(0);
                    s = s.substring(0, cursor) + temp + s.substring(cursor);
                    cursor++;
                    break;
                default:

            }
        }
        System.out.println(s);
    }
}
