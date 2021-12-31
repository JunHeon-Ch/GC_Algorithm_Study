package 프로그래머스.lv3.단어변환;

import java.util.*;

class Solution2 {
    public ArrayList<String> list = new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        for(String word: words)
            list.add(word);
        if(!list.contains(target))
            return 0;

        answer = bfs(begin, target);
        return answer;
    }

    public int bfs(String begin, String target){
        Queue<word> queue = new LinkedList<>();
        queue.add(new word(begin, 0));

        while(!queue.isEmpty()){
            word now = queue.poll();

            if(now.word.equals(target))
                return now.cnt;

            for(int i=0; i<list.size(); i++){
                if(check(now.word, list.get(i))){
                    queue.offer(new word(list.get(i), now.cnt+1));
                }
            }
        }
        return 0;
    }

    public boolean check(String str1, String str2){
        int cnt = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        else
            return false;
    }
}
class word{
    String word;
    int cnt;

    public word(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}
