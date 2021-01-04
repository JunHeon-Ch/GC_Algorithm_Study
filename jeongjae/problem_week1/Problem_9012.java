package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_9012 {
    
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        
        int count = sc.nextInt();
        sc.nextLine();
        int isb = 0;
        
        for (int i = 0; i < count; i++)
        {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++)
            {
                String temp = str.substring(j, j+1);
                if(temp.equals("(")) stack.add(temp);
                else
                {
                    if(stack.empty())
                    {
                        System.out.println("NO");
                        isb = 1;
                        break;
                    }
                    else stack.pop();
                }
            }
            if(stack.empty() && isb == 0)
            {
                System.out.println("YES");
            }
            else {
                if(isb==1) {}
                else System.out.println("NO");
            }
            stack.clear();
            isb = 0;
        }
    }
}