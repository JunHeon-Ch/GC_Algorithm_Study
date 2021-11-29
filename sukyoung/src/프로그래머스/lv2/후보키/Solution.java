package 프로그래머스.lv2.후보키;

import java.util.*;

class Solution {
    public ArrayList<Set<Integer>> candidateList = new ArrayList<>();
    public boolean[] visit;
    public int solution(String[][] relation) {
        int answer = 0;

        int size = relation[0].length;
        int[] arr = new int[size];
        for(int i=0; i<size; i++)
            arr[i] = i;

        visit = new boolean[size];
        for(int i=1; i<=size; i++){
            dfs(0, i, 0, arr, new HashSet<>(), relation);
        }
        //System.out.print(candidateList);

        answer = candidateList.size();
        return answer;
    }
    public void dfs(int depth, int size, int start, int[] arr, Set<Integer> keySet, String[][] relation){
        if(depth == size){

            //for(int i : keySet) System.out.print(i + " ");
            for(Set<Integer> key : candidateList) {
                if(keySet.containsAll(key)) {
                    return;
                }
            }

            if(isUnique(keySet, relation)){
                candidateList.add(keySet);
            }
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                Set<Integer> newSet = new HashSet<>(keySet);
                newSet.add(arr[i]);
                dfs(depth+1, size, i, arr, newSet, relation);
                visit[i] = false;
            }
        }
    }
    public boolean isUnique(Set<Integer> keySet, String[][] relation){
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<relation.length; i++){
            String value = "";
            for(int key: keySet){
                value += relation[i][key];
            }

            if(list.contains(value))
                return false;
            else
                list.add(value);
        }

        return true;
    }
}
