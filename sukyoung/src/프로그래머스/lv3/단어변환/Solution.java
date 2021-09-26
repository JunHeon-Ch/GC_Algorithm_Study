package 프로그래머스.lv3.단어변환;

import java.util.*;

class Solution {
    public boolean[] visit;
    public ArrayList<String> wordList = new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];

        for(String word: words)
            wordList.add(word);
        if(!wordList.contains(target))
            return 0;

        int answer = bfs(begin, target);
        return answer;
    }

    public int bfs(String begin, String target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            String temp_word = temp.word;
            int temp_cnt = temp.cnt;

            if(temp_word.equals(target))
                return temp_cnt;

            for(int i=0; i<wordList.size(); i++){
                if(!visit[i] && check(temp_word, wordList.get(i))){
                    visit[i] = true;
                    queue.offer(new Node(wordList.get(i), temp_cnt+1));
                }
            }
        }
        return 0;
    }
    public boolean check(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }
}
class Node{
    String word;
    int cnt;
    Node (String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}