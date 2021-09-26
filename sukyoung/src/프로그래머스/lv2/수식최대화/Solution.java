package 프로그래머스.lv2.수식최대화;

import java.util.*;

class Solution {
    public long answer = Long.MIN_VALUE;
    public ArrayList<String> operation = new ArrayList<>();
    public ArrayList<Long> number = new ArrayList<>();

    public String[] oper = {"+", "-", "*"};
    public String[] ans = new String[3];
    public boolean[] visit = new boolean[3];
    public long solution(String expression) {
        String n = "";
        for(int i=0; i<expression.length(); i++){
            char temp = expression.charAt(i);
            if(temp == '+' || temp == '-' || temp == '*'){
                operation.add(temp+"");
                number.add(Long.parseLong(n));
                n = "";
            }
            else
                n += temp;
        }
        number.add(Long.parseLong(n));
        permutation(0);
        return answer;
    }

    public void permutation(int depth){
        if(depth == 3){
            getAns();
        }

        for(int i=0; i<3; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[depth] = oper[i];
                permutation(depth+1);
                visit[i] = false;
            }
        }
    }
    public void getAns(){
        ArrayList<String> temp_operation = new ArrayList<>();
        ArrayList<Long> temp_number = new ArrayList<>();
        temp_operation.addAll(operation);
        temp_number.addAll(number);

        for(int i=0; i<ans.length; i++){
            String op = ans[i];
            for(int j=0; j<temp_operation.size(); j++){
                if(op.equals(temp_operation.get(j))){
                    long num1 = temp_number.get(j);
                    long num2 = temp_number.get(j+1);
                    long res = cal(num1, num2, op);

                    temp_number.remove(j+1); // 숫자 삭제
                    temp_number.remove(j);
                    temp_operation.remove(j); // 연산자 삭제

                    temp_number.add(j, res);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(temp_number.get(0)));
    }
    public long cal(long n1, long n2, String o){
        long res = 0;
        switch(o) {
            case "+" :
                res = n1 + n2;
                break;
            case "-" :
                res = n1 -n2;
                break;
            case "*" :
                res = n1 * n2;
                break;
        }

        return res;
    }
}
