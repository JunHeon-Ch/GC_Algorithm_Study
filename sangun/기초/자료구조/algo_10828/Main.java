package algo_10828;
import java.util.Scanner;

public class Main {
    public static int[] a;
    public static int t=-1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        String command;
        int num;
        a=new int[n];
        for(int i=0;i<n;i++) {
            command=sc.next();
            switch(command) {
                case "push":{
                    num=sc.nextInt();
                    push(num);
                    break;
                }
                case "pop":{
                    pop();
                    break;
                }
                case "size":{
                    size();
                    break;
                }
                case "empty":{
                    if(empty()==1) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                }
                case "top":{
                    top();
                }
                break;
            }
        }
    }
    static void push(int x) {
        a[++t]=x;
    }
    public static void pop() {
        if(empty()==1) {
            System.out.println(-1);
        }
        else {
            System.out.println(a[t--]);
        }

    }
    public static void size() {
        //size
        System.out.println(t+1);
    }
    public static int empty() {
        // empty
        if(t<0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void top() {
        //null
        if(empty()==1) {
            System.out.println(-1);
        }
        else {
            System.out.println(a[t]);
        }
    }
}

