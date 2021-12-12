package 프로그래머스.lv3.표편집;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        int pointer = k;
        Stack<node> erased = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int i=0; i<cmd.length; i++){
            if(cmd[i].charAt(0) == 'U'){
                int num = Integer.parseInt(cmd[i].substring(2));
                while(num-- > 0) {
                    pointer = prev[pointer];
                }
            }
            else if(cmd[i].charAt(0) == 'D'){
                int num = Integer.parseInt(cmd[i].substring(2));
                while(num-- > 0) {
                    pointer = next[pointer];
                }
            }
            else if(cmd[i].charAt(0) == 'C'){
                erased.push(new node(prev[pointer], pointer, next[pointer]));

                if(prev[pointer] != -1) next[prev[pointer]] = next[pointer];
                if(next[pointer] != -1) prev[next[pointer]] = prev[pointer];
                sb.setCharAt(pointer, 'X');

                // 커서 이동
                if(next[pointer] != -1)
                    pointer = next[pointer];
                else
                    pointer = prev[pointer];
            }
            else{
                int pp = erased.peek().prev; // 복구된 원소의 이전 원소
                int cc = erased.peek().cur; // 복구된 원소
                int nn = erased.peek().next; // 복구된 원소의 다음 원소
                erased.pop();

                if(pp != -1) next[pp] = cc;
                if(nn != -1) prev[nn] = cc;
                sb.setCharAt(cc, 'O');
            }
        }

        return sb.toString();
    }

    public class node{
        int prev, cur, next;

        public node(int prev, int cur, int next) {
            this.prev = prev;
            this.cur = cur;
            this.next = next;
        }
    }
}
