package problem;

import java.util.Scanner;

public class Problem_10799{
	
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int result = 0;

        String str = sc.nextLine();
        for (int i=0; i<str.length()-1; i++)
        {
            String str1 = str.substring(i,i+1);
            String str2 = str.substring(i+1,i+2);
            if (str1.equals("("))
            {
                if (str2.equals("(")) count += 1;
                else
                {
                    result = result + count;
                    i = i + 1;
                }
            }    
            else
            {
                result = result + 1;
                count = count - 1;
            }
        }
        result = result + 1;
        System.out.println(result);
    }
}