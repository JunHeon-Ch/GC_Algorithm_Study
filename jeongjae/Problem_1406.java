package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem_1406{
    
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Stack<String> left_stack = new Stack<String>();
        Stack<String> right_stack = new Stack<String>();
     
        String first = sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<first.length(); i++)
        {
            left_stack.add(first.substring(i, i+1));
        }

        for(int i=0; i<count; i++)
        {
            String command = sc.next();
            if(command.equals("L"))
            {
                if(left_stack.empty()) continue;
                else right_stack.add(left_stack.pop());
            }
            else if(command.equals("D"))
            {
                if(right_stack.empty()) continue;
                else left_stack.add(right_stack.pop());
            }
            else if(command.equals("B"))
            {
                if(left_stack.empty()) continue;
                else left_stack.pop();
            }
            else if(command.equals("P"))
            {
                String add = sc.next();
                left_stack.add(add);
            }
        }
        for(int i=0; i<left_stack.size(); i++)
        {
            System.out.print(left_stack.get(i));
        }
        for(int i=right_stack.size()-1; i>=0; i--)
        {
            System.out.print(right_stack.get(i));
        }
    }
}