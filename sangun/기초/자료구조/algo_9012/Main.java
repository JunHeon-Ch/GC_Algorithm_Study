package algo_9012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String vps = sc.nextLine();

        for (int i = 0; i < n; i++) {
            vps = sc.nextLine();
            if (vps.length() % 2 == 1) {
                System.out.println("NO");
            } else {
                valid(vps);
            }


        }
    }

    public static void valid(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                for (int j = i + 1; j < arr.length; j+=2) {
                    if (arr[j] == ')') {
                        arr[i] = 0;
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
        int check=1;

        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                check=0;
            }
        }
        if (check==1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
