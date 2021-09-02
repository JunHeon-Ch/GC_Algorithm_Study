package 프로그래머스.lv2.괄호변환;

import java.util.*;

class Solution {
    //public String u = "";
    //public String v = "";
    public String solution(String p) {
        String answer = "";

        if(property(p))
            answer = p;
        else
            answer = algorithm(p);
        return answer;
    }

    public String algorithm(String p) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(p.length() == 0)
            return "";

        int open = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') open++;
            else open--;

            if(open == 0){
                u.append(p.substring(0,i+1));
                v.append(p.substring(i+1,p.length()));

                if(property(u.toString())){
                    u.append(algorithm(v.toString()));
                }
                else{
                    StringBuilder str = new StringBuilder();
                    str.append("(");
                    str.append(algorithm(v.toString()));
                    str.append(")");
                    str.append(reverse(u.toString()));

                    return str.toString();
                }
                break;
            }
        }
        return u.toString();
    }

    public boolean property(String p){
        int open = 0;

        if(p.charAt(0) ==')') return false;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '(') open++;
            else {
                open--;
                if(open<0) return false;
            }
        }

        return true;
    }

    public String reverse (String p){
        StringBuilder s = new StringBuilder();

        for(int i = 1; i<p.length()-1;i++){

            if(p.charAt(i) == '(')
                s.append(")");
            else
                s.append("(");
        }

        return s.toString();
    }
}